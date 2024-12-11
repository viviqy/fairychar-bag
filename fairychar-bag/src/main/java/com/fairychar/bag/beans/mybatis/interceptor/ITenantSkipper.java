package com.fairychar.bag.beans.mybatis.interceptor;

/**
 * <p>是否使用自动租户控制器</p>
 * 通过{@link ITenantSkipper#setSkip}在执行sql之前,可以
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
public interface ITenantSkipper {


    /**
     * 是否跳过租户
     *
     * @param skip 跳
     */
    void setSkip(boolean skip);

    /**
     * 清除是否跳过上下文
     */
    void cleanContext();

    /**
     * 是否使用租户
     *
     * @return boolean
     */
    boolean getSkip();
}
