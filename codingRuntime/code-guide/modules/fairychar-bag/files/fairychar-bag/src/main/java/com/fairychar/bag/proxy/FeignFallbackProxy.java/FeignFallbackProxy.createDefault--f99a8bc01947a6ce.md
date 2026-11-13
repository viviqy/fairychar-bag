# com.fairychar.bag.proxy.FeignFallbackProxy.createDefault

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FeignFallbackProxy.java.md)

[Lexical owner](FeignFallbackProxy.md#symbol-616d7307f09aca94)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-0d90ced6e619e668"></a>
## com.fairychar.bag.proxy.FeignFallbackProxy.createDefault

```java
public static <I> I createDefault(Class<I> feignClient, Throwable cause)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/proxy/FeignFallbackProxy.java:31`; evidence: `declaration-0d90ced6e619e668e12cd1bb45f1da60f599e25fa3e34ac8a9986d48b49fb2b1`.
Owner: `com.fairychar.bag.proxy.FeignFallbackProxy`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
代理feignclient的方法,代理后的方法返回{@link HttpResult}.fallback()

 @param feignClient feignClient
 @param <I>
 @return jdk动态代理后的FeignClient
```
