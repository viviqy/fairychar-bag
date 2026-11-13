# com.fairychar.bag.properties.FairycharBagProperties

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FairycharBagProperties.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-94800adc7d739228"></a>
## com.fairychar.bag.properties.FairycharBagProperties

```java
@ConfigurationProperties(prefix = "fairychar.bag")
@Getter
@Setter
public class FairycharBagProperties
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/FairycharBagProperties.java:13`; evidence: `declaration-94800adc7d7392287bdae60b9ec56f2016293002a765b3c8705d85ca4b32f96b`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
Fairychar Bag 属性配置

 @author qiyue
```


## Fields

<a id="symbol-8df9739393b5bfde"></a>
### aop

```java
@NestedConfigurationProperty
private AopProperties aop
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/FairycharBagProperties.java:17`; evidence: `declaration-8df9739393b5bfded2eba8009ae9fb19da1bd233aad45aca6d982a83a6a21cda`.
Visibility: `private` (explicit).
Type: `AopProperties`.
No initializer recorded.

<a id="symbol-9d92b73fba7fcbdd"></a>
### serverClient

```java
@NestedConfigurationProperty
private NettyServerClientProperties serverClient
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/FairycharBagProperties.java:19`; evidence: `declaration-9d92b73fba7fcbdd06e3edc6612057d5124f7885b3002a7e8b1c6c8b4f503e1b`.
Visibility: `private` (explicit).
Type: `NettyServerClientProperties`.
No initializer recorded.

<a id="symbol-265ebb4f214d3e0b"></a>
### secret

```java
@NestedConfigurationProperty
private SecretProperties secret
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/FairycharBagProperties.java:21`; evidence: `declaration-265ebb4f214d3e0baf04cd6d533a2273f6480f9fec64947b54b711c1cd47c85f`.
Visibility: `private` (explicit).
Type: `SecretProperties`.
No initializer recorded.

<a id="symbol-7c76c1f850f8af6a"></a>
### web

```java
@NestedConfigurationProperty
private WebProperties web
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/properties/FairycharBagProperties.java:23`; evidence: `declaration-7c76c1f850f8af6a244fc5f9cf79ac830eecc5e448fe16d908b836f03936709c`.
Visibility: `private` (explicit).
Type: `WebProperties`.
No initializer recorded.
