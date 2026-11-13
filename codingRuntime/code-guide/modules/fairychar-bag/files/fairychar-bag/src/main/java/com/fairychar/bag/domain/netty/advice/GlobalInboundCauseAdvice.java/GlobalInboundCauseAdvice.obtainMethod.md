# com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice.obtainMethod

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../GlobalInboundCauseAdvice.java.md)

[Lexical owner](GlobalInboundCauseAdvice.md#symbol-23177676aedebbe9)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-c98277c2178561fb"></a>
## com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice.obtainMethod

```java
private Method obtainMethod(CauseInfo c)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:143`; evidence: `declaration-c98277c2178561fb5aca904d36d43ea79af9fcaeeca51c01f4e76279130c2564`.
Owner: `com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice`; visibility: `private` (explicit).

Source docstring (unreviewed):
```text
根据causeInfo信息,分别从cache1,cache2,cache3里获取对应的Method
 cache1推断方式 = exception+handler+method
 cache2推断方式 = exception+handler
 cache3推断方式 = exception
 <p>
 获取优先级顺序为 cache1->cache2->cache3

 @param c causeInfo
 @return 查到的Method或者null
```
