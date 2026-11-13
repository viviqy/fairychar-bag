# com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AbstractActionFlow.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-87bb4e2b51cc8487"></a>
## com.fairychar.bag.extension.action.condition.bool.AbstractActionFlow

```java
@NoArgsConstructor
@Slf4j
public abstract class AbstractActionFlow<C, N> implements ActionFlow<C, N>
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/action/condition/bool/AbstractActionFlow.java:15`; evidence: `declaration-87bb4e2b51cc8487c2a879c8694982440e07f56999e3157737082f87f6fdf7ec`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
抽象操作流

 @author chiyo
 @since 1.0.0
```


## Fields

<a id="symbol-1990fdcd501ba1e5"></a>
### trueFlow

```java
@Setter
@Getter
private AbstractActionFlow trueFlow
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/action/condition/bool/AbstractActionFlow.java:21`; evidence: `declaration-1990fdcd501ba1e5b06a936d2fa60d02b57de55a556cc6633fde661852886e91`.
Visibility: `private` (explicit).
Type: `AbstractActionFlow`.
No initializer recorded.

Source docstring (unreviewed):
```text
compute结果为true时call的下一流
```


<a id="symbol-fc838b13f2f2d160"></a>
### falseFlow

```java
@Getter
@Setter
private AbstractActionFlow falseFlow
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/action/condition/bool/AbstractActionFlow.java:27`; evidence: `declaration-fc838b13f2f2d160ae8ba20971a1729fb70843935076299e899d595aec5b764c`.
Visibility: `private` (explicit).
Type: `AbstractActionFlow`.
No initializer recorded.

Source docstring (unreviewed):
```text
compute结果为false时call的下一流
```


## Members

- [callNext](AbstractActionFlow.callNext.md#symbol-9fed148e339a34b3) — `function`, source line 36
