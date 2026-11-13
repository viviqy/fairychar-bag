# com.fairychar.security.core.verify.RedisPhoneCodeVerifier

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RedisPhoneCodeVerifier.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-bf72654c1140df31"></a>
## com.fairychar.security.core.verify.RedisPhoneCodeVerifier

```java
@Slf4j
public class RedisPhoneCodeVerifier implements ICodeVerifier
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisPhoneCodeVerifier.java:27`; evidence: `declaration-bf72654c1140df3141f4c11ff492822a0028d3d5b56235d5cad5d8db049171e9`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
基于redis的验证码校验器

 @author chiyo <br>
```


## Fields

<a id="symbol-1e27b4ad8486613b"></a>
### redisTemplate

```java
private final RedisTemplate<String, String> redisTemplate
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisPhoneCodeVerifier.java:29`; evidence: `declaration-1e27b4ad8486613b7f87e32b6b934d4b47b219feea822a9d4ad74281ef980e96`.
Visibility: `private` (explicit).
Type: `RedisTemplate<String, String>`.
No initializer recorded.

<a id="symbol-dd90bd74388ed504"></a>
### client

```java
private final AsyncClient client
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisPhoneCodeVerifier.java:30`; evidence: `declaration-dd90bd74388ed504be233ab9746ca890625dd72f8cd63add60318a7e14f86b24`.
Visibility: `private` (explicit).
Type: `AsyncClient`.
No initializer recorded.

<a id="symbol-709ffd19939a7884"></a>
### aliyunSmsProperties

```java
private final SmsVerifyProperties.AliyunSmsProperties aliyunSmsProperties
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisPhoneCodeVerifier.java:31`; evidence: `declaration-709ffd19939a78841a121e2bcba64a88c2128b1d3f6167c767256d0ef63b1957`.
Visibility: `private` (explicit).
Type: `SmsVerifyProperties.AliyunSmsProperties`.
No initializer recorded.

<a id="symbol-6df62b8aeaf327c6"></a>
### objectMapper

```java
private final ObjectMapper objectMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisPhoneCodeVerifier.java:32`; evidence: `declaration-6df62b8aeaf327c6105dd27fd302b8cb5eceaad83a92634874439585e2b2710b`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

<a id="symbol-587b5050f7410066"></a>
### prefix

```java
private final String prefix
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisPhoneCodeVerifier.java:37`; evidence: `declaration-587b5050f7410066ab7685a70cec47785f7205b7d1db2b72c388ce8c52d594dd`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
验证码存储空间的redis前缀
```


<a id="symbol-1908a7ba8abe6882"></a>
### codeHeader

```java
private final String codeHeader
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisPhoneCodeVerifier.java:41`; evidence: `declaration-1908a7ba8abe6882b8e7dec15b637d102314b8148f7423083268ee5c7236e56e`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
前端传输验证码header的名称
```


<a id="symbol-39ec11d214aedc7b"></a>
### keyHeader

```java
private final String keyHeader
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisPhoneCodeVerifier.java:45`; evidence: `declaration-39ec11d214aedc7b5fe58afe78a6e88e875a405f30369a2b763e19206aadbb8a`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
验证码唯一标识返回的header名称
```


<a id="symbol-23a9db4655aa3436"></a>
### expireSeconds

```java
@Setter
@Getter
private int expireSeconds = 300
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisPhoneCodeVerifier.java:49`; evidence: `declaration-23a9db4655aa3436aa3b07fd49095991c05897214efa1961efe54ce267eda654`.
Visibility: `private` (explicit).
Type: `int`.

Source docstring (unreviewed):
```text
验证码有效期(秒)
```


<a id="symbol-405369a975bfa0e4"></a>
### width

```java
@Setter
@Getter
private int width = 140
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisPhoneCodeVerifier.java:53`; evidence: `declaration-405369a975bfa0e4451ec0490145122951aa28c366065b3197b2fdb6329f316c`.
Visibility: `private` (explicit).
Type: `int`.

<a id="symbol-daa1028f724f18d8"></a>
### height

```java
@Setter
@Getter
private int height = 60
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisPhoneCodeVerifier.java:56`; evidence: `declaration-daa1028f724f18d8d02d51acb3de0ede93ef9dc51482f631712d1608231ed11c`.
Visibility: `private` (explicit).
Type: `int`.

## Members

- [RedisPhoneCodeVerifier](RedisPhoneCodeVerifier.RedisPhoneCodeVerifier--13c3a277d536f5d4.md#symbol-0da7e800d760bbba) — `constructor`, source line 61
- [RedisPhoneCodeVerifier](RedisPhoneCodeVerifier.RedisPhoneCodeVerifier--d873019770488abe.md#symbol-68ad04a8e21b5742) — `constructor`, source line 65
- [generateCode](RedisPhoneCodeVerifier.generateCode.md#symbol-df710563de783085) — `function`, source line 75
- [verifyCode](RedisPhoneCodeVerifier.verifyCode.md#symbol-1b43f2e5e30355cf) — `function`, source line 92
