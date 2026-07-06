# Utils And Templates Reference

> 返回主入口: [fairychar-bag-usage-guide.md](../fairychar-bag-usage-guide.md)。本文件只保留说明、约束和 API 语义；代码示例放在 `../scripts/`。

## 工具类详解

### StringUtil

位置: `com.fairychar.bag.utils.StringUtil`


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `StringUtil`。


方法:

- `compressByGzip(String data)`: UTF-8 Gzip 压缩，失败抛 `FBException`。
- `decompressByGzip(byte[] compressedData)`: UTF-8 Gzip 解压，按行读取并拼接，换行会被去掉。
- `defaultText(String source, String text)`: `source` 为 null 或空字符串时返回 `text`。
- `fillBegin` / `fillEnd`: 已废弃，优先用 Guava `Strings.padStart/padEnd`。

### DateConvertUtil

位置: `com.fairychar.bag.utils.DateConvertUtil`


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `DateConvertUtil`。


支持日期格式:

- `yyyy-MM-dd`
- `yyyyMMdd`
- `yyyyMd`
- `yyyy/M/d`
- `yyyy/MM/dd`

支持时间格式:

- `yyyy-MM-dd HH:mm:ss`
- `yyyyMMdd HH:mm:ss`
- `yyyyMd HH:mm:ss`
- `yyyy/M/d HH:mm:ss`
- `yyyy/M/d HH/mm/ss`
- `yyyy/MM/dd HH/mm/ss`
- `yyyy/MM/ddHH/mm/ss`
- `yyyyMMdd HHmmss`
- `yyyyMMddHHmmss`

注意: 解析失败返回 `null`，不会抛解析异常；入参空白会触发 Hutool `Assert.notBlank`。

### RequestUtil

位置: `com.fairychar.bag.utils.RequestUtil`


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `RequestUtil`。


方法:

- `getHeader(HttpServletRequest)`: 返回所有 header 的 `LinkedHashMap`。
- `getCurrentRequest()`: 从 `RequestContextHolder` 获取当前请求，失败抛 `FBException`。
- `getCurrentResponse()`: 从 `RequestContextHolder` 获取当前响应，失败抛 `FBException`。
- `putAttribute(String, T)`: 写当前 request attribute。
- `getAttribute(String, Class<T>)`: 读当前 request attribute，源码未做类型校验，靠调用方保证类型。
- `getIpAddress(HttpServletRequest)`: 依次读取 `X-Forwarded-For`、`Proxy-Client-IP`、`WL-Proxy-Client-IP`、`HTTP_CLIENT_IP`、`X-Real-IP`，最后用 `getRemoteAddr()`。
- `obtainUri(MethodSignature)`: 从 Controller 类和方法的 Mapping 注解拼接 URI。

注意:

- `obtainUri` 假设 mapping 的 `value()[0]` 存在，空 mapping 可能异常。
- `getCurrentRequest/Response` 只能在请求线程使用。

### SpelUtil

位置: `com.fairychar.bag.utils.SpelUtil`

用于 AOP 场景从方法参数解析 SpEL。


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `SpelUtil`。


方法:

- `eval(String expression, JoinPoint joinPoint, Class<T> returnType)`
- `eval(String expression, Method method, Object[] args, Class<T> returnType)`
- `createEvaluationContext(Method method, Object[] args)`
- `parseExpression(String expression)`: 内部有 `ConcurrentHashMap` 表达式缓存。

### ReflectUtil

位置: `com.fairychar.bag.utils.ReflectUtil`

适用于简单 Bean 映射、递归查找字段、树形父子递归查找、字段擦除/保留。它直接使用反射字段，不依赖 getter/setter。

#### Map 和 Bean 转换


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `Map 和 Bean 转换`。


参数语义:

- `mapToEntity(map, clazz, mustMatchAll, matchNull)`
  - `mustMatchAll=true`: map key 在目标类找不到同名字段时抛异常。
  - `matchNull=true`: null 值也写入目标字段。
- `entityToMap(source, matchNull)`
  - `matchNull=false`: 跳过 null 值。
- `copyProperties(source, target, matchNull)`
  - 只复制同名字段。
  - `matchNull=false`: null 值不复制。

#### 字段保留和擦除


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `字段保留和擦除`。


注意:

- `eraseValue(o, "*")` 会擦除当前类所有声明字段。
- `keepValue` 当前实现对多字段匹配有重复循环，复杂场景要先看源码或补测试。
- final 字段可能抛异常。

#### 递归搜索父子

内存列表:


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `递归搜索父子`。


函数式查询，适合数据库批量查询:


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `递归搜索父子`。


#### 注解字段搜索


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `注解字段搜索`。


支持递归对象、`Collection`、`Map`，并通过 `identityHashCode` 防止循环引用重复解析。

#### Unsafe 方法

`setLong`、`setInt`、`compareAndSwapLong`、`compareAndSwapInteger` 会修改包装类型内部值，属于危险能力。普通业务代码不要使用，除非明确需要做底层实验且有测试覆盖。

### MappingObjectUtil

位置: `com.fairychar.bag.utils.MappingObjectUtil`

#### 列表转 TreeNode


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `列表转 TreeNode`。


返回 `TreeNode<T>`:

- `current`: 当前对象。
- `child`: 子节点列表。

#### 列表转原对象树


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `列表转原对象树`。


要求对象有同名字段:

- `parentId`
- `id`
- `children`

且 `children` 类型能接收 `List<T>`。

#### Map 转展示对象


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `Map 转展示对象`。


用途:

- `mapping`: `Map<K,V>` -> `List<MappingAO<K,V>>`
- `mappingList`: `Map<K,List<V>>` -> 带 count 的列表。
- `mapToNode`: 支持嵌套 `Map` 或末级 `List` 的树节点包装。

### RedisLockUtil

位置: `com.fairychar.bag.utils.RedisLockUtil`

悲观锁:


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `RedisLockUtil`。


带双检查:


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `RedisLockUtil`。


乐观锁:


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `RedisLockUtil`。


语义:

- `lock(...)`: 调用 Redisson `lock()` 或 `lock(time, unit)`，获取不到时阻塞。
- `tryLock(...)`: 获取失败抛 `FailToGetLockException`。
- `beforeSearch`: 加锁前执行。
- `searchAgain`: 加锁后再次检查，典型用于缓存击穿双检查。
- `action`: 真正业务动作。
- finally 中会判断 `isHeldByCurrentThread()` 后解锁。

### CacheOperateTemplate

位置: `com.fairychar.bag.template.CacheOperateTemplate`

本地锁缓存读取:


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `CacheOperateTemplate`。


Redis 分布式锁缓存读取:


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `CacheOperateTemplate`。


语义:

1. 先读缓存。
2. 缓存为空则加锁。
3. 锁内再次读缓存。
4. 仍为空则读 DB。
5. DB 非空时写缓存并返回。
6. DB 为空时返回 null，不写缓存。

### TransactionUtil

位置: `com.fairychar.bag.utils.TransactionUtil`

用于多个异步事务协同提交/回滚。所有任务执行完后在 `CyclicBarrier` 等待，如果任一任务失败则 `isAllSuccess=false`，各事务在 finally 中标记回滚。


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `TransactionUtil`。


注意:

- `CyclicBarrier` 的 parties 必须等于参与事务任务数。
- 如果一个任务抛异常，会设置 `isAllSuccess=false`。
- 如果等待超时或 barrier 异常，也会回滚。

### ConcurrentUtil

位置: `com.fairychar.bag.utils.ConcurrentUtil`


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `ConcurrentUtil`。


逐个 `Future.get()`:

- `InterruptedException`: 恢复中断标记并抛 `FBException`。
- `ExecutionException`: 抛 `FBException`。

### CollectionUtil

位置: `com.fairychar.bag.utils.CollectionUtil`


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `CollectionUtil`。


将列表尽量平均分成指定份数:

- 原列表长度小于等于份数时，每个元素单独一份，不足部分补空列表。
- 原列表长度大于份数时，余数分配给前几份。

### CircularTaskUtil

位置: `com.fairychar.bag.utils.CircularTaskUtil`


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `CircularTaskUtil`。


参数:

- `task`: 每轮执行的 `Supplier<Boolean>`。
- `condition`: 期望结果。
- `maxRound`: 最大轮数，0 表示无限。
- `maxMillis`: 最大耗时毫秒，0 表示无限。

注意: 无法中断正在执行的 supplier，只在下一轮循环前检查超时。

### FileUtil

位置: `com.fairychar.bag.utils.FileUtil`

拼接文件:


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `FileUtil`。


按百分比分割文件:


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `FileUtil`。


创建测试假文件:


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `FileUtil`。


注意:

- `cutFile` 的 `start` 范围 `[0, 1)`，`end` 范围 `(0, 1]`。
- `createFakeFileByNio` 如果目标文件已存在，会抛运行时异常。

### TaskTestUtil

位置: `com.fairychar.bag.utils.test.TaskTestUtil`

用于测试或压测辅助，不建议生产业务依赖。


> 代码示例已移到 `../scripts/04-utils-and-templates-examples.md`，对应标题: `TaskTestUtil`。


常用方法:

- `createThreadPool(poolName, size)`
- `createThreadPoolByCpuCore(poolName)`
- `createThreadPoolByCpuCore(poolName, multi)`
- `concurrentRunAsync(actions)`
- `batchRunSync(actions, executor)`
- `batchRunAsync(actions, executor)`
- `getWasteMillis(action, round)`

