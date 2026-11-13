# com.fairychar.bag.listener.SpringContextHolder

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SpringContextHolder.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-38444f34fbcedb50"></a>
## com.fairychar.bag.listener.SpringContextHolder

```java
@Order(Ordered.HIGHEST_PRECEDENCE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpringContextHolder implements ApplicationListener<ContextRefreshedEvent>
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/listener/SpringContextHolder.java:23`; evidence: `declaration-38444f34fbcedb50c7839f59f9e74b8e16ec45eadf9a2e38a70ef56f4d428657`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>spring bean工具类,包含ApplicationContext的所有方法</p>

 @author qiyue
```


## Fields

<a id="symbol-8d51e1b0b6c4a7a1"></a>
### context

```java
@Delegate(types = {EnvironmentCapable.class, ListableBeanFactory.class, HierarchicalBeanFactory.class, MessageSource.class, ApplicationEventPublisher.class, ResourcePatternResolver.class})
private ApplicationContext context
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/listener/SpringContextHolder.java:27`; evidence: `declaration-8d51e1b0b6c4a7a1c2529fdb8a0b0be98a884fe16c92b0be5ce248892eb68fd6`.
Visibility: `private` (explicit).
Type: `ApplicationContext`.
No initializer recorded.

## Members

- [getInstance](SpringContextHolder.getInstance.md#symbol-b943c9992c2643fd) — `function`, source line 31
- [onApplicationEvent](SpringContextHolder.onApplicationEvent.md#symbol-d2566d9ff4c08412) — `function`, source line 35
- [Singleton](SpringContextHolder.Singleton.md#symbol-a5aa8ac6dbd0d761) — `enum`, source line 41
