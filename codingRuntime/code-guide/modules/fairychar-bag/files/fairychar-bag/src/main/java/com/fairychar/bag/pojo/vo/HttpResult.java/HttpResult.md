# com.fairychar.bag.pojo.vo.HttpResult

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../HttpResult.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-50e0aad9e402ffa6"></a>
## com.fairychar.bag.pojo.vo.HttpResult

```java
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class HttpResult<T> implements Serializable
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/vo/HttpResult.java:20`; evidence: `declaration-50e0aad9e402ffa6fbc0983ad3d0837700410eb31db54950e252b1c1627c694f`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
restful响应体

 @author chiyo
```


## Fields

<a id="symbol-1724dcc66c9e7aa3"></a>
### CACHED_OK

```java
private static final HttpResult CACHED_OK = new HttpResult(200, null, "success")
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/vo/HttpResult.java:25`; evidence: `declaration-1724dcc66c9e7aa30fab44c81a10f4f1f5c1d62a9049bc443275f20897857d70`.
Visibility: `private` (explicit).
Type: `HttpResult`.

<a id="symbol-d7fcc27e76e697ef"></a>
### CACHED_FAIL

```java
private static final HttpResult CACHED_FAIL = new HttpResult<>(RestErrorCode.OPERATION_FAILED.getCode()
            , null, RestErrorCode.OPERATION_FAILED.getMessage())
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/vo/HttpResult.java:26`; evidence: `declaration-d7fcc27e76e697efdd77eafa1683e3900ded1905ae876164ef305170415744b5`.
Visibility: `private` (explicit).
Type: `HttpResult`.

<a id="symbol-4a97571bd136c15d"></a>
### code

```java
private int code
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/vo/HttpResult.java:29`; evidence: `declaration-4a97571bd136c15d88c7872c6bb63476ef837e3c07fd93642a9031fd5b2044b9`.
Visibility: `private` (explicit).
Type: `int`.
No initializer recorded.

<a id="symbol-63b8dd3cbed87a33"></a>
### data

```java
@FuzzyValue
private T data
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/vo/HttpResult.java:34`; evidence: `declaration-63b8dd3cbed87a3347cca5f45da8dbdb232df83b31ba1d55610304d3b24a4eee`.
Visibility: `private` (explicit).
Type: `T`.
No initializer recorded.

Source docstring (unreviewed):
```text
返回数据
 <p>{@link FuzzyValue}添加模糊化参数支持</p>
```


<a id="symbol-c363c37dc0a1beea"></a>
### msg

```java
private String msg
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/vo/HttpResult.java:36`; evidence: `declaration-c363c37dc0a1beeab0ca7738a0dc4a2207326ba96616f4dd651485b4ac560be7`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

## Members

- [response](HttpResult.response--b1119f79c9773296.md#symbol-717adca84f2dc30e) — `function`, source line 39
- [response](HttpResult.response--16804a57715fad5b.md#symbol-034a31e58da311a0) — `function`, source line 45
- [ok](HttpResult.ok--927f1b4f36019bd8.md#symbol-139a12ded44fb1ca) — `function`, source line 52
- [ok](HttpResult.ok--90f2b9994483b64d.md#symbol-05575883bbacad01) — `function`, source line 57
- [fail](HttpResult.fail--f2066c043b7c05e6.md#symbol-289d861e378f1e59) — `function`, source line 61
- [fail](HttpResult.fail--fa6f9702f59523b5.md#symbol-00da59e7a285ce5a) — `function`, source line 65
- [fail](HttpResult.fail--df214c0c64c8ffbc.md#symbol-3015e496e5b96495) — `function`, source line 69
- [fail](HttpResult.fail--a7c1501ec2a5e933.md#symbol-902f0b1d427e0a35) — `function`, source line 73
