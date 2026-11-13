# com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice.CauseInfo

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../GlobalInboundCauseAdvice.java.md)

[Lexical owner](GlobalInboundCauseAdvice.md#symbol-23177676aedebbe9)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-32deec41d095079b"></a>
## com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice.CauseInfo

```java
@AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Accessors(chain = true)
    static class CauseInfo
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:293`; evidence: `declaration-32deec41d095079b55f1bea3ecf6650ff5397a09296db814c132816b837887c8`.
Owner: `com.fairychar.bag.domain.netty.advice.GlobalInboundCauseAdvice`; visibility: `package-private` (language default or unknown).

Source docstring (unreviewed):
```text
1.同一个Ex只能有一个处理方法 (ex,handler=null,method=null)
 2.同一个Ex不同handler可以有不同的处理方法(ex,handler,method=null)
 3.同一个ex同一个handler不同的方法可以有不同的处理方法(ex,handler,method)
```


## Fields

<a id="symbol-c2f9bcd1d4566db3"></a>
### ex

```java
private Class ex
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:299`; evidence: `declaration-c2f9bcd1d4566db3c333247dfcfd3a69d6e69604c6da5f046e04ba42e558cd6a`.
Visibility: `private` (explicit).
Type: `Class`.
No initializer recorded.

<a id="symbol-bef33c3c9abbc6cf"></a>
### handler

```java
private Class handler
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:300`; evidence: `declaration-bef33c3c9abbc6cf858b88598c24ff194e513c80e527ea7eeb99c732048d4294`.
Visibility: `private` (explicit).
Type: `Class`.
No initializer recorded.

<a id="symbol-d9d82a598d192a25"></a>
### methodName

```java
private String methodName
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:301`; evidence: `declaration-d9d82a598d192a25b7486ee5c333863fe0c11ebe971c3a6d424eca83a9d005e1`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-5eb87f7403cc4e0a"></a>
### method

```java
private Method method
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/netty/advice/GlobalInboundCauseAdvice.java:302`; evidence: `declaration-5eb87f7403cc4e0adb2e0131c852b4d40820df59a30dbf5add1847b343f556ce`.
Visibility: `private` (explicit).
Type: `Method`.
No initializer recorded.

## Members

- [getMark](GlobalInboundCauseAdvice.CauseInfo.getMark.md#symbol-136e3f9a7ae982ba) — `function`, source line 304
