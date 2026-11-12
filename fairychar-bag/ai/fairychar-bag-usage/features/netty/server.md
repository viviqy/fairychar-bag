# Netty 服务端封装

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## SimpleNettyServer

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

构造方法:

- `SimpleNettyServer(int workerSize, int port)`
- `SimpleNettyServer(int workerSize, int port, ChannelInitializer<SocketChannel> childHandlers)`
- `SimpleNettyServer(int workerSize, int port, ChannelInitializer<ServerSocketChannel> handlers, ChannelInitializer<SocketChannel> childHandlers)`

行为:

- boss 线程数固定为 1。
- `start()` 设置 `RunState.STARTING -> STARTED`，但没有等待 bind 成功；STARTED 不是端口就绪证明。
- `stop()` 请求关闭 channel、boss、worker，不等待 event loop 完全终止；重复启动没有防护。不默认采用，完整失败与资源责任见 [Netty 契约](../concurrency/future-wait.md)。

## SimpleNettyServer：不默认作为新项目启动设施

**输入**：`workerSize > 0`，`1 <= port <= 65534`，`maxShutdownWaitSeconds > 0`；构造本身不执行完整校验，start 才校验。默认 shutdown 等待值是 Integer.MAX_VALUE 秒，应由业务显式设置有限值。handler/childHandler 由调用方配置，默认仅日志处理不是业务协议。

**启动效果**：start 创建 boss/worker event loop，boss 固定为 1；调用 bind 后直接取得 channel 并设置 STARTED，没有等待 bind future 成功。返回 void 或状态 STARTED 都不保证端口已监听。必须用业务的 readiness/连接探测确认；不在不可阻塞线程执行生命周期工作。

**失败**：参数错误抛 IllegalArgumentException，线程资源尚未在该次 start 创建；同步启动异常触发清理后抛 RuntimeException。异步 bind 失败不受该同步异常路径保证，不能凭 start 未抛异常判断启动成功。

**停止与责任**：未启动或已 STOPPED 时 stop 直接返回；其他状态先尝试关闭 channel 并等待最多 maxShutdownWaitSeconds，然后请求两个 event loop 优雅关闭，但不等待 event loop 终止。close 超时/失败也可能标为 STOPPED，所以该状态不是资源完全释放证明。被 Spring 管理时可触发销毁回调；普通 new 对象由业务负责停止。重复 start 没有防护，会替换资源引用，不重复启动，不与 stop 并发调用。

**采用决定**：需要可靠启动、端口就绪及关闭屏障时，使用业务可控 Netty Bootstrap 和 event loop 生命周期。这里不提供“start 返回即可提供服务”的模板。

## 类型与完整签名

- [`com.fairychar.bag.beans.netty.server.SimpleNettyServer`](../../api/beans-netty-server.md)
- [`com.fairychar.bag.domain.enums.RunState`](../../api/domain-enums.md)
