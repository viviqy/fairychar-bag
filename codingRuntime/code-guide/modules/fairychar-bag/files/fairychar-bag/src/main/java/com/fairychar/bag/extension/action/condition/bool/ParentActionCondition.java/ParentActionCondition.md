# com.fairychar.bag.extension.action.condition.bool.ParentActionCondition

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ParentActionCondition.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-c2cd8544823f507a"></a>
## com.fairychar.bag.extension.action.condition.bool.ParentActionCondition

```java
@AllArgsConstructor
@Getter
public class ParentActionCondition
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/action/condition/bool/ParentActionCondition.java:14`; evidence: `declaration-c2cd8544823f507a90cfd9bbc1f1dc50673b5434fdd51c78f7b8fc62fd1fa172`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
父类flow条件与对应class的映射类

 @author chiyo
 @since 1.0.0
```


## Fields

<a id="symbol-355f617af1f8ad72"></a>
### parentClass

```java
private Class<? extends ActionFlow> parentClass
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/action/condition/bool/ParentActionCondition.java:20`; evidence: `declaration-355f617af1f8ad72fc8f776e3708f0d99891ff33865a40d96cbc84e284a7b16f`.
Visibility: `private` (explicit).
Type: `Class<? extends ActionFlow>`.
No initializer recorded.

Source docstring (unreviewed):
```text
父ActionFlow class
```


<a id="symbol-1189cdc199d4f277"></a>
### condition

```java
private boolean condition
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/action/condition/bool/ParentActionCondition.java:24`; evidence: `declaration-1189cdc199d4f277772cba7fa02497d191974420b94375d2954b24355154a082`.
Visibility: `private` (explicit).
Type: `boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
父类走到当前子类的条件
```


## Members

- [hashCode](ParentActionCondition.hashCode.md#symbol-f874e18c00e2ea01) — `function`, source line 26
- [equals](ParentActionCondition.equals.md#symbol-4bf6c2b3f387daa2) — `function`, source line 31
