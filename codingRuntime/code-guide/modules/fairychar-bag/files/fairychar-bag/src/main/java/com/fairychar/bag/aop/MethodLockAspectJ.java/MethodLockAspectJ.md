# com.fairychar.bag.aop.MethodLockAspectJ

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MethodLockAspectJ.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-d5c300d3c2da2fab"></a>
## com.fairychar.bag.aop.MethodLockAspectJ

```java
@Aspect
@EnableConfigurationProperties(FairycharBagProperties.class)
@Order
@Slf4j
public class MethodLockAspectJ implements InitializingBean
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/aop/MethodLockAspectJ.java:55`; evidence: `declaration-d5c300d3c2da2fab7d62361af801b1f0ddadc992700602310663b732b0c56788`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
这个类是一个切面，用于基于注解提供方法锁定功能。
 它支持不同类型的锁，如本地锁、Redis锁和ZooKeeper锁。
 该切面拦截使用@MethodLock注解的方法，并应用指定的锁类型。
 它使用一个Map来存储本地锁，并在不存在时创建一个新的锁。
 对于Redis锁，它使用RedissonClient来获取和释放锁。
 对于ZooKeeper锁，它使用CuratorFramework来创建和释放锁。
 该切面还处理乐观锁，通过检查在超时期间是否可以获取到锁。
 它使用FairycharBagProperties类来获取配置属性。
 该切面使用AspectJ实现，并按顺序在其他切面之后执行。

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-42e380e9c9820394"></a>
### fairycharBagProperties

```java
@Autowired
private FairycharBagProperties fairycharBagProperties
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/aop/MethodLockAspectJ.java:60`; evidence: `declaration-42e380e9c9820394caf24c26eb26656251dce7901c1293e08293de769141bb91`.
Visibility: `private` (explicit).
Type: `FairycharBagProperties`.
No initializer recorded.

<a id="symbol-2acdc3127d005aaa"></a>
### spelExpressionParser

```java
private final SpelExpressionParser spelExpressionParser = new SpelExpressionParser()
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/aop/MethodLockAspectJ.java:62`; evidence: `declaration-2acdc3127d005aaa4dde209cf1606308c1dd7e9a5e4cc545604e2c47b2d4e435`.
Visibility: `private` (explicit).
Type: `SpelExpressionParser`.

<a id="symbol-5ccdc415fb4a31be"></a>
### lockMap

```java
private Map<String, ReentrantLock> lockMap = new ConcurrentHashMap<>(32)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/aop/MethodLockAspectJ.java:63`; evidence: `declaration-5ccdc415fb4a31beac58064f0f6fd468de21849de097b39c7c437d63b32ee0db`.
Visibility: `private` (explicit).
Type: `Map<String, ReentrantLock>`.

<a id="symbol-206ee0025639c573"></a>
### parameterNameDiscoverer

```java
private final ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer()
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/aop/MethodLockAspectJ.java:64`; evidence: `declaration-206ee0025639c573c682f71c0eba7d02a978fc1c17361c43fc25b77c9f3ed7c6`.
Visibility: `private` (explicit).
Type: `ParameterNameDiscoverer`.

## Members

- [locking](MethodLockAspectJ.locking.md#symbol-3cc30b8f49912431) — `function`, source line 66
- [switchLock](MethodLockAspectJ.switchLock.md#symbol-96737a8344a824da) — `function`, source line 76
- [doLocalLock](MethodLockAspectJ.doLocalLock.md#symbol-7b47d58969a4e35f) — `function`, source line 92
- [doRedisLock](MethodLockAspectJ.doRedisLock.md#symbol-ccd538b16256530b) — `function`, source line 128
- [doZookeeperLock](MethodLockAspectJ.doZookeeperLock.md#symbol-5345e66d1744d41e) — `function`, source line 165
- [getMethodFullPath](MethodLockAspectJ.getMethodFullPath.md#symbol-99c995cc3494948f) — `function`, source line 205
- [getTimeout](MethodLockAspectJ.getTimeout.md#symbol-5f77b995744890ba) — `function`, source line 217
- [getTimeUnit](MethodLockAspectJ.getTimeUnit.md#symbol-6e74e246a57c46bd) — `function`, source line 228
- [createOrGetLocalLock](MethodLockAspectJ.createOrGetLocalLock.md#symbol-f9f6d5ee6544c1c4) — `function`, source line 237
- [resolveNameExpression](MethodLockAspectJ.resolveNameExpression.md#symbol-a439d748d59e16e1) — `function`, source line 244
- [createEvaluationContext](MethodLockAspectJ.createEvaluationContext.md#symbol-552cbf6c2b67f1fa) — `function`, source line 258
- [afterPropertiesSet](MethodLockAspectJ.afterPropertiesSet.md#symbol-89018239f3d2cf87) — `function`, source line 264
