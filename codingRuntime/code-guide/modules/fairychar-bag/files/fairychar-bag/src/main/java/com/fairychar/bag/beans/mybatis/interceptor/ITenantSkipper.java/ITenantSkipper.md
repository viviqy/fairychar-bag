# com.fairychar.bag.beans.mybatis.interceptor.ITenantSkipper

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../ITenantSkipper.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-d52b4badb739b9a0"></a>
## com.fairychar.bag.beans.mybatis.interceptor.ITenantSkipper

```java
public interface ITenantSkipper
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/mybatis/interceptor/ITenantSkipper.java:31`; evidence: `declaration-d52b4badb739b9a0a083ee9ac1f714b8a4917c293d8eae7b8674db27bfc81d3a`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>是否使用自动租户控制器</p>
 通过{@link ITenantSkipper#setSkip}在执行sql之前,可以
 绕过自动租户插件对拼接租户流程的执行.需要配合{@link SkipableTenantLineInnerInterceptor}使用
 <pre>
 {@code
 @Service
 public class UserService{
      @Autowired
      private UserMapper userMapper;

      public List<User> getUsers(){
          try{
            //跳过不使用自动租户插件
            TenantSkipper.skip();
            return this.userMapper.list();
          }finally{
            //记得一定要清除线程上下文
            TenantSkipper.remove();
          }
      }
 }
 }
 </pre>

 @author chiyo <br>
 @since 1.0.2
```


## Members

- [setSkip](ITenantSkipper.setSkip.md#symbol-fe85615f80894a39) — `function`, source line 39
- [cleanContext](ITenantSkipper.cleanContext.md#symbol-7876132b91ce8eff) — `function`, source line 44
- [getSkip](ITenantSkipper.getSkip.md#symbol-90f45cff2ce95934) — `function`, source line 51
