# `com.fairychar.bag.beans.netty.server`

[返回 API 索引](README.md)

[SimpleNettyServer](#beans-netty-server-simplenettyserver)

<a id="beans-netty-server-simplenettyserver"></a>

## `com.fairychar.bag.beans.netty.server.SimpleNettyServer`

类型声明：

```java
public class com.fairychar.bag.beans.netty.server.SimpleNettyServer
```

使用说明：[features/netty/server.md](../features/netty/server.md)。

父类：`java.lang.Object`。

### public 构造器

```java
public com.fairychar.bag.beans.netty.server.SimpleNettyServer(int,int)
public com.fairychar.bag.beans.netty.server.SimpleNettyServer(int,int,io.netty.channel.ChannelInitializer<io.netty.channel.socket.ServerSocketChannel>,io.netty.channel.ChannelInitializer<io.netty.channel.socket.SocketChannel>)
public com.fairychar.bag.beans.netty.server.SimpleNettyServer(int,int,io.netty.channel.ChannelInitializer<io.netty.channel.socket.SocketChannel>)
```

### 当前类型声明的 public 方法

```java
public com.fairychar.bag.domain.enums.RunState com.fairychar.bag.beans.netty.server.SimpleNettyServer.getRunState()
public int com.fairychar.bag.beans.netty.server.SimpleNettyServer.getBossSize()
public int com.fairychar.bag.beans.netty.server.SimpleNettyServer.getMaxShutdownWaitSeconds()
public int com.fairychar.bag.beans.netty.server.SimpleNettyServer.getPort()
public int com.fairychar.bag.beans.netty.server.SimpleNettyServer.getWorkerSize()
public io.netty.channel.ChannelInitializer<io.netty.channel.socket.ServerSocketChannel> com.fairychar.bag.beans.netty.server.SimpleNettyServer.getHandlers()
public io.netty.channel.ChannelInitializer<io.netty.channel.socket.SocketChannel> com.fairychar.bag.beans.netty.server.SimpleNettyServer.getChildHandlers()
public void com.fairychar.bag.beans.netty.server.SimpleNettyServer.setMaxShutdownWaitSeconds(int)
public void com.fairychar.bag.beans.netty.server.SimpleNettyServer.start()
public void com.fairychar.bag.beans.netty.server.SimpleNettyServer.stop()
```

### public 字段 / 枚举常量

无。

