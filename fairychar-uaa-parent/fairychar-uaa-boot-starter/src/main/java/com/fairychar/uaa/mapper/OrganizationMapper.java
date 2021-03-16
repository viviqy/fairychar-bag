package com.fairychar.uaa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.uaa.entity.Organization;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Organization)表数据库访问层
 *
 * @author chiyo
 * @since 2021-02-08 17:38:38
 */
public interface OrganizationMapper extends BaseMapper<Organization> {

    /**
     * 条件匹配查询Organization所有数据
     *
     * @param organization {@link Organization}查询条件
     * @return 查询结果 {@link Organization}
     */
    List<Organization> queryAll(Organization organization);

    /**
     * 条件匹配分页查询Organization所有数据
     *
     * @param page         分页参数
     * @param organization {@link Organization}查询条件
     * @return 查询结果 {@link Organization}
     */
    IPage<Organization> pageAll(@Param("page") Page page, @Param("organization") Organization organization);

    /**
     * 条件匹配查询Organization匹配数据总数
     *
     * @param organization {@link Organization}查询条件
     * @return 总数
     */
    int count(Organization organization);
}