# com.fairychar.bag.beans.mybatis.interceptor.SimpleTenantSkipper

Snapshot: `snapshot-20261113T014229Z-bb422342`; coverage: `incomplete`.

[Source file index](../SimpleTenantSkipper.java.md)

Syntax and relationship candidates do not establish runtime behavior, field meaning, producers/consumers or lifecycle. Verify current source and tests; see gaps.jsonl.

<a id="symbol-f3aa04e11d3730db"></a>
## com.fairychar.bag.beans.mybatis.interceptor.SimpleTenantSkipper

```java
@Slf4j
public class SimpleTenantSkipper implements ITenantSkipper
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/mybatis/interceptor/SimpleTenantSkipper.java:33`; evidence: `declaration-f3aa04e11d3730db13b2fee499fd4e94822d20c9ba41916cfd681d93e63b23ce`.
Owner: `<top-level>`; visibility: `public` (explicit).

Source docstring (unreviewed):
```text
<p>是否使用自动租户控制器</p>
 通过{@link SimpleTenantSkipper#setSkip}在执行sql之前,可以
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


## Fields

<a id="symbol-92df85ea722de3bb"></a>
### THREAD_LOCAL

```java
private static final ThreadLocal<Boolean> THREAD_LOCAL = ThreadLocal.withInitial(() -> true)
```

Source: `fairychar-bag/src/main/java/com/fairychar/bag/beans/mybatis/interceptor/SimpleTenantSkipper.java:36`; evidence: `declaration-92df85ea722de3bb82276cbdd3726cb3d83ebdfc5df1cebd5976fa39f684fe5e`.
Visibility: `private` (explicit).
Type: `ThreadLocal<Boolean>`.

## Members

- [setSkip](SimpleTenantSkipper.setSkip.md#symbol-125563a0cfb0db9e) — `function`, source line 39
- [cleanContext](SimpleTenantSkipper.cleanContext.md#symbol-7eb6e30b57323783) — `function`, source line 45
- [getSkip](SimpleTenantSkipper.getSkip.md#symbol-4865fdd6939c08c2) — `function`, source line 51
