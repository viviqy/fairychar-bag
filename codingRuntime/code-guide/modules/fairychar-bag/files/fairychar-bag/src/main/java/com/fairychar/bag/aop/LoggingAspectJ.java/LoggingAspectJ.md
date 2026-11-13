# com.fairychar.bag.aop.LoggingAspectJ

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../LoggingAspectJ.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-5cd4c0260ab2da3c"></a>
## com.fairychar.bag.aop.LoggingAspectJ

```java
@Aspect
@Slf4j
@EnableConfigurationProperties(value = {FairycharBagProperties.class})
@Order(0)
public class LoggingAspectJ implements InitializingBean
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/aop/LoggingAspectJ.java:28`; evidence: `declaration-5cd4c0260ab2da3c4669c0fe4ac1d45751cd37757ee04bea41b5501293478852`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
该类是一个切面，用于在控制器方法执行前后记录日志。
 它通过使用@RequestLog注解来确定是否启用日志记录。
 如果启用了日志记录，则根据配置的处理程序名称执行相应的处理方法。
 如果未配置处理程序名称，则使用全局配置的处理程序名称执行处理方法。
 处理程序需要实现LoggingHandler接口。
```


## Fields

<a id="symbol-92b627836104495a"></a>
### properties

```java
@Autowired
private FairycharBagProperties properties
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/aop/LoggingAspectJ.java:34`; evidence: `declaration-92b627836104495a4e7400bddde6dfe350da6925ba21566703b5d0259d891a62`.
Visibility: `private` (explicit).
Type: `FairycharBagProperties`.
No initializer recorded.

<a id="symbol-a35a18151f9a9ac7"></a>
### handlerMap

```java
@Autowired
private Map<String, LoggingHandler> handlerMap
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/aop/LoggingAspectJ.java:36`; evidence: `declaration-a35a18151f9a9ac740446c408af4b699618f3dfcf2b43d93a4a3770868d7eaaa`.
Visibility: `private` (explicit).
Type: `Map<String, LoggingHandler>`.
No initializer recorded.

## Members

- [beforeLogging](LoggingAspectJ.beforeLogging.md#symbol-3b0496dcfc53a52d) — `function`, source line 45
- [afterLogging](LoggingAspectJ.afterLogging.md#symbol-456ed48129118ef1) — `function`, source line 69
- [afterPropertiesSet](LoggingAspectJ.afterPropertiesSet.md#symbol-e3c8e5be1e2d42ce) — `function`, source line 90
- [handleBefore](LoggingAspectJ.handleBefore.md#symbol-5ebfeb1e34570926) — `function`, source line 98
- [handleAfter](LoggingAspectJ.handleAfter.md#symbol-7bdf49817c4248c0) — `function`, source line 110
