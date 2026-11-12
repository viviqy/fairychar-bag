# SpEL 表达式求值

[返回功能入口](../../fairychar-bag-usage-guide.md)

## 用途与采用边界

**采用状态：条件接入**。仅在本页明确的输入、效果和限制内使用；未说明的重载不扩展行为承诺。

本页是该功能的使用说明；下列代码片段依赖业务类型时需替换为项目已有定义，完整 Java 文件另有标注。

## SpelUtil

位置: `com.fairychar.bag.utils.SpelUtil`

用于 AOP 场景从方法参数解析 SpEL。

```java
Method method = OrderService.class.getMethod("update", Long.class);
String key = SpelUtil.eval("'order:' + #orderId", method, new Object[]{1L}, String.class);
```

方法:

- `eval(String expression, JoinPoint joinPoint, Class<T> returnType)`
- `eval(String expression, Method method, Object[] args, Class<T> returnType)`
- `createEvaluationContext(Method method, Object[] args)`
- `parseExpression(String expression)`: 内部有 `ConcurrentHashMap` 表达式缓存。

## 输入、输出与失败

| 入口 | 输入与效果 | 失败、责任与边界 |
| --- | --- | --- |
| `SpelUtil.eval(expression,Method,args,returnType)` | 非 null 方法与参数数组、可信有效表达式；`#p0` / `#a0` 用位置参数；命名参数依赖参数名可发现 | returnType 不执行转换或检查，调用方接收不兼容类型时会 ClassCastException；解析/求值异常不转为业务错误。null 结果可返回；不要对 null 结果直接拆箱 |
| `SpelUtil.eval(expression,JoinPoint,returnType)` | JoinPoint 必须实际是 ProceedingJoinPoint 且 signature 是 MethodSignature | 普通 JoinPoint 不能保证可用；业务优先 Method 重载。只求值可信固定表达式，不执行用户输入；动态无限表达式会增长全局缓存 |

**例子**：表达式 `"1 + 1"` 返回 Integer；returnType=String 不会把结果转换成 `"2"`。

## 类型与完整签名

- [`com.fairychar.bag.domain.spring.expression.SimpleEvaluationContext`](../../api/domain-spring-expression.md)
- [`com.fairychar.bag.domain.spring.expression.SimpleExpressionRootObject`](../../api/domain-spring-expression.md)
- [`com.fairychar.bag.utils.SpelUtil`](../../api/utils--spelutil.md)
