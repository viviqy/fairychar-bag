# com.fairychar.security.core.rbac.pojo.query.SysDictQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SysDictQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-641a5ff1447ccc7b"></a>
## com.fairychar.security.core.rbac.pojo.query.SysDictQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "SysDictQuery")
public class SysDictQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:20`; evidence: `declaration-641a5ff1447ccc7b6bf29e8655b81630f63b19391f922b250acc649c930f8b5b`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
数据字典详情(SysDict)表实体类

 @author chiyo
```


## Fields

<a id="symbol-d41c9d581b68611c"></a>
### id

```java
@Schema(description = "ID")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:31`; evidence: `declaration-d41c9d581b68611c65f496b63a840a734b441273c9c0034ddae8694c7575ffc6`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-f63732a400caba48"></a>
### uid

```java
@Schema(description = "\u5b57\u5178uid")
private Long uid
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:36`; evidence: `declaration-f63732a400caba48647cf1b4ae54f1ce83d0c5da67b56797c5eb2e61a005cf0e`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
字典uid
```


<a id="symbol-210423ab8bab65a2"></a>
### label

```java
@Schema(description = "\u5b57\u5178\u6807\u7b7e")
private String label
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:41`; evidence: `declaration-210423ab8bab65a2bc9a28f9450fc1adbbb1badf403bcb4c04a184dde47da9d5`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
字典标签
```


<a id="symbol-5af7a4ff9d194ca9"></a>
### labelValue

```java
@Schema(description = "\u5b57\u5178\u503c")
private String labelValue
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:46`; evidence: `declaration-5af7a4ff9d194ca9fcca89e8a63276244e9f258170603e8bb3b5c0cfa0435d8b`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
字典值
```


<a id="symbol-ce7e0ef5eabe4591"></a>
### description

```java
@Schema(description = "\u63cf\u8ff0")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:51`; evidence: `declaration-ce7e0ef5eabe4591a2585f51ccfc9c338590c0908c1a6d9fda8cfed787b2da8b`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
描述
```


<a id="symbol-3a29c277f50c66f4"></a>
### dictSort

```java
@Schema(description = "\u6392\u5e8f")
private Integer dictSort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:56`; evidence: `declaration-3a29c277f50c66f44ed599276d5083794936aeaf1a6c7b8a8841f61799c9ade6`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```


<a id="symbol-8773a4b4f6bd56ea"></a>
### createBy

```java
@Schema(description = "\u521b\u5efa\u8005")
private Long createBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:61`; evidence: `declaration-8773a4b4f6bd56ea74fde1d62f4f5ce200ed80ea0ef4dc58dcd5794f5642b9d6`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建者
```


<a id="symbol-b001afac6f02f53c"></a>
### createName

```java
@Schema(description = "\u521b\u5efa\u4eba\u540d\u79f0")
private String createName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:66`; evidence: `declaration-b001afac6f02f53cc8e2e7e523141dfe1570fd7329ca89eea931c66cc0c7d2c3`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建人名称
```


<a id="symbol-5060e82b4f0c55c7"></a>
### updateBy

```java
@Schema(description = "\u66f4\u65b0\u8005")
private Long updateBy
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:71`; evidence: `declaration-5060e82b4f0c55c7f5bbe172b842ddb359036764b099aa15d1eceace7e62aaa3`.
Visibility: `private` (explicit).
Type: `Long`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新者
```


<a id="symbol-07e68918d6d0f8b4"></a>
### updateName

```java
@Schema(description = "\u4fee\u6539\u4eba\u540d\u79f0")
private String updateName
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:76`; evidence: `declaration-07e68918d6d0f8b4949d2112ce57612fa88acb3c9508ced8f1c4f3cac225de5e`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
修改人名称
```


<a id="symbol-cd0c2fa5b803f4ab"></a>
### createTime

```java
@Schema(description = "\u521b\u5efa\u65e5\u671f")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime createTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:81`; evidence: `declaration-cd0c2fa5b803f4ab661e2142b407bcd568ea349c90b7dab4f29824a8e513bf4d`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
创建日期
```


<a id="symbol-b419e323841b9787"></a>
### updateTime

```java
@Schema(description = "\u66f4\u65b0\u65f6\u95f4")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private LocalDateTime updateTime
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:87`; evidence: `declaration-b419e323841b97871469e264fef194c454bdde1a7e28417cc908ec18736cf772`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

Source docstring (unreviewed):
```text
更新时间
```


<a id="symbol-382c218f1d42d15d"></a>
### pageQuery

```java
@Schema(description = "\u5206\u9875\u53c2\u6570")
private Page pageQuery = new Page()
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/SysDictQuery.java:93`; evidence: `declaration-382c218f1d42d15dbf3f2ac92960e3618e04bc65cf279f5f2b7c0771a7976443`.
Visibility: `private` (explicit).
Type: `Page`.

Source docstring (unreviewed):
```text
分页请求参数
```
