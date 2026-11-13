# com.fairychar.bag.extension.action.condition.bool.FlowBuilder

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FlowBuilder.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-197b97126cae473f"></a>
## com.fairychar.bag.extension.action.condition.bool.FlowBuilder

```java
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlowBuilder
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/action/condition/bool/FlowBuilder.java:21`; evidence: `declaration-197b97126cae473f15372c175445a0b15c8eb7fcaa81d4e1c123d16d867cc814`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
流生成器

 @author chiyo
 @since 1.0.0
```


## Fields

<a id="symbol-f15d9853b26a044d"></a>
### rootFlow

```java
private AbstractActionFlow rootFlow
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/action/condition/bool/FlowBuilder.java:23`; evidence: `declaration-f15d9853b26a044d7edfc99a76c41cddfb999f844ac804df6b8731a82f3bce4c`.
Visibility: `private` (explicit).
Type: `AbstractActionFlow`.
No initializer recorded.

<a id="symbol-bf01a513fe6f79ce"></a>
### beanSet

```java
private Set<AbstractActionFlow> beanSet
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/action/condition/bool/FlowBuilder.java:24`; evidence: `declaration-bf01a513fe6f79ce660eb95d7f8c4f18589b1fbf55f8475bec065efc42079760`.
Visibility: `private` (explicit).
Type: `Set<AbstractActionFlow>`.
No initializer recorded.

<a id="symbol-a35a6ced885e3d2e"></a>
### buildComplete

```java
private boolean buildComplete
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/action/condition/bool/FlowBuilder.java:25`; evidence: `declaration-a35a6ced885e3d2ebec4addb0539170ee1c2c36ce2b181b519142dda4fc3c01a`.
Visibility: `private` (explicit).
Type: `boolean`.
No initializer recorded.

<a id="symbol-c3413425c8d527f2"></a>
### steps

```java
private HashSet<String> steps = new HashSet<>()
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/action/condition/bool/FlowBuilder.java:26`; evidence: `declaration-c3413425c8d527f2a99b9e4dab0ed57aba5654cd8b3e839d99241f5a3a9acac2`.
Visibility: `private` (explicit).
Type: `HashSet<String>`.

<a id="symbol-eed6a4c8a7d421e6"></a>
### jsonCache

```java
private String jsonCache = null
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/action/condition/bool/FlowBuilder.java:27`; evidence: `declaration-eed6a4c8a7d421e6dfe4c6d00446fab8c87ed6b3f170bb928c396e42c1b7bec6`.
Visibility: `private` (explicit).
Type: `String`.

## Members

- [fromClasses](FlowBuilder.fromClasses.md#symbol-7b9d2057a9fdef66) — `function`, source line 29
- [buildFlow](FlowBuilder.buildFlow.md#symbol-a7194d73e6080365) — `function`, source line 43
- [convertAsJsonSchema](FlowBuilder.convertAsJsonSchema.md#symbol-97b3655e7a7923b8) — `function`, source line 82
- [eachNode](FlowBuilder.eachNode.md#symbol-7e757bb4b759e197) — `function`, source line 104
- [instanceBeanFromClasses](FlowBuilder.instanceBeanFromClasses.md#symbol-6c4a4f353ae1ee4d) — `function`, source line 132
- [ensureHasOnlyOneRoot](FlowBuilder.ensureHasOnlyOneRoot.md#symbol-202dcab13f12d01f) — `function`, source line 151
- [FlowJson](FlowBuilder.FlowJson.md#symbol-ab7025d2a3319081) — `class`, source line 161
