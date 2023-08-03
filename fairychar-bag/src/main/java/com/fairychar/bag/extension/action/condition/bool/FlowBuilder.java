package com.fairychar.bag.extension.action.condition.bool;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 流生成器
 *
 * @author chiyo <br>
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlowBuilder {
    private AbstractActionFlow rootFlow;
    private Set<AbstractActionFlow> beanSet;

    public static FlowBuilder fromClasses(Set<Class<AbstractActionFlow>> classes) {
        Set<AbstractActionFlow> beanSet = instanceBeanFromClasses(classes);
        AbstractActionFlow root = ensureHasOnlyOneRoot(beanSet);
        FlowBuilder builder = new FlowBuilder();
        builder.rootFlow = root;
        builder.beanSet = beanSet;
        return builder;
    }

    public void buildFlow(AbstractActionFlow root, Set<AbstractActionFlow> beanSet) {
        Map<? extends Class<? extends AbstractActionFlow>, AbstractActionFlow> classBeanMap = beanSet.stream().collect(Collectors.toMap(k -> k.getClass(), v -> v));
        beanSet.forEach(e->{
            AbstractActionFlow current = e;
            Set<ParentActionCondition> parentClassSet = (Set<ParentActionCondition>) e.getParentClassSet();
            
        });

    }

    private static void mapping(AbstractActionFlow parent, Set<AbstractActionFlow> child) {
        if (child.isEmpty()) {
            return;
        }
        for (AbstractActionFlow c : child) {
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
}
