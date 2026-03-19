# Fairychar-bag 代码地图

> 本文档包含 fairychar-bag 模块中所有类的功能说明和函数签名
> 生成时间: 2025-01-XX

## 目录

- [Utils 工具类](#utils-工具类)
- [AOP 切面](#aop-切面)
- [Beans 组件](#beans-组件)
- [Domain 领域层](#domain-领域层)
- [Extension 扩展](#extension-扩展)
- [Function 函数式接口](#function-函数式接口)
- [Properties 配置属性](#properties-配置属性)
- [Template 模板](#template-模板)

---

## Utils 工具类

### com.fairychar.bag.utils.TransactionUtil

**类型**: Class

**功能**: 数据库事务操作工具类，支持异步事务执行，使用CyclicBarrier实现多事务协调

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `Future<?> doWithTransactionAsync(Action action, AtomicBoolean isAllSuccess, CyclicBarrier cyclicBarrier, ExecutorService executor, TransactionTemplate transactionTemplate)` | 异步执行带事务的操作，默认60秒超时 |
| `Future<?> doWithTransactionAsync(Action action, AtomicBoolean isAllSuccess, CyclicBarrier cyclicBarrier, ExecutorService executor, TransactionTemplate transactionTemplate, int timeoutSeconds)` | 异步执行带事务的操作，支持自定义超时时间 |

---

### com.fairychar.bag.utils.StringUtil

**类型**: Class (final)

**功能**: 字符串工具处理类，提供Gzip压缩解压、字符串填充等功能

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `byte[] compressByGzip(String data)` | 使用gzip压缩字符串为byte数组 |
| `String decompressByGzip(byte[] compressedData)` | 使用gzip解压缩byte数组为字符串 |
| `String fillBegin(String source, char c, int length)` | 从开头填充字符串到固定长度(已废弃) |
| `String fillEnd(String source, char c, int length)` | 从尾部填充字符串到固定长度(已废弃) |
| `String defaultText(String source, String text)` | 当原文本为空或null时返回默认文本 |

---

### com.fairychar.bag.utils.SpelUtil

**类型**: Class

**功能**: SpEL(Spring Expression Language)表达式工具类

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `<T> T eval(String expression, JoinPoint joinPoint, Class<T> returnType)` | 评估SpEL表达式，基于AOP连接点 |
| `<T> T eval(String expression, Method method, Object[] args, Class<T> returnType)` | 计算SpEL值，基于方法和参数 |
| `EvaluationContext createEvaluationContext(Method method, Object[] args)` | 创建SpEL上下文 |
| `Expression parseExpression(String expression)` | 解析SpEL表达式 |

---

### com.fairychar.bag.utils.RequestUtil

**类型**: Class (final)

**功能**: Servlet请求工具类，提供请求头获取、IP地址获取、URI解析等功能

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `Map<String, String> getHeader(HttpServletRequest request)` | 获取request的所有header信息 |
| `HttpServletRequest getCurrentRequest()` | 获取当前线程的请求对象 |
| `HttpServletResponse getCurrentResponse()` | 获取当前线程的响应对象 |
| `<T> void putAttribute(String keyName, T attribute)` | 向当前thread的request设置属性 |
| `<T> T getAttribute(String keyName, Class<T> clazz)` | 从当前thread的request获取属性 |
| `String getIpAddress(HttpServletRequest request)` | 获取远端访问ip地址（支持多级代理） |
| `String obtainUri(MethodSignature signature)` | 通过反射获取请求地址 |

---

### com.fairychar.bag.utils.ReflectUtil

**类型**: Class (final)

**功能**: 反射工具类，提供字段递归搜索、属性复制、实体转换等功能

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `Map<Class<? extends Annotation>, List<FieldContainer>> recursiveSearchFieldValueByAnnotations(Object e, Collection<Class<? extends Annotation>> annotations)` | 递归搜索带有指定注解的字段值 |
| `<T, I> List<T> recursiveSearchParent(List<T> source, String pidField, String idField, I idValue)` | 递归查询指定id的所有父项 |
| `<T, I> List<T> recursiveSearchChild(List<T> source, String idField, String pidField, I idValue)` | 递归查询指定id的所有子项 |
| `<T, I> List<T> recursiveSearchParent(String pidField, I idValue, Function<List<I>, List<T>> parentSearchSupplier)` | 递归搜索父项（基于函数式查询） |
| `<T, I> List<T> recursiveSearchParent(String pidField, List<I> idValues, Function<List<I>, List<T>> parentSearchSupplier)` | 递归搜索多个父项 |
| `<T, P> List<T> recursiveSearchChild(String idField, P pidValue, Function<List<P>, List<T>> childSearchSupplier)` | 递归搜索子项（基于函数式查询） |
| `<T, P> List<T> recursiveSearchChild(String idField, List<P> pidValues, Function<List<P>, List<T>> childSearchSupplier)` | 递归搜索多个子项 |
| `Map<Class<? extends Annotation>, List<Field>> recursiveSearchFieldByAnnotations(Class clazz, Collection<Class<? extends Annotation>> annotations)` | 递归搜索带有指定注解的字段 |
| `void keepValue(Object o, String fields)` | 保留指定字段值，其他置为null |
| `void eraseValue(Object o, Class<?>... fieldTypes)` | 擦除指定类型的字段值 |
| `void eraseValue(Object o, String fields)` | 擦除指定字段值 |
| `void setLong(Long source, Long expect)` | 通过unsafe修改Long类型的值 |
| `void setInt(Integer source, Integer expect)` | 通过unsafe修改Integer类型的值 |
| `void compareAndSwapLong(Long a, Long b)` | 通过unsafe交换Long a和Long b的值 |
| `void compareAndSwapInteger(Integer a, Integer b)` | 通过unsafe交换Integer a和Integer b的值 |
| `<T> T mapToEntity(Map<String, Object> map, Class<T> tClass)` | Map转换为实体对象 |
| `<T> T mapToEntity(Map<String, Object> map, Class<T> tClass, boolean mustMatchAll, boolean matchNull)` | Map转换为实体对象（带匹配选项） |
| `Map<String, Object> entityToMap(Object source)` | 实体对象转换为Map |
| `Map<String, Object> entityToMap(Object source, boolean matchNull)` | 实体对象转换为Map（带null值选项） |
| `Unsafe getUnsafe()` | 获取Unsafe实例 |
| `Set<Field> getClassFields(Class<?> clazz, boolean getParent, boolean getStatic, boolean getFinal)` | 获取类的字段 |
| `void copyProperties(Object source, Object target, boolean matchNull)` | 复制属性到目标对象 |
| `<T> T copyProperties(Object source, Class<T> tClass, boolean matchNull)` | 复制属性到新实例 |

---

### com.fairychar.bag.utils.base.FieldContainer

**类型**: Class

**功能**: Field容器，包含Field与其对应Object

#### 字段:

| 字段名 | 类型 | 说明 |
|--------|------|------|
| `targetObject` | Object | 目标对象 |
| `field` | Field | 字段 |
| `path` | String | 字段全路径，如A.b.c.name |

---

### com.fairychar.bag.utils.RedisLockUtil

**类型**: Class (final)

**功能**: Redis分布式锁工具类，提供悲观锁和乐观锁操作

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `void lock(RLock lock, Action checkIsPresent, Action action, int time, TimeUnit timeUnit)` | 获取锁并执行操作（带超时） |
| `void lock(RLock lock, Action action, int time, TimeUnit timeUnit)` | 获取锁并执行操作（带超时） |
| `void lock(RLock lock, Action action)` | 获取锁并执行操作 |
| `void lock(RLock lock, Action checkIsPresent, Action action)` | 获取锁并执行操作（带前置检查） |
| `void lock(RLock lock, Action beforeSearch, Action searchAgain, Action action)` | 获取锁并执行操作（双检查） |
| `void lock(RLock lock, Action beforeSearch, Action searchAgain, Action action, int time, TimeUnit timeUnit)` | 获取锁并执行操作（双检查+超时） |
| `void tryLock(RLock lock, Action action, int time, TimeUnit timeUnit)` | 尝试获取锁并执行操作 |
| `void tryLock(RLock lock, Action checkIsPresent, Action action, int time, TimeUnit timeUnit)` | 尝试获取锁并执行操作（带检查） |
| `void tryLock(RLock lock, Action action)` | 尝试获取锁并执行操作 |
| `void tryLock(RLock lock, Action checkIsPresent, Action action)` | 尝试获取锁并执行操作（带检查） |
| `void tryLock(RLock lock, Action beforeSearch, Action searchAgain, Action action)` | 尝试获取锁并执行操作（双检查） |
| `void tryLock(RLock lock, Action beforeSearch, Action searchAgain, Action action, int time, TimeUnit timeUnit)` | 尝试获取锁并执行操作（双检查+超时） |

---

### com.fairychar.bag.utils.MappingObjectUtil

**类型**: Class (final)

**功能**: HTTP响应体渲染工具类，提供列表转树、Map转节点等功能

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `<T, I> List<TreeNode<T>> listToTree(List<T> source, String pidField, String idField, I idValue)` | 列表转换为树形结构 |
| `<T, I> List<T> listToTree(List<T> source, String pidField, String idField, String childField, I idValue)` | 列表转换为树形结构（指定子字段） |
| `<T> List<MapObjectNode<T>> mapToNode(Map<? extends Object, ? extends Object> groupingBy)` | Map转换为节点列表 |
| `<K, V> List<MappingAO<K, V>> mapping(Map<K, V> map)` | Map转换为MappingAO列表 |
| `<K, V> List<MappingObjectAO<K, V>> mappingList(Map<K, List<V>> maps)` | Map转换为MappingObjectAO列表 |

---

### com.fairychar.bag.utils.FileUtil

**类型**: Class (final)

**功能**: 文件操作工具类，提供文件拼接、分割、创建虚拟文件等功能

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `void concatFile(String outputPath, File head, File... concatFiles)` | 拼接多个文件 |
| `void cutFile(String sourceFilePath, String outputFilePath, double start, double end)` | 按百分比分割文件 |
| `void createFakeFileByNio(String path, long writeByteSize)` | 使用NIO创建虚拟文件 |
| `void createFakeFileByNio(String path, byte fillByte, long writeByteSize)` | 使用NIO创建虚拟文件（指定填充字节） |
| `void createFakeFile(String path, long writeByteSize)` | 创建虚拟文件 |
| `void createFakeFile(String path, byte fillByte, long writeByteSize)` | 创建虚拟文件（指定填充字节） |
| `void createFakeFileByNio(String path, byte fillByte, long writeByteSize, int pipeBufferSize)` | 使用NIO创建虚拟文件（指定缓冲区） |
| `void createFakeFile(String path, byte fillByte, long writeByteSize, int pipeBufferSize)` | 创建虚拟文件（指定缓冲区） |

---

### com.fairychar.bag.utils.DateConvertUtil

**类型**: Class (final)

**功能**: LocalDate/LocalDateTime与Date互转工具

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `LocalDateTime parseTime(String text)` | 解析时间字符串为LocalDateTime |
| `LocalDate parseDate(String text)` | 解析日期字符串为LocalDate |
| `LocalDateTime dateToLocaldateTime(Date date)` | Date转换为LocalDateTime |
| `LocalDate dateToLocaldate(Date date)` | Date转换为LocalDate |
| `Date localdateToDate(LocalDate localDate)` | LocalDate转换为Date |

---

### com.fairychar.bag.utils.ConcurrentUtil

**类型**: Class

**功能**: 并发工具类

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `void getFutures(List<Future> futures)` | 获取所有Future结果，有异常时抛出FBException |

---

### com.fairychar.bag.utils.CollectionUtil

**类型**: Class

**功能**: 集合工具类

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `<T> List<List<T>> splitList(List<T> originalList, int numberOfParts)` | 将List尽量平均分成指定份数 |

---

### com.fairychar.bag.utils.CircularTaskUtil

**类型**: Class (final)

**功能**: 循环任务工具类

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `boolean run(Supplier<Boolean> task, boolean condition)` | 循环执行任务直到匹配条件 |
| `boolean run(Supplier<Boolean> task, boolean condition, int maxRound, int maxMillis)` | 循环执行任务（带最大次数和时间限制） |

---

### com.fairychar.bag.utils.BindingResultUtil

**类型**: Class (final)

**功能**: Hibernate Validator校验结果渲染工具类

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `void checkBindingErrors(BindingResult... bindingResults)` | 检查并抛出参数校验错误 |
| `void checkBindingErrors(List<BindingResult> bindingResults)` | 检查并抛出参数校验错误（列表方式） |

---

## AOP 切面

### com.fairychar.bag.aop.MethodLockAspectJ

**类型**: Class (Aspect)

**功能**: 方法锁切面，支持本地锁、Redis分布式锁、ZooKeeper分布式锁，支持乐观锁和悲观锁模式

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `Object locking(JoinPoint joinPoint, MethodLock methodLock)` | 主切面方法，拦截@MethodLock注解 |
| `void afterPropertiesSet()` | 初始化验证配置 |

---

### com.fairychar.bag.aop.LoggingAspectJ

**类型**: Class (Aspect)

**功能**: 接口请求日志切面，支持在Controller方法执行前后记录日志

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `void beforeLogging(JoinPoint joinPoint, RequestLog requestLog)` | 在Controller方法执行前记录日志 |
| `void afterLogging(JoinPoint joinPoint, RequestLog requestLog, Object result)` | 在Controller方法执行后记录日志 |
| `void afterPropertiesSet()` | 初始化验证配置 |

---

## Beans 组件

### com.fairychar.bag.beans.netty.server.SimpleNettyServer

**类型**: Class

**功能**: 简单Netty服务器封装，支持快速启动和优雅关闭

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `SimpleNettyServer(int workerSize, int port)` | 构造函数（带默认日志Handler） |
| `SimpleNettyServer(int workerSize, int port, ChannelInitializer<ServerSocketChannel> handlers, ChannelInitializer<SocketChannel> childHandlers)` | 完整构造函数 |
| `SimpleNettyServer(int workerSize, int port, ChannelInitializer<SocketChannel> childHandlers)` | 构造函数（指定子Handler） |
| `void start()` | 启动服务器 |
| `void stop()` | 停止服务器（@PreDestroy） |

---

### com.fairychar.bag.beans.netty.client.SimpleNettyClient

**类型**: Class

**功能**: 简单Netty客户端封装

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `SimpleNettyClient(int workerSize, int port, String host)` | 构造函数（带默认日志Handler） |
| `SimpleNettyClient(int workerSize, int port, String host, ChannelInitializer<SocketChannel> childHandlers)` | 完整构造函数 |
| `void start()` | 启动客户端连接 |
| `void stop()` | 断开连接（@PreDestroy） |

---

### com.fairychar.bag.beans.spring.advice.DefaultExceptionAdvice

**类型**: Class

**功能**: 默认全局异常处理器

---

### com.fairychar.bag.beans.spring.mvc.FuzzyValueAdvice / KeepValueAdvice / EraseValueAdvice

**类型**: Class

**功能**: Spring MVC响应值处理切面，支持模糊化、保留、擦除字段值

---

### com.fairychar.bag.beans.redis.PrefixStringSerializer / GzipStringSerializer

**类型**: Class

**功能**: Redis序列化器，支持前缀添加和Gzip压缩

---

### com.fairychar.bag.beans.mybatis.interceptor.*

**类型**: Class/Interface

**功能**: MyBatis多租户拦截器相关组件

- **ITenantSwitcher**: 租户切换器接口
- **ITenantSkipper**: 租户跳过器接口
- **TenantSwitcher**: 租户切换实现
- **SimpleTenantSkipper**: 简单租户跳过实现
- **SwitchableTenantLineInnerInterceptor**: 可切换租户拦截器
- **SkipableTenantLineInnerInterceptor**: 可跳过租户拦截器

---

### com.fairychar.bag.beans.mybatis.handler.RsaTypeHandler / AesTypeHandler

**类型**: Class

**功能**: MyBatis类型处理器，支持RSA/AES加密解密

---

### com.fairychar.bag.beans.aop.LoggingHandler (Interface)

**类型**: Interface

**功能**: 日志处理器接口

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `void before(JoinPoint joinPoint)` | 前置处理 |
| `void after(JoinPoint joinPoint, Object result)` | 后置处理 |

---

## Domain 领域层

### com.fairychar.bag.domain.exceptions.FBException

**类型**: Class (RuntimeException)

**功能**: 基础业务异常类

#### 构造方法:

| 构造方法签名 | 功能说明 |
|-------------|---------|
| `FBException()` | 默认构造 |
| `FBException(String message)` | 带消息构造 |
| `FBException(int code, String message)` | 带错误码构造 |
| `FBException(String message, Throwable cause)` | 带原因构造 |
| `FBException(String message, int code, Object data)` | 完整构造（带数据） |

---

### com.fairychar.bag.domain.exceptions.ParamErrorException

**类型**: Class

**功能**: 参数错误异常

---

### com.fairychar.bag.domain.exceptions.FailToGetLockException

**类型**: Class

**功能**: 获取锁失败异常

---

### com.fairychar.bag.domain.exceptions.RestException

**类型**: Class

**功能**: REST API异常

---

### com.fairychar.bag.domain.annotations.MethodLock

**类型**: Annotation

**功能**: 方法锁注解，用于标记需要加锁的方法

#### 属性:

| 属性名 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `lockType` | Type | DEFAULT | 锁类型(LOCAL/REDIS/ZK) |
| `enable` | boolean | true | 是否启用 |
| `timeout` | int | -1 | 超时时间(-1使用全局设置) |
| `optimistic` | boolean | false | 是否使用乐观锁 |
| `timeUnit` | TimeUnit | NANOSECONDS | 时间单位 |
| `nameExpression` | String | "" | 锁名称SpEL表达式 |
| `distributedPrefix` | String | "fairychar:lock:" | 分布式锁前缀 |

---

### com.fairychar.bag.domain.annotations.RequestLog

**类型**: Annotation

**功能**: 接口请求日志拦截注解

#### 属性:

| 属性名 | 类型 | 默认值 | 说明 |
|--------|------|--------|------|
| `enable` | boolean | true | 是否启用 |
| `loggingLevel` | Level | NONE | 日志级别 |
| `beforeHandler` | String | "" | 前置处理器bean名称 |
| `afterHandler` | String | "" | 后置处理器bean名称 |

---

### com.fairychar.bag.domain.annotations.EventHandler / CauseHandler

**类型**: Annotation

**功能**: Netty事件和异常处理注解

---

### com.fairychar.bag.domain.enums.RunState

**类型**: Enum

**功能**: 运行状态枚举

#### 枚举值:

- `UN_INITIALIZE` - 未初始化
- `STARTING` - 启动中
- `STARTED` - 已启动
- `WORKING` - 运行中
- `STOPPING` - 停止中
- `STOPPED` - 已停止

---

### com.fairychar.bag.domain.validator.rest.*

**类型**: Annotation + Validator

**功能**: 自定义校验注解和校验器

| 注解 | 校验器 | 功能 |
|------|--------|------|
| `@Url` | UrlValidator | URL格式校验 |
| `@TimeBetween` | TimeValidator | 时间范围校验 |
| `@StartWith` | StartWithValidator | 前缀校验 |
| `@Phone` | PhoneValidator | 手机号校验 |
| `@NotIn` | NotInValidator | 不包含校验 |
| `@Language` | LanguageValidator | 语言格式校验 |
| `@IP` | IpValidator | IP地址校验 |
| `@In` | InValidator | 包含校验 |
| `@IdCard` | IdCardValidator | 身份证号校验 |
| `@FileSize` | FileSizeValidator | 文件大小校验 |
| `@EndWith` | EndWithValidator | 后缀校验 |
| `@DateBetween` | DateValidator | 日期范围校验 |

---

### com.fairychar.bag.domain.conditional.*

**类型**: Annotation + Condition

**功能**: Spring条件装配注解

| 注解 | 条件类 | 功能 |
|------|--------|------|
| `@ConditionalOnSystemProperty` | OnSystemPropertyCondition | 基于系统属性 |
| `@ConditionalOnSystemOS` | OnSystemOsCondition | 基于操作系统 |
| `@ConditionalOnRandomNumber` | OnRandomNumberCondition | 基于随机数 |
| `@ConditionalOnPingHost` | OnPingHostCondition | 基于主机可达性 |
| `@ConditionalOnDateTime` | OnDateTimeCondition | 基于日期时间 |

---

## Extension 扩展

### com.fairychar.bag.extension.request.*

**类型**: Class

**功能**: HttpServletRequest扩展类

- **MockHttpServletRequest**: Mock请求实现
- **ClonedServletRequest**: 可克隆的请求包装器
- **CloneServletInputStream**: 可克隆的输入流
- **EmptyServletRequest**: 空请求实现

---

### com.fairychar.bag.extension.concurrent.*

**类型**: Class

**功能**: 并发工具扩展

- **RoundTaskExecutor**: 轮询任务执行器
- **RepeatTaskExecutor**: 重复任务执行器
- **AssignableFactory**: 可分配工厂
- **ActionSchedule**: 动作调度器

---

### com.fairychar.bag.extension.action.condition.bool.*

**类型**: Class/Interface

**功能**: 条件动作流框架

- **ActionFlow**: 动作流接口
- **AbstractActionFlow**: 抽象动作流实现
- **FlowBuilder**: 流构建器
- **RootAction**: 根动作
- **ParentActionCondition**: 父动作条件

---

## Function 函数式接口

### com.fairychar.bag.function.Action

**类型**: FunctionalInterface

**功能**: 动作函数式接口，常用于Lambda表达式

#### 方法:

| 方法签名 | 功能说明 |
|---------|---------|
| `void doAction() throws RuntimeException` | 执行动作 |

---

### com.fairychar.bag.function.IShardingProcessor / ITableShardingProcessor / IDataBaseShardingProcessor

**类型**: Interface

**功能**: 分片处理器接口

---

## Properties 配置属性

### com.fairychar.bag.properties.FairycharBagProperties

**类型**: Class (ConfigurationProperties)

**功能**: Fairychar Bag 属性配置根类

#### 属性:

| 属性名 | 类型 | 说明 |
|--------|------|------|
| `aop` | AopProperties | AOP配置 |
| `serverClient` | NettyServerClientProperties | Netty服务端/客户端配置 |
| `convert` | ConvertProperties | 转换器配置 |
| `secret` | SecretProperties | 密钥配置 |
| `web` | WebProperties | Web配置 |

---

## Template 模板

### com.fairychar.bag.template.CacheOperateTemplate

**类型**: Class (final)

**功能**: 缓存操作模板，支持本地锁和Redis分布式锁方式的缓存读取

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `<C> C get(Supplier<C> fromCache, Supplier<C> fromDb, Consumer<C> putCache, Object lock)` | 单体缓存读取（本地锁） |
| `<C> C get(Supplier<C> fromCache, Supplier<C> fromDb, Consumer<C> putCache, RLock lock)` | Redis分布式缓存读取（悲观锁） |

---

### com.fairychar.bag.template.ActionSelectorTemplate

**类型**: Class

**功能**: 动作选择器模板，支持定时调度执行动作

#### 方法列表:

| 方法签名 | 功能说明 |
|---------|---------|
| `ActionSelectorTemplate()` | 默认构造 |
| `ActionSelectorTemplate(ExecutorService boss, ExecutorService worker)` | 自定义线程池构造 |
| `void start()` | 启动调度器 |
| `void shutdownGracefully()` | 优雅关闭 |
| `void shutdownNow()` | 立即关闭 |
| `void remove(String taskName)` | 移除任务 |
| `void remove(String taskName, boolean isInterrupt)` | 移除任务（带中断选项） |
| `void put(String taskName, long period, AbstractScheduleAction action)` | 添加定时任务 |
| `void put(String taskName, long period, Action action)` | 添加定时任务（简化版） |
| `void put(ActionSchedule actionSchedule)` | 添加任务调度器 |

---

## Configurer 配置器

### com.fairychar.bag.configurer.BagBeansAutoConfigurer

**类型**: Class (Configuration)

**功能**: Bag Bean配置启动项，自动配置各类组件

#### 内部配置类:

| 配置类 | 功能 |
|--------|------|
| `WebConfiguration` | Web相关配置（异常处理、属性处理） |
| `LogConfiguration` | 日志切面配置 |
| `LockConfiguration` | 锁切面配置 |
| `ConvertConfiguration` | 类型转换器配置 |
| `SecretConfiguration` | 加密组件配置（AES/RSA） |

---

## 使用示例

### 1. 方法锁使用

```java
@Service
public class OrderService {
    
    // 本地锁
    @MethodLock(lockType = MethodLock.Type.LOCAL)
    public void createOrder(Order order) {
        // 业务逻辑
    }
    
    // Redis分布式乐观锁
    @MethodLock(lockType = MethodLock.Type.REDIS, optimistic = true, timeout = 5)
    public void updateStock(Long productId) {
        // 业务逻辑
    }
}
```

### 2. 请求日志使用

```java
@RestController
public class UserController {
    
    @RequestLog(beforeHandler = "swagger", afterHandler = "simple")
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getById(id);
    }
}
```

### 3. 缓存模板使用

```java
@Service
public class UserService {
    @Autowired
    private RedissonClient redissonClient;
    
    public User getUser(Long id) {
        return CacheOperateTemplate.get(
            () -> redisTemplate.opsForValue().get("user:" + id),
            () -> userMapper.selectById(id),
            user -> redisTemplate.opsForValue().set("user:" + id, user),
            redissonClient.getLock("user:lock:" + id)
        );
    }
}
```

### 4. 树形结构转换

```java
List<Menu> menus = menuService.list();
List<TreeNode<Menu>> tree = MappingObjectUtil.listToTree(
    menus, "parentId", "id", 0L
);
```

### 5. 反射工具使用

```java
// 递归搜索字段
Map<Class<? extends Annotation>, List<FieldContainer>> result = 
    ReflectUtil.recursiveSearchFieldValueByAnnotations(
        user, 
        Arrays.asList(NotNull.class, Size.class)
    );

// 列表转树
List<Department> all = departmentService.list();
List<Department> tree = ReflectUtil.recursiveSearchChild(
    all, "id", "parentId", 0L
);
```

---

## 版本信息

- **模块**: fairychar-bag
- **版本**: ${revision}
- **描述**: simple utils for easy coding
- **作者**: chiyo (1261975105@qq.com)
- **License**: Apache License 2.0

---

*本文档由自动工具生成，如有疑问请参考源码或联系作者*
