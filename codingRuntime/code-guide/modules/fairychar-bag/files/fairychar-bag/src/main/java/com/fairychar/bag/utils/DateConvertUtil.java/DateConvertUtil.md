# com.fairychar.bag.utils.DateConvertUtil

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../DateConvertUtil.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-f889b30d1a26e1df"></a>
## com.fairychar.bag.utils.DateConvertUtil

```java
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateConvertUtil
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/DateConvertUtil.java:19`; evidence: `declaration-f889b30d1a26e1dfbb5a3d947b98df4903ef283425f4dbfb0259a1d0699e4624`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
{@link LocalDate},{@link LocalDateTime}与{@link Date}互转工具

 @author chiyo
 @since 0.0.1-SNAPSHOT
```


## Fields

<a id="symbol-f22e249e56e8971f"></a>
### SUPPORT_DATE_FORMAT

```java
private static final Set<String> SUPPORT_DATE_FORMAT = new HashSet<String>() {{
        add("yyyy-MM-dd");
        add("yyyyMMdd");
        add("yyyyMd");
        add("yyyy/M/d");
        add("yyyy/MM/dd");
    }}
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/DateConvertUtil.java:21`; evidence: `declaration-f22e249e56e8971ff1261dd75538e3f0ec8ef765b6dd2e513549fc1ebd37a9d1`.
Visibility: `private` (explicit).
Type: `Set<String>`.

<a id="symbol-f5bcca764667ed27"></a>
### SUPPORT_DATE_TIME_FORMAT

```java
private static final Set<String> SUPPORT_DATE_TIME_FORMAT = new HashSet<String>() {{
        add("yyyy-MM-dd HH:mm:ss");
        add("yyyyMMdd HH:mm:ss");
        add("yyyyMd HH:mm:ss");
        add("yyyy/M/d HH:mm:ss");
        add("yyyy/M/d HH/mm/ss");
        add("yyyy/MM/dd HH/mm/ss");
        add("yyyy/MM/ddHH/mm/ss");
        add("yyyyMMdd HHmmss");
        add("yyyyMMddHHmmss");
    }}
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/utils/DateConvertUtil.java:29`; evidence: `declaration-f5bcca764667ed272c5f18aae8a0de1f79bcfbe8868caa36f9fc6fcc22c6d5a7`.
Visibility: `private` (explicit).
Type: `Set<String>`.

## Members

- [parseTime](DateConvertUtil.parseTime.md#symbol-dc5830aaf4544567) — `function`, source line 42
- [parseDate](DateConvertUtil.parseDate.md#symbol-3b006dff9d9cdc41) — `function`, source line 56
- [dateToLocaldateTime](DateConvertUtil.dateToLocaldateTime.md#symbol-46c1582d2e076346) — `function`, source line 71
- [dateToLocaldate](DateConvertUtil.dateToLocaldate.md#symbol-bbdf5c2c4930928c) — `function`, source line 78
- [localdateToDate](DateConvertUtil.localdateToDate.md#symbol-b1bdb75d47064b47) — `function`, source line 86
