package com.fairychar.bag.beans.mybatis.interceptor;

/**
 * <p>mybatis 租户是否启用选择器</p>
 * 配合{@link SwitchableTenantLineInnerInterceptor}使用
 * 把这个参数放到mapper方法参数里面任意位置,在执行此mapper方法时
 * 将会读取{@link ITenantSwitcher#use()}方法,如果返回true代表使用租户
 * 插件,false代表绕过租户插件,对于同一个mapper方法有些场景下需要
 * 自动租户,而有些场景不需要能得到更好的控制
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
public interface ITenantSwitcher {

    /**
     * 是否使用租户
     *
     * @return boolean
     */
    boolean use();
}
