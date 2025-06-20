package com.fairychar.security.core.rbac.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.security.core.rbac.entity.SysApi;
import com.fairychar.security.core.rbac.pojo.query.AddSysApiQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysApi)表数据库访问层
 *
 * @author chiyo
 */
public interface SysApiMapper extends BaseMapper<SysApi> {


    /**
     * 条件匹配查询SysApi单条数据
     *
     * @param sysApi {@see SysApi}查询条件
     * @return 查询结果 {@see SysApi}
     */
    SysApi queryOne(@Param("e") SysApi sysApi);

    /**
     * 条件匹配查询SysApi单条数据指定column
     *
     * @param sysApi {@see SysApi}查询条件
     * @return 查询结果 {@see SysApi}
     */
    SysApi queryOneSelective(@Param("fields") String[] fields, @Param("e") SysApi sysApi);

    /**
     * 条件匹配查询SysApi所有数据
     *
     * @param sysApi {@see SysApi}查询条件
     * @return 查询结果 {@see SysApi}
     */
    List<SysApi> queryAll(@Param("e") SysApi sysApi);

    /**
     * 条件匹配查询SysApi所有数据指定column
     *
     * @param sysApi {@see SysApi}查询条件
     * @return 查询结果 {@see SysApi}
     */
    List<SysApi> queryAllSelective(@Param("fields") String[] fields, @Param("e") SysApi sysApi);

    /**
     * 条件匹配分页查询SysApi所有数据
     *
     * @param page   分页参数
     * @param sysApi {@see SysApi}查询条件
     * @return 查询结果 {@see SysApi}
     */
    Page<SysApi> pageAll(@Param("page") IPage page, @Param("e") SysApi sysApi);

    /**
     * 条件匹配分页查询SysApi所有数据指定column
     *
     * @param page   分页参数
     * @param sysApi {@see SysApi}查询条件
     * @return 查询结果 {@see SysApi}
     */
    Page<SysApi> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") SysApi sysApi);

    /**
     * 条件匹配查询SysApi匹配数据总数
     *
     * @param sysApi {@see SysApi}查询条件
     * @return 总数
     */
    int count(@Param("e") SysApi sysApi);

    /**
     * 根据指定字段分组
     *
     * @param fields 分组字段集
     * @return {@see SysApi}数据集
     */
    List<SysApi> countGroupBy(@Param("fields") String fields);

    void insertBatch(@Param("list") List<SysApi> entities);

    List<SysApi> listByMethodAndUri(@Param("list") List<AddSysApiQuery> batch);
}
