# com.fairychar.bag.domain.validator.rest.Language.LanguageType

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../Language.java.md)

[Lexical owner](Language.md#symbol-0c9069b292e01443)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-2b648663fb426d5a"></a>
## com.fairychar.bag.domain.validator.rest.Language.LanguageType

```java
@AllArgsConstructor
    @Getter
    enum LanguageType
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/Language.java:37`; evidence: `declaration-2b648663fb426d5a69df058d096e9f2f4e8f08cd253d18b9d5f8afc9adbedbce`.
Owner: `com.fairychar.bag.domain.validator.rest.Language`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
语言类型

 @author chiyo
```


## Fields

<a id="symbol-68bd496e4b1620fb"></a>
### CHINESE

```java
CHINESE("^[\\u4e00-\\u9fa5]+$")
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/Language.java:44`; evidence: `declaration-68bd496e4b1620fbc3860bd2fec9c104afbbb41b3743c2206958a7e2ef898d12`.
Visibility: `public` (language default or unknown).
Type: `LanguageType`.
No initializer recorded.

Source docstring (unreviewed):
```text
中文
```


<a id="symbol-d89d945f0f0bde99"></a>
### CHINES_WITH_ENGLISH

```java
CHINES_WITH_ENGLISH("^[\\u4e00-\\u9fa5]+$+[a-zA-Z]+")
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/Language.java:48`; evidence: `declaration-d89d945f0f0bde996a277caa7af0dcb561c18dd5ade8eb7a0e15707221d79e4d`.
Visibility: `public` (language default or unknown).
Type: `LanguageType`.
No initializer recorded.

Source docstring (unreviewed):
```text
中文与英文
```


<a id="symbol-61793f8a505a9898"></a>
### CHINESE_WITH_NUMBER

```java
CHINESE_WITH_NUMBER("^[\\u4e00-\\u9fa5]+$+[0-9]+")
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/Language.java:52`; evidence: `declaration-61793f8a505a98989090e218f5a4f314b886d5a88835c4348821c184ab261399`.
Visibility: `public` (language default or unknown).
Type: `LanguageType`.
No initializer recorded.

Source docstring (unreviewed):
```text
带数字中文
```


<a id="symbol-e94ac80712a4b212"></a>
### CHINESE_WITH_ENGLISH_AND_NUMBER

```java
CHINESE_WITH_ENGLISH_AND_NUMBER("^[\\u4e00-\\u9fa5]+$+[a-zA-Z0-9]+")
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/Language.java:56`; evidence: `declaration-e94ac80712a4b212d198742d33a31ab647bd1a7c17159a8c1f12138fb83aed82`.
Visibility: `public` (language default or unknown).
Type: `LanguageType`.
No initializer recorded.

Source docstring (unreviewed):
```text
中文与英文和数字
```


<a id="symbol-303d9c7e0fa2576d"></a>
### regex

```java
private String regex
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/validator/rest/Language.java:58`; evidence: `declaration-303d9c7e0fa2576dca52cffdb84db63c97d5551d83e1fcaca27efca1d16decd8`.
Visibility: `private` (explicit).
Type: `String`.
No initializer recorded.
