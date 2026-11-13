# com.fairychar.security.core.rbac.pojo.dto.SysDictDTO

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysDictDTO.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-d3ee8a44405ab0d7"></a>
## com.fairychar.security.core.rbac.pojo.dto.SysDictDTO

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "SysDictDTO")
public class SysDictDTO implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysDictDTO.java:18`; evidence: `declaration-d3ee8a44405ab0d77c60207932bef69210b4e1a72c3f3aadc2f21f7c9b005771`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
数据字典详情(SysDict)表实体类

 @author chiyo
```


## Fields

<a id="symbol-a2c330a5697e3abd"></a>
### id

```java
@Schema(description = "ID")
@JsonFormat(shape = JsonFormat.Shape.STRING)
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysDictDTO.java:29`; evidence: `declaration-a2c330a5697e3abd792409255fbba118018394ef5ec95986b7a06c339817ea64`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-44c722a0892e40b8"></a>
### uid

```java
@Schema(description = "\u5b57\u5178uid")
private Long uid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysDictDTO.java:35`; evidence: `declaration-44c722a0892e40b819e0f9ef134333d1557c7fd1c62cc3d3d3feb1ce1b0841c4`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
字典uid
```


<a id="symbol-25e0a997deb821d4"></a>
### label

```java
@Schema(description = "\u5b57\u5178\u6807\u7b7e")
private String label
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysDictDTO.java:40`; evidence: `declaration-25e0a997deb821d41804fba655896f2674fc04b21ee05d2c8d01f062322b942f`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
字典标签
```


<a id="symbol-1aad510267a20d51"></a>
### labelValue

```java
@Schema(description = "\u5b57\u5178\u503c")
private String labelValue
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysDictDTO.java:45`; evidence: `declaration-1aad510267a20d51b7a9f3bfdd5ada8359194f83150d193624c9b06114e50a38`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
字典值
```


<a id="symbol-6727b543aef75be2"></a>
### description

```java
@Schema(description = "\u63cf\u8ff0")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysDictDTO.java:50`; evidence: `declaration-6727b543aef75be26efe20c4287bda632a70cfeaf57ae8c3481a6f87d4e54b61`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
描述
```


<a id="symbol-ce7e5449afb3ba27"></a>
### dictSort

```java
@Schema(description = "\u6392\u5e8f")
private Integer dictSort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysDictDTO.java:55`; evidence: `declaration-ce7e5449afb3ba27a9edd57b5c4b719eaf3967ee8dca83bed79ab1e73b86cc5a`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-d7da12a4a1e3d8f1"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u8005")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysDictDTO.java:60`; evidence: `declaration-d7da12a4a1e3d8f11774c2fa64306614c64d196c6bc64bce71694cc78367e5b7`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建者
```


<a id="symbol-c7ebbe9f43118ae5"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysDictDTO.java:65`; evidence: `declaration-c7ebbe9f43118ae5182ca28c1062aa090a0367c5717d461ecb9bec16aa691f11`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-0550f4f0c4ff7147"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u8005")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysDictDTO.java:70`; evidence: `declaration-0550f4f0c4ff71477017062f46c5c87cd53cc249372c6460c3bdb000235556f3`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新者
```


<a id="symbol-55598821d3f48900"></a>
### updateName

```java
@Schema(description = "\u4fee\u6539\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysDictDTO.java:75`; evidence: `declaration-55598821d3f48900b03778159adeef9ddb9c3da4d0389a575eccd3c613b918a8`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
修改人名称
```


<a id="symbol-c388cee077a8824e"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65e5\u671f")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysDictDTO.java:80`; evidence: `declaration-c388cee077a8824ef99e8fcd5e750b8f7fdcd5078c03bbb12dc4aa23add5b155`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建日期
```


<a id="symbol-fab54836a97abc42"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/dto/SysDictDTO.java:86`; evidence: `declaration-fab54836a97abc421f50f81d0244c80808a23db1d4b2d9200e17e767799a115e`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```
