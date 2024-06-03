package com.fairychar.bag.extension.action.condition.bool;

import com.fairychar.bag.domain.Singletons;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Strings;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 流生成器
 *
 * @author chiyo
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlowBuilder {
    private AbstractActionFlow rootFlow;
    private Set<AbstractActionFlow> beanSet;
    private boolean buildComplete;
    private HashSet<String> steps = new HashSet<>();
    private String jsonCache = null;

    public static FlowBuilder fromClasses(Set<Class<AbstractActionFlow>> classes) {
        Set<AbstractActionFlow> beanSet = instanceBeanFromClasses(classes);
        AbstractActionFlow root = ensureHasOnlyOneRoot(beanSet);
        FlowBuilder builder = new FlowBuilder();
        builder.rootFlow = root;
        builder.beanSet = beanSet;
        return builder;
    }

    /**
     * 构建流程结构图
     *
     * @return {@link AbstractActionFlow}root节点
     */
    public AbstractActionFlow buildFlow() {
        if (this.buildComplete) {
            return rootFlow;
        }
        Map<? extends Class<? extends AbstractActionFlow>, AbstractActionFlow> classBeanMap = beanSet.stream().collect(Collectors.toMap(k -> k.getClass(), v -> v));
        beanSet.forEach(e -> {
            AbstractActionFlow current = e;
            Set<ParentActionCondition> parentClassSet = (Set<ParentActionCondition>) e.getParentClassSet();
            parentClassSet.forEach(p -> {
                AbstractActionFlow parent = classBeanMap.get(p.getParentClass());
                if (p.isCondition()) {
                    if (parent.getTrueFlow() != null) {
                        throw new IllegalArgumentException(String.format("multiple trueFlow found,class=%s,childClass=%s,already set childClass=%s", parent.getClass().getName(), current.getClass().getName(), parent.getTrueFlow().getClass().getName()));
                    }
                    parent.setTrueFlow(current);
                } else {
                    if (parent.getFalseFlow() != null) {
                        throw new IllegalArgumentException(String.format("multiple trueFlow found,class=%s,childClass=%s,already set childClass=%s", parent.getClass().getName(), current.getClass().getName(), parent.getFalseFlow().getClass().getName()));
                    }
                    parent.setFalseFlow(current);
                }
            });
        });
        this.buildComplete = true;
        return rootFlow;
    }

    /**
     * 转换为json格式
     *
     * @return {@link String}
     * @throws JsonProcessingException json处理异常
     */
    public String convertAsJsonSchema() throws JsonProcessingException {
        if (!this.buildComplete) {
            throw new IllegalStateException("doesn't build complete yet");
        }
        if (!Strings.isNullOrEmpty(this.jsonCache)) {
            return this.jsonCache;
        }
        FlowJson rootJson = new FlowJson();
        rootJson.currentNodeClass = rootJson.getClass().getName();
        this.eachNode(rootJson, this.rootFlow.getTrueFlow(), this.rootFlow.getFalseFlow());
        String json = Singletons.JsonBean.getInstance().writeValueAsString(rootJson);
        this.jsonCache = json;
        return this.jsonCache;
    }

    /**
     * 递归获取每个流程节点
     *
     * @param flowJson  json对象
     * @param trueFlow  condition=true的流节点
     * @param falseFlow condition=false的流节点
     */
    private void eachNode(FlowJson flowJson, AbstractActionFlow trueFlow, AbstractActionFlow falseFlow) {
        if (trueFlow == null && falseFlow == null) {
            return;
        }
        if (trueFlow != null) {
            FlowJson trueJson = new FlowJson();
            trueJson.currentNodeClass = trueFlow.getClass().getName();
            flowJson.trueFlow = trueJson;
            //防止循环流程无限递归
            if (!steps.contains(trueFlow.getClass().getName())) {
                eachNode(trueJson, trueFlow.getTrueFlow(), trueFlow.getFalseFlow());
                steps.add(trueFlow.getClass().getName());
            }
        }
        if (falseFlow != null) {
            FlowJson falseJson = new FlowJson();
            falseJson.currentNodeClass = falseFlow.getClass().getName();
            flowJson.falseFlow = falseJson;
            //防止循环流程无限递归
            if (!steps.contains(falseFlow.getClass().getName())) {
                eachNode(falseJson, falseFlow.getTrueFlow(), falseFlow.getFalseFlow());
                steps.add(falseFlow.getClass().getName());
            }
        }

    }


    private static Set<AbstractActionFlow> instanceBeanFromClasses(Set<Class<AbstractActionFlow>> classes) {
        Set<AbstractActionFlow> beans = classes.stream().map(c -> {
            try {
                return (AbstractActionFlow) c.newInstance().instanceBean();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toSet());
        return beans;
    }

    /**
     * 确保只有一个ROOT
     *
     * @param flows ROOT节点class
     * @return {@link AbstractActionFlow}
     */
    private static AbstractActionFlow ensureHasOnlyOneRoot(Set<AbstractActionFlow> flows) {
        List<AbstractActionFlow> roots = flows.stream().filter(s -> s.getParentClassSet().contains(RootAction.class)).collect(Collectors.toList());
        if (roots.size() > 1) {
            String rootClasses = roots.stream().map(c -> c.getClass().getName()).collect(Collectors.joining(","));
            throw new IllegalArgumentException("more than one root,classes=" + rootClasses);
        }
        return roots.get(0);
    }


    private static class FlowJson {
        private String currentNodeClass;
        private FlowJson trueFlow;
        private FlowJson falseFlow;
    }
}
