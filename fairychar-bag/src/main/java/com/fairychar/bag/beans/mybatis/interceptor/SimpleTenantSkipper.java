package com.fairychar.bag.beans.mybatis.interceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>是否使用自动租户控制器</p>
 * 通过{@link SimpleTenantSkipper#setSkip}在执行sql之前,可以
 * 绕过自动租户插件对拼接租户流程的执行.需要配合{@link SkipableTenantLineInnerInterceptor}使用
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
@Slf4j
public class SimpleTenantSkipper implements ITenantSkipper {

    private static final ThreadLocal<Boolean> THREAD_LOCAL = ThreadLocal.withInitial(() -> true);


    @Override
    public void setSkip(boolean skip) {
        log.debug("skip tenant plugin");
        THREAD_LOCAL.set(skip);
    }

    @Override
    public void cleanContext() {
        log.debug("remove tenant thread context");
        THREAD_LOCAL.remove();
    }

    @Override
    public boolean getSkip() {
        return THREAD_LOCAL.get();
    }
}
