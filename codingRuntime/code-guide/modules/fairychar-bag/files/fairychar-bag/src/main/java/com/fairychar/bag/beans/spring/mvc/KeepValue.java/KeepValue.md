# com.fairychar.bag.beans.spring.mvc.KeepValue

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../KeepValue.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-892edb387046cbc8"></a>
## com.fairychar.bag.beans.spring.mvc.KeepValue

```java
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface KeepValue
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/spring/mvc/KeepValue.java:31`; evidence: `declaration-892edb387046cbc86699fc12a4089c3cc7ed56e0a6684f9d34f591abac736d7a`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>spring mvc 请求参数property保持值</p>
 请求参数内<font color="red"><b>没有被标记</b>的字段</font> ,在没进controller接口前将会把值抹除
 只保留group匹配的标注字段，其余当前类声明的非静态、非final字段均抹除。
 引用类型置为null，基本类型重置为Java默认值，不递归处理嵌套对象或父类字段。
 <pre>
   {@code
   class Request{
       @KeepValue
       private String name;
       private String gender;
   }

   @PostMapping("/add")
   public String add(@RequestBody @KeepValue Request request){
       //request gender字段的值将会为null
       return request.toString();
   }

   }
 </pre>
 与其对应的反作用注解{@link EraseValue}

 @author chiyo
 @since 1.0.2
```


## Members

- [value](KeepValue.value.md#symbol-903f07142fcd2ed9) — `function`, source line 43
