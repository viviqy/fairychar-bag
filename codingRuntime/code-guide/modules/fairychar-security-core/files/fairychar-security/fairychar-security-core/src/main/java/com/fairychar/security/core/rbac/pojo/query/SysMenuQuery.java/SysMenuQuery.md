# com.fairychar.security.core.rbac.pojo.query.SysMenuQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysMenuQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-60c3d0d9c1b473a7"></a>
## com.fairychar.security.core.rbac.pojo.query.SysMenuQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "SysMenuQuery")
public class SysMenuQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:20`; evidence: `declaration-60c3d0d9c1b473a75674bafbf4bc29dd1cc7610bacfe9b9cca6e51d7a716db60`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
系统菜单(SysMenu)表实体类

 @author chiyo
```


## Fields

<a id="symbol-564299e432abb616"></a>
### id

```java
@Schema(description = "ID")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:31`; evidence: `declaration-564299e432abb6160088800aa4f1c32e6316c188085063d16314b82837f554eb`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-eb0f415c9162c882"></a>
### pid

```java
@Schema(description = "\u4e0a\u7ea7\u83dc\u5355ID(0\u4ee3\u8868root)")
private Integer pid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:36`; evidence: `declaration-eb0f415c9162c88234ffaaad72ac2d7f4b64b31dca5808033fa63b4d9866a5d1`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
上级菜单ID(0代表root)
```


<a id="symbol-88851ab8f1f32b90"></a>
### code

```java
@Schema(description = "\u83dc\u5355\u6807\u8bc6code(\u552f\u4e00)")
private String code
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:41`; evidence: `declaration-88851ab8f1f32b90d42efa66702a9dcac1d68e1d7d9eb942ed737efaa4ad9cb3`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单标识code(唯一)
```


<a id="symbol-774e14641ff88e22"></a>
### title

```java
@Schema(description = "\u83dc\u5355\u6807\u9898")
private String title
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:46`; evidence: `declaration-774e14641ff88e22c2da155faf7c7ef34a2fddfc957e2d42595dc41309a2dff1`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
菜单标题
```


<a id="symbol-a43a516572eadef9"></a>
### componentName

```java
@Schema(description = "\u7ec4\u4ef6\u540d\u79f0")
private String componentName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:51`; evidence: `declaration-a43a516572eadef9e13da27df264cbaec171fabedd129f841cba4667f46390af`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
组件名称
```


<a id="symbol-1b67a929eee3a4e7"></a>
### componentData

```java
@Schema(description = "\u7ec4\u4ef6\u5185\u5bb9")
private String componentData
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:56`; evidence: `declaration-1b67a929eee3a4e78570c0d2b8171edfee892e7bfeb583adf47fa262499a0dcb`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
组件内容
```


<a id="symbol-e68307ec1464d42e"></a>
### sort

```java
@Schema(description = "\u6392\u5e8f")
private Integer sort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:61`; evidence: `declaration-e68307ec1464d42e7b63d3e3ce72c62193c607c2c34c21e5752e51cf6daff8a7`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-f9534c20532d260c"></a>
### icon

```java
@Schema(description = "\u56fe\u6807")
private String icon
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:66`; evidence: `declaration-f9534c20532d260cd1d20fbd0a3a241074c0b0c054db28e121db9d2e9f7ca5df`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
图标
```


<a id="symbol-1c0ed440ddf6fd1f"></a>
### path

```java
@Schema(description = "\u94fe\u63a5\u5730\u5740")
private String path
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:71`; evidence: `declaration-1c0ed440ddf6fd1f7622b88d4e378ac7c851b21bfd036be00d2ad89598f8ba29`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
链接地址
```


<a id="symbol-619d7e502179c568"></a>
### iFrame

```java
@Schema(description = "\u662f\u5426\u5916\u94fe")
private Boolean iFrame
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:76`; evidence: `declaration-619d7e502179c568410ee803aaa77c89933495090dea17b3ed34c179c4a01891`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否外链
```


<a id="symbol-23acde3924ab4f83"></a>
### cache

```java
@Schema(description = "\u7f13\u5b58")
private Boolean cache
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:81`; evidence: `declaration-23acde3924ab4f839a174c50afe5310f5d49ea73a9a9cc91da526d618bcc7ce5`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
缓存
```


<a id="symbol-dc9f0d7b8bda1c7b"></a>
### hidden

```java
@Schema(description = "\u9690\u85cf")
private Boolean hidden
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:86`; evidence: `declaration-dc9f0d7b8bda1c7b7fbbf866b0cd4b29021539dba8a2f467f8661995a5795fba`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
隐藏
```


<a id="symbol-ccb32d6bcc44727b"></a>
### enable

```java
@Schema(description = "\u662f\u5426\u542f\u7528")
private Boolean enable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:91`; evidence: `declaration-ccb32d6bcc44727b34d138c26e01a857531b672732c6e23f669fc64c2cd16aa5`.
Visibility: `private` (explicit).
Type: `Boolean`.
No initializer recorded.

Source docstring (unreviewed):
```text
是否启用
```


<a id="symbol-f9dd2774f05428f8"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u8005")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:96`; evidence: `declaration-f9dd2774f05428f83574159cbf3252c2e55c8165bc34dd341648c96d5d4c804e`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建者
```


<a id="symbol-d302cff3625aab83"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:101`; evidence: `declaration-d302cff3625aab831b6c5e43c3a81614697395e7d30d5d921a314207611a98b4`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-6b7e193eb24fb0aa"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u8005")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:106`; evidence: `declaration-6b7e193eb24fb0aaa1deb15a0ceb439cb7f9a9928d545b8ff31bfe2e065c17a5`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新者
```


<a id="symbol-ecc982bf57e3eff6"></a>
### updateName

```java
@Schema(description = "\u66f4\u65b0\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:111`; evidence: `declaration-ecc982bf57e3eff6cb4809637a36ee5f1230ef66f4f65c4bfdc4026bfa176d0d`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新人名称
```


<a id="symbol-4d9fc1559643a5fe"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65e5\u671f")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:116`; evidence: `declaration-4d9fc1559643a5fe3c09af610c742883d66afed7ed417aa0833be7cc2d3cc8d6`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建日期
```


<a id="symbol-84dd398e1e2de3aa"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:122`; evidence: `declaration-84dd398e1e2de3aaffcb5c28e728cc7a36f580dc02cf1b5406dd9a98abde3e89`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```


<a id="symbol-802933a9903c5e40"></a>
### pageQuery

```java
@Schema(description = "\u5206\u9875\u53c2\u6570")
private Page pageQuery = new Page()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysMenuQuery.java:128`; evidence: `declaration-802933a9903c5e40bea1715822956bd49ef7661b57450e002ed2bcdb7725061f`.
Visibility: `private` (explicit).
Type: `Page`.

Source docstring (unreviewed):
```text
分页请求参数
```
