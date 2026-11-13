# com.fairychar.bag.extension.action.condition.bool.RootAction

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RootAction.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-8b02c575e8febbaf"></a>
## com.fairychar.bag.extension.action.condition.bool.RootAction

```java
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RootAction implements ActionFlow
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/action/condition/bool/RootAction.java:17`; evidence: `declaration-8b02c575e8febbaf882e61777ba78b6284eb4a7fa5ef127cc31dd7180b0c93fe`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
</p>Root节点流程,仅作为一个流的root标识</p>
 为什么需要:
 1. 唯一的入口点
 2. 对于有循环的流程,可以区分入口

 @author chiyo
 @since 1.0.0
```


## Members

- [compute](RootAction.compute.md#symbol-e94124861f3bd310) — `function`, source line 20
- [callNext](RootAction.callNext.md#symbol-4c24d30c9f00912b) — `function`, source line 25
- [getNextParam](RootAction.getNextParam.md#symbol-df395403d553b7de) — `function`, source line 30
- [getParentClassSet](RootAction.getParentClassSet.md#symbol-055cdba7703a8a4a) — `function`, source line 35
- [instanceBean](RootAction.instanceBean.md#symbol-f6c1fc6b4305f29f) — `function`, source line 40
- [getCondition](RootAction.getCondition.md#symbol-abeb4ea3b6fe3872) — `function`, source line 45
- [Singleton](RootAction.Singleton.md#symbol-f4e7f7c0d51095ba) — `enum`, source line 49
