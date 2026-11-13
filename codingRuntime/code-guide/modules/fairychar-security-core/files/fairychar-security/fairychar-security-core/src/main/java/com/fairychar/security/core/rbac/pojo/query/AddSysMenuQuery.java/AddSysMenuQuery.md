# com.fairychar.security.core.rbac.pojo.query.AddSysMenuQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AddSysMenuQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-f4684ae16cc5c8ce"></a>
## com.fairychar.security.core.rbac.pojo.query.AddSysMenuQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "AddSysMenuQuery")
public class AddSysMenuQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysMenuQuery.java:19`; evidence: `declaration-f4684ae16cc5c8ce472448578c2acac26ed932cf4242f5153c6a44378fc75975`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
系统菜单(SysMenu)表实体类

 @author chiyo
```


## Fields

<a id="symbol-4a6c2f3ea49aed47"></a>
### pid

```java
@Schema(description = "\u4e0a\u7ea7\u83dc\u5355ID(0\u4ee3\u8868root)")
@NotNull
private Integer pid = 0
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysMenuQuery.java:30`; evidence: `declaration-4a6c2f3ea49aed47e04f2a5101a4a5cef814734333d36c8d9f25724f5b517fd4`.
Visibility: `private` (explicit).
Type: `Integer`.

Source docstring (unreviewed):
```text
上级菜单ID(0代表root)
```


<a id="symbol-7a4b59424eeba736"></a>
### code

```java
@Schema(description = "\u83dc\u5355\u6807\u8bc6code(\u552f\u4e00)")
@NotNull
private String code
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysMenuQuery.java:36`; evidence: `declaration-7a4b59424eeba7360f786616ef9a43727666188b6d3c1d6f2de4bca23df7e347`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单类型(预留字段)
```


<a id="symbol-042c0913eaa55c95"></a>
### title

```java
@Schema(description = "\u83dc\u5355\u6807\u9898")
@NotEmpty
private String title
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysMenuQuery.java:42`; evidence: `declaration-042c0913eaa55c95fa3e3aad9a5171bd385aaed2f18bb8eb6203931393012d41`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单标题
```


<a id="symbol-9eebebeaf5d9f879"></a>
### enable

```java
@Schema(description = "\u662f\u5426\u542f\u7528")
private Boolean enable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysMenuQuery.java:48`; evidence: `declaration-9eebebeaf5d9f879992944d6703605f820198718bc8f7f74b87e07a4afd5893e`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否启用
```


<a id="symbol-583b91b63bffe69b"></a>
### componentName

```java
@Schema(description = "\u7ec4\u4ef6\u540d\u79f0")
private String componentName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysMenuQuery.java:53`; evidence: `declaration-583b91b63bffe69b19b4fda7efe96eee3087fd02444edd04ca7aff53c69f2cb4`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
组件名称
```


<a id="symbol-c066f2bc130bb646"></a>
### componentData

```java
@Schema(description = "\u7ec4\u4ef6\u5185\u5bb9")
private String componentData
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysMenuQuery.java:58`; evidence: `declaration-c066f2bc130bb6467bb8d0385b08a8baf0ee19e884d4a58671275893d69da7fd`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
组件内容
```


<a id="symbol-f4843a5d4ef45b5b"></a>
### sort

```java
@Schema(description = "\u6392\u5e8f")
private Integer sort = 0
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysMenuQuery.java:63`; evidence: `declaration-f4843a5d4ef45b5bb6bc4c9b37b8e4ef3238afa6ed158929d5c4124b37da231b`.
Visibility: `private` (explicit).
Type: `Integer`.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-c9b03b4f59b954e9"></a>
### icon

```java
@Schema(description = "\u56fe\u6807")
private String icon
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysMenuQuery.java:68`; evidence: `declaration-c9b03b4f59b954e983726057a75a2bc23570ceb5cfe1eca9882d6520f3ab5761`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
图标
```


<a id="symbol-e2aa2174897ff488"></a>
### path

```java
@Schema(description = "\u94fe\u63a5\u5730\u5740")
private String path
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysMenuQuery.java:73`; evidence: `declaration-e2aa2174897ff4889597c883822e62f5f2136a966fa838e3c162d46a38a909bd`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
链接地址
```


<a id="symbol-bdbb99bd592a1bf9"></a>
### iFrame

```java
@Schema(description = "\u662f\u5426\u5916\u94fe")
private Boolean iFrame
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysMenuQuery.java:78`; evidence: `declaration-bdbb99bd592a1bf9f3900c3fcc0b1b886629016f158981e9b05bd5a52b652f8f`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否外链
```


<a id="symbol-4d50cc63249fb693"></a>
### cache

```java
@Schema(description = "\u7f13\u5b58")
private Boolean cache
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysMenuQuery.java:83`; evidence: `declaration-4d50cc63249fb6932affd11619e6cda770e71cbd0016b96b72dae16b170d07cd`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
缓存
```


<a id="symbol-bb8f41facb9fed6a"></a>
### hidden

```java
@Schema(description = "\u9690\u85cf")
private Boolean hidden
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysMenuQuery.java:88`; evidence: `declaration-bb8f41facb9fed6abb98a803b17eff17a4f2907a96b5e998747b7689918cbbcb`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
隐藏
```
