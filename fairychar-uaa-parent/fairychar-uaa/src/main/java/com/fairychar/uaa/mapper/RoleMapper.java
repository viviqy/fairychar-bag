package com.fairychar.uaa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.uaa.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Role)表数据库访问层
 *
 * @author chiyo
 * @since 2021-02-08 17:38:44
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 条件匹配查询Role所有数据
     *
     * @param role {@link Role}查询条件
     * @return 查询结果 {@link Role}
     */
    List<Role> queryAll(Role role);

    /**
     * 条件匹配分页查询Role所有数据
     *
     * @param page 分页参数
     * @param role {@link Role}查询条件
     * @return 查询结果 {@link Role}
     */
    IPage<Role> pageAll(@Param("page") Page page, @Param("role") Role role);

    /**
     * 条件匹配查询Role匹配数据总数
     *
     * @param role {@link Role}查询条件
     * @return 总数
     */
    int count(Role role);
}