# com.fairychar.security.core.verify.InMemPhoneCodeVerifier

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../InMemPhoneCodeVerifier.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-31dd5ba370d7878e"></a>
## com.fairychar.security.core.verify.InMemPhoneCodeVerifier

```java
@Slf4j
public class InMemPhoneCodeVerifier implements ICodeVerifier
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemPhoneCodeVerifier.java:28`; evidence: `declaration-31dd5ba370d7878e36846247aa8cb97fa20d6c12e8ceee3d198668e5a43261f7`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
简单图片验证器,基于内存方式

 @author chiyo <br>
```


## Fields

<a id="symbol-3e914b758f75c938"></a>
### codeStore

```java
private final Cache<String, SimpleImageCode> codeStore
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemPhoneCodeVerifier.java:30`; evidence: `declaration-3e914b758f75c938b5b1105952d2eedd45203bc0b299e9a41a26f98e9b608d74`.
Visibility: `private` (explicit).
Type: `Cache<String, SimpleImageCode>`.
No initializer recorded.

<a id="symbol-4fadbd76e971d8eb"></a>
### client

```java
private final AsyncClient client
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemPhoneCodeVerifier.java:31`; evidence: `declaration-4fadbd76e971d8eb80ab67f6dc54006bf4839f8c45a843a4371846061fd57e52`.
Visibility: `private` (explicit).
Type: `AsyncClient`.
No initializer recorded.

<a id="symbol-d0038d82ec6e96fe"></a>
### aliyunSmsProperties

```java
private final SmsVerifyProperties.AliyunSmsProperties aliyunSmsProperties
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemPhoneCodeVerifier.java:32`; evidence: `declaration-d0038d82ec6e96fe65bac253b6d734c7156c692e06dcac0f61a24490a62bffe0`.
Visibility: `private` (explicit).
Type: `SmsVerifyProperties.AliyunSmsProperties`.
No initializer recorded.

<a id="symbol-d194ab30c6934ca6"></a>
### objectMapper

```java
private final ObjectMapper objectMapper
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemPhoneCodeVerifier.java:33`; evidence: `declaration-d194ab30c6934ca640d5896ca79fd46a512df5cae42359b457199f4a834f8122`.
Visibility: `private` (explicit).
Type: `ObjectMapper`.
No initializer recorded.

<a id="symbol-f2c58ee446a27e09"></a>
### codeHeader

```java
private String codeHeader = "verifyCode"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemPhoneCodeVerifier.java:35`; evidence: `declaration-f2c58ee446a27e0976a2508506d20349debbd5e5374e941ba2a9e5dc78e79152`.
Visibility: `private` (explicit).
Type: `String`.

<a id="symbol-b8b8f127a2c8e7ce"></a>
### keyHeader

```java
private String keyHeader = "verifyKey"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/verify/InMemPhoneCodeVerifier.java:36`; evidence: `declaration-b8b8f127a2c8e7ce16f1b1b5fa11bea8013d439a115420fc5e23dbd81795f426`.
Visibility: `private` (explicit).
Type: `String`.

## Members

- [InMemPhoneCodeVerifier](InMemPhoneCodeVerifier.InMemPhoneCodeVerifier--3e2e1b5da0451fd2.md#symbol-9302d295d2d4b3c9) — `constructor`, source line 39
- [InMemPhoneCodeVerifier](InMemPhoneCodeVerifier.InMemPhoneCodeVerifier--94ff06abb38fcbad.md#symbol-9fad4ff3f4d60a43) — `constructor`, source line 50
- [InMemPhoneCodeVerifier](InMemPhoneCodeVerifier.InMemPhoneCodeVerifier--ba1e96c292ca2ee4.md#symbol-5c1811f14812e6ad) — `constructor`, source line 57
- [generateCode](InMemPhoneCodeVerifier.generateCode.md#symbol-9f463d68cee6871e) — `function`, source line 66
- [verifyCode](InMemPhoneCodeVerifier.verifyCode.md#symbol-1f15cd3714c51457) — `function`, source line 82
