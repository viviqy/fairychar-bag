package com.fairychar.security.core.rbac.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.security.core.rbac.entity.SystemRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色表(SystemRole)表数据库访问层
 *
 * @author chiyo
 */
public interface SystemRoleMapper extends BaseMapper<SystemRole> {


    /**
     * 条件匹配查询SystemRole单条数据
     *
     * @param systemRole {@see SystemRole}查询条件
     * @return 查询结果 {@see SystemRole}
     */
    SystemRole queryOne(@Param("e") SystemRole systemRole);

    /**
     * 条件匹配查询SystemRole单条数据指定column
     *
     * @param systemRole {@see SystemRole}查询条件
     * @return 查询结果 {@see SystemRole}
     */
    SystemRole queryOneSelective(@Param("fields") String[] fields, @Param("e") SystemRole systemRole);

    /**
     * 条件匹配查询SystemRole所有数据
     *
     * @param systemRole {@see SystemRole}查询条件
     * @return 查询结果 {@see SystemRole}
     */
    List<SystemRole> queryAll(@Param("e") SystemRole systemRole);

    /**
     * 条件匹配查询SystemRole所有数据指定column
     *
     * @param systemRole {@see SystemRole}查询条件
     * @return 查询结果 {@see SystemRole}
     */
    List<SystemRole> queryAllSelective(@Param("fields") String[] fields, @Param("e") SystemRole systemRole);

    /**
     * 条件匹配分页查询SystemRole所有数据
     *
     * @param page       分页参数
     * @param systemRole {@see SystemRole}查询条件
     * @return 查询结果 {@see SystemRole}
     */
    Page<SystemRole> pageAll(@Param("page") IPage page, @Param("e") SystemRole systemRole);

    /**
     * 条件匹配分页查询SystemRole所有数据指定column
     *
     * @param page       分页参数
     * @param systemRole {@see SystemRole}查询条件
     * @return 查询结果 {@see SystemRole}
     */
    Page<SystemRole> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") SystemRole systemRole);

    /**
     * 条件匹配查询SystemRole匹配数据总数
     *
     * @param systemRole {@see SystemRole}查询条件
     * @return 总数
     */
    int count(@Param("e") SystemRole systemRole);

    /**
     * 根据指定字段分组
     *
     * @param fields 分组字段集
     * @return {@see SystemRole}数据集
     */
    List<SystemRole> countGroupBy(@Param("fields") String fields);

    void insertBatch(@Param("list") List<SystemRole> entities);
}
