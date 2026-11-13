# com.fairychar.security.core.rbac.pojo.dto.SysApiDTO

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysApiDTO.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-6ec6caae123722c1"></a>
## com.fairychar.security.core.rbac.pojo.dto.SysApiDTO

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "SysApiDTO")
public class SysApiDTO implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysApiDTO.java:18`; evidence: `declaration-6ec6caae123722c122cad939852ab08a1d7dbe7daea73561e9ab2604aff16d24`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
(SysApi)表实体类

 @author chiyo
```


## Fields

<a id="symbol-2e268070e031b5cf"></a>
### id

```java
@Schema(description = "")
@JsonFormat(shape = JsonFormat.Shape.STRING)
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysApiDTO.java:27`; evidence: `declaration-2e268070e031b5cf71eb675694cb8cf103b05fc492a0f71ed9887adaf5201d45`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

<a id="symbol-0668f33e061c913e"></a>
### httpMethod

```java
@Schema(description = "http\u8bf7\u6c42\u65b9\u6cd5")
private String httpMethod
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysApiDTO.java:33`; evidence: `declaration-0668f33e061c913ecd845c9539eaa8944a3ae769c407f7f3415ca18f81fb4bf8`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
http请求方法
```


<a id="symbol-fd4454390cd6a3d1"></a>
### uri

```java
@Schema(description = "\u8bf7\u6c42\u63a5\u53e3\u8def\u5f84,\u4f7f\u7528antMatch\u65b9\u5f0f")
private String uri
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysApiDTO.java:38`; evidence: `declaration-fd4454390cd6a3d1e814fe83a182b81948f0171fe1c52e402bb4dfc18adccee4`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
请求接口路径,使用antMatch方式
```


<a id="symbol-4fdae972d6aacce3"></a>
### description

```java
@Schema(description = "\u63a5\u53e3\u63cf\u8ff0")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysApiDTO.java:43`; evidence: `declaration-4fdae972d6aacce3003d1d1b1d13898c8a1ffbfae27973183322e29f944ad66d`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
接口描述
```


<a id="symbol-a2fe234d1fc4d49a"></a>
### sort

```java
@Schema(description = "\u6392\u5e8f")
private Integer sort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysApiDTO.java:48`; evidence: `declaration-a2fe234d1fc4d49adcc4bd35c7edbf0b38198eeba9d1a647bb85fe9bab80317a`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-59de123f94aa91f4"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u4eba")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysApiDTO.java:53`; evidence: `declaration-59de123f94aa91f453d43303de91e292a54ea38f600aa5710bf899358f726708`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人
```


<a id="symbol-f6a3bf8a5ad0f8e0"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysApiDTO.java:58`; evidence: `declaration-f6a3bf8a5ad0f8e094a3bef4580e685da689962b57c92c57f88d1e82de5d96a9`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-871bf7720822caf5"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u4eba")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysApiDTO.java:63`; evidence: `declaration-871bf7720822caf5abed297732c4ddf152c393acf3c631a0c33647ef1ed2260d`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人
```


<a id="symbol-e93bc52d07d90748"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysApiDTO.java:68`; evidence: `declaration-e93bc52d07d90748d3e828e69c78bfcd15c13ad10ceb23d4f02c546de7468c27`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-8f1457179f830f0f"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysApiDTO.java:73`; evidence: `declaration-8f1457179f830f0ff79ab657cfa20ea9a0afdf6b446b362ecb1727ae659f6a3b`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建时间
```


<a id="symbol-ace83dfa5c684832"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysApiDTO.java:79`; evidence: `declaration-ace83dfa5c684832956988142cf36827b5f6a4441c74291d68623a0e0e60c860`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```
