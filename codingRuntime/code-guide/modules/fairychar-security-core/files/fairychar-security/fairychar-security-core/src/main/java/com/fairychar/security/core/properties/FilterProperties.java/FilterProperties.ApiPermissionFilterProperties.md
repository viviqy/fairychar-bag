# com.fairychar.security.core.properties.FilterProperties.ApiPermissionFilterProperties

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FilterProperties.java.md)

[Lexical owner](FilterProperties.md#symbol-1a56d439aa0354fa)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-0b67ce9a5c750b52"></a>
## com.fairychar.security.core.properties.FilterProperties.ApiPermissionFilterProperties

```java
@Data
    public static class ApiPermissionFilterProperties
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FilterProperties.java:46`; evidence: `declaration-0b67ce9a5c750b52699e3b5f6bbff9799f9df3c1d529dac1b43528ec5304852c`.
Owner: `com.fairychar.security.core.properties.FilterProperties`; visibility: `public` (explicit).

## Fields

<a id="symbol-f8045a828c99cb28"></a>
### enable

```java
private boolean enable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FilterProperties.java:48`; evidence: `declaration-f8045a828c99cb28c30c5304b55bb7167adf74f844256e66f133cc8baa14f512`.
Visibility: `private` (explicit).
Type: `boolean`.
No initializer recorded.

<a id="symbol-4ba9295cf10d480d"></a>
### ignorePaths

```java
private Set<String> ignorePaths = Collections.emptySet()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FilterProperties.java:52`; evidence: `declaration-4ba9295cf10d480d49f7516818f27fb1f096e6ec54f14653bd7aa4fc6b7860e4`.
Visibility: `private` (explicit).
Type: `Set<String>`.

Source docstring (unreviewed):
```text
忽略的路径
```
