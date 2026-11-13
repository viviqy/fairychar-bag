# com.fairychar.security.core.rbac.pojo.dto.SysMenuDTO

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysMenuDTO.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-572f441f3ea08db9"></a>
## com.fairychar.security.core.rbac.pojo.dto.SysMenuDTO

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "SysMenuDTO")
public class SysMenuDTO implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:20`; evidence: `declaration-572f441f3ea08db976ba7609af742bc554abf3b55fa74dc75c41c713242243ed`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
系统菜单(SysMenu)表实体类

 @author chiyo
```


## Fields

<a id="symbol-13c457356ed73436"></a>
### id

```java
@Schema(description = "ID")
@JsonFormat(shape = JsonFormat.Shape.STRING)
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:31`; evidence: `declaration-13c457356ed73436591b9ae39b17ad74d976394473d7046573318749868b10c3`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-cdd71d514f83c066"></a>
### pid

```java
@Schema(description = "\u4e0a\u7ea7\u83dc\u5355ID(0\u4ee3\u8868root)")
private Integer pid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:37`; evidence: `declaration-cdd71d514f83c0662fb88ccad6e281aea1de716122d002ad88206a0aa5b0f1fd`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
上级菜单ID(0代表root)
```


<a id="symbol-065ca28848c34796"></a>
### code

```java
@Schema(description = "\u83dc\u5355\u6807\u8bc6code(\u552f\u4e00)")
private String code
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:42`; evidence: `declaration-065ca28848c34796eafd58af2a996183929a72060fb849390da8b714efac0556`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单标识code(唯一)
```


<a id="symbol-6969b00364e561f1"></a>
### title

```java
@Schema(description = "\u83dc\u5355\u6807\u9898")
private String title
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:47`; evidence: `declaration-6969b00364e561f13222c17771333147927f91c1a2cd9aa0cd0ced8940113797`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单标题
```


<a id="symbol-d3aa4c2d79ae149c"></a>
### componentName

```java
@Schema(description = "\u7ec4\u4ef6\u540d\u79f0")
private String componentName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:52`; evidence: `declaration-d3aa4c2d79ae149caed3a21954cea9108267b106c8555c0278cf2041b69a5a60`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
组件名称
```


<a id="symbol-0d34edfcad66580d"></a>
### componentData

```java
@Schema(description = "\u7ec4\u4ef6\u5185\u5bb9")
private String componentData
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:57`; evidence: `declaration-0d34edfcad66580df904c1702e7daa4bbe215bad95a624604718dd7c8c4e1698`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
组件内容
```


<a id="symbol-83b3a34828bc8f06"></a>
### sort

```java
@Schema(description = "\u6392\u5e8f")
private Integer sort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:62`; evidence: `declaration-83b3a34828bc8f067693fb3366c77ae1d2b0c19743733d86c48a56f2fa7f8865`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-6efe74b3cca7dd4d"></a>
### icon

```java
@Schema(description = "\u56fe\u6807")
private String icon
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:67`; evidence: `declaration-6efe74b3cca7dd4d1c989168c8e43f8dd326653b1d9b783f4960194ba1215961`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
图标
```


<a id="symbol-6fdb654f0ba21cd1"></a>
### path

```java
@Schema(description = "\u94fe\u63a5\u5730\u5740")
private String path
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:72`; evidence: `declaration-6fdb654f0ba21cd1bdb0b2183f91596308376e5dc012d8a1080ddfc906049ad0`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
链接地址
```


<a id="symbol-3b0acbb32f809f41"></a>
### iFrame

```java
@Schema(description = "\u662f\u5426\u5916\u94fe")
private Boolean iFrame
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:77`; evidence: `declaration-3b0acbb32f809f411b57dc674307904fe4c6d742a82fc96e588916213fc671aa`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否外链
```


<a id="symbol-315e96c3622f0c90"></a>
### cache

```java
@Schema(description = "\u7f13\u5b58")
private Boolean cache
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:82`; evidence: `declaration-315e96c3622f0c90396824ec9e13ade1646c6e5a2d2e1980ac41b33590171e96`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
缓存
```


<a id="symbol-666fe4c9076f183f"></a>
### hidden

```java
@Schema(description = "\u9690\u85cf")
private Boolean hidden
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:87`; evidence: `declaration-666fe4c9076f183f1fcd842bfdcbffbb1f2f25b76c78534ebdc00064aee6351a`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
隐藏
```


<a id="symbol-f39b518a7ed723d7"></a>
### enable

```java
@Schema(description = "\u662f\u5426\u542f\u7528")
private Boolean enable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:92`; evidence: `declaration-f39b518a7ed723d7a7f61f1977beeec242aee773b38667a6cde3bdda5ac8e4ae`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否启用
```


<a id="symbol-1713faf025a044dc"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u8005")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:97`; evidence: `declaration-1713faf025a044dc077426595ece74f7e0db1fa522ede878326edcdf1a610496`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建者
```


<a id="symbol-cf382c550420c727"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:102`; evidence: `declaration-cf382c550420c727012e4cf87b62dd67067d97f3682b7f5e17e4db561e1a363a`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-ac568098d3366d8f"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u8005")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:107`; evidence: `declaration-ac568098d3366d8f8e54b471773617b4ab52d6ccaf2fc43fe3e81a8dc9f5b14b`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新者
```


<a id="symbol-eea380d825f05a4d"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:112`; evidence: `declaration-eea380d825f05a4dcb68d3e79abbf0bc070957a5c2ca7cd78b0811dd548fa1c0`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-3cb2d8d58a248806"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65e5\u671f")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:117`; evidence: `declaration-3cb2d8d58a2488069283d26cba5e86204a4806477147615b894dc7f9cb589306`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建日期
```


<a id="symbol-5518ada03427e77e"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:123`; evidence: `declaration-5518ada03427e77ea43752f3e827abe81626d3f63904c858a95a53cd05b02c16`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```


<a id="symbol-9ddf124b4abeb89d"></a>
### child

```java
@Schema(description = "\u5b50\u9879")
private List<SysMenuDTO> child
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysMenuDTO.java:127`; evidence: `declaration-9ddf124b4abeb89d51239d35d47bbd17250f3850dac72b7ec8a33e592d6a3047`.
Visibility: `private` (explicit).
Type: `List<SysMenuDTO>`.
No initializer recorded.
