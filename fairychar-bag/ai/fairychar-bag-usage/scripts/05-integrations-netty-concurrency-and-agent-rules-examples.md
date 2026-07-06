# Integrations Netty Concurrency And Agent Rules Examples

> 返回主入口: [fairychar-bag-usage-guide.md](../fairychar-bag-usage-guide.md)。说明和约束见 `../references/` 中对应文档。

## Example 1: AES/RSA TypeHandler

```yaml
fairychar:
  bag:
    secret:
      aes:
        key: "1234567890123456"
      rsa:
        pub-key: "..."
        pri-key: "..."
```

## Example 2: AES/RSA TypeHandler

```java
@TableField(typeHandler = AesTypeHandler.class)
private String phone;

@TableField(typeHandler = RsaTypeHandler.class)
private String idCard;
```

## Example 3: AES/RSA TypeHandler

```java
String cipher = AesTypeHandler.encryptHex("hello");
String plain = AesTypeHandler.decrypt(cipher);

String rsaCipher = RsaTypeHandler.encryptBase64("hello");
String rsaPlain = RsaTypeHandler.decrypt(rsaCipher);
```

## Example 4: SwitchableTenantLineInnerInterceptor

```java
List<User> listUsers(@Param("query") UserQuery query, ITenantSwitcher tenantSwitcher);

userMapper.listUsers(query, new TenantSwitcher(false)); // 不使用租户
userMapper.listUsers(query, new TenantSwitcher(true));  // 使用租户
```

## Example 5: SkipableTenantLineInnerInterceptor

```java
SimpleTenantSkipper skipper = new SimpleTenantSkipper();

try {
    skipper.setSkip(true);
    return userMapper.listAll();
} finally {
    skipper.cleanContext();
}
```

## Example 6: PrefixStringSerializer

```java
RedisTemplate<String, Object> template = new RedisTemplate<>();
template.setKeySerializer(new PrefixStringSerializer("my-service:"));
```

## Example 7: GzipStringSerializer

```java
template.setValueSerializer(new GzipStringSerializer());
```

## Example 8: SimpleNettyServer

```java
SimpleNettyServer server = new SimpleNettyServer(
        4,
        10000,
        new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ch.pipeline()
                        .addLast(new DelimitersHeadTailFrameDecoder(
                                new byte[]{0x02},
                                new byte[]{0x03},
                                1024
                        ))
                        .addLast(new MyInboundHandler());
            }
        }
);

server.setMaxShutdownWaitSeconds(10);
server.start();
```

## Example 9: SimpleNettyClient

```java
SimpleNettyClient client = new SimpleNettyClient(
        2,
        10000,
        "127.0.0.1",
        new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ch.pipeline().addLast(new MyInboundHandler());
            }
        }
);

client.start();
Channel channel = client.getChannel();
```

## Example 10: DelimitersHeadTailFrameDecoder

```java
new DelimitersHeadTailFrameDecoder(
        new byte[]{0x68},
        new byte[]{0x16},
        2048
);
```

## Example 11: Action

```java
@FunctionalInterface
public interface Action {
    void doAction() throws RuntimeException;
}
```

## Example 12: AssignableFactory

```java
ExecutorService executor = Executors.newFixedThreadPool(8);
AssignableFactory factory = AssignableFactory.recruitWorkers(3, executor);

factory.doWork(() -> callA(), 2);
factory.doWork(() -> callB(), 1);

Future<String> future = factory.doWorkFuture(() -> loadData(), 1);
```

## Example 13: RepeatTaskExecutor

```java
RepeatTaskExecutor executor = RepeatTaskExecutor.createCycle(
        List.of(
                () -> syncA(),
                () -> syncB()
        ),
        "sync"
);

executor.start(
        e -> log.warn("interrupted", e),
        e -> log.warn("timeout", e),
        e -> log.warn("broken", e),
        10_000
);
```

## Example 14: RoundTaskExecutor

```java
List<List<Action>> chains = new ArrayList<>();
chains.add(new ArrayList<>(List.of(() -> stepA1(), () -> stepA2())));
chains.add(new ArrayList<>(List.of(() -> stepB1(), () -> stepB2())));

RoundTaskExecutor executor = RoundTaskExecutor.boxedTaskList(chains);
executor.start();
```

## Example 15: ActionSelectorTemplate

```java
ActionSelectorTemplate template = new ActionSelectorTemplate();
template.setTimePause(100);

template.put("refresh-cache", 5_000, () -> refreshCache());
template.put("sync-user", 10_000, new AbstractScheduleAction() {
    @Override
    public void doAction() {
        syncUser();
    }
});

template.start();
```

## Example 16: AbstractBalkingReference

```java
class ConfigRef extends AbstractBalkingReference<Config> {
    ConfigRef(Config config) {
        super(config);
    }

    @Override
    public boolean doSave() {
        repository.save(t);
        return true;
    }
}

ConfigRef ref = new ConfigRef(config);
ref.save();       // 首次保存
ref.change(newConfig);
ref.save();       // 有变更才保存
```

## Example 17: 条件动作流 ActionFlow

```java
public class StringFlow extends AbstractActionFlow<String, Integer> {
    @Override
    public ActionFlow<String, Integer> instanceBean() {
        return new StringFlow();
    }

    @Override
    public boolean compute(String context) {
        return context.isEmpty();
    }

    @Override
    public Set<ParentActionCondition> getParentClassSet() {
        return Sets.newHashSet(RootAction.getCondition());
    }

    @Override
    public Integer getNextParam(String context) {
        return Integer.valueOf(context);
    }
}
```

## Example 18: 条件动作流 ActionFlow

```java
public class IntegerCompareFlow extends AbstractActionFlow<Integer, Integer> {
    @Override
    public ActionFlow<Integer, Integer> instanceBean() {
        return new IntegerCompareFlow();
    }

    @Override
    public boolean compute(Integer context) {
        return context > 1;
    }

    @Override
    public Set<ParentActionCondition> getParentClassSet() {
        return Sets.newHashSet(new ParentActionCondition(StringFlow.class, true));
    }

    @Override
    public Integer getNextParam(Integer context) {
        return context + 1;
    }
}
```

## Example 19: 条件动作流 ActionFlow

```java
Set<Class<AbstractActionFlow>> classes = new HashSet<>();
classes.add((Class) StringFlow.class);
classes.add((Class) IntegerCompareFlow.class);

FlowBuilder builder = FlowBuilder.fromClasses(classes);
AbstractActionFlow root = builder.buildFlow();
root.callNext("123");
```

## Example 20: 常用验证命令

```powershell
mvn -pl fairychar-bag -am -DskipTests compile
```

## Example 21: 常用验证命令

```powershell
mvn -pl fairychar-bag -am -DskipTests=false test
```

## Example 22: 常用验证命令

```powershell
powershell -ExecutionPolicy Bypass -File fairychar-bag\skills\fairychar-coding-java\script\check-fairychar-style.ps1 -Root fairychar-bag\src\main\java
```

