package com.fairychar.security.core.rbac.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.security.core.rbac.entity.SystemUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统用户(SystemUser)表数据库访问层
 *
 * @author chiyo
 */
public interface SystemUserMapper extends BaseMapper<SystemUser> {


    /**
     * 条件匹配查询SystemUser单条数据
     *
     * @param systemUser {@see SystemUser}查询条件
     * @return 查询结果 {@see SystemUser}
     */
    SystemUser queryOne(@Param("e") SystemUser systemUser);

    /**
     * 条件匹配查询SystemUser单条数据指定column
     *
     * @param systemUser {@see SystemUser}查询条件
     * @return 查询结果 {@see SystemUser}
     */
    SystemUser queryOneSelective(@Param("fields") String[] fields, @Param("e") SystemUser systemUser);

    /**
     * 条件匹配查询SystemUser所有数据
     *
     * @param systemUser {@see SystemUser}查询条件
     * @return 查询结果 {@see SystemUser}
     */
    List<SystemUser> queryAll(@Param("e") SystemUser systemUser);

    /**
     * 条件匹配查询SystemUser所有数据指定column
     *
     * @param systemUser {@see SystemUser}查询条件
     * @return 查询结果 {@see SystemUser}
     */
    List<SystemUser> queryAllSelective(@Param("fields") String[] fields, @Param("e") SystemUser systemUser);

    /**
     * 条件匹配分页查询SystemUser所有数据
     *
     * @param page       分页参数
     * @param systemUser {@see SystemUser}查询条件
     * @return 查询结果 {@see SystemUser}
     */
    Page<SystemUser> pageAll(@Param("page") IPage page, @Param("e") SystemUser systemUser);

    /**
     * 条件匹配分页查询SystemUser所有数据指定column
     *
     * @param page       分页参数
     * @param systemUser {@see SystemUser}查询条件
     * @return 查询结果 {@see SystemUser}
     */
    Page<SystemUser> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") SystemUser systemUser);

    /**
     * 条件匹配查询SystemUser匹配数据总数
     *
     * @param systemUser {@see SystemUser}查询条件
     * @return 总数
     */
    int count(@Param("e") SystemUser systemUser);

    /**
     * 根据指定字段分组
     *
     * @param fields 分组字段集
     * @return {@see SystemUser}数据集
     */
    List<SystemUser> countGroupBy(@Param("fields") String fields);

    void insertBatch(@Param("list") List<SystemUser> entities);
}
