# com.fairychar.bag.beans.netty.decoder.DelimitersHeadTailFrameDecoder

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../DelimitersHeadTailFrameDecoder.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-47f6b91d52239d01"></a>
## com.fairychar.bag.beans.netty.decoder.DelimitersHeadTailFrameDecoder

```java
@Slf4j
public class DelimitersHeadTailFrameDecoder extends ByteToMessageDecoder
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/decoder/DelimitersHeadTailFrameDecoder.java:22`; evidence: `declaration-47f6b91d52239d01324b7667c9614f13cea1c4c4af5f80d42fc5b29da6c46cc2`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
固定报文头与固定报文尾的协议解码器
 <p>
 Datetime: 2021/2/7 16:21

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-066f438430895024"></a>
### head

```java
private final byte[] head
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/decoder/DelimitersHeadTailFrameDecoder.java:28`; evidence: `declaration-066f438430895024c9a7c51f48bc80f6fb78836205be29a86fa8cfa86b8d4fc7`.
Visibility: `private` (explicit).
Type: `byte[]`.
No initializer recorded.

Source docstring (unreviewed):
```text
报文包头
```


<a id="symbol-bd42a7adf76f6297"></a>
### tail

```java
private final byte[] tail
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/decoder/DelimitersHeadTailFrameDecoder.java:32`; evidence: `declaration-bd42a7adf76f62972761d92a04c386e1e4b39d4533973fc99762184fcb04e4a1`.
Visibility: `private` (explicit).
Type: `byte[]`.
No initializer recorded.

Source docstring (unreviewed):
```text
报文包尾
```


<a id="symbol-79318b89fe1ec45d"></a>
### cache

```java
private final ByteBuf cache
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/decoder/DelimitersHeadTailFrameDecoder.java:36`; evidence: `declaration-79318b89fe1ec45df76d254fa456498d585827d9ecd3cd95e6249c9a27940dbe`.
Visibility: `private` (explicit).
Type: `ByteBuf`.
No initializer recorded.

Source docstring (unreviewed):
```text
缓存content
```


<a id="symbol-106d46f6b0e64296"></a>
### isMatchedHeader

```java
private boolean isMatchedHeader = false
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/netty/decoder/DelimitersHeadTailFrameDecoder.java:40`; evidence: `declaration-106d46f6b0e64296037f410faf1c33f6db570ae5cb408d38709d9a9601483d1a`.
Visibility: `private` (explicit).
Type: `boolean`.

Source docstring (unreviewed):
```text
是否已经匹配到header
```


## Members

- [DelimitersHeadTailFrameDecoder](DelimitersHeadTailFrameDecoder.DelimitersHeadTailFrameDecoder.md#symbol-a16e9fd0ff019204) — `constructor`, source line 42
- [decode](DelimitersHeadTailFrameDecoder.decode--f0bf394d7b7d8235.md#symbol-eac17beece5ed953) — `function`, source line 49
- [decode](DelimitersHeadTailFrameDecoder.decode--4e84260662cf11c3.md#symbol-a171993768ea4a26) — `function`, source line 57
- [isMatchedTail](DelimitersHeadTailFrameDecoder.isMatchedTail.md#symbol-a60687f1fd8ba1a3) — `function`, source line 80
- [wrapFrame](DelimitersHeadTailFrameDecoder.wrapFrame.md#symbol-5551f220ec8a1f4a) — `function`, source line 91
- [validateHeader](DelimitersHeadTailFrameDecoder.validateHeader.md#symbol-3507be0f77bb05b3) — `function`, source line 98
