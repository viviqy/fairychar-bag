# `com.fairychar.bag.beans.netty.client`

[返回 API 索引](README.md)

[SimpleNettyClient](#beans-netty-client-simplenettyclient)

<a id="beans-netty-client-simplenettyclient"></a>

## `com.fairychar.bag.beans.netty.client.SimpleNettyClient`

类型声明：

```java
public class com.fairychar.bag.beans.netty.client.SimpleNettyClient
```

使用说明：[features/netty/client.md](../features/netty/client.md)。

父类：`java.lang.Object`。

### public 构造器

```java
public com.fairychar.bag.beans.netty.client.SimpleNettyClient(int,int,java.lang.String)
public com.fairychar.bag.beans.netty.client.SimpleNettyClient(int,int,java.lang.String,io.netty.channel.ChannelInitializer<io.netty.channel.socket.SocketChannel>)
```

### 当前类型声明的 public 方法

```java
public com.fairychar.bag.domain.enums.RunState com.fairychar.bag.beans.netty.client.SimpleNettyClient.getRunState()
public int com.fairychar.bag.beans.netty.client.SimpleNettyClient.getMaxShutdownWaitSeconds()
public int com.fairychar.bag.beans.netty.client.SimpleNettyClient.getPort()
public int com.fairychar.bag.beans.netty.client.SimpleNettyClient.getWorkerSize()
public io.netty.channel.Channel com.fairychar.bag.beans.netty.client.SimpleNettyClient.getChannel()
public io.netty.channel.ChannelInitializer<io.netty.channel.socket.SocketChannel> com.fairychar.bag.beans.netty.client.SimpleNettyClient.getChildHandlers()
public java.lang.String com.fairychar.bag.beans.netty.client.SimpleNettyClient.getHost()
public void com.fairychar.bag.beans.netty.client.SimpleNettyClient.setMaxShutdownWaitSeconds(int)
public void com.fairychar.bag.beans.netty.client.SimpleNettyClient.start()
public void com.fairychar.bag.beans.netty.client.SimpleNettyClient.stop()
```

### public 字段 / 枚举常量

无。

