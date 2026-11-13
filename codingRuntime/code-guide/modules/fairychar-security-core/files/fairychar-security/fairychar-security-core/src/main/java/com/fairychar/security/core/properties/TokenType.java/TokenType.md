# com.fairychar.security.core.properties.TokenType

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../TokenType.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-da51fef27fde680d"></a>
## com.fairychar.security.core.properties.TokenType

```java
public enum TokenType
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/TokenType.java:7`; evidence: `declaration-da51fef27fde680d785ca18dba9a95af41d87e271210d6cb425fb30adaef2c9c`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
@author chiyo <br>
 @since 1.3.3
```


## Fields

<a id="symbol-2406d11698796fec"></a>
### REDIS

```java
REDIS
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/TokenType.java:11`; evidence: `declaration-2406d11698796fec224e5059c717b56d02295ab4176f21d610dacc4e55ee8b53`.
Visibility: `public` (language default or unknown).
Type: `TokenType`.
No initializer recorded.

Source docstring (unreviewed):
```text
采用redis存储用户会话信息
```


<a id="symbol-2e99bcac5f298d5f"></a>
### JWT

```java
JWT
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/TokenType.java:15`; evidence: `declaration-2e99bcac5f298d5fd2a9ab836a087ae0bf1d5c7a6e7e63a1d7b4f414b3d8cc69`.
Visibility: `public` (language default or unknown).
Type: `TokenType`.
No initializer recorded.

Source docstring (unreviewed):
```text
使用jwt令牌存储用户会话信息(暂未支持)
```


<a id="symbol-bef903eef5e5995f"></a>
### MEM

```java
MEM
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/TokenType.java:20`; evidence: `declaration-bef903eef5e5995ff40c861b2f7791e06ecbb2fa50a8772b6bc3766aec822752`.
Visibility: `public` (language default or unknown).
Type: `TokenType`.
No initializer recorded.

Source docstring (unreviewed):
```text
基于jvm内存(暂未支持)
```


<a id="symbol-f593497ae6f6afa5"></a>
### MYSQL

```java
MYSQL
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/properties/TokenType.java:25`; evidence: `declaration-f593497ae6f6afa529d78b2b78fd440361583918055484b2f484f535e105f6a1`.
Visibility: `public` (language default or unknown).
Type: `TokenType`.
No initializer recorded.

Source docstring (unreviewed):
```text
基于MySQL(暂未支持)
```
