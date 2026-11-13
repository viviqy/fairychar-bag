# com.fairychar.bag.utils.FileUtil.createFakeFileByNio

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FileUtil.java.md)

[Lexical owner](FileUtil.md#symbol-6afa9075f04d8d0f)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-16c166e3058274d6"></a>
## com.fairychar.bag.utils.FileUtil.createFakeFileByNio

```java
public static void createFakeFileByNio(String path, byte fillByte, long writeByteSize, int pipeBufferSize) throws IOException
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/FileUtil.java:163`; evidence: `declaration-16c166e3058274d68ad6c5409856be31dfb6c18653eeb85f1cf3f1c13973664a`.
Owner: `com.fairychar.bag.utils.FileUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
使用NIO创建虚拟文件

 @param path           虚拟文件路径
 @param fillByte       填充字节
 @param writeByteSize  虚拟文件大小（字节数）
 @param pipeBufferSize 缓冲区大小
 @throws IOException IO异常
```
