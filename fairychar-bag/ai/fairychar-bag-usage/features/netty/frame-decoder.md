# 头尾帧解码

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。按本页说明判断适用性；public 可访问不等于适合作为业务默认设施。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## DelimitersHeadTailFrameDecoder

固定头尾协议解码:

```java
new DelimitersHeadTailFrameDecoder(
        new byte[]{0x68},
        new byte[]{0x16},
        2048
);
```

输出对象: `HeadTailFrame`

- `head`: 协议头。
- `content`: 协议体 `ByteBuf`，存在额外 retain，不能假设一次 release 即释放；此解码器不默认采用。
- `tail`: 协议尾。

注意:

- 如果头不匹配会 `in.clear()` 并抛 `DecoderException("head error")`。
- `maxCapacity` 是内部缓存初始容量，不是可靠帧长上限。坏包可不前进并不终止，分片与引用计数限制如下；不在事件循环里探测坏包。

## DelimitersHeadTailFrameDecoder：不默认采用

**输入与效果**：head/tail 必须非 null 且非空，不共享 decoder 实例到多个 channel；decode 会消费传入 ByteBuf 的 readerIndex 并保存跨调用状态。完整头尾匹配返回 HeadTailFrame，未完整时可返回 null；头不匹配清空输入并抛 DecoderException。

**确定限制**：尾首字节出现但后续不匹配时，可重复复位 readerIndex 而不前进，存在不终止路径；分片尾、短头处理也没有完整的安全契约。maxCapacity 只是初始缓冲容量，不是可靠帧长上限。输出 content 分配后额外 retain，不能把一次 release 必然归零作为所有权契约；内部缓冲清理也不能依赖业务的一次 content.release。

**采用决定**：不要在事件循环上试探可疑字节来验证基本行为，也不要用多次 release 当通用补丁。采用业务已验证的帧解码器，并明确最大帧长、引用计数和所有分片/坏包行为。

## 类型与完整签名

- [`com.fairychar.bag.beans.netty.decoder.DelimitersHeadTailFrameDecoder`](../../api/beans-netty-decoder.md)
- [`com.fairychar.bag.domain.netty.frame.HeadTailFrame`](../../api/domain-netty-frame.md)
