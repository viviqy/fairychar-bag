# com.fairychar.bag.beans.spring.mvc.EraseValue

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../EraseValue.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-ad5e2ccafe7a86b8"></a>
## com.fairychar.bag.beans.spring.mvc.EraseValue

```java
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface EraseValue
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/spring/mvc/EraseValue.java:30`; evidence: `declaration-ad5e2ccafe7a86b8445b7299ad55ed084b3ea42a2799ee0b30c308fc5f80b8d3`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>spring mvc 请求参数的property值抹除注解</p>
 请求参数内被标记的字段,在没进controller接口前将会把值抹除
 只处理请求体当前类声明的非静态、非final字段；引用类型置为null，基本类型重置为Java默认值，不递归处理嵌套对象或父类字段。
 <pre>
   {@code
   class Request{
       @EraseValue
       private String name;
       private String gender;
   }

   @PostMapping("/add")
   public String add(@RequestBody @EraseValue Request request){
       //request name字段的值将会为null
       return request.toString();
   }

   }
 </pre>
 与其对应的反作用注解{@link KeepValue}

 @author chiyo
 @since 1.0.2
```


## Members

- [value](EraseValue.value.md#symbol-4d9acd0bbe603386) — `function`, source line 42
