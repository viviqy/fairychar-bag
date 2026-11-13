# com.fairychar.bag.beans.aop.JsonLoggingHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../JsonLoggingHandler.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-81ecd6bef2f1c0f8"></a>
## com.fairychar.bag.beans.aop.JsonLoggingHandler

```java
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class JsonLoggingHandler implements LoggingHandler
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/aop/JsonLoggingHandler.java:26`; evidence: `declaration-81ecd6bef2f1c0f88c0163cf3e46a9c0bb6f0b30367898ba436bd44eedd0fd95`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
json格式的api请求与响应内容打印

 @author chiyo <br>
 @since 1.3.2
```


## Fields

<a id="symbol-da8f9520e175afea"></a>
### objectMapper

```java
private ObjectMapper objectMapper
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/aop/JsonLoggingHandler.java:30`; evidence: `declaration-da8f9520e175afea17d870a5143772b392a8728bcba4d19d2c6c51249a8793c1`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

<a id="symbol-9089af1f6a35c283"></a>
### prettyJson

```java
private boolean prettyJson = false
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/aop/JsonLoggingHandler.java:31`; evidence: `declaration-9089af1f6a35c2832f729941b2d4c80760e4825efae2c5abcac559cd050c977a`.
Visibility: `private` (explicit).
Type: `boolean`.

<a id="symbol-bf16f474c6080ab1"></a>
### TRACE_ID

```java
private static final String TRACE_ID = "TRACE_ID"
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/aop/JsonLoggingHandler.java:33`; evidence: `declaration-bf16f474c6080ab1ce550c48b15ba24f860c64fec0af26722ecb67a308689f31`.
Visibility: `private` (explicit).
Type: `String`.

## Members

- [before](JsonLoggingHandler.before.md#symbol-50e04ce2c5f3352a) — `function`, source line 35
- [after](JsonLoggingHandler.after.md#symbol-3214417f47253f60) — `function`, source line 66
- [copyArgs](JsonLoggingHandler.copyArgs.md#symbol-4fc9e5998488299a) — `function`, source line 93
