# com.fairychar.bag.domain.netty.advice.GlobalInboundEventAdvice

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../GlobalInboundEventAdvice.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-fbe07655f6d5f4ef"></a>
## com.fairychar.bag.domain.netty.advice.GlobalInboundEventAdvice

```java
@Slf4j
public class GlobalInboundEventAdvice extends ChannelInboundHandlerAdapter implements BeanFactoryPostProcessor
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundEventAdvice.java:30`; evidence: `declaration-fbe07655f6d5f4ef4bbb690b98b9a09f553e6fdd8c5e5facfbb9b5768cac0b0d`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
Datetime: 2021/7/1 21:55

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-7e7441c7784301e0"></a>
### cache1

```java
private HashMap<Class, Method> cache1
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundEventAdvice.java:37`; evidence: `declaration-7e7441c7784301e0da9e35b16c1b23a1fa373590d39cd8c82290a54e4336b6f6`.
Visibility: `private` (explicit).
Type: `HashMap<Class, Method>`.
No initializer recorded.

Source docstring (unreviewed):
```text
key=mark(ex+handler+method)
```


<a id="symbol-20381c2e2361a52a"></a>
### invokeArgsCache

```java
private HashMap<String, InvokeEntity> invokeArgsCache = new HashMap<>(32)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundEventAdvice.java:41`; evidence: `declaration-20381c2e2361a52aa2bd31c822fc62efc093135860e956fe26faa63817ba33de`.
Visibility: `private` (explicit).
Type: `HashMap<String, InvokeEntity>`.

Source docstring (unreviewed):
```text
key=method fullName;
```


<a id="symbol-fadf7e9be9201399"></a>
### beanMap

```java
private Map<String, Object> beanMap
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundEventAdvice.java:42`; evidence: `declaration-fadf7e9be9201399474cf7905c368e1d25520aea8c94a0b66a8862193854a020`.
Visibility: `private` (explicit).
Type: `Map<String, Object>`.
No initializer recorded.

## Members

- [userEventTriggered](GlobalInboundEventAdvice.userEventTriggered.md#symbol-dd569d925ece613d) — `function`, source line 44
- [dispatch](GlobalInboundEventAdvice.dispatch.md#symbol-60d636978e76f466) — `function`, source line 49
- [invoke](GlobalInboundEventAdvice.invoke.md#symbol-a4032894caac9128) — `function`, source line 65
- [getInvokeEntity](GlobalInboundEventAdvice.getInvokeEntity.md#symbol-d03569e663308c3c) — `function`, source line 82
- [obtainMethod](GlobalInboundEventAdvice.obtainMethod.md#symbol-ffa2115d9e73aab1) — `function`, source line 100
- [validate](GlobalInboundEventAdvice.validate.md#symbol-f11e3f8796f1cfb3) — `function`, source line 115
- [createCache](GlobalInboundEventAdvice.createCache.md#symbol-ce72d8699662c790) — `function`, source line 130
- [ensureNotExistSameMethod](GlobalInboundEventAdvice.ensureNotExistSameMethod.md#symbol-e50211d823301b48) — `function`, source line 147
- [initCache](GlobalInboundEventAdvice.initCache.md#symbol-faa6e7223672e41b) — `function`, source line 162
- [postProcessBeanFactory](GlobalInboundEventAdvice.postProcessBeanFactory.md#symbol-dc278afd2cd9e5d1) — `function`, source line 172
- [EventInfo](GlobalInboundEventAdvice.EventInfo.md#symbol-04338cb03d34e8eb) — `class`, source line 186
