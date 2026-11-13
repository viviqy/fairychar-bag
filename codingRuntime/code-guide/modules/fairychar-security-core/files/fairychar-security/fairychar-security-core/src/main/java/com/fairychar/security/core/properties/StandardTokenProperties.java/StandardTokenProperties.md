# com.fairychar.security.core.properties.StandardTokenProperties

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../StandardTokenProperties.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-a8081c6f0b9b6f82"></a>
## com.fairychar.security.core.properties.StandardTokenProperties

```java
@Data
public class StandardTokenProperties
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/StandardTokenProperties.java:9`; evidence: `declaration-a8081c6f0b9b6f828975d386419ce5098c7dbfbe61c5db914c0d458578a06333`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
@author chiyo <br>
```


## Fields

<a id="symbol-889f0a8dd89392d7"></a>
### tokenHeaderName

```java
private String tokenHeaderName = "token"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/StandardTokenProperties.java:11`; evidence: `declaration-889f0a8dd89392d7abfe5f55cc9f71147cedb4971f4a7aa120f1aaec8d5d8d97`.
Visibility: `private` (explicit).
Type: `String`.

<a id="symbol-5edb912d14a24d20"></a>
### maxSession

```java
private int maxSession = 3
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/StandardTokenProperties.java:12`; evidence: `declaration-5edb912d14a24d205df17e658ab896f2002bc42ce88c4efda43cf93665272e9a`.
Visibility: `private` (explicit).
Type: `int`.

<a id="symbol-bfc206ac50a90a51"></a>
### filter

```java
@NestedConfigurationProperty
private FilterProperties filter = new FilterProperties()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/StandardTokenProperties.java:14`; evidence: `declaration-bfc206ac50a90a51952cc9d67a8e87748596b81c2fadf100a951fd249aebd46c`.
Visibility: `private` (explicit).
Type: `FilterProperties`.
