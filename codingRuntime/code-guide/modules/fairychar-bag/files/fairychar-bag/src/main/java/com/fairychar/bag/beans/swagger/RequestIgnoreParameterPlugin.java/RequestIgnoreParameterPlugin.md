# com.fairychar.bag.beans.swagger.RequestIgnoreParameterPlugin

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../RequestIgnoreParameterPlugin.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-ae2f2ff5f11a08fd"></a>
## com.fairychar.bag.beans.swagger.RequestIgnoreParameterPlugin

```java
@Order(Ordered.HIGHEST_PRECEDENCE + 103)
@Deprecated(since = "openApi3")
public class RequestIgnoreParameterPlugin
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/swagger/RequestIgnoreParameterPlugin.java:12`; evidence: `declaration-ae2f2ff5f11a08fde2f4bd36fef80ee520f6001511d90b1ba5400f438e8f7802`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
忽略接口某个参数,避免编写过多的实体类,该插件通过给Open API v2.0 的Path节点添加扩展属性x-ignoreParameters扩展属性,结合前端ui自定义实现过滤规则.
 2.0.3版本添加includeParameters属性的支持
 后期想办法适配
 @since:swagger-bootstrap-ui 1.9.5
```
