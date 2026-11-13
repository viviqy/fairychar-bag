# com.fairychar.bag.beans.mybatis.interceptor.SkipableTenantLineInnerInterceptor

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SkipableTenantLineInnerInterceptor.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-23eef23354b97477"></a>
## com.fairychar.bag.beans.mybatis.interceptor.SkipableTenantLineInnerInterceptor

```java
@EqualsAndHashCode(callSuper = true)
public class SkipableTenantLineInnerInterceptor extends TenantLineInnerInterceptor
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/mybatis/interceptor/SkipableTenantLineInnerInterceptor.java:23`; evidence: `declaration-23eef23354b9747746ebcfa733c940f4b043589303d2120d626cfef20340dfaf`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>可自定义是否跳过动态选择是否使用mybatis自动租户插件的拦截器</p>

 @author chiyo
 @since 1.0.2
```


## Fields

<a id="symbol-dbb12f6ef62cb9d4"></a>
### tenantSkipper

```java
private ITenantSkipper tenantSkipper
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/mybatis/interceptor/SkipableTenantLineInnerInterceptor.java:26`; evidence: `declaration-dbb12f6ef62cb9d4f8e42b25d093f0cad404280fffd4b415dac2c9bcc651d186`.
Visibility: `private` (explicit).
Type: `ITenantSkipper`.
No initializer recorded.

## Members

- [SkipableTenantLineInnerInterceptor](SkipableTenantLineInnerInterceptor.SkipableTenantLineInnerInterceptor--a488e410fd3b3ecb.md#symbol-51119e04440f84a0) — `constructor`, source line 28
- [SkipableTenantLineInnerInterceptor](SkipableTenantLineInnerInterceptor.SkipableTenantLineInnerInterceptor--4321ec2b99cda539.md#symbol-4844d899bb40bcee) — `constructor`, source line 33
- [beforeQuery](SkipableTenantLineInnerInterceptor.beforeQuery.md#symbol-b7c9347d3b72168e) — `function`, source line 39
