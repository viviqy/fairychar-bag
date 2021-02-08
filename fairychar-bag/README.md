# fairychar-bag开发工具包
## spring mvc参数校验实现
### 使用方式
配置文件开启校验切面
```yaml
fairychar:
  bag:
    aop:
      binding:
        enable: true
```
代码使用
```java
import com.fairychar.bag.domain.annotions.BindingCheck;
/*
* 在需要校验的接口上打上此注解
*/
@BindingCheck
public String hello(@RequestBody @Validate User user,BindingResult bindingResult) throws Exception{
    return "hello";
}
```
### 实现效果
在每次请求请求时可自动校验参数,在参数校验失败后抛出ParamErrorException
### 实现原理
使用aop配合hibernate-validator实现

## 接口请求日志
### 使用方式
配置文件开启日志切面
```yaml
fairychar:
  bag:
    aop:
      log:
        enable: true //是否启用
        global-before: swagger //全局默认接口请求前拦截器
        global-after: simple //全局默认接口请求后拦截器
        global-level: info //全局默认接口请求后拦截器
```
代码使用

配置类
```java
@Configuration
public class LoggingConfiguration{
    /*
    * 可自定义实现LoggingHandler接口,内置SimpleLoggingHandler和SwaggerLoggingHandler
    */
    @Bean
    LoggingHandler swagger(){
        return new SwaggerLoggingHandler();
    }
}
```
接口方法
```java
/*
* 在需要校验的接口上打上此注解
*/
@PostMapping("hello")
@ApiOperation("你好")
@RequestLog(beforeHandler="swagger",afterHandler="simple",loggingLevel=RequestLog.Level.INFO)
public String hello(@RequestBody @Validate User user,BindingResult bindingResult) throws Exception{
    return "hello";
}
```
### 实现效果
swaggerHandler的日志打印输出为
```text
request uri=hello,uriName=你好 at 2021-01-29 14:54:52 from 127.0.0.1
```
### 实现原理
使用aop配合spring bean实现,通过@RequestLog内handler属性获取指定bean处理拦截逻辑

## 方法锁实现
### 使用方式
配置文件开启
```yaml
fairychar:
  bag:
    aop:
      lock:
        enable: true //是否启用切面
        time-unit: seconds //乐观锁全局超时时间单位
        global-timeout: 1 //乐观锁全局超时时间
        default-lock: redis //默认锁类型
```

代码使用
```java
import com.fairychar.bag.domain.annotions.MethodLock;

@Service
public class HelloService {
    /*
    * 使用本地锁(基于ReentrantLock实现)
    */
    @MethodLock(lockType = MethodLock.Type.LOCAL)
    public String getTom() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return "tom";
    }

    /*
    * 使用分布式锁(基于Redis实现的乐观锁,会在未抢到锁时抛出FailToGetLockException)
    */
    @MethodLock(optimistic = true, lockType = MethodLock.Type.REDIS
            , timeout = 1, timeUnit = TimeUnit.SECONDS
            , distributedPrefix = "fairychar:device:", distributedPath = "collector")
    public String getJerry() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return "jerry";
    }

    /*
    * 使用分布式锁(基于Zookeeper实现的乐观锁,会在未抢到锁时抛出FailToGetLockException)
    */
    @MethodLock(optimistic = true, lockType = MethodLock.Type.ZK
            , timeUnit = TimeUnit.SECONDS, timeout = 1)
    public String say(String word) throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return word;
    }

    /*
    * 使用分布式锁(基于Zookeeper实现的锁)
    */
    @MethodLock(lockType = MethodLock.Type.ZK)
    public String getHuruta() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return "huruta";
    }

    /*
    * 使用分布式锁(基于Redis实现的乐观锁)
    */
    @MethodLock(lockType = MethodLock.Type.REDIS
            , distributedPrefix = "fairychar:device:", distributedPath = "collector")
    public String getJerryFair() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return "jerry";
    }

}

```

### 实现效果
会在调用方法时进入本地锁或者分布式锁

### 实现原理
使用aop配合ReentrantLock、Redisson、Curator实现

## netty server and client
### 使用方式

代码使用

非spring方式
```java
    public void testNetty() {
        SimpleNettyServer server = new SimpleNettyServer(1, 2, 10000
                , new ChannelInitializer<ServerSocketChannel>() {
            @Override
            protected void initChannel(ServerSocketChannel serverSocketChannel) throws Exception {
                serverSocketChannel.pipeline().addLast(new LoggingHandler());
            }
        }, new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new LoggingHandler());
            }
        });
        server.setMaxShutdownWaitSeconds(10);
        server.start();
//        server.stop();

        SimpleNettyClient client = new SimpleNettyClient(1, 10001, "127.0.0.1"
                , new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new LoggingHandler());
            }
        });
        client.setMaxShutdownWaitSeconds(10);
        client.stop();
    }
```
基于spring

```java
@Configuration
@EnableConfigurationProperties(FairycharBagProperties.class)
public class BeansConfiguration {

    @Autowired
    private FairycharBagProperties bagProperties;

    @Bean
    SimpleNettyServer simpleNettyServer(){
        NettyServerClientProperties.ServerProperties properties = bagProperties.getServerClient().getServer();
        SimpleNettyServer simpleNettyServer = new SimpleNettyServer(properties.getBossSize(), properties.getWorkerSize(), properties.getPort());
        return simpleNettyServer;
        // 在需要的spring bean加载完成后执行start方法
    }

    @Bean
    SimpleNettyClient simpleNettyClient(){
        NettyServerClientProperties.ClientProperties client = bagProperties.getServerClient().getClient();
        SimpleNettyClient simpleNettyClient = new SimpleNettyClient(client.getEventLoopSize(), client.getPort(), client.getHost());
        return simpleNettyClient;
        // 在需要的spring bean加载完成后执行start方法
    }
}
```
### 实现效果
可简单化启动netty或整合入spring

### 实现原理
基于spring整合