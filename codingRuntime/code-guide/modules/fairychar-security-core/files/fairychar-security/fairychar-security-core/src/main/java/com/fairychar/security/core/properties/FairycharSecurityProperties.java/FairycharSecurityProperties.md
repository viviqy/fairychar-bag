# com.fairychar.security.core.properties.FairycharSecurityProperties

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FairycharSecurityProperties.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-fbf75626ebab9880"></a>
## com.fairychar.security.core.properties.FairycharSecurityProperties

```java
@Data
@ConfigurationProperties(prefix = "fairychar.security")
public class FairycharSecurityProperties
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FairycharSecurityProperties.java:11`; evidence: `declaration-fbf75626ebab98804d15b59fbf2d725b3f5d3da7a80c26b5b6d712e7f4b052b9`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
@author chiyo <br>
 @since 1.3.3
```


## Fields

<a id="symbol-851dff3941376649"></a>
### tokenType

```java
private TokenType tokenType = TokenType.REDIS
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FairycharSecurityProperties.java:14`; evidence: `declaration-851dff39413766494697659a58d7052575a9044b59b8c1683786f1c339f43535`.
Visibility: `private` (explicit).
Type: `TokenType`.

<a id="symbol-2a88ffa66cfe5ca7"></a>
### standard

```java
@NestedConfigurationProperty
private StandardTokenProperties standard = new StandardTokenProperties()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FairycharSecurityProperties.java:15`; evidence: `declaration-2a88ffa66cfe5ca72487900e259ab1d772c69d25a8c5ec6162270f68da5939bc`.
Visibility: `private` (explicit).
Type: `StandardTokenProperties`.

<a id="symbol-977137f3c78cb033"></a>
### verify

```java
@NestedConfigurationProperty
private SmsVerifyProperties verify = new SmsVerifyProperties()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FairycharSecurityProperties.java:17`; evidence: `declaration-977137f3c78cb03394920c5b567f76116ae2f3057908a5d9647ca8415cd74947`.
Visibility: `private` (explicit).
Type: `SmsVerifyProperties`.

<a id="symbol-829b7965aca5b717"></a>
### plugins

```java
@NestedConfigurationProperty
private PluginsProperties plugins = new PluginsProperties()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FairycharSecurityProperties.java:19`; evidence: `declaration-829b7965aca5b7171b56d3ac6317c0898f0b0d8dc0a8e4802755105f09ff1309`.
Visibility: `private` (explicit).
Type: `PluginsProperties`.

<a id="symbol-b08bde146065f5c9"></a>
### url

```java
@NestedConfigurationProperty
private UrlProperties url = new UrlProperties()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FairycharSecurityProperties.java:21`; evidence: `declaration-b08bde146065f5c9aea01ec637fbc9ab834565e2e12f7c3873e79acdabc478ad`.
Visibility: `private` (explicit).
Type: `UrlProperties`.
