# com.fairychar.security.core.rbac.pojo.query.MenuHasApiQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MenuHasApiQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-ca0dedb69cd82b19"></a>
## com.fairychar.security.core.rbac.pojo.query.MenuHasApiQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "MenuHasApiQuery")
public class MenuHasApiQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/MenuHasApiQuery.java:20`; evidence: `declaration-ca0dedb69cd82b190a221b0df652bb80787730dd85d38d0cf46c191dd3f0813e`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
(MenuHasApi)表实体类

 @author chiyo
```


## Fields

<a id="symbol-0043dc00daad1cf8"></a>
### id

```java
@Schema(description = "\u4e3b\u952e")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/MenuHasApiQuery.java:31`; evidence: `declaration-0043dc00daad1cf8ae0ad0aed30d3bf06dd621e9853777a717b81d14b17e168b`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
主键
```


<a id="symbol-2962e09d3368aa9f"></a>
### menuId

```java
@Schema(description = "\u5173\u8054\u83dc\u5355id")
private Integer menuId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/MenuHasApiQuery.java:36`; evidence: `declaration-2962e09d3368aa9fad3201fd553db734bff706a03d1c3d8e630e3172da71980b`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
关联菜单id
```


<a id="symbol-7afd530ed8474848"></a>
### apiId

```java
@Schema(description = "\u5173\u8054\u63a5\u53e3id")
private Integer apiId
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/MenuHasApiQuery.java:41`; evidence: `declaration-7afd530ed8474848209671e2b0c29d4b2e409d340fe9078b6c1c0643ceb00630`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
关联接口id
```


<a id="symbol-e40d02cddf8c6f56"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u4eba")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/MenuHasApiQuery.java:46`; evidence: `declaration-e40d02cddf8c6f568050e7f435aa9392b0e805149dd9e42393ec66741ae7f16e`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人
```


<a id="symbol-62f82662daf552c9"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/MenuHasApiQuery.java:51`; evidence: `declaration-62f82662daf552c99067b2a39a418233abf8794fb9bd4ce53694d507aaaea66a`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-7672c23f4c6a4b33"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u4eba")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/MenuHasApiQuery.java:56`; evidence: `declaration-7672c23f4c6a4b333bb78d81421d3d137dc5755918104aab156930675f1d4191`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人
```


<a id="symbol-5e4e009fc4d06799"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/MenuHasApiQuery.java:61`; evidence: `declaration-5e4e009fc4d06799cef22e16c15e718717a0624ba12b8e78ee6384928c65e384`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-5cda4db6bc6a82b6"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/MenuHasApiQuery.java:66`; evidence: `declaration-5cda4db6bc6a82b68d5e4a63f0357cd104ce1a0e09eff2b31f2f6a91362f3a0a`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建时间
```


<a id="symbol-ec2783b8c1069255"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/MenuHasApiQuery.java:72`; evidence: `declaration-ec2783b8c1069255bd9e44f39e69f5e56fd786af0031bdfa35af2a959e65bb4b`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```


<a id="symbol-a60fb6bcf62b2092"></a>
### pageQuery

```java
@Schema(description = "\u5206\u9875\u53c2\u6570")
private Page pageQuery = new Page()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/MenuHasApiQuery.java:78`; evidence: `declaration-a60fb6bcf62b20921bca93f98e3d4dfc5b7e1c64f48a46fdd5dbcbace9af361c`.
Visibility: `private` (explicit).
Type: `Page`.

Source docstring (unreviewed):
```text
分页请求参数
```
