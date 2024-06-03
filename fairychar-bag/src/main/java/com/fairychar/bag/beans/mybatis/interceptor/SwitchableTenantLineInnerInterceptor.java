package com.fairychar.bag.beans.mybatis.interceptor;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.plugins.InterceptorIgnoreHelper;
import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.SQLException;
import java.util.Map;

/**
 * <p>可动态选择是否使用mybatis自动租户插件的拦截器</p>
 * 通过在mapper参数里设置{@link ITenantSwitcher}动态配置方法是否
 * 使用自动租户插件.
 * 使用例子
 * <pre>
 * {@code
 * public class UserMapper{
 *     //switcher可以出现在参数任意位置,缺省代表使用自动租户,设置多个取第一个生效
 *     List<User> getUsers(@param("e") UserEntity entity,ITenantSwitcher switcher);
 * }
 * @Service
 * public class UserService{
 *     @Autowired
 *     private UserMapper userMapper;
 *
 *     public void test(){
 *         //代表不使用自动租户插件
 *         userMapper.getUsers(new UserEntity(),new TenantTenantSwitcher(false));
 *         //代表使用自动租户插件
 *         userMapper.getUsers(new UserEntity(),new TenantTenantSwitcher(true));
 *     }
 *
 * }
 * }
 * </pre>
 *
 * @author chiyo
 * @since 1.0.2
 */
public class SwitchableTenantLineInnerInterceptor extends TenantLineInnerInterceptor {

    public SwitchableTenantLineInnerInterceptor(TenantLineHandler tenantLineHandler) {
        super(tenantLineHandler);
    }


    @Override
    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        if (InterceptorIgnoreHelper.willIgnoreTenantLine(ms.getId())) {
            return;
        }
        if (!useTenant(parameter)) return;
        PluginUtils.MPBoundSql mpBs = PluginUtils.mpBoundSql(boundSql);
        mpBs.sql(parserSingle(mpBs.sql(), null));
    }

    private static boolean useTenant(Object parameter) {
        if (parameter != null && parameter instanceof MapperMethod.ParamMap) {
            for (Map.Entry<String, ?> entry : ((MapperMethod.ParamMap<?>) parameter).entrySet()) {
                if (entry.getValue() instanceof ITenantSwitcher) {
                    ITenantSwitcher tenantSwitcher = (ITenantSwitcher) entry.getValue();
                    Assert.notNull(tenantSwitcher, () -> new MybatisPlusException("Tenant switcher cannot be null"));
                    if (!tenantSwitcher.use()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
