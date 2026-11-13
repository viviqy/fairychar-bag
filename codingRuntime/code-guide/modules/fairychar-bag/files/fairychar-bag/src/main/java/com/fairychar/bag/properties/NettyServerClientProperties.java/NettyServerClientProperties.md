# com.fairychar.bag.properties.NettyServerClientProperties

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../NettyServerClientProperties.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-5f48808fc65f0611"></a>
## com.fairychar.bag.properties.NettyServerClientProperties

```java
@Data
public class NettyServerClientProperties
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/NettyServerClientProperties.java:12`; evidence: `declaration-5f48808fc65f0611bb8fbba310d5ed5ec5c1645dcafdf1bec9e4ee7e8633696f`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>netty服务参数</p>
 提供netty核心参数,但不自动配置任何组件,提供于需要获取netty相关参数配置的组件

 @author chiyo
 @since 0.0.1-SNAPSHOT
```


## Fields

<a id="symbol-a8a30b2f3105f232"></a>
### server

```java
private ServerProperties server
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/NettyServerClientProperties.java:14`; evidence: `declaration-a8a30b2f3105f2322cfd49b2b573e8117d59d632920f03cc6dd47dc840f67e54`.
Visibility: `private` (explicit).
Type: `ServerProperties`.
No initializer recorded.

<a id="symbol-34bd475122293d53"></a>
### client

```java
private ClientProperties client
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/NettyServerClientProperties.java:15`; evidence: `declaration-34bd475122293d530f281274450b045886ed199ca8dbfd78763569867c35f977`.
Visibility: `private` (explicit).
Type: `ClientProperties`.
No initializer recorded.

## Members

- [ClientProperties](NettyServerClientProperties.ClientProperties.md#symbol-2c146d383d308c29) — `class`, source line 17
- [ServerProperties](NettyServerClientProperties.ServerProperties.md#symbol-0bb9e829a518be5f) — `class`, source line 24
