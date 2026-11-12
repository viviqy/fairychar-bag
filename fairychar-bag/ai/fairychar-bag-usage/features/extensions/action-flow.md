# 条件动作流

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：仅签名及局部语义可查**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## 条件动作流 ActionFlow

位置: `com.fairychar.bag.extension.action.condition.bool`

适用于构建 bool 条件树，每个节点计算 `true/false` 后进入对应子节点。

定义 root 节点:

```java
public class StringFlow extends AbstractActionFlow<String, Integer> {
    @Override
    public ActionFlow<String, Integer> instanceBean() {
        return new StringFlow();
    }

    @Override
    public boolean compute(String context) {
        return context.isEmpty();
    }

    @Override
    public Set<ParentActionCondition> getParentClassSet() {
        return Sets.newHashSet(RootAction.getCondition());
    }

    @Override
    public Integer getNextParam(String context) {
        return Integer.valueOf(context);
    }
}
```

定义子节点:

```java
public class IntegerCompareFlow extends AbstractActionFlow<Integer, Integer> {
    @Override
    public ActionFlow<Integer, Integer> instanceBean() {
        return new IntegerCompareFlow();
    }

    @Override
    public boolean compute(Integer context) {
        return context > 1;
    }

    @Override
    public Set<ParentActionCondition> getParentClassSet() {
        return Sets.newHashSet(new ParentActionCondition(StringFlow.class, true));
    }

    @Override
    public Integer getNextParam(Integer context) {
        return context + 1;
    }
}
```

构建并执行:

```java
Set<Class<AbstractActionFlow>> classes = new HashSet<>();
classes.add((Class) StringFlow.class);
classes.add((Class) IntegerCompareFlow.class);

FlowBuilder builder = FlowBuilder.fromClasses(classes);
AbstractActionFlow root = builder.buildFlow();
root.callNext("123");
```

约束:

- 必须且只能有一个 root，即 `getParentClassSet()` 包含 `RootAction.getCondition()` 的节点。
- 同一父节点的 true 分支最多一个子节点，false 分支最多一个子节点。
- `convertAsJsonSchema()` 必须在 `buildFlow()` 后调用。

## 类型与完整签名

- [`com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow`](../../api/extension-action-condition-bool.md)
- [`com.fairychar.bag.extension.action.condition.bool.ActionFlow`](../../api/extension-action-condition-bool.md)
- [`com.fairychar.bag.extension.action.condition.bool.FlowBuilder`](../../api/extension-action-condition-bool.md)
- [`com.fairychar.bag.extension.action.condition.bool.ParentActionCondition`](../../api/extension-action-condition-bool.md)
- [`com.fairychar.bag.extension.action.condition.bool.RootAction`](../../api/extension-action-condition-bool.md)
