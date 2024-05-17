package com.fairychar.bag.beans.mybatis.interceptor;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>是否使用自动租户控制器</p>
 * 通过{@link TenantSkipper#skip}在执行sql之前,可以
 * 绕过自动租户插件对拼接租户流程的执行.需要配合{@link ThreadContextTenantLineInnerInterceptor}使用
 * <pre>
 * {@code
 * @Service
 * public class UserService{
 *      @Autowired
 *      private UserMapper userMapper;
 *
 *      public List<User> getUsers(){
 *          try{
 *            //跳过不使用自动租户插件
 *            TenantSkipper.skip();
 *            return this.userMapper.list();
 *          }finally{
 *            //记得一定要清除线程上下文
 *            TenantSkipper.remove();
 *          }
 *      }
 * }
 * }
 * </pre>
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public final class TenantSkipper {

    private static ThreadLocal<Boolean> threadLocal = ThreadLocal.withInitial(() -> true);


    public static void skip() {
        log.debug("skip tenant plugin");
        threadLocal.set(false);
    }

    public static void remove() {
        log.debug("remove tenant thread context");
        threadLocal.remove();
    }

    protected static boolean use() {
        return threadLocal.get();
    }
}
