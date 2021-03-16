package com.fairychar.uaa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.uaa.entity.OrganizationCustomer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (OrganizationCustomer)表数据库访问层
 *
 * @author chiyo
 * @since 2021-02-08 17:38:41
 */
public interface OrganizationCustomerMapper extends BaseMapper<OrganizationCustomer> {

    /**
     * 条件匹配查询OrganizationCustomer所有数据
     *
     * @param organizationCustomer {@link OrganizationCustomer}查询条件
     * @return 查询结果 {@link OrganizationCustomer}
     */
    List<OrganizationCustomer> queryAll(OrganizationCustomer organizationCustomer);

    /**
     * 条件匹配分页查询OrganizationCustomer所有数据
     *
     * @param page                 分页参数
     * @param organizationCustomer {@link OrganizationCustomer}查询条件
     * @return 查询结果 {@link OrganizationCustomer}
     */
    IPage<OrganizationCustomer> pageAll(@Param("page") Page page, @Param("organizationCustomer") OrganizationCustomer organizationCustomer);

    /**
     * 条件匹配查询OrganizationCustomer匹配数据总数
     *
     * @param organizationCustomer {@link OrganizationCustomer}查询条件
     * @return 总数
     */
    int count(OrganizationCustomer organizationCustomer);
}