# Netty 客户端封装

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## SimpleNettyClient

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

构造方法:

- `SimpleNettyClient(int workerSize, int port, String host)`
- `SimpleNettyClient(int workerSize, int port, String host, ChannelInitializer<SocketChannel> childHandlers)`

连接失败可正常返回并留存 worker；正常 stop 路径不关闭 worker，未启动时 stop 可 NPE。不默认采用，不能靠检查 runState 证明资源释放。启动、失败与停止的详细行为如下。

## SimpleNettyClient：不默认作为新项目连接设施

**输入**：workerSize、port、shutdown 等待规则同 server，host 非 null；host 空字符串并未被参数检查拦截，业务仍需有效地址。构造不建立连接。

**启动效果与失败**：start 调用 connect.sync，成功后设置 STARTED；参数错误抛 IllegalArgumentException。连接阶段异常被记录后设置 STOPPED 并正常返回，没有统一抛给调用方，也不会在该失败路径关闭已创建 worker。中断也在该路径被捕获，不承诺恢复中断标记。

**停止与责任**：stop 无“未启动/已停止”保护；channel 为 null 时直接抛 NullPointerException。正常 channel.close 完成的路径不关闭 worker，仅 close 的特定异常路径调用 worker.shutdownGracefully。即使状态 STOPPED 也可能仍有线程资源，不能通过多调用一次 stop 可靠弥补。重复启动没有资源保护，没有自动重连。

**采用决定**：业务优先管理自己的连接、event loop、超时、失败传播和关闭 future；不以检查 runState 再 stop 作为已证明安全的生产接入方案。

## 类型与完整签名

- [`com.fairychar.bag.beans.netty.client.SimpleNettyClient`](../../api/beans-netty-client.md)
