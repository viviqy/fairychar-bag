# com.fairychar.bag.extension.request.ClonedServletRequest

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ClonedServletRequest.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-7517457dca5dfeed"></a>
## com.fairychar.bag.extension.request.ClonedServletRequest

```java
public class ClonedServletRequest extends HttpServletRequestWrapper
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/request/ClonedServletRequest.java:31`; evidence: `declaration-7517457dca5dfeedee0806568de4c6109db9117af4f57e4457e1092843818b94`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
克隆http请求request
 {@link ClonedServletRequest#getInputStream()}方法可以重复读取请求流,每次读取都返回一个原有请求流的clone
 copy保留:
 1.request attribute
 2.request headers
 3.request method
 4.request sessionId
 5.request uri

 @author chiyo
 @since 3.0.1
```


## Fields

<a id="symbol-072eefddefe334b9"></a>
### method

```java
private String method
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/request/ClonedServletRequest.java:33`; evidence: `declaration-072eefddefe334b9348e727234ec96594219d6a81838eec9ece45f84083b32c9`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-023ced95448c8910"></a>
### requestURI

```java
private String requestURI
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/request/ClonedServletRequest.java:34`; evidence: `declaration-023ced95448c89101ee9ee4d725a167cedda7f1fd70c4b6061ccb543dfc4764e`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-7910fc6cd49afbdb"></a>
### sessionId

```java
private String sessionId
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/request/ClonedServletRequest.java:35`; evidence: `declaration-7910fc6cd49afbdb1b9bc80f0682b56bdc07fe0de5fcae501b347d8ccf4aa01d`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

<a id="symbol-bbecb682168cdb02"></a>
### inputBytes

```java
private byte[] inputBytes
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/request/ClonedServletRequest.java:36`; evidence: `declaration-bbecb682168cdb025f23acdc7d3630bc0ffba92d4806563cbc5af84ecb2984d2`.
Visibility: `private` (explicit).
Type: `byte[]`.
No initializer recorded.

<a id="symbol-4ee9c0985ffe2e06"></a>
### headers

```java
private Map<String, String> headers
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/request/ClonedServletRequest.java:38`; evidence: `declaration-4ee9c0985ffe2e069618997a2e18dc0c83b79ab8abbc24733276a4820535e014`.
Visibility: `private` (explicit).
Type: `Map<String, String>`.
No initializer recorded.

<a id="symbol-99109961bb80a8f9"></a>
### attributes

```java
private Map<String, Object> attributes
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/extension/request/ClonedServletRequest.java:40`; evidence: `declaration-99109961bb80a8f9d94b6eeb4cbf5bdeaacd847c733eeb031347a66bb3e2e394`.
Visibility: `private` (explicit).
Type: `Map<String, Object>`.
No initializer recorded.

## Members

- [ClonedServletRequest](ClonedServletRequest.ClonedServletRequest.md#symbol-5cbc788e2685b808) — `constructor`, source line 42
- [getAttribute](ClonedServletRequest.getAttribute.md#symbol-8a02470fefada88c) — `function`, source line 69
- [getAttributeNames](ClonedServletRequest.getAttributeNames.md#symbol-578c6641bd522eb5) — `function`, source line 74
- [getRequestURI](ClonedServletRequest.getRequestURI.md#symbol-d220c429b0134f55) — `function`, source line 90
- [getRequestedSessionId](ClonedServletRequest.getRequestedSessionId.md#symbol-04a8cf777b7c5f2a) — `function`, source line 95
- [getMethod](ClonedServletRequest.getMethod.md#symbol-cc809c102ae4f347) — `function`, source line 100
- [getHeaderNames](ClonedServletRequest.getHeaderNames.md#symbol-7aca2379891dce47) — `function`, source line 105
- [getHeader](ClonedServletRequest.getHeader.md#symbol-f9c8b960a57fc346) — `function`, source line 110
- [getInputStream](ClonedServletRequest.getInputStream.md#symbol-ce5b062bfc407bec) — `function`, source line 115
