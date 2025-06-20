package com.fairychar.security.core.rbac.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.security.core.rbac.entity.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据字典详情(SysDict)表数据库访问层
 *
 * @author chiyo
 */
public interface SysDictMapper extends BaseMapper<SysDict> {


    /**
     * 条件匹配查询SysDict单条数据
     *
     * @param sysDict {@see SysDict}查询条件
     * @return 查询结果 {@see SysDict}
     */
    SysDict queryOne(@Param("e") SysDict sysDict);

    /**
     * 条件匹配查询SysDict单条数据指定column
     *
     * @param sysDict {@see SysDict}查询条件
     * @return 查询结果 {@see SysDict}
     */
    SysDict queryOneSelective(@Param("fields") String[] fields, @Param("e") SysDict sysDict);

    /**
     * 条件匹配查询SysDict所有数据
     *
     * @param sysDict {@see SysDict}查询条件
     * @return 查询结果 {@see SysDict}
     */
    List<SysDict> queryAll(@Param("e") SysDict sysDict);

    /**
     * 条件匹配查询SysDict所有数据指定column
     *
     * @param sysDict {@see SysDict}查询条件
     * @return 查询结果 {@see SysDict}
     */
    List<SysDict> queryAllSelective(@Param("fields") String[] fields, @Param("e") SysDict sysDict);

    /**
     * 条件匹配分页查询SysDict所有数据
     *
     * @param page    分页参数
     * @param sysDict {@see SysDict}查询条件
     * @return 查询结果 {@see SysDict}
     */
    Page<SysDict> pageAll(@Param("page") IPage page, @Param("e") SysDict sysDict);

    /**
     * 条件匹配分页查询SysDict所有数据指定column
     *
     * @param page    分页参数
     * @param sysDict {@see SysDict}查询条件
     * @return 查询结果 {@see SysDict}
     */
    Page<SysDict> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") SysDict sysDict);

    /**
     * 条件匹配查询SysDict匹配数据总数
     *
     * @param sysDict {@see SysDict}查询条件
     * @return 总数
     */
    int count(@Param("e") SysDict sysDict);

    /**
     * 根据指定字段分组
     *
     * @param fields 分组字段集
     * @return {@see SysDict}数据集
     */
    List<SysDict> countGroupBy(@Param("fields") String fields);

    void insertBatch(@Param("list") List<SysDict> entities);
}
