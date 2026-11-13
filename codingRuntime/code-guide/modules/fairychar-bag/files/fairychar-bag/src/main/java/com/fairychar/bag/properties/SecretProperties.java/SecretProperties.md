# com.fairychar.bag.properties.SecretProperties

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SecretProperties.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-59df30aee6af3714"></a>
## com.fairychar.bag.properties.SecretProperties

```java
@Data
public class SecretProperties
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/SecretProperties.java:12`; evidence: `declaration-59df30aee6af37140c03cee7ca1d690173b24ee30622eb3742d5dff52e21c3e1`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
Datetime: 2021/12/2 23:01

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-e0a78e0b88e6c545"></a>
### aes

```java
@NestedConfigurationProperty
private AesProperties aes
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/SecretProperties.java:15`; evidence: `declaration-e0a78e0b88e6c545a365602d0fb93d6baf610c6165a1b44728ffe38ba9ee6432`.
Visibility: `private` (explicit).
Type: `AesProperties`.
No initializer recorded.

<a id="symbol-0a5d1cfeb6435962"></a>
### rsa

```java
@NestedConfigurationProperty
private RsaProperties rsa
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/SecretProperties.java:17`; evidence: `declaration-0a5d1cfeb6435962c2c8a90901c8aa5ba6b819e6251588c4173d73d93d7caf61`.
Visibility: `private` (explicit).
Type: `RsaProperties`.
No initializer recorded.

## Members

- [AesProperties](SecretProperties.AesProperties.md#symbol-2089534c4cf0f7eb) — `class`, source line 20
- [RsaProperties](SecretProperties.RsaProperties.md#symbol-e501ac9bdb24eb36) — `class`, source line 25
