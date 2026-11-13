# com.fairychar.bag.beans.spring.mvc.FuzzyResult.field

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FuzzyResult.java.md)

[Lexical owner](FuzzyResult.md#symbol-9a04501aeeaa6d95)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-81d07cb82d47f1a2"></a>
## com.fairychar.bag.beans.spring.mvc.FuzzyResult.field

```java
String field() default ""
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/spring/mvc/FuzzyResult.java:50`; evidence: `declaration-81d07cb82d47f1a230d6e8a7bbea82af48deb8264eea51bfe81f1f844c796fdd`.
Owner: `com.fairychar.bag.beans.spring.mvc.FuzzyResult`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
由于接口大多会包装一层进行返回,如
 <pre>
 {@code
 public HttpResult<User> getUser();
 }
 </pre>
 这种情况下,实际业务返回对象为User.class,但是HttpResult一般无法在data字段上添加注解
 提供field属性,取包装体字段为模糊对象进行模糊处理
 属性字段名称,如果有值则会取对应字段值为Object,可以通过.分割
 如果值为空则取当前返回对象为Object
 <pre>{@code
 @FuzzyResult(field = "data.user")
 }
 </pre>

 @return {@link String}
```
