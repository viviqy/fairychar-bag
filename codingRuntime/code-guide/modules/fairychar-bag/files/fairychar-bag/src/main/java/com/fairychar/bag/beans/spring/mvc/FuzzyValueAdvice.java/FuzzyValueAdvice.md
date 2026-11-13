# com.fairychar.bag.beans.spring.mvc.FuzzyValueAdvice

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../FuzzyValueAdvice.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-632cd54653676ba6"></a>
## com.fairychar.bag.beans.spring.mvc.FuzzyValueAdvice

```java
@ControllerAdvice
@Order(100)
public class FuzzyValueAdvice implements ResponseBodyAdvice<Object>
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/spring/mvc/FuzzyValueAdvice.java:30`; evidence: `declaration-632cd54653676ba6a83b55cd973963452a5a5e90a4b199d277afe41f06dcce64`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
脱敏注解{@link FuzzyResult},{@link FuzzyValue},在接口响应参数返回中的具体解析实现

 @author chiyo
 @since 3.0.1
```


## Members

- [supports](FuzzyValueAdvice.supports.md#symbol-64905bc5386e5bbd) — `function`, source line 33
- [beforeBodyWrite](FuzzyValueAdvice.beforeBodyWrite.md#symbol-f6d9b8424453c71c) — `function`, source line 39
- [preProcess](FuzzyValueAdvice.preProcess.md#symbol-317d934af82dc91c) — `function`, source line 113
- [processMap](FuzzyValueAdvice.processMap.md#symbol-bb173dd4edd11515) — `function`, source line 138
- [processList](FuzzyValueAdvice.processList.md#symbol-84e0fdeaa1f4a2b3) — `function`, source line 154
- [wrapProperty](FuzzyValueAdvice.wrapProperty.md#symbol-f401e6a18ec10f62) — `function`, source line 164
- [processText](FuzzyValueAdvice.processText.md#symbol-5198863eb416ade0) — `function`, source line 189
