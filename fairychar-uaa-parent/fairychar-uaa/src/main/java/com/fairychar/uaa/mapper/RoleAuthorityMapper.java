package com.fairychar.uaa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.uaa.entity.RoleAuthority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (RoleAuthority)表数据库访问层
 *
 * @author chiyo
 * @since 2021-02-08 17:38:47
 */
public interface RoleAuthorityMapper extends BaseMapper<RoleAuthority> {

    /**
     * 条件匹配查询RoleAuthority所有数据
     *
     * @param roleAuthority {@link RoleAuthority}查询条件
     * @return 查询结果 {@link RoleAuthority}
     */
    List<RoleAuthority> queryAll(RoleAuthority roleAuthority);

    /**
     * 条件匹配分页查询RoleAuthority所有数据
     *
     * @param page          分页参数
     * @param roleAuthority {@link RoleAuthority}查询条件
     * @return 查询结果 {@link RoleAuthority}
     */
    IPage<RoleAuthority> pageAll(@Param("page") Page page, @Param("roleAuthority") RoleAuthority roleAuthority);

    /**
     * 条件匹配查询RoleAuthority匹配数据总数
     *
     * @param roleAuthority {@link RoleAuthority}查询条件
     * @return 总数
     */
    int count(RoleAuthority roleAuthority);
}