# com.fairychar.bag.utils.FileUtil.createFakeFileByNio

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FileUtil.java.md)

[Lexical owner](FileUtil.md#symbol-6afa9075f04d8d0f)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-e02211428dbcf863"></a>
## com.fairychar.bag.utils.FileUtil.createFakeFileByNio

```java
public static void createFakeFileByNio(String path, byte fillByte, long writeByteSize) throws IOException
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/FileUtil.java:127`; evidence: `declaration-e02211428dbcf8633f38015d48225c7edb00e7c0644d279e5507c2d14c090282`.
Owner: `com.fairychar.bag.utils.FileUtil`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
使用NIO创建虚拟文件

 @param path          虚拟文件路径
 @param fillByte      填充字节
 @param writeByteSize 虚拟文件大小（字节数）
 @throws IOException IO异常
```
