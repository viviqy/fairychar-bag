# com.fairychar.security.core.rbac.pojo.query.SystemRoleQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemRoleQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-fd2ddd079e49dc86"></a>
## com.fairychar.security.core.rbac.pojo.query.SystemRoleQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "SystemRoleQuery")
public class SystemRoleQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:20`; evidence: `declaration-fd2ddd079e49dc86fcf3786f8b1bfe5303832172bbd2f1dda08cc33fb317f58b`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
角色表(SystemRole)表实体类

 @author chiyo
```


## Fields

<a id="symbol-d5e2d814c3c5b376"></a>
### id

```java
@Schema(description = "ID")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:31`; evidence: `declaration-d5e2d814c3c5b376fb25f4cad9f7d091ad31158772a9ccc0aa39d49a3760db34`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-dc987575397f16f5"></a>
### roleCode

```java
@Schema(description = "\u89d2\u8272\u6807\u8bc6\u552f\u4e00code\u6807\u8bc6")
private String roleCode
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:36`; evidence: `declaration-dc987575397f16f57d2b44b471640ebdb000f0e2d3f6d759e9386f71df70b02f`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色标识唯一code标识
```


<a id="symbol-e85c9857b8000a6f"></a>
### name

```java
@Schema(description = "\u540d\u79f0")
private String name
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:41`; evidence: `declaration-e85c9857b8000a6f9ddeb158d0e6f40cb5dacba1048af90e0990bc14d354c021`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
名称
```


<a id="symbol-e76a632601b5a845"></a>
### level

```java
@Schema(description = "\u89d2\u8272\u7ea7\u522b(0\u4ee3\u8868root)")
private Integer level
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:46`; evidence: `declaration-e76a632601b5a845acc3a444335fd397b4d95514f566da9bf8fac0230c59a06d`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色级别(0代表root)
```


<a id="symbol-b4b2e46c1afd1cdd"></a>
### enable

```java
@Schema(description = "\u662f\u5426\u542f\u7528")
private Boolean enable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:51`; evidence: `declaration-b4b2e46c1afd1cddc44dbb22d5124cecacf096061685593f44056bf147bbdbad`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否启用
```


<a id="symbol-7d5f25e7daca1d20"></a>
### description

```java
@Schema(description = "\u63cf\u8ff0")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:56`; evidence: `declaration-7d5f25e7daca1d20cf2271cb5a234e8fb1086d71c7d54837ac19fbce069982ff`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
描述
```


<a id="symbol-81c08337105a18eb"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u8005")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:61`; evidence: `declaration-81c08337105a18eb70b623c2f222fa46a8aeec0bd1e5b92856c76998f505482e`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建者
```


<a id="symbol-97da9f56af7b45cd"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:66`; evidence: `declaration-97da9f56af7b45cd2eac1d33f216a34a69e7bc4a862a6823d6c4fe43fa1bf3a8`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-bc863c182814e149"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u8005")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:71`; evidence: `declaration-bc863c182814e1498b48a20190bdf6db725e056c25e606f25027a84f29ddac36`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新者
```


<a id="symbol-6a68a364d11c4d31"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:76`; evidence: `declaration-6a68a364d11c4d317b3bcc305fade7950d2dad5e399974912b25144d1095ac24`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-ea70d84cec66a836"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65e5\u671f")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:81`; evidence: `declaration-ea70d84cec66a836ba4037402492d8f6f32f75d1863985e416bd6ca206ef2614`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建日期
```


<a id="symbol-bfd4122d6ec5a107"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:87`; evidence: `declaration-bfd4122d6ec5a107c8282f770febd591836022d3765fe9d4ca0fb1244217a922`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```


<a id="symbol-b0d6951e508f23e6"></a>
### pageQuery

```java
@Schema(description = "\u5206\u9875\u53c2\u6570")
private Page pageQuery = new Page()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SystemRoleQuery.java:91`; evidence: `declaration-b0d6951e508f23e6ac5e4bdfd63d4aad8be01148eb911ef4cb77ccebae083569`.
Visibility: `private` (explicit).
Type: `Page`.
