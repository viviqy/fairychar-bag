# com.fairychar.bag.domain.conditional.ConditionalOnSystemOS

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ConditionalOnSystemOS.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-ecb32010935d679f"></a>
## com.fairychar.bag.domain.conditional.ConditionalOnSystemOS

```java
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Conditional(OnSystemOsCondition.class)
public @interface ConditionalOnSystemOS
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/conditional/ConditionalOnSystemOS.java:12`; evidence: `declaration-ecb32010935d679fd860c8466294040865c8efb9f87b28c0aaffc6216fc0b79d`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
基于系统的Bean条件判断器,仅当当前运行系统匹配时才会初始化Bean

 @author chiyo
```


## Members

- [os](ConditionalOnSystemOS.os--c6f77e9922af0f23.md#symbol-985866a765bb75f5) — `function`, source line 20
- [condition](ConditionalOnSystemOS.condition.md#symbol-8ea85e9c2d4313b3) — `function`, source line 25
- [OS](ConditionalOnSystemOS.OS--2cab5cf9a4b02286.md#symbol-baa3fe89029e228d) — `enum`, source line 27
