# com.fairychar.bag.utils.FileUtil.createFakeFile

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FileUtil.java.md)

[Lexical owner](FileUtil.md#symbol-6afa9075f04d8d0f)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-17fe6c12349b1264"></a>
## com.fairychar.bag.utils.FileUtil.createFakeFile

```java
public static void createFakeFile(String path, byte fillByte, long writeByteSize, int pipeBufferSize) throws IOException
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/FileUtil.java:202`; evidence: `declaration-17fe6c12349b126418b86c803478dd5b4269ec7a0a8afedd17ee681bc5bc15d0`.
Owner: `com.fairychar.bag.utils.FileUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
创建虚拟文件

 @param path           虚拟文件路径
 @param fillByte       填充字节
 @param writeByteSize  虚拟文件大小（字节数）
 @param pipeBufferSize 缓冲区大小
 @throws IOException IO异常
```
