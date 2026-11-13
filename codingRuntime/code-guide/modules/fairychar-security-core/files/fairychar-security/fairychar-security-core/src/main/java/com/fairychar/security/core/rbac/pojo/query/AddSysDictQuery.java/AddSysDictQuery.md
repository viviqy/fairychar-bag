# com.fairychar.security.core.rbac.pojo.query.AddSysDictQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../AddSysDictQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-5c8b0c1d95b9b306"></a>
## com.fairychar.security.core.rbac.pojo.query.AddSysDictQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "AddSysDictQuery")
public class AddSysDictQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysDictQuery.java:21`; evidence: `declaration-5c8b0c1d95b9b30644d5273dc013ed774987fe2b80181de885495c960c73a081`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
数据字典详情(SysDict)表实体类

 @author chiyo
```


## Fields

<a id="symbol-01fc416e55ed5b38"></a>
### label

```java
@Schema(description = "\u5b57\u5178\u6807\u7b7e")
@NotEmpty
private String label
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysDictQuery.java:32`; evidence: `declaration-01fc416e55ed5b38f799cef33b53a8ee6daa23af793f248f18117464fd264e77`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
字典标签
```


<a id="symbol-caf60b8958ef6a57"></a>
### labelValue

```java
@Schema(description = "\u5b57\u5178\u503c")
@NotEmpty
private String labelValue
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysDictQuery.java:38`; evidence: `declaration-caf60b8958ef6a5774c408d4aec474bb5cda2f48d6ecb8cc0c41452d282bfce8`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
字典值
```


<a id="symbol-3b84bba62749e45c"></a>
### description

```java
@Schema(description = "\u63cf\u8ff0")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysDictQuery.java:44`; evidence: `declaration-3b84bba62749e45c4c9e9ef9d060834a5ca023fd91d49f0c112f1a1a759a20f4`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
描述
```


<a id="symbol-31c9b82b0bad6dd1"></a>
### dictSort

```java
@Schema(description = "\u6392\u5e8f")
private Integer dictSort = 0
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/AddSysDictQuery.java:49`; evidence: `declaration-31c9b82b0bad6dd158d43b2b8ff3ee7f864e220f3b4de4bac7604387a1626e1c`.
Visibility: `private` (explicit).
Type: `Integer`.

Source docstring (unreviewed):
```text
排序
```
