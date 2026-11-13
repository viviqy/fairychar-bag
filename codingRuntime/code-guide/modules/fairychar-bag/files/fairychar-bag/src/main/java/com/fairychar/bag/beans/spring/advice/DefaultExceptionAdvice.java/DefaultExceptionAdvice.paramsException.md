# com.fairychar.bag.beans.spring.advice.DefaultExceptionAdvice.paramsException

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../DefaultExceptionAdvice.java.md)

[Lexical owner](DefaultExceptionAdvice.md#symbol-9069430f47d87ceb)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-890e13ef0a02e7a7"></a>
## com.fairychar.bag.beans.spring.advice.DefaultExceptionAdvice.paramsException

```java
@ExceptionHandler(value = {BindException.class, ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public HttpResult paramsException(Exception exception)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/spring/advice/DefaultExceptionAdvice.java:46`; evidence: `declaration-890e13ef0a02e7a7aff73f370864ca2e699028dd75fe0ed0bbd28cf9eec33cfd`.
Owner: `com.fairychar.bag.beans.spring.advice.DefaultExceptionAdvice`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
只返回第一个校验失败的参数的校验原因
 该类错误可以从返回体中获取失败原因， 因此无需打印error
 处理参数格式校验失败错误 处理范围
 一Get请求中 标记@Valid的参数实体
 二@RequestParam 上标记@Validate的参数实体
 三@RequestBody 上标记@Validate的参数实体

 @param exception 异常
 @return 包装返回体
```
