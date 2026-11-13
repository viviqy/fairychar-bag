# com.fairychar.security.core.properties.UrlProperties

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../UrlProperties.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-96b12d83727203ec"></a>
## com.fairychar.security.core.properties.UrlProperties

```java
@Data
public class UrlProperties
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/UrlProperties.java:9`; evidence: `declaration-96b12d83727203ec6ceb2bdedce9f28089fb53eae14b83594c04ad56b0ca9d54`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
@author chiyo <br>
 @since 1.3.3
```


## Fields

<a id="symbol-395a37db7ba5d98a"></a>
### login

```java
private String login = "/login"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/UrlProperties.java:11`; evidence: `declaration-395a37db7ba5d98a24007c4c896d4789dbe736bfbe740619f955f87e820b4a21`.
Visibility: `private` (explicit).
Type: `String`.

<a id="symbol-2dab8490be374d68"></a>
### logout

```java
private String logout = "/logout"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/UrlProperties.java:12`; evidence: `declaration-2dab8490be374d68621e4cd4bcbe5fc921a74711332a13266bb91ac293c56685`.
Visibility: `private` (explicit).
Type: `String`.

<a id="symbol-68becf25ead30ac0"></a>
### allowed

```java
private String[] allowed
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/UrlProperties.java:13`; evidence: `declaration-68becf25ead30ac0237ab4560bd5d9b1aa336c548355633f55be95249f96c92d`.
Visibility: `private` (explicit).
Type: `String[]`.
No initializer recorded.

<a id="symbol-5d76e9573e03b35d"></a>
### authenticated

```java
private String[] authenticated
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/UrlProperties.java:14`; evidence: `declaration-5d76e9573e03b35d6e9dda63fc0f1eab47e94f8397e7892bed8a41eeb8da8518`.
Visibility: `private` (explicit).
Type: `String[]`.
No initializer recorded.

<a id="symbol-8d33eef3e9292d81"></a>
### disableLoginCors

```java
private boolean disableLoginCors = true
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/UrlProperties.java:15`; evidence: `declaration-8d33eef3e9292d81b2c1946421fcbee3e8737a28ed7d76ce0075ef8ed9d4b417`.
Visibility: `private` (explicit).
Type: `boolean`.

<a id="symbol-ee26338e42a4540e"></a>
### disableLoginCsrf

```java
private boolean disableLoginCsrf = true
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/UrlProperties.java:16`; evidence: `declaration-ee26338e42a4540efbe2dd7f9225b0f495ffb71ae1761da3923308cb1f0ec42a`.
Visibility: `private` (explicit).
Type: `boolean`.
