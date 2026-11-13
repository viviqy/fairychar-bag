# com.fairychar.bag.pojo.query.DateBetweenQuery

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../DateBetweenQuery.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-b08ced9e4b94c17e"></a>
## com.fairychar.bag.pojo.query.DateBetweenQuery

```java
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Schema(description = "日期段查询")
public class DateBetweenQuery implements Serializable
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/query/DateBetweenQuery.java:21`; evidence: `declaration-b08ced9e4b94c17e2efcceb8958c239bdbc2ff33cbedc3d49574127ad5cf8174`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
Datetime: 2021/5/21 20:03

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-f2381c4bd6792dad"></a>
### from

```java
@Schema(description = "\u8d77\u59cb\u65f6\u95f4")
@JsonFormat(pattern = Consts.SIMPLE_DATE_FORMAT)
private LocalDate from
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/query/DateBetweenQuery.java:27`; evidence: `declaration-f2381c4bd6792dad72297c69647b2c24c8f89577e2059cf32a335c30bdac95c9`.
Visibility: `private` (explicit).
Type: `LocalDate`.
No initializer recorded.

<a id="symbol-c7476e49954dcd9d"></a>
### to

```java
@Schema(description = "\u7ed3\u675f\u65f6\u95f4")
@JsonFormat(pattern = Consts.SIMPLE_DATE_FORMAT)
private LocalDate to
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/pojo/query/DateBetweenQuery.java:30`; evidence: `declaration-c7476e49954dcd9de1e65f90102bf56aabdaf064eb435c455a02adc39fa34283`.
Visibility: `private` (explicit).
Type: `LocalDate`.
No initializer recorded.
