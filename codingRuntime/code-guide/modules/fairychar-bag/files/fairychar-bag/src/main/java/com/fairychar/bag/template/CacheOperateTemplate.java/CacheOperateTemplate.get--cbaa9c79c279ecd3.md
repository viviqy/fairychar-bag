# com.fairychar.bag.template.CacheOperateTemplate.get

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../CacheOperateTemplate.java.md)

[Lexical owner](CacheOperateTemplate.md#symbol-fc51f61fadef4eee)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-33e201d422a11665"></a>
## com.fairychar.bag.template.CacheOperateTemplate.get

```java
public static <C> C get(Supplier<C> fromCache, Supplier<C> fromDb, Consumer<C> putCache, RLock lock)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/template/CacheOperateTemplate.java:48`; evidence: `declaration-33e201d422a116650f8621e6c10a710c0fcac39587c5a24dfee373053ab76abe`.
Owner: `com.fairychar.bag.template.CacheOperateTemplate`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
redis分布式缓存读取(悲观锁方式)

 @param fromCache 缓存数据提供者
 @param fromDb    数据库数据提供者
 @param putCache  数据库数据到缓存数据消费者
 @param lock      分布式lock实现者
 @param <C>       返回类泛型
 @return {@link C}
```
