# com.fairychar.security.core.rbac.entity.SysMenu fields

Snapshot: `snapshot-20261113T014229Z-bb422342`

[Owner / index](../SysMenu.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-ba2f0619f62acda1"></a>
### id

```java
@Schema(description = "ID")
@TableId(type = IdType.AUTO, value = "id")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:32`; evidence: `declaration-ba2f0619f62acda1264f467161bbd97a311df7b0a53f32994b7b292163c45ef1`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-8d5245716a6db063"></a>
### pid

```java
@Schema(description = "\u4e0a\u7ea7\u83dc\u5355ID(0\u4ee3\u8868root)")
@TableField(value = "`pid`")
private Integer pid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:38`; evidence: `declaration-8d5245716a6db063208a88320fecc65d1e05ce104b743224ab7bfe06ac64d346`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
上级菜单ID(0代表root)
```


<a id="symbol-c3dca689020db5c0"></a>
### code

```java
@Schema(description = "\u83dc\u5355\u6807\u8bc6code(\u552f\u4e00)")
@TableField(value = "`code`")
private String code
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:44`; evidence: `declaration-c3dca689020db5c0944e0aae766fd94305659cd553345fa35106a9428ed15a4b`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单标识code(唯一)
```


<a id="symbol-a51d1c68385708f9"></a>
### title

```java
@Schema(description = "\u83dc\u5355\u6807\u9898")
@TableField(value = "`title`")
private String title
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:50`; evidence: `declaration-a51d1c68385708f9720f21a79bdc89ce036299d576f908609b7530a3530d9197`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单标题
```


<a id="symbol-5de734a0dce71dd6"></a>
### componentName

```java
@Schema(description = "\u7ec4\u4ef6\u540d\u79f0")
@TableField(value = "`component_name`")
private String componentName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:56`; evidence: `declaration-5de734a0dce71dd61f694f6e1af606b642ce64149f66275cf5ec3b823d932f6f`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
组件名称
```


<a id="symbol-1d0f3712db11cd29"></a>
### componentData

```java
@Schema(description = "\u7ec4\u4ef6\u5185\u5bb9")
@TableField(value = "`component_data`")
private String componentData
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:62`; evidence: `declaration-1d0f3712db11cd297a56023026077f69f2cc257bb653091f85fddf5363a8f621`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
组件内容
```


<a id="symbol-31ab2a15fa68f23c"></a>
### sort

```java
@Schema(description = "\u6392\u5e8f")
@TableField(value = "`sort`")
private Integer sort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:68`; evidence: `declaration-31ab2a15fa68f23c1ce6c6088096082de45114d3b50e5f2d18511997d85cedb4`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-c41ade34012408ea"></a>
### icon

```java
@Schema(description = "\u56fe\u6807")
@TableField(value = "`icon`")
private String icon
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:74`; evidence: `declaration-c41ade34012408ea456d35b7a004e8599391ffd508e8a2c17fb668056f5232ac`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
图标
```


<a id="symbol-9fcdd5ae4eaad809"></a>
### path

```java
@Schema(description = "\u94fe\u63a5\u5730\u5740")
@TableField(value = "`path`")
private String path
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:80`; evidence: `declaration-9fcdd5ae4eaad8093c3315b4f72216a6ce6b43e7223cf202de625be8f5f3ec86`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
链接地址
```


<a id="symbol-3f752f213209a3fe"></a>
### iFrame

```java
@Schema(description = "\u662f\u5426\u5916\u94fe")
@TableField(value = "`i_frame`")
private Boolean iFrame
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:86`; evidence: `declaration-3f752f213209a3fe918e9e3826f96c89aac19e10de4d7396a0d90d70eae476ed`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否外链
```


<a id="symbol-52e73d2c9167424c"></a>
### cache

```java
@Schema(description = "\u7f13\u5b58")
@TableField(value = "`cache`")
private Boolean cache
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:92`; evidence: `declaration-52e73d2c9167424cd506690129dc7075c103afd5bf61b3c2879f5c5160b33ff8`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
缓存
```


<a id="symbol-036b561834097b35"></a>
### hidden

```java
@Schema(description = "\u9690\u85cf")
@TableField(value = "`hidden`")
private Boolean hidden
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:98`; evidence: `declaration-036b561834097b3581d6ada0d528990b3871b42ab3d0114e0390b8825c413b59`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
隐藏
```


<a id="symbol-7cb4e1eae78b5edf"></a>
### enable

```java
@Schema(description = "\u662f\u5426\u542f\u7528")
@TableField(value = "`enable`")
private Boolean enable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:104`; evidence: `declaration-7cb4e1eae78b5edf9655aad04f70fb7a7346c03d4d1ffef921e0f0a4ce2b3219`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否启用
```


<a id="symbol-28c027971bfed0b1"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u8005")
@TableField(value = "`create_by`", fill = FieldFill.INSERT)
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:110`; evidence: `declaration-28c027971bfed0b1afc7c1714bff58230920e1b2fd355fd6928d6ce343e7a4a7`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建者
```


<a id="symbol-efbcc6184532f806"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
@TableField(value = "`create_name`", fill = FieldFill.INSERT)
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:116`; evidence: `declaration-efbcc6184532f806bbbf729159edfe4dbaff2996133e6a4698f2cae8dacf62e5`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-8a1fb36d23e56526"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u8005")
@TableField(value = "`update_by`", fill = FieldFill.UPDATE)
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:122`; evidence: `declaration-8a1fb36d23e565261b278a5a4d082d6526e966df9c2ecdedd7667ffc058a607c`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新者
```


<a id="symbol-0d6a94a388d4a750"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
@TableField(value = "`update_name`", fill = FieldFill.UPDATE)
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:128`; evidence: `declaration-0d6a94a388d4a750cf976605632ffb079503702b63bc5b960cb1bf0368ab14f2`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-51be25da914eaafb"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65e5\u671f")
@TableField(value = "`create_time`")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:134`; evidence: `declaration-51be25da914eaafbb201217525187cb3ac6a3c38eae15800daf88ca9b1775ab4`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建日期
```


<a id="symbol-2007501381b3c459"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@TableField(value = "`update_time`")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:140`; evidence: `declaration-2007501381b3c45998e2e573c63b3ba21a27deca13d9ac5821825092f1560055`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```


<a id="symbol-fd974933a14c5e33"></a>
### groupByCount

```java
@TableField(exist = false)
@Schema(description = "\u5206\u7ec4\u6570\u91cf\u5339\u914d\u5b57\u6bb5,\u548c\u539f\u8868\u65e0\u5173")
private Integer groupByCount
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:146`; evidence: `declaration-fd974933a14c5e33756f179029043b6acdc86a55d86c19aa1cd51d1568fe3ba8`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
分组匹配字符
```


<a id="symbol-292583db664c4362"></a>
### ID

```java
public static final String ID = "id"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:164`; evidence: `declaration-292583db664c4362d472b8446062a7c9b1540ee5d725966161a9a770554efd7c`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
id - ID
```


<a id="symbol-047b7f530d3b0f1a"></a>
### PID

```java
public static final String PID = "pid"
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/entity/SysMenu.java:169`; evidence: `declaration-047b7f530d3b0f1a11b50ab1e99ebb0f61f9f5167f1d2b9f7da6f1a9cde81186`.
Visibility: `public` (explicit).
Type: `String`.

Source docstring (unreviewed):
```text
pid - 上级菜单ID(0代表root)
```
