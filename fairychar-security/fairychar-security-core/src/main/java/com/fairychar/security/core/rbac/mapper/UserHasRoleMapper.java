package com.fairychar.security.core.rbac.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.security.core.rbac.entity.UserHasRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色关联(UserHasRole)表数据库访问层
 *
 * @author chiyo
 */
public interface UserHasRoleMapper extends BaseMapper<UserHasRole> {


    /**
     * 条件匹配查询UserHasRole单条数据
     *
     * @param userHasRole {@see UserHasRole}查询条件
     * @return 查询结果 {@see UserHasRole}
     */
    UserHasRole queryOne(@Param("e") UserHasRole userHasRole);

    /**
     * 条件匹配查询UserHasRole单条数据指定column
     *
     * @param userHasRole {@see UserHasRole}查询条件
     * @return 查询结果 {@see UserHasRole}
     */
    UserHasRole queryOneSelective(@Param("fields") String[] fields, @Param("e") UserHasRole userHasRole);

    /**
     * 条件匹配查询UserHasRole所有数据
     *
     * @param userHasRole {@see UserHasRole}查询条件
     * @return 查询结果 {@see UserHasRole}
     */
    List<UserHasRole> queryAll(@Param("e") UserHasRole userHasRole);

    /**
     * 条件匹配查询UserHasRole所有数据指定column
     *
     * @param userHasRole {@see UserHasRole}查询条件
     * @return 查询结果 {@see UserHasRole}
     */
    List<UserHasRole> queryAllSelective(@Param("fields") String[] fields, @Param("e") UserHasRole userHasRole);

    /**
     * 条件匹配分页查询UserHasRole所有数据
     *
     * @param page        分页参数
     * @param userHasRole {@see UserHasRole}查询条件
     * @return 查询结果 {@see UserHasRole}
     */
    Page<UserHasRole> pageAll(@Param("page") IPage page, @Param("e") UserHasRole userHasRole);

    /**
     * 条件匹配分页查询UserHasRole所有数据指定column
     *
     * @param page        分页参数
     * @param userHasRole {@see UserHasRole}查询条件
     * @return 查询结果 {@see UserHasRole}
     */
    Page<UserHasRole> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") UserHasRole userHasRole);

    /**
     * 条件匹配查询UserHasRole匹配数据总数
     *
     * @param userHasRole {@see UserHasRole}查询条件
     * @return 总数
     */
    int count(@Param("e") UserHasRole userHasRole);

    /**
     * 根据指定字段分组
     *
     * @param fields 分组字段集
     * @return {@see UserHasRole}数据集
     */
    List<UserHasRole> countGroupBy(@Param("fields") String fields);

    void insertBatch(@Param("list") List<UserHasRole> entities);

    List<UserHasRole> listByUserIdAndRoleId(@Param("list") List<UserHasRole> entities);
}
