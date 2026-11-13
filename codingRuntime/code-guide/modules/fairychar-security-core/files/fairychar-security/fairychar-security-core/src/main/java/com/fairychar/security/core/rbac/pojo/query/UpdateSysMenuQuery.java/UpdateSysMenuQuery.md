# com.fairychar.security.core.rbac.pojo.query.UpdateSysMenuQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../UpdateSysMenuQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-71dbf96e50813371"></a>
## com.fairychar.security.core.rbac.pojo.query.UpdateSysMenuQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "UpdateSysMenuQuery")
public class UpdateSysMenuQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:19`; evidence: `declaration-71dbf96e50813371da88738186d2e1e5981108004bbfdd5d0fe797d93e191c7f`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
系统菜单(SysMenu)表实体类

 @author chiyo
```


## Fields

<a id="symbol-1700ec58ce8a46d1"></a>
### id

```java
@Schema(description = "id")
@NotNull(message = "id\u4e0d\u80fd\u4e3anull")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:26`; evidence: `declaration-1700ec58ce8a46d14ce232b337e783c66446a04037c98bf9077441548fc465ab`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

<a id="symbol-a23a8b57cc192353"></a>
### pid

```java
@Schema(description = "\u4e0a\u7ea7\u83dc\u5355ID(0\u4ee3\u8868root)")
@NotNull
private Integer pid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:32`; evidence: `declaration-a23a8b57cc19235362f9872d99c5d36e76191bb8d03667e203a2203052fa1f1a`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
上级菜单ID(0代表root)
```


<a id="symbol-410a0e504eac91f6"></a>
### code

```java
@Schema(description = "\u83dc\u5355\u6807\u8bc6code(\u552f\u4e00)")
@NotNull
private String code
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:38`; evidence: `declaration-410a0e504eac91f65b843ab56d01ca776a0a3b758a47aa4b6eb7e99c2d0f98da`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单类型(预留字段)
```


<a id="symbol-cad55a21b3f9e049"></a>
### enable

```java
@Schema(description = "\u662f\u5426\u542f\u7528")
private Boolean enable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:44`; evidence: `declaration-cad55a21b3f9e04903e6f42645764e52acb1ed8cc65e6590e48c55c57ec0680c`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否启用
```


<a id="symbol-56410688bf9fbfb8"></a>
### title

```java
@Schema(description = "\u83dc\u5355\u6807\u9898")
@NotEmpty
private String title
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:49`; evidence: `declaration-56410688bf9fbfb885ebffe20fe3717d8899e051bd4323cc456876320c143b0c`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单标题
```


<a id="symbol-eb8273a1ebe2414c"></a>
### componentName

```java
@Schema(description = "\u7ec4\u4ef6\u540d\u79f0")
private String componentName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:55`; evidence: `declaration-eb8273a1ebe2414c1c76f9ac177e1e934e75a7d7362e25b586776076e51ca39b`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
组件名称
```


<a id="symbol-780e0b9a2b342349"></a>
### componentData

```java
@Schema(description = "\u7ec4\u4ef6\u5185\u5bb9")
private String componentData
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:60`; evidence: `declaration-780e0b9a2b3423490b87006b05f7e97b87dbfe052b193f8b9f633a2c895c573a`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
组件内容
```


<a id="symbol-e83ab2178f3edd46"></a>
### sort

```java
@Schema(description = "\u6392\u5e8f")
private Integer sort = 0
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:65`; evidence: `declaration-e83ab2178f3edd463fcdc644432a08248661b091246a5e69972829e43b1ed995`.
Visibility: `private` (explicit).
Type: `Integer`.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-5da3115b1a74d847"></a>
### icon

```java
@Schema(description = "\u56fe\u6807")
private String icon
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:70`; evidence: `declaration-5da3115b1a74d84789a207b48ebe70a4e730517545a27adbfd2bde31e9fd62d2`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
图标
```


<a id="symbol-ae41e45af923ce37"></a>
### path

```java
@Schema(description = "\u94fe\u63a5\u5730\u5740")
private String path
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:75`; evidence: `declaration-ae41e45af923ce371873c7be0ac15fe3bf838ba13339b143c615782ea4439292`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
链接地址
```


<a id="symbol-f36a3a8b0442057a"></a>
### iFrame

```java
@Schema(description = "\u662f\u5426\u5916\u94fe")
private Boolean iFrame
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:80`; evidence: `declaration-f36a3a8b0442057a985102808f76a66422637bfcadc5d6b195b012cf31ea6268`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否外链
```


<a id="symbol-98df294d87ac16f9"></a>
### cache

```java
@Schema(description = "\u7f13\u5b58")
private Boolean cache
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:85`; evidence: `declaration-98df294d87ac16f97f96b28ce224dfb2c69467a442de09ba8969c490d7a5b1ac`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
缓存
```


<a id="symbol-62c334025063e459"></a>
### hidden

```java
@Schema(description = "\u9690\u85cf")
private Boolean hidden
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysMenuQuery.java:90`; evidence: `declaration-62c334025063e45915f9dca0541b8baf865f1a392537feaf3e69ca14c18ae8de`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
隐藏
```
