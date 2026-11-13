# com.fairychar.bag.beans.mybatis.interceptor.SwitchableTenantLineInnerInterceptor

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SwitchableTenantLineInnerInterceptor.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-c72afa92cfe12075"></a>
## com.fairychar.bag.beans.mybatis.interceptor.SwitchableTenantLineInnerInterceptor

```java
public class SwitchableTenantLineInnerInterceptor extends TenantLineInnerInterceptor
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/mybatis/interceptor/SwitchableTenantLineInnerInterceptor.java:49`; evidence: `declaration-c72afa92cfe12075a93c10d72d6d931e0b0101618f4f0f70029657df8a6602bb`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>可动态选择是否使用mybatis自动租户插件的拦截器</p>
 通过在mapper参数里设置{@link ITenantSwitcher}动态配置方法是否
 使用自动租户插件.
 使用例子
 <pre>
 {@code
 public class UserMapper{
     //switcher可以出现在参数任意位置,缺省代表使用自动租户,设置多个取第一个生效
     List<User> getUsers(@param("e") UserEntity entity,ITenantSwitcher switcher);
 }
 @Service
 public class UserService{
     @Autowired
     private UserMapper userMapper;

     public void test(){
         //代表不使用自动租户插件
         userMapper.getUsers(new UserEntity(),new TenantSwitcher(false));
         //代表使用自动租户插件
         userMapper.getUsers(new UserEntity(),new TenantSwitcher(true));
     }

 }
 }
 </pre>

 @author chiyo
 @since 1.0.2
```


## Members

- [SwitchableTenantLineInnerInterceptor](SwitchableTenantLineInnerInterceptor.SwitchableTenantLineInnerInterceptor.md#symbol-2e9627bbdba228d5) — `constructor`, source line 51
- [beforeQuery](SwitchableTenantLineInnerInterceptor.beforeQuery.md#symbol-bbadb77a8e15a13c) — `function`, source line 56
- [useTenant](SwitchableTenantLineInnerInterceptor.useTenant.md#symbol-090b333002fedc0e) — `function`, source line 69
