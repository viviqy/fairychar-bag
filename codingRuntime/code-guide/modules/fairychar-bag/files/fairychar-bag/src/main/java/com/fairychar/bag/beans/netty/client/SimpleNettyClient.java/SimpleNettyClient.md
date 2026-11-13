# com.fairychar.bag.beans.netty.client.SimpleNettyClient

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SimpleNettyClient.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-72b04951a2b2af0f"></a>
## com.fairychar.bag.beans.netty.client.SimpleNettyClient

```java
@Slf4j
public class SimpleNettyClient
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/client/SimpleNettyClient.java:27`; evidence: `declaration-72b04951a2b2af0fefb3d126716810b7230190414a35b3e87505ba0b41649fc4`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
简单Netty客户端

 @author chiyo
 @since 0.0.1-SNAPSHOT
```


## Fields

<a id="symbol-9f8c893a0d9ff830"></a>
### CHILD_LOGGING_HANDLER

```java
private static final ChannelInitializer<SocketChannel> CHILD_LOGGING_HANDLER
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/client/SimpleNettyClient.java:29`; evidence: `declaration-9f8c893a0d9ff83069de9b2a4c629c01f9afd4e3e4e1ad3bd1db0dd0c0de50a2`.
Visibility: `private` (explicit).
Type: `ChannelInitializer<SocketChannel>`.
No initializer recorded.

<a id="symbol-316bc7529826d666"></a>
### workerSize

```java
@Getter
private final int workerSize
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/client/SimpleNettyClient.java:41`; evidence: `declaration-316bc7529826d666552177c1147b614b4ee703de43411798035fa9237b328424`.
Visibility: `private` (explicit).
Type: `int`.
No initializer recorded.

<a id="symbol-f729c34e56801138"></a>
### port

```java
@Getter
private final int port
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/client/SimpleNettyClient.java:43`; evidence: `declaration-f729c34e5680113850e6ad53799aa62a822afdc7aec5768c9583e0833c7669b4`.
Visibility: `private` (explicit).
Type: `int`.
No initializer recorded.

<a id="symbol-c5190f3ade78902a"></a>
### host

```java
@Getter
private final String host
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/client/SimpleNettyClient.java:45`; evidence: `declaration-c5190f3ade78902a0bc3fbbf6c2a11f380c14aa32eda4068f8129f930e32f0f1`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-53a2efa5a3e737d4"></a>
### childHandlers

```java
@Getter
private ChannelInitializer<SocketChannel> childHandlers
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/client/SimpleNettyClient.java:47`; evidence: `declaration-53a2efa5a3e737d4d9a64dfba43c3d690a005f7ce4c9d1a3238f3edd36d8942a`.
Visibility: `private` (explicit).
Type: `ChannelInitializer<SocketChannel>`.
No initializer recorded.

<a id="symbol-076e36e9abf1f587"></a>
### runState

```java
@Getter
private RunState runState = RunState.UN_INITIALIZE
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/client/SimpleNettyClient.java:49`; evidence: `declaration-076e36e9abf1f587ceb52c909f2b247979cfc475a980b4eaf0fa20e58a3f62f9`.
Visibility: `private` (explicit).
Type: `RunState`.

<a id="symbol-9c7b491de3ba05fe"></a>
### maxShutdownWaitSeconds

```java
@Getter
@Setter
private int maxShutdownWaitSeconds = Integer.MAX_VALUE
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/client/SimpleNettyClient.java:51`; evidence: `declaration-9c7b491de3ba05fe809590def16ddfb38ebc6f0312bcd2540ca0a64e8e17a6ff`.
Visibility: `private` (explicit).
Type: `int`.

<a id="symbol-f66a1d93b6c4f8d7"></a>
### bootstrap

```java
private Bootstrap bootstrap
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/client/SimpleNettyClient.java:54`; evidence: `declaration-f66a1d93b6c4f8d74cb3493bf976d01825ea8f0c28cbed4260ee7b6b56e982ad`.
Visibility: `private` (explicit).
Type: `Bootstrap`.
No initializer recorded.

<a id="symbol-f4e3879787ff10b5"></a>
### channel

```java
@Getter
private Channel channel
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/client/SimpleNettyClient.java:55`; evidence: `declaration-f4e3879787ff10b52a58532954fdb918c2da3676218554f84804fe6cc6b14997`.
Visibility: `private` (explicit).
Type: `Channel`.
No initializer recorded.

<a id="symbol-15eafc028c71caa9"></a>
### worker

```java
private NioEventLoopGroup worker
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/client/SimpleNettyClient.java:57`; evidence: `declaration-15eafc028c71caa907bec13a1f6086c7de3a51f28f219b2f27b3bea6f77dc082`.
Visibility: `private` (explicit).
Type: `NioEventLoopGroup`.
No initializer recorded.

## Members

- [SimpleNettyClient](SimpleNettyClient.SimpleNettyClient--23abe78abaf55b7f.md#symbol-e72ecb6356da414c) — `constructor`, source line 59
- [SimpleNettyClient](SimpleNettyClient.SimpleNettyClient--c215e8cb79fecc13.md#symbol-7e3693b84be959b5) — `constructor`, source line 66
- [start](SimpleNettyClient.start.md#symbol-bf6eac198f873ccc) — `function`, source line 73
- [stop](SimpleNettyClient.stop.md#symbol-8e852fbe3d12b935) — `function`, source line 94
- [checkArgs](SimpleNettyClient.checkArgs.md#symbol-1f134fcda0b91ea3) — `function`, source line 108
