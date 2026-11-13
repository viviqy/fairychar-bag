# com.fairychar.security.core.rbac.pojo.query.UpdateSysDictQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../UpdateSysDictQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-d622f10daafa920b"></a>
## com.fairychar.security.core.rbac.pojo.query.UpdateSysDictQuery

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@Schema(description = "UpdateSysDictQuery")
public class UpdateSysDictQuery implements Serializable
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysDictQuery.java:20`; evidence: `declaration-d622f10daafa920bd45df3b3d262cd0b4f7b6f10aea34bf3944550521a45c189`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
数据字典详情(SysDict)表实体类

 @author chiyo
```


## Fields

<a id="symbol-598355f2b9d8d291"></a>
### id

```java
@Schema(description = "ID")
private Integer id
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysDictQuery.java:31`; evidence: `declaration-598355f2b9d8d291a54887d5734616adb9f549cbb328496b44c189b83878cb4c`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
ID
```


<a id="symbol-af22eafe94bf4903"></a>
### label

```java
@Schema(description = "\u5b57\u5178\u6807\u7b7e")
private String label
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysDictQuery.java:36`; evidence: `declaration-af22eafe94bf49034a03dae6041ec76ba64f3c07103cb20d319b525ebf75174c`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
字典标签
```


<a id="symbol-2f3adb2c9cb5670e"></a>
### labelValue

```java
@Schema(description = "\u5b57\u5178\u503c")
private String labelValue
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysDictQuery.java:41`; evidence: `declaration-2f3adb2c9cb5670e53cbc726b3223af4323c087508f7c733e1d9d077450a409c`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
字典值
```


<a id="symbol-4e5053ba24715ba9"></a>
### description

```java
@Schema(description = "\u63cf\u8ff0")
private String description
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysDictQuery.java:46`; evidence: `declaration-4e5053ba24715ba95016e9dd244aba4b38391d763bad766fc3970ebab7920c66`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.

Source docstring (unreviewed):
```text
描述
```


<a id="symbol-222f136c7a0289ba"></a>
### dictSort

```java
@Schema(description = "\u6392\u5e8f")
private Integer dictSort
```

Source: `fairychar-security/fairychar-security-core/src/main/java/com/fairychar/security/core/rbac/pojo/query/UpdateSysDictQuery.java:51`; evidence: `declaration-222f136c7a0289ba3b771e7af72afb56588cf3216368349eab79f85261b019f9`.
Visibility: `private` (explicit).
Type: `Integer`.
No initializer recorded.

Source docstring (unreviewed):
```text
排序
```
