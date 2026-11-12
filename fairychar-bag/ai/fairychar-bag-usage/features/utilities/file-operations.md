# 文件拼接、截取与测试文件

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：不默认采用**。仅在本页明确的输入、效果和限制内使用；未说明的重载不扩展行为承诺。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## FileUtil

位置: `com.fairychar.bag.utils.FileUtil`

拼接文件:

```java
FileUtil.concatFile("out.bin", new File("head.bin"), new File("part1.bin"), new File("part2.bin"));
```

按百分比分割文件:

```java
FileUtil.cutFile("source.bin", "middle.bin", 0.2D, 0.8D);
```

创建测试假文件:

```java
FileUtil.createFakeFile("tmp.bin", 1024 * 1024);
FileUtil.createFakeFileByNio("tmp-nio.bin", (byte) 0, 1024 * 1024, 4096);
```

注意:

- `cutFile` 的 `start` 范围 `[0, 1)`，`end` 范围 `(0, 1]`。
- `createFakeFileByNio` 如果目标文件已存在，会抛运行时异常。

## 限制与替代方案

| 入口 | 已确定的效果或缺口 | 新项目决定 |
| --- | --- | --- |
| `FileUtil.concatFiles/cutFile` | 会创建/截断输出，不是无副作用查询；输出与输入相同可破坏输入。cut 按字节比例截取，不是按行/字符，UTF-8 可被切断；IO 包装为 RuntimeException，失败可留下部分文件 | 不把未验证文件路径写入当安全默认；优先业务标准 Files/流，独立临时输出成功后发布；检查路径和覆盖策略 |
| `FileUtil.createFakeFile*` | 仅测试用途；部分缓冲写入/余数路径不提供准确填充值和长度保证，NIO 版本已存在文件时报错；父目录不自动创建 | 不用于生产内容生成；测试需自行检查长度和内容，不复制为通用文件创建模板 |

## 类型与完整签名

- [`com.fairychar.bag.utils.FileUtil`](../../api/utils--fileutil.md)
