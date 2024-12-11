package com.fairychar.bag.beans.mybatis.interceptor;

import com.baomidou.mybatisplus.core.plugins.InterceptorIgnoreHelper;
import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.SQLException;

/**
 * <p>可自定义是否跳过动态选择是否使用mybatis自动租户插件的拦截器</p>
 *
 * @author chiyo
 * @since 1.0.2
 */
//TODO 还没怎么测试
public class SkipableTenantLineInnerInterceptor extends TenantLineInnerInterceptor {

    private ITenantSkipper tenantSkipper;

    public SkipableTenantLineInnerInterceptor(TenantLineHandler tenantLineHandler) {
        super(tenantLineHandler);
        this.tenantSkipper = new SimpleTenantSkipper();
    }

    public SkipableTenantLineInnerInterceptor(TenantLineHandler tenantLineHandler, ITenantSkipper tenantSkipper) {
        super(tenantLineHandler);
        this.tenantSkipper = tenantSkipper;
    }


    @Override
    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds
            , ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        if (InterceptorIgnoreHelper.willIgnoreTenantLine(ms.getId())) {
            return;
        }
        if (this.tenantSkipper.getSkip()) {
            return;
        }
        PluginUtils.MPBoundSql mpBs = PluginUtils.mpBoundSql(boundSql);
        mpBs.sql(parserSingle(mpBs.sql(), null));
    }

}
