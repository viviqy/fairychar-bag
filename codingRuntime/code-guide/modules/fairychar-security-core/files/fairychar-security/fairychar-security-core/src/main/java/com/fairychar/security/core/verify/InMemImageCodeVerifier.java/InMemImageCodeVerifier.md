# com.fairychar.security.core.verify.InMemImageCodeVerifier

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../InMemImageCodeVerifier.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-8f32cfb2e898eb04"></a>
## com.fairychar.security.core.verify.InMemImageCodeVerifier

```java
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class InMemImageCodeVerifier implements ICodeVerifier
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemImageCodeVerifier.java:29`; evidence: `declaration-8f32cfb2e898eb0458aad60e6664e6a55f775f685ded2614b6c82b03650f556b`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
简单图片验证器,基于内存方式

 @author chiyo <br>
```


## Fields

<a id="symbol-72e4a12f740c6be4"></a>
### codeStore

```java
private final Cache<String, SimpleImageCode> codeStore = Caffeine.newBuilder()
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .maximumSize(10_0000)
            .build()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemImageCodeVerifier.java:33`; evidence: `declaration-72e4a12f740c6be4ed86bec654a987c56c5fa570a0b411c00bd908f192f38d35`.
Visibility: `private` (explicit).
Type: `Cache<String, SimpleImageCode>`.

<a id="symbol-11c30652f683e41e"></a>
### codeHeader

```java
private String codeHeader = "verifyCode"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemImageCodeVerifier.java:38`; evidence: `declaration-11c30652f683e41ec514401942a53f97a2013d9857f8909a0864ea3a722cdd54`.
Visibility: `private` (explicit).
Type: `String`.

<a id="symbol-6bca840a0a49f1b5"></a>
### keyHeader

```java
private String keyHeader = "verifyKey"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemImageCodeVerifier.java:39`; evidence: `declaration-6bca840a0a49f1b5b6c3c9c89e95dba0e66e3a20848433ef08480240ebb98f5f`.
Visibility: `private` (explicit).
Type: `String`.

<a id="symbol-e6406c25b884768e"></a>
### expireSeconds

```java
@Setter
@Getter
private int expireSeconds = 300
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemImageCodeVerifier.java:44`; evidence: `declaration-e6406c25b884768eadbe89b63ce530a39b2c87f13fa02675542d60f9058e3136`.
Visibility: `private` (explicit).
Type: `int`.

Source docstring (unreviewed):
```text
验证码有效期(秒)
```


<a id="symbol-100e483d1477f084"></a>
### width

```java
@Setter
@Getter
private int width = 140
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemImageCodeVerifier.java:48`; evidence: `declaration-100e483d1477f084d899d08c59fcdd0290cf2f4c3e845528e0a71ab462f6dc26`.
Visibility: `private` (explicit).
Type: `int`.

<a id="symbol-d85bec6bc31f4659"></a>
### height

```java
@Setter
@Getter
private int height = 60
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemImageCodeVerifier.java:51`; evidence: `declaration-d85bec6bc31f465939a835d5727e0a2b6e0542300cc036bbc734c90dee0a0d2c`.
Visibility: `private` (explicit).
Type: `int`.

## Members

- [generateCode](InMemImageCodeVerifier.generateCode.md#symbol-0f6a1f621aabbd8b) — `function`, source line 55
- [verifyCode](InMemImageCodeVerifier.verifyCode.md#symbol-834fb5b024a0fa6a) — `function`, source line 67
