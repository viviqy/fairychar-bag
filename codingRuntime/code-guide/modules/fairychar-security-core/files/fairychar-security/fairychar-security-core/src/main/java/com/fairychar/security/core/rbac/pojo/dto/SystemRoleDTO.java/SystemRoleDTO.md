# com.fairychar.security.core.rbac.pojo.dto.SystemRoleDTO

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SystemRoleDTO.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-6f11bb0b95b8f208"></a>
## com.fairychar.security.core.rbac.pojo.dto.SystemRoleDTO

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "SystemRoleDTO")
public class SystemRoleDTO implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemRoleDTO.java:18`; evidence: `declaration-6f11bb0b95b8f2084ae40abbc078fa01e5627e8359d7665d5869d2ac83502378`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
角色表(SystemRole)表实体类

 @author chiyo
```


## Fields

<a id="symbol-8de1b3a0575fd63e"></a>
### id

```java
@Schema(description = "ID")
@JsonFormat(shape = JsonFormat.Shape.STRING)
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemRoleDTO.java:29`; evidence: `declaration-8de1b3a0575fd63ecd77d2e91103604ef16127f37eaa9dea01a50ebe0746d4d0`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-e7d693dc989b78fb"></a>
### roleCode

```java
@Schema(description = "\u89d2\u8272\u6807\u8bc6\u552f\u4e00code\u6807\u8bc6")
private String roleCode
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemRoleDTO.java:35`; evidence: `declaration-e7d693dc989b78fb6324b41bb67ac33f750402717edbae36556c6d18c2d9f6ba`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色标识唯一code标识
```


<a id="symbol-369587ddc92c409f"></a>
### name

```java
@Schema(description = "\u540d\u79f0")
private String name
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemRoleDTO.java:40`; evidence: `declaration-369587ddc92c409f3a1cbb2fda6d278b635aa1762da380630be95060dd62d2d5`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
名称
```


<a id="symbol-a50fc94d6f7ae4ab"></a>
### level

```java
@Schema(description = "\u89d2\u8272\u7ea7\u522b(0\u4ee3\u8868root)")
private Integer level
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemRoleDTO.java:45`; evidence: `declaration-a50fc94d6f7ae4ab2258ed2e50d9e365672d061431d6bb492b17adcad4f1e377`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
角色级别(0代表root)
```


<a id="symbol-c5391375a130ad45"></a>
### enable

```java
@Schema(description = "\u662f\u5426\u542f\u7528")
private Boolean enable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemRoleDTO.java:50`; evidence: `declaration-c5391375a130ad4582f5162c3b307d2b6429a9ead880ed4dbde7646f18c441b5`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否启用
```


<a id="symbol-fa05c853f0aefa37"></a>
### description

```java
@Schema(description = "\u63cf\u8ff0")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemRoleDTO.java:55`; evidence: `declaration-fa05c853f0aefa3791f8a647e96ec00b9bc4e35301cd05968f39491e922c3b56`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
描述
```


<a id="symbol-5801488a309cb873"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u8005")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemRoleDTO.java:60`; evidence: `declaration-5801488a309cb87336662e9d7b81a8b136ceaa1945429a7630733b049345de14`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建者
```


<a id="symbol-b9046370d23486ee"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemRoleDTO.java:65`; evidence: `declaration-b9046370d23486ee7b6b65c1bfb05868cc9bfc04dc61756443c008f3f8035dac`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-b19cf50734fdc069"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u8005")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemRoleDTO.java:70`; evidence: `declaration-b19cf50734fdc06905d023c548f6ab2aa7df07b2c3ff9604383d091457e59087`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新者
```


<a id="symbol-67ec1109044576b6"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemRoleDTO.java:75`; evidence: `declaration-67ec1109044576b6ee6f667355e8c51cc2259c291edb97a520f272693df2f981`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-6037e4809c6ecdb7"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65e5\u671f")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemRoleDTO.java:80`; evidence: `declaration-6037e4809c6ecdb7c4be0a212bbdd4cb7d32bfe48becc4d956f0f7e9f715c8ed`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建日期
```


<a id="symbol-6d3b5aed6bd786c8"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SystemRoleDTO.java:86`; evidence: `declaration-6d3b5aed6bd786c855c8576a572e86261436786cfabbee8d415e55e7d1616a3e`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```
