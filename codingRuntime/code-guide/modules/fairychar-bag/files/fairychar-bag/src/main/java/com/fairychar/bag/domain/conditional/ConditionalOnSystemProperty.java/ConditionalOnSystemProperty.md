# com.fairychar.bag.domain.conditional.ConditionalOnSystemProperty

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ConditionalOnSystemProperty.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-171ce05ff5272cbb"></a>
## com.fairychar.bag.domain.conditional.ConditionalOnSystemProperty

```java
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/conditional/ConditionalOnSystemProperty.java:12`; evidence: `declaration-171ce05ff5272cbbf07547b7095c7f05ead8124d450f8eb383f1ad3e8bd20602`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
基于系统参数的Bean条件判断器,仅当系统参数对应值相同时才会配置Bean

 @author chiyo
```


## Members

- [name](ConditionalOnSystemProperty.name.md#symbol-23b8b97fcf438de2) — `function`, source line 17
- [value](ConditionalOnSystemProperty.value.md#symbol-0a2792593be81cb6) — `function`, source line 19
