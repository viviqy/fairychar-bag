# com.fairychar.bag.domain.netty.advice.GlobalInboundEventAdvice.validate

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../GlobalInboundEventAdvice.java.md)

[Lexical owner](GlobalInboundEventAdvice.md#symbol-fbe07655f6d5f4ef)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-f11e3f8796f1cfb3"></a>
## com.fairychar.bag.domain.netty.advice.GlobalInboundEventAdvice.validate

```java
private void validate(List<Method> methods) throws IllegalAccessException
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundEventAdvice.java:115`; evidence: `declaration-f11e3f8796f1cfb3897f1d1b9cef54e2f32aac316bb94d2f380c4ea0f147b42d`.
Owner: `com.fairychar.bag.domain.netty.advice.GlobalInboundEventAdvice`; visibility: `private` (explicit).

Source docstring (unreviewed):
```text
<p>验证映射到的Method合法性</p>
 <p>
 1.校验异常处理方法是否重复
 2.校验是否存在配置了methodName但是却未指定Handler

 @param methods
 @throws IllegalAccessException
```
