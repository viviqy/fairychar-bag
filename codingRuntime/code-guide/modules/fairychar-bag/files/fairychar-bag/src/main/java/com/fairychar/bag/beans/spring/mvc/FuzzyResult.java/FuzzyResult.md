# com.fairychar.bag.beans.spring.mvc.FuzzyResult

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FuzzyResult.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-9a04501aeeaa6d95"></a>
## com.fairychar.bag.beans.spring.mvc.FuzzyResult

```java
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FuzzyResult
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/spring/mvc/FuzzyResult.java:27`; evidence: `declaration-9a04501aeeaa6d955feeb17e98c55df7b9ed67602db70ace55f9bd0fa13763bd`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
spring mvc 响应参数接口标记注解,被标记的接口将会脱敏响应参数
 <pre>
     {@code
     class Sample{
         @FuzzyValue(beginAt=1,endAt=2)
         private String name="1234";
     }

     @FuzzyResult
     @GetMapping("/getOne")
     public Sample getOne(){
         return new Sample();
         //response= {name: "1**4"}
     }

     }
 </pre>

 @author chiyo
 @since 1.0.2
```


## Members

- [field](FuzzyResult.field.md#symbol-81d07cb82d47f1a2) — `function`, source line 50
