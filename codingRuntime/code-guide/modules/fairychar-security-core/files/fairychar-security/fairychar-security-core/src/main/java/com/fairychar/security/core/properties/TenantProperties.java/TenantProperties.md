# com.fairychar.security.core.properties.TenantProperties

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../TenantProperties.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-8a823183aef4d8d0"></a>
## com.fairychar.security.core.properties.TenantProperties

```java
@Data
public class TenantProperties
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/TenantProperties.java:12`; evidence: `declaration-8a823183aef4d8d0ac2eda4b583e6d244806344a94acc22cdabc06c7cb4e0aeb`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
@author chiyo <br>
 @since
```


## Fields

<a id="symbol-c817f2219e54403f"></a>
### enable

```java
private boolean enable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/TenantProperties.java:14`; evidence: `declaration-c817f2219e54403f577ab7144f32e6d6ebcc0bce3de383b19d74ecedd389e395`.
Visibility: `private` (explicit).
Type: `boolean`.
No initializer recorded.

<a id="symbol-2407c18ab068cfe5"></a>
### ignoreTables

```java
private Set<String> ignoreTables = Collections.emptySet()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/TenantProperties.java:15`; evidence: `declaration-2407c18ab068cfe5b04fc8e26e6297731c90624cc92b1ef347302bbd96e2fa26`.
Visibility: `private` (explicit).
Type: `Set<String>`.

<a id="symbol-c4c2c007017c99a7"></a>
### columnName

```java
private String columnName = "tenant_id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/TenantProperties.java:16`; evidence: `declaration-c4c2c007017c99a7efcc57ef772912d9f84a98ab8d64fdb766d9f7861a0fb6ee`.
Visibility: `private` (explicit).
Type: `String`.
