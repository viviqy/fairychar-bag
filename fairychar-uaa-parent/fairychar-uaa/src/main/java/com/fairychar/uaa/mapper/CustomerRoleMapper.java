package com.fairychar.uaa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.uaa.entity.CustomerRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (CustomerRole)表数据库访问层
 *
 * @author chiyo
 * @since 2021-02-08 17:38:34
 */
public interface CustomerRoleMapper extends BaseMapper<CustomerRole> {

    /**
     * 条件匹配查询CustomerRole所有数据
     *
     * @param customerRole {@link CustomerRole}查询条件
     * @return 查询结果 {@link CustomerRole}
     */
    List<CustomerRole> queryAll(CustomerRole customerRole);

    /**
     * 条件匹配分页查询CustomerRole所有数据
     *
     * @param page         分页参数
     * @param customerRole {@link CustomerRole}查询条件
     * @return 查询结果 {@link CustomerRole}
     */
    IPage<CustomerRole> pageAll(@Param("page") Page page, @Param("customerRole") CustomerRole customerRole);

    /**
     * 条件匹配查询CustomerRole匹配数据总数
     *
     * @param customerRole {@link CustomerRole}查询条件
     * @return 总数
     */
    int count(CustomerRole customerRole);
}