# com.fairychar.bag.domain.annotations.CauseHandler

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../CauseHandler.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-20b16171eedf0f96"></a>
## com.fairychar.bag.domain.annotations.CauseHandler

```java
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CauseHandler
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/annotations/CauseHandler.java:14`; evidence: `declaration-20b16171eedf0f96bf526c2be363fdb44429ef3050abbda2936ffd7f35aacf5e`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
netty指定异常拦截器,配合{@link NettyCauseAdvice}使用
 <p>
 使用方式和{@link org.springframework.web.bind.annotation.ExceptionHandler}一样

 @author chiyo
```


## Members

- [value](CauseHandler.value.md#symbol-17b4eed576c0df2a) — `function`, source line 24
- [handler](CauseHandler.handler.md#symbol-9079f215577d19c7) — `function`, source line 31
- [methodName](CauseHandler.methodName.md#symbol-329e6d3190f72bd2) — `function`, source line 38
