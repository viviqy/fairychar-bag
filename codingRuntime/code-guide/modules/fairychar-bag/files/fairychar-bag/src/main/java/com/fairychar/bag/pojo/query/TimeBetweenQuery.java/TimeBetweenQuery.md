# com.fairychar.bag.pojo.query.TimeBetweenQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../TimeBetweenQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-9cad8897221018d8"></a>
## com.fairychar.bag.pojo.query.TimeBetweenQuery

```java
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Schema(description = "时间段查询")
public class TimeBetweenQuery implements Serializable
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/query/TimeBetweenQuery.java:21`; evidence: `declaration-9cad8897221018d8be0314c637fbed5dc796c304981b4e45cacd3cbbf6f40152`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
Datetime: 2021/5/21 20:03

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-04ec8dde67280c8a"></a>
### from

```java
@Schema(description = "\u8d77\u59cb\u65f6\u95f4")
@JsonFormat(pattern = Consts.SIMPLE_DATETIME_FORMAT)
private LocalDateTime from
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/query/TimeBetweenQuery.java:27`; evidence: `declaration-04ec8dde67280c8aadca9d73d0be3d6378a840324b73c9d0e60c291abd37d68c`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.

<a id="symbol-a7162491a7b04e37"></a>
### to

```java
@Schema(description = "\u7ed3\u675f\u65f6\u95f4")
@JsonFormat(pattern = Consts.SIMPLE_DATETIME_FORMAT)
private LocalDateTime to
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/query/TimeBetweenQuery.java:30`; evidence: `declaration-a7162491a7b04e375eb199b24dd2f99ab226215c6f7ab4a313167baff60742d0`.
Visibility: `private` (explicit).
Type: `LocalDateTime`.
No initializer recorded.
