# com.fairychar.security.core.verify.RedisImageCodeVerifier

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RedisImageCodeVerifier.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-bc516f0cce000c28"></a>
## com.fairychar.security.core.verify.RedisImageCodeVerifier

```java
public class RedisImageCodeVerifier implements ICodeVerifier
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisImageCodeVerifier.java:24`; evidence: `declaration-bc516f0cce000c28c7e30024b444af13cc281065e166225e67339a07b6ef4299`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
基于redis的验证码校验器

 @author chiyo <br>
```


## Fields

<a id="symbol-e3dfefe04e2cd4f1"></a>
### redisTemplate

```java
private final RedisTemplate<String, String> redisTemplate
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisImageCodeVerifier.java:25`; evidence: `declaration-e3dfefe04e2cd4f1dee040e0ce60af0fe01f432260b673003894ecf87dc04fdd`.
Visibility: `private` (explicit).
Type: `RedisTemplate<String, String>`.
No initializer recorded.

<a id="symbol-c015c723fd337db9"></a>
### prefix

```java
private final String prefix
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisImageCodeVerifier.java:29`; evidence: `declaration-c015c723fd337db91213a061602a7565ef126f4fca99b8e3a3c314173652ef30`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
验证码存储空间的redis前缀
```


<a id="symbol-08a4c1c08db9b113"></a>
### codeHeader

```java
private final String codeHeader
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisImageCodeVerifier.java:33`; evidence: `declaration-08a4c1c08db9b1130030321420210c35f76bd6069b652ac1fde6f6b4d8ce0f5e`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
前端传输验证码header的名称
```


<a id="symbol-764d61aa408d0a1d"></a>
### keyHeader

```java
private final String keyHeader
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisImageCodeVerifier.java:37`; evidence: `declaration-764d61aa408d0a1d88df962fca6b4ecf0fa9a6ffb9649fd43943a2d0c0702a72`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
验证码唯一标识返回的header名称
```


<a id="symbol-ddd46596e49f6fe2"></a>
### expireSeconds

```java
@Setter
@Getter
private int expireSeconds = 300
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisImageCodeVerifier.java:41`; evidence: `declaration-ddd46596e49f6fe28aecf08055efeedf7c3d26123fae06e73950b79b06fda396`.
Visibility: `private` (explicit).
Type: `int`.

Source docstring (unreviewed):
```text
验证码有效期(秒)
```


<a id="symbol-5612f32641974b57"></a>
### width

```java
@Setter
@Getter
private int width = 140
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisImageCodeVerifier.java:45`; evidence: `declaration-5612f32641974b57d98029c6f52d771182e6c3501d668d2085522a92a80fb4bc`.
Visibility: `private` (explicit).
Type: `int`.

<a id="symbol-c8b8d1a6feeeaab7"></a>
### height

```java
@Setter
@Getter
private int height = 60
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/RedisImageCodeVerifier.java:48`; evidence: `declaration-c8b8d1a6feeeaab70c57b6961956d07dd377b613a2f7fc9f51685a19544e3041`.
Visibility: `private` (explicit).
Type: `int`.

## Members

- [RedisImageCodeVerifier](RedisImageCodeVerifier.RedisImageCodeVerifier--526bc4904dc41666.md#symbol-dba5da2015d8105b) — `constructor`, source line 53
- [RedisImageCodeVerifier](RedisImageCodeVerifier.RedisImageCodeVerifier--5ce0ff34ea024994.md#symbol-4bb01c3fe2407465) — `constructor`, source line 57
- [generateCode](RedisImageCodeVerifier.generateCode.md#symbol-46eeb9ebd54bc71b) — `function`, source line 64
- [verifyCode](RedisImageCodeVerifier.verifyCode.md#symbol-319e439c0f88c491) — `function`, source line 76
