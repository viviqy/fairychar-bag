# com.fairychar.bag.domain.Consts

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../Consts.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-c83d43852f483f28"></a>
## com.fairychar.bag.domain.Consts

```java
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Consts
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:15`; evidence: `declaration-c83d43852f483f28aab66395c749e72065ea835d885bdf254309d10c04478307`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
常用常量属性

 @author chiyo
 @since 1.0
```


## Fields

<a id="symbol-090b401d324a128d"></a>
### EMPTY_STR

```java
public static final String EMPTY_STR = ""
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:18`; evidence: `declaration-090b401d324a128d0c220989e7a42518491a6b890fbee276b3512e7a6c48a811`.
Visibility: `public` (explicit).
Type: `String`.

<a id="symbol-66e8289e5313d9fd"></a>
### KB_PER_B

```java
public static final long KB_PER_B = 1024
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:19`; evidence: `declaration-66e8289e5313d9fd43463554037df0d62b36b603d5ee092327e6646d23441004`.
Visibility: `public` (explicit).
Type: `long`.

<a id="symbol-d2483382e74a25a8"></a>
### MB_PER_B

```java
public static final long MB_PER_B = 1024 * 1024
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:20`; evidence: `declaration-d2483382e74a25a8f0a9afa546c0286ec2daf1946cbdb1679089f2948edc133a`.
Visibility: `public` (explicit).
Type: `long`.

<a id="symbol-9ad7f0e4a7ef03f0"></a>
### GB_PER_B

```java
public static final long GB_PER_B = 1024 * 1024 * 1024
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:21`; evidence: `declaration-9ad7f0e4a7ef03f0fd06e35e6624f5c01bbd0cf6a45fece2bace3961768ec9b3`.
Visibility: `public` (explicit).
Type: `long`.

<a id="symbol-2bd12b25e3d22dc8"></a>
### TB_PER_B

```java
public static final long TB_PER_B = 1024 * 1024 * 1024 * 1024
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:22`; evidence: `declaration-2bd12b25e3d22dc8d380a7561b1f62eb47b52469c2fbfad6a64f26f54e28e54f`.
Visibility: `public` (explicit).
Type: `long`.

<a id="symbol-9cd8bc32444b54a5"></a>
### PB_PER_B

```java
public static final long PB_PER_B = 1024 * 1024 * 1024 * 1024 * 1024
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:23`; evidence: `declaration-9cd8bc32444b54a5d5709c73b0ddb586db7a2a35b5fea569c2cb3f876e11737e`.
Visibility: `public` (explicit).
Type: `long`.

<a id="symbol-063415aca2243073"></a>
### NONE

```java
public static final String NONE = "none"
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:25`; evidence: `declaration-063415aca2243073066d166c79b8818c7aeff0298cedbd71c75ffa404081fcc1`.
Visibility: `public` (explicit).
Type: `String`.

<a id="symbol-f71786ac31dae689"></a>
### SIMPLE_DATETIME_FORMAT

```java
public static final String SIMPLE_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss"
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:27`; evidence: `declaration-f71786ac31dae689f7d0e314c35599770fb7047009a08c9cbd9c2c609b3c0dd5`.
Visibility: `public` (explicit).
Type: `String`.

<a id="symbol-ffb84b425a5090b1"></a>
### SIMPLE_DATE_TIME_FORMATTER

```java
public static final DateTimeFormatter SIMPLE_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(SIMPLE_DATETIME_FORMAT)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:29`; evidence: `declaration-ffb84b425a5090b122cc8338bfbf5cbcfa84bf8e7aed295dbb5cb08138806510`.
Visibility: `public` (explicit).
Type: `DateTimeFormatter`.

<a id="symbol-cf30966cdc953f16"></a>
### SIMPLE_DATE_FORMAT

```java
public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd"
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:31`; evidence: `declaration-cf30966cdc953f16cb662eb89dc73ddf966b18efabfdca806a9cf1cfba5f24b7`.
Visibility: `public` (explicit).
Type: `String`.

<a id="symbol-0fdf0bdb40a6eba1"></a>
### SIMPLE_DATE_FORMATTER

```java
public static final DateTimeFormatter SIMPLE_DATE_FORMATTER = DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMAT)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:33`; evidence: `declaration-0fdf0bdb40a6eba1cddac690f03f53ef18142c66f4abd99f3242fba439ed9d6d`.
Visibility: `public` (explicit).
Type: `DateTimeFormatter`.

<a id="symbol-36d18177f5e79bf1"></a>
### MYSQL_MAX_DATETIME

```java
public static final LocalDateTime MYSQL_MAX_DATETIME = LocalDateTime.parse("9999-12-31 23:59:59", SIMPLE_DATE_TIME_FORMATTER)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:35`; evidence: `declaration-36d18177f5e79bf1368c7597b88a785c31b19ebc9d7e9ab77a3bc8a5af2c5c0d`.
Visibility: `public` (explicit).
Type: `LocalDateTime`.

<a id="symbol-4856677569692bae"></a>
### MYSQL_MAX_TIMESTAMP

```java
public static final LocalDateTime MYSQL_MAX_TIMESTAMP = LocalDateTime.parse("2038-01-19 03:14:07", SIMPLE_DATE_TIME_FORMATTER)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/Consts.java:37`; evidence: `declaration-4856677569692baefc76d6f63b27b2b942ffe931c72675934a7bfce3ab16dd53`.
Visibility: `public` (explicit).
Type: `LocalDateTime`.

## Members

- [OAuth2](Consts.OAuth2.md#symbol-4011cdfc42bb0cd6) — `class`, source line 39
- [Regex](Consts.Regex.md#symbol-4f397ce5feba9835) — `class`, source line 47
