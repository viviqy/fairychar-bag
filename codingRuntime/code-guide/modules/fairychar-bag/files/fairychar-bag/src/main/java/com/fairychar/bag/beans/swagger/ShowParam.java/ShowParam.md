# com.fairychar.bag.beans.swagger.ShowParam

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ShowParam.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-3c4ff12ff533be98"></a>
## com.fairychar.bag.beans.swagger.ShowParam

```java
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Deprecated(since = "openapi3")
//后期想办法适配
public @interface ShowParam
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/swagger/ShowParam.java:30`; evidence: `declaration-3c4ff12ff533be98f9a99a1047c01dbf5629cb8d5eed341f201cc0c8a585e310`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>swagger文档请求参数部分暂时注解</p>
 在不想每个接口都定义一个请求参数的情况下,通常会使用一个大的请求参数实体来做
 通用的请求体,但是这个通用请求体在swagger文档上,对于有些接口显示的参数太多
 无用的,容易引起阅读困难.这个注解可以让接口指定显示当前接口需要展示的字段,隐藏
 其他无用字段.
 <pre>
     {@code
     class Sample{
         @ShowParam
         private String name;
         private String gender;
     }

     @GetMapping("/getOne")
     public Sample getOne(@ShowParam @RequestBody Sample sample){
         return sample;
     }
     }
 </pre>
 swagger文档上这个接口请求参数只会暂时name字段

 @author chiyo
 @since 1.0.2
```


## Members

- [value](ShowParam.value.md#symbol-ca05fb8594a97bcc) — `function`, source line 42
