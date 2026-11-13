# com.fairychar.bag.beans.netty.server.SimpleNettyServer

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SimpleNettyServer.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-d2dd233f8425045f"></a>
## com.fairychar.bag.beans.netty.server.SimpleNettyServer

```java
@Slf4j
public class SimpleNettyServer
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/server/SimpleNettyServer.java:29`; evidence: `declaration-d2dd233f8425045fba1c01770a9527e516b265c835bf02faa9c4861c301156ff`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
简单Netty服务器

 @author chiyo
 @since 0.0.1-SNAPSHOT
```


## Fields

<a id="symbol-02d9693692f9407c"></a>
### bossSize

```java
@Getter
private final int bossSize = 1
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/server/SimpleNettyServer.java:32`; evidence: `declaration-02d9693692f9407ce8df613f45f30010f595380e7593241d6750539d6eabc32c`.
Visibility: `private` (explicit).
Type: `int`.

<a id="symbol-97b959193434f89d"></a>
### workerSize

```java
@Getter
private final int workerSize
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/server/SimpleNettyServer.java:34`; evidence: `declaration-97b959193434f89dfb9086eb463efeef0b6fab73585eb4992f514596bae529ec`.
Visibility: `private` (explicit).
Type: `int`.
No initializer recorded.

<a id="symbol-a3288efe9190c989"></a>
### port

```java
@Getter
private final int port
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/server/SimpleNettyServer.java:36`; evidence: `declaration-a3288efe9190c989041d290af6156cc3f5773ac4bc0e0babd3918f24a7be18ee`.
Visibility: `private` (explicit).
Type: `int`.
No initializer recorded.

<a id="symbol-abf73cb0bb5f3800"></a>
### handlers

```java
@Getter
private ChannelInitializer<ServerSocketChannel> handlers
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/server/SimpleNettyServer.java:38`; evidence: `declaration-abf73cb0bb5f38000b24e638ef68ec785ba32817f95be82ffc0f5cfbc3f091ac`.
Visibility: `private` (explicit).
Type: `ChannelInitializer<ServerSocketChannel>`.
No initializer recorded.

<a id="symbol-9d6d23cb825d7ae2"></a>
### childHandlers

```java
@Getter
private ChannelInitializer<SocketChannel> childHandlers
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/server/SimpleNettyServer.java:40`; evidence: `declaration-9d6d23cb825d7ae29bbc41b1ceaa058a02cf8b5d5e50bb020cfc422550961b82`.
Visibility: `private` (explicit).
Type: `ChannelInitializer<SocketChannel>`.
No initializer recorded.

<a id="symbol-7d9d3bf41e148840"></a>
### runState

```java
@Getter
private RunState runState = RunState.UN_INITIALIZE
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/server/SimpleNettyServer.java:42`; evidence: `declaration-7d9d3bf41e148840584f4da90ce198e4528700c01fe190053a5224a0769e8f13`.
Visibility: `private` (explicit).
Type: `RunState`.

<a id="symbol-5d9d233fa12c7f2d"></a>
### maxShutdownWaitSeconds

```java
@Getter
@Setter
private int maxShutdownWaitSeconds = Integer.MAX_VALUE
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/server/SimpleNettyServer.java:44`; evidence: `declaration-5d9d233fa12c7f2dee7ec0ad28db0cccd3dcaba62251d9c5fd654f84140e4aca`.
Visibility: `private` (explicit).
Type: `int`.

<a id="symbol-e62bc2e5e0926817"></a>
### serverBootstrap

```java
private ServerBootstrap serverBootstrap
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/server/SimpleNettyServer.java:47`; evidence: `declaration-e62bc2e5e092681787d92b79bc4c6abd84efffb07beb9956ab57b74270e94e67`.
Visibility: `private` (explicit).
Type: `ServerBootstrap`.
No initializer recorded.

<a id="symbol-205269dfd8d5ec5d"></a>
### channel

```java
private Channel channel
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/server/SimpleNettyServer.java:48`; evidence: `declaration-205269dfd8d5ec5ddc5cd3f73909e0d4978ad52cb0944c70729a712318da91eb`.
Visibility: `private` (explicit).
Type: `Channel`.
No initializer recorded.

<a id="symbol-351260861d52811d"></a>
### boss

```java
private NioEventLoopGroup boss
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/server/SimpleNettyServer.java:49`; evidence: `declaration-351260861d52811d2e3d06f6cb2ffb25e10061003661d07926b174e6af5d4b93`.
Visibility: `private` (explicit).
Type: `NioEventLoopGroup`.
No initializer recorded.

<a id="symbol-e3f9d0dc82521c0a"></a>
### worker

```java
private NioEventLoopGroup worker
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/server/SimpleNettyServer.java:50`; evidence: `declaration-e3f9d0dc82521c0a180af48ec72fd783fe334e59e786a14562f0c9e0fa8ed2b7`.
Visibility: `private` (explicit).
Type: `NioEventLoopGroup`.
No initializer recorded.

## Members

- [SimpleNettyServer](SimpleNettyServer.SimpleNettyServer--17b5ef7993dfc72f.md#symbol-6d2a0402e10b441d) — `constructor`, source line 52
- [SimpleNettyServer](SimpleNettyServer.SimpleNettyServer--1bdbb9b20b608592.md#symbol-70801902ed4584a6) — `constructor`, source line 70
- [SimpleNettyServer](SimpleNettyServer.SimpleNettyServer--454e81eb4ba2708f.md#symbol-b07eb83ca7fa1102) — `constructor`, source line 78
- [start](SimpleNettyServer.start.md#symbol-8a87141f8361256f) — `function`, source line 91
- [stop](SimpleNettyServer.stop.md#symbol-f053cdf317086469) — `function`, source line 113
- [checkArgs](SimpleNettyServer.checkArgs.md#symbol-d2c0f345746dd826) — `function`, source line 152
