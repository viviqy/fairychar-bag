# com.fairychar.bag.domain.annotations.MethodLock.nameExpression

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../MethodLock.java.md)

[Lexical owner](MethodLock.md#symbol-ebf8ee2b07d94f0d)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-17430c4d8d6cff9f"></a>
## com.fairychar.bag.domain.annotations.MethodLock.nameExpression

```java
String nameExpression() default ""
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/domain/annotations/MethodLock.java:58`; evidence: `declaration-17430c4d8d6cff9fffe8c4e1809be474b87f1e5b7bec6ae268b6ae86f9d5211e`.
Owner: `com.fairychar.bag.domain.annotations.MethodLock`; visibility: `public` (language default or unknown).

Source docstring (unreviewed):
```text
本地锁名称或者分布式锁节点名称,Spel表达式

 @return 分布式锁情况下默认使用全路径类名+方法名+参数类型,本地锁情况下指定则优先根据此值获取锁
```
