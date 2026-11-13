# com.fairychar.bag.beans.mybatis.interceptor.ITenantSwitcher

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ITenantSwitcher.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-6f20ff5e3838815e"></a>
## com.fairychar.bag.beans.mybatis.interceptor.ITenantSwitcher

```java
public interface ITenantSwitcher
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/mybatis/interceptor/ITenantSwitcher.java:14`; evidence: `declaration-6f20ff5e3838815e564f5360acd4ff6c3c18de1c2ae1fb2330590edde5f0456e`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>mybatis 租户是否启用选择器</p>
 配合{@link SwitchableTenantLineInnerInterceptor}使用
 把这个参数放到mapper方法参数里面任意位置,在执行此mapper方法时
 将会读取{@link ITenantSwitcher#use()}方法,如果返回true代表使用租户
 插件,false代表绕过租户插件,对于同一个mapper方法有些场景下需要
 自动租户,而有些场景不需要能得到更好的控制

 @author chiyo <br>
 @since 1.0.2
```


## Members

- [use](ITenantSwitcher.use.md#symbol-586cd1fb8e98b17a) — `function`, source line 21
