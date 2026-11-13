# com.fairychar.security.core.properties.FilterProperties.VerifyCodeFilterProperties

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FilterProperties.java.md)

[Lexical owner](FilterProperties.md#symbol-1a56d439aa0354fa)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-2e0e2dcee5e4a764"></a>
## com.fairychar.security.core.properties.FilterProperties.VerifyCodeFilterProperties

```java
@Data
    public static class VerifyCodeFilterProperties
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FilterProperties.java:35`; evidence: `declaration-2e0e2dcee5e4a764f18d344efca416e2d3b02e4d3787cb6accd66f13c4b023eb`.
Owner: `com.fairychar.security.core.properties.FilterProperties`; visibility: `public` (explicit).

## Fields

<a id="symbol-e97bb882d81a98fc"></a>
### enable

```java
private boolean enable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FilterProperties.java:37`; evidence: `declaration-e97bb882d81a98fca063c99aa1167022971a9784134f158d2357b0c1d14d4897`.
Visibility: `private` (explicit).
Type: `boolean`.
No initializer recorded.

<a id="symbol-8b22ea65ccfef819"></a>
### verifyUrls

```java
private Set<String> verifyUrls = Collections.emptySet()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/FilterProperties.java:43`; evidence: `declaration-8b22ea65ccfef8198556d770157e45e9406e39b4d9e3dbdc0db9688ab6cf3d7e`.
Visibility: `private` (explicit).
Type: `Set<String>`.

Source docstring (unreviewed):
```text
<pre>忽略拦截的url</pre>
 使用了{@link org.springframework.util.AntPathMatcher}匹配,可以使用复杂模糊匹配,例如<br>
 "/api/**","/index/hi"
```
