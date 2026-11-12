# 字符串与 Gzip

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：可直接采用（文档内操作）**。仅在本页明确的输入、效果和限制内使用；未说明的重载不扩展行为承诺。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## StringUtil

位置: `com.fairychar.bag.utils.StringUtil`

```java
byte[] bytes = StringUtil.compressByGzip("hello");
String text = StringUtil.decompressByGzip(bytes);
String value = StringUtil.defaultText(input, "default");
```

方法:

- `compressByGzip(String data)`: UTF-8 Gzip 压缩，失败抛 `FBException`。
- `decompressByGzip(byte[] compressedData)`: UTF-8 Gzip 解压，按行读取并拼接，换行会被去掉。
- `defaultText(String source, String text)`: `source` 为 null 或空字符串时返回 `text`。
- `fillBegin` / `fillEnd`: 已废弃，优先用 Guava `Strings.padStart/padEnd`。

## 输入、效果与失败契约

**前置与输入**：静态方法；gzip 使用 UTF-8。`defaultText(source, fallback)` 的两参数可为 null；压缩/解压参数必须非 null。

**效果与返回**：`defaultText` 仅对 null 或 `""` 返回 fallback，`" "` 保持原样；fallback 为 null 时结果可为 null。`compressByGzip("")` 返回有效的非空 gzip 字节；`decompressByGzip` 逐行拼接，删除行分隔符，因此不是任意文本的无损往返。

**失败**：压缩/解压 null 抛 `NullPointerException`；空字节、损坏或非 gzip 数据解压抛 `FBException`，不返回 null。底层 IOException 包装为 `FBException`。

**副作用与资源**：不修改输入字节；内部流由方法关闭。没有流式或输出大小上限，不用于处理不受控压缩数据；需保留换行时使用业务自己的保真压缩工具。

**输入 → 输出**：`defaultText(" ", "x") → " "`；`decompressByGzip(compressByGzip("a\nb\r\nc")) → "abc"`。旧填充方法不作为新代码入口。

## 类型与完整签名

- [`com.fairychar.bag.utils.StringUtil`](../../api/utils--stringutil.md)
