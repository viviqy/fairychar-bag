# com.fairychar.bag.domain.netty.frame.HeadTailFrame

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../HeadTailFrame.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-943452c099bfbf63"></a>
## com.fairychar.bag.domain.netty.frame.HeadTailFrame

```java
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HeadTailFrame
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/frame/HeadTailFrame.java:14`; evidence: `declaration-943452c099bfbf635e023cc3b03bcbe4663083cdf59082b39f090ac0118109e2`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
Datetime: 2021/2/7 17:08

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-648f147e49219d6b"></a>
### head

```java
private byte[] head
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/frame/HeadTailFrame.java:21`; evidence: `declaration-648f147e49219d6bb84d9749499a55d3bdd89517f1852d488a7dffcdf098f7fa`.
Visibility: `private` (explicit).
Type: `byte[]`.
No initializer recorded.

Source docstring (unreviewed):
```text
协议头
```


<a id="symbol-03ce09e419b78977"></a>
### content

```java
private ByteBuf content
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/frame/HeadTailFrame.java:25`; evidence: `declaration-03ce09e419b789772b9fc1c662c545f994bbf5368ee7e16c7655108659caaee6`.
Visibility: `private` (explicit).
Type: `ByteBuf`.
No initializer recorded.

Source docstring (unreviewed):
```text
协议体用完后要{@code release()}
```


<a id="symbol-f2d9169d839cf7f4"></a>
### tail

```java
private byte[] tail
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/frame/HeadTailFrame.java:29`; evidence: `declaration-f2d9169d839cf7f46656090bdc2afec7ed550ece19a128693cc15edd6a22a041`.
Visibility: `private` (explicit).
Type: `byte[]`.
No initializer recorded.

Source docstring (unreviewed):
```text
协议尾
```
