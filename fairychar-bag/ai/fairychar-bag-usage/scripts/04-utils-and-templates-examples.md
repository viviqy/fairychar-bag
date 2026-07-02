# Utils And Templates Examples

> 返回主入口: [fairychar-bag-usage-guide.md](../fairychar-bag-usage-guide.md)。说明和约束见 `../references/` 中对应文档。

## Example 1: StringUtil

```java
byte[] bytes = StringUtil.compressByGzip("hello");
String text = StringUtil.decompressByGzip(bytes);
String value = StringUtil.defaultText(input, "default");
```

## Example 2: DateConvertUtil

```java
LocalDate date = DateConvertUtil.parseDate("20260702");
LocalDateTime time = DateConvertUtil.parseTime("2026-07-02 12:30:00");
Date legacy = DateConvertUtil.localdateToDate(LocalDate.now());
```

## Example 3: RequestUtil

```java
HttpServletRequest request = RequestUtil.getCurrentRequest();
HttpServletResponse response = RequestUtil.getCurrentResponse();
String ip = RequestUtil.getIpAddress(request);
Map<String, String> headers = RequestUtil.getHeader(request);

RequestUtil.putAttribute("userId", 1L);
Long userId = RequestUtil.getAttribute("userId", Long.class);
```

## Example 4: SpelUtil

```java
Method method = OrderService.class.getMethod("update", Long.class);
String key = SpelUtil.eval("'order:' + #orderId", method, new Object[]{1L}, String.class);
```

## Example 5: Map 和 Bean 转换

```java
Map<String, Object> map = Map.of("id", 1L, "name", "Tom");
User user = ReflectUtil.mapToEntity(map, User.class);

Map<String, Object> userMap = ReflectUtil.entityToMap(user, false);

UserVO vo = ReflectUtil.copyProperties(user, UserVO.class, false);
ReflectUtil.copyProperties(user, existingVO, false);
```

## Example 6: 字段保留和擦除

```java
ReflectUtil.eraseValue(user, "password,salt");
ReflectUtil.eraseValue(user, String.class);
ReflectUtil.keepValue(user, "id,name");
```

## Example 7: 递归搜索父子

```java
List<Menu> children = ReflectUtil.recursiveSearchChild(allMenus, "id", "parentId", 0L);
List<Menu> parents = ReflectUtil.recursiveSearchParent(allMenus, "parentId", "id", childId);
```

## Example 8: 递归搜索父子

```java
List<Menu> allChildren = ReflectUtil.recursiveSearchChild("id", 0L, parentIds -> {
    return menuMapper.selectByParentIds(parentIds);
});

List<Menu> allParents = ReflectUtil.recursiveSearchParent("parentId", List.of(10L, 11L), ids -> {
    return menuMapper.selectByIds(ids);
});
```

## Example 9: 注解字段搜索

```java
Map<Class<? extends Annotation>, List<FieldContainer>> result =
        ReflectUtil.recursiveSearchFieldValueByAnnotations(
                user,
                List.of(FuzzyValue.class)
        );
```

## Example 10: 列表转 TreeNode

```java
List<TreeNode<Menu>> tree = MappingObjectUtil.listToTree(
        menus,
        "parentId",
        "id",
        0L
);
```

## Example 11: 列表转原对象树

```java
List<Menu> tree = MappingObjectUtil.listToTree(
        menus,
        "parentId",
        "id",
        "children",
        0L
);
```

## Example 12: Map 转展示对象

```java
List<MappingAO<String, Long>> items = MappingObjectUtil.mapping(countMap);
List<MappingObjectAO<String, User>> groups = MappingObjectUtil.mappingList(groupMap);
List<MapObjectNode<User>> nodes = MappingObjectUtil.mapToNode(nestedGroupMap);
```

## Example 13: RedisLockUtil

```java
RLock lock = redissonClient.getLock("user:" + userId);
RedisLockUtil.lock(lock, () -> {
    // 业务逻辑
});
```

## Example 14: RedisLockUtil

```java
RedisLockUtil.lock(
        lock,
        () -> checkCacheBeforeLock(),
        () -> checkCacheAfterLock(),
        () -> loadDbAndPutCache(),
        30,
        TimeUnit.SECONDS
);
```

## Example 15: RedisLockUtil

```java
RedisLockUtil.tryLock(lock, () -> updateStock(), 3, TimeUnit.SECONDS);
```

## Example 16: CacheOperateTemplate

```java
User user = CacheOperateTemplate.get(
        () -> localCache.get(id),
        () -> userMapper.selectById(id),
        value -> localCache.put(id, value),
        ("user:" + id).intern()
);
```

## Example 17: CacheOperateTemplate

```java
User user = CacheOperateTemplate.get(
        () -> redisTemplate.opsForValue().get("user:" + id),
        () -> userMapper.selectById(id),
        value -> redisTemplate.opsForValue().set("user:" + id, value),
        redissonClient.getLock("lock:user:" + id)
);
```

## Example 18: TransactionUtil

```java
ExecutorService executor = Executors.newFixedThreadPool(2);
AtomicBoolean allSuccess = new AtomicBoolean(true);
CyclicBarrier barrier = new CyclicBarrier(2);

Future<?> f1 = TransactionUtil.doWithTransactionAsync(
        () -> orderMapper.insert(order),
        allSuccess,
        barrier,
        executor,
        transactionTemplate,
        30
);

Future<?> f2 = TransactionUtil.doWithTransactionAsync(
        () -> stockMapper.deduct(stockId),
        allSuccess,
        barrier,
        executor,
        transactionTemplate,
        30
);

ConcurrentUtil.getFutures(List.of(f1, f2));
```

## Example 19: ConcurrentUtil

```java
ConcurrentUtil.getFutures(futures);
```

## Example 20: CollectionUtil

```java
List<List<Long>> parts = CollectionUtil.splitList(ids, 4);
```

## Example 21: CircularTaskUtil

```java
boolean ok = CircularTaskUtil.run(
        () -> remoteService.isReady(),
        true,
        100,
        5_000
);
```

## Example 22: FileUtil

```java
FileUtil.concatFile("out.bin", new File("head.bin"), new File("part1.bin"), new File("part2.bin"));
```

## Example 23: FileUtil

```java
FileUtil.cutFile("source.bin", "middle.bin", 0.2D, 0.8D);
```

## Example 24: FileUtil

```java
FileUtil.createFakeFile("tmp.bin", 1024 * 1024);
FileUtil.createFakeFileByNio("tmp-nio.bin", (byte) 0, 1024 * 1024, 4096);
```

## Example 25: TaskTestUtil

```java
ExecutorService executor = TaskTestUtil.createThreadPool("demo", 8);
long cost = TaskTestUtil.batchRunSync(() -> service.call(), 100, executor);
TaskTestUtil.concurrentRunAsync(List.of(action1, action2));
```

