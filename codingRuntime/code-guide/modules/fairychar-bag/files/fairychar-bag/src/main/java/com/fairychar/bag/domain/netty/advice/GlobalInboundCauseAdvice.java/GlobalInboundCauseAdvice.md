# com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../GlobalInboundCauseAdvice.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-23177676aedebbe9"></a>
## com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice

```java
@Slf4j
public class GlobalInboundCauseAdvice extends ChannelInboundHandlerAdapter implements BeanFactoryPostProcessor
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:36`; evidence: `declaration-23177676aedebbe90d22f82fbbddcba2af6d1c530873d7e68ba6949589c097c0`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
Datetime: 2021/6/24 17:46
 channel inBound 全局异常处理器,添加到inbound pipeline的最后节点

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-3ea9a74eaa66f1fe"></a>
### ALL

```java
private static final String ALL = "0all"
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:39`; evidence: `declaration-3ea9a74eaa66f1fe9440ffb30f11ae3c302019adc0b03da02de1e0235e24d199`.
Visibility: `private` (explicit).
Type: `String`.

<a id="symbol-8d75ef936181c9d0"></a>
### cache1

```java
private HashMap<String, Method> cache1
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:43`; evidence: `declaration-8d75ef936181c9d0e8a96210e08889fb23ecd21c2d669585248138a28d4765b0`.
Visibility: `private` (explicit).
Type: `HashMap<String, Method>`.
No initializer recorded.

Source docstring (unreviewed):
```text
key=mark(ex+handler+method)
```


<a id="symbol-11dfd2f9a4c51815"></a>
### cache2

```java
private HashMap<String, Method> cache2
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:44`; evidence: `declaration-11dfd2f9a4c51815bc276146ba74f49437ca4b1955b717b166e05acf0d8d9a45`.
Visibility: `private` (explicit).
Type: `HashMap<String, Method>`.
No initializer recorded.

<a id="symbol-a211bd19426de5f7"></a>
### cache3

```java
private HashMap<Class<? extends Throwable>, Method> cache3
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:45`; evidence: `declaration-a211bd19426de5f784af03a9b324d061d265e15e815e115a22e6822c9a15090d`.
Visibility: `private` (explicit).
Type: `HashMap<Class<? extends Throwable>, Method>`.
No initializer recorded.

<a id="symbol-5729b042699da33d"></a>
### invokeArgsCache

```java
private HashMap<String, InvokeEntity> invokeArgsCache = new HashMap<>(32)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:49`; evidence: `declaration-5729b042699da33d6060cba783666184bc115d608b37b72c71ebea0afce21444`.
Visibility: `private` (explicit).
Type: `HashMap<String, InvokeEntity>`.

Source docstring (unreviewed):
```text
key=method fullName;
```


<a id="symbol-3fca820c3d7802bb"></a>
### beanMap

```java
private Map<String, Object> beanMap
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:50`; evidence: `declaration-3fca820c3d7802bbffaf52a09d257b15baac758ed563eb52352e0f7fb4a7b460`.
Visibility: `private` (explicit).
Type: `Map<String, Object>`.
No initializer recorded.

## Members

- [exceptionCaught](GlobalInboundCauseAdvice.exceptionCaught.md#symbol-e7b2e6552890afba) — `function`, source line 52
- [dispatch](GlobalInboundCauseAdvice.dispatch.md#symbol-b40634781965bc54) — `function`, source line 66
- [getCauseInfo](GlobalInboundCauseAdvice.getCauseInfo.md#symbol-823d1f8c9736f4a9) — `function`, source line 82
- [invoke](GlobalInboundCauseAdvice.invoke.md#symbol-ef35d098e6f34e1e) — `function`, source line 97
- [getInvokeEntity](GlobalInboundCauseAdvice.getInvokeEntity.md#symbol-ccfb7382ebbdc883) — `function`, source line 115
- [obtainMethod](GlobalInboundCauseAdvice.obtainMethod.md#symbol-c98277c2178561fb) — `function`, source line 143
- [validate](GlobalInboundCauseAdvice.validate.md#symbol-a48eb7ddb848efca) — `function`, source line 162
- [createCache](GlobalInboundCauseAdvice.createCache.md#symbol-c1fbd45e4c8ed3d2) — `function`, source line 183
- [obtainCache2Key](GlobalInboundCauseAdvice.obtainCache2Key.md#symbol-dc17501da10e35c9) — `function`, source line 210
- [ensureNotExistSameMethod](GlobalInboundCauseAdvice.ensureNotExistSameMethod.md#symbol-50b735274d86242f) — `function`, source line 219
- [initCache](GlobalInboundCauseAdvice.initCache.md#symbol-be2d608741d71766) — `function`, source line 234
- [isChannelHandler](GlobalInboundCauseAdvice.isChannelHandler.md#symbol-7bcdb0839b5d5316) — `function`, source line 251
- [findByChannelHandler](GlobalInboundCauseAdvice.findByChannelHandler.md#symbol-349b233d3de509d6) — `function`, source line 264
- [postProcessBeanFactory](GlobalInboundCauseAdvice.postProcessBeanFactory.md#symbol-8af3338b857dd4a4) — `function`, source line 274
- [CauseInfo](GlobalInboundCauseAdvice.CauseInfo.md#symbol-32deec41d095079b) — `class`, source line 293
