# com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice.dispatch

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../GlobalInboundCauseAdvice.java.md)

[Lexical owner](GlobalInboundCauseAdvice.md#symbol-23177676aedebbe9)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-b40634781965bc54"></a>
## com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice.dispatch

```java
private void dispatch(ChannelHandlerContext ctx, Throwable cause)
            throws InvocationTargetException, IllegalAccessException, ClassNotFoundException
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:66`; evidence: `declaration-b40634781965bc5473cd9b232c84f44a8307aa35ae4aa4d72a24d58d61ab9543`.
Owner: `com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice`; visibility: `private` (explicit).

Source docstring (unreviewed):
```text
异常处理分发,如果未找到异常处理器将会将此异常向下传递

 @param ctx
 @param cause
 @throws InvocationTargetException
 @throws IllegalAccessException
 @throws ClassNotFoundException
```
