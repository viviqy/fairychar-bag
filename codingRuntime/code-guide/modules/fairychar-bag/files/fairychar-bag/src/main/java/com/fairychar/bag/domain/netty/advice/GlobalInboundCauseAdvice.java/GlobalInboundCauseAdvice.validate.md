# com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice.validate

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../GlobalInboundCauseAdvice.java.md)

[Lexical owner](GlobalInboundCauseAdvice.md#symbol-23177676aedebbe9)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-a48eb7ddb848efca"></a>
## com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice.validate

```java
private void validate(List<Method> methods) throws IllegalAccessException
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:162`; evidence: `declaration-a48eb7ddb848efca86665c2a015134de63bf63b465b06ac5360f622211c8f5ae`.
Owner: `com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice`; visibility: `private` (explicit).

Source docstring (unreviewed):
```text
<p>验证映射到的Method合法性</p>
 <p>
 1.校验异常处理方法是否重复
 2.校验是否存在配置了methodName但是却未指定Handler

 @param methods
 @throws IllegalAccessException
```
