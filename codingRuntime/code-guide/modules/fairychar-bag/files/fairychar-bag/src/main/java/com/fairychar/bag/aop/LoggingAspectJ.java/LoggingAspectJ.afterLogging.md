# com.fairychar.bag.aop.LoggingAspectJ.afterLogging

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../LoggingAspectJ.java.md)

[Lexical owner](LoggingAspectJ.md#symbol-5cd4c0260ab2da3c)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-456ed48129118ef1"></a>
## com.fairychar.bag.aop.LoggingAspectJ.afterLogging

```java
@AfterReturning(pointcut = "execution(public * *..controller..*.*(..)) && @annotation(requestLog)", returning = "result")
    public void afterLogging(JoinPoint joinPoint, RequestLog requestLog, Object result)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/aop/LoggingAspectJ.java:69`; evidence: `declaration-456ed48129118ef1d53fb687336ad192a8784a3f33dbd0f1bc7a2da30b82bddb`.
Owner: `com.fairychar.bag.aop.LoggingAspectJ`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
在控制器方法执行后记录日志。
 根据@RequestLog注解的配置决定是否启用日志记录。
 如果启用了日志记录，则根据配置的处理程序名称执行相应的处理方法。
 如果未配置处理程序名称，则使用全局配置的处理程序名称执行处理方法。
```
