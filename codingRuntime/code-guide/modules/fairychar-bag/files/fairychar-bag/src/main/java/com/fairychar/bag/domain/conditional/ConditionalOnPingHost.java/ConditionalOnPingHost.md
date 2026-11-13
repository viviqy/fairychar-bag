# com.fairychar.bag.domain.conditional.ConditionalOnPingHost

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ConditionalOnPingHost.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-0de1bae5ff777b76"></a>
## com.fairychar.bag.domain.conditional.ConditionalOnPingHost

```java
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Conditional(value = OnPingHostCondition.class)
public @interface ConditionalOnPingHost
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/conditional/ConditionalOnPingHost.java:13`; evidence: `declaration-0de1bae5ff777b769165bfc0a683466304a3a0f303d2aaa4e074b3c554b35226`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
基于ping指定host的Bean条件判断器,仅当host能ping成功的情况下才会初始化Bean

 @author chiyo
 @since 1.0
```


## Members

- [host](ConditionalOnPingHost.host.md#symbol-957dd06a61bf2d71) — `function`, source line 21
- [result](ConditionalOnPingHost.result.md#symbol-dd97eaa5620acc97) — `function`, source line 26
- [timeout](ConditionalOnPingHost.timeout.md#symbol-17675bda072f36aa) — `function`, source line 31
