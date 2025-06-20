package com.fairychar.security.core.rbac.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.security.core.rbac.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统菜单(SysMenu)表数据库访问层
 *
 * @author chiyo
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {


    /**
     * 条件匹配查询SysMenu单条数据
     *
     * @param sysMenu {@see SysMenu}查询条件
     * @return 查询结果 {@see SysMenu}
     */
    SysMenu queryOne(@Param("e") SysMenu sysMenu);

    /**
     * 条件匹配查询SysMenu单条数据指定column
     *
     * @param sysMenu {@see SysMenu}查询条件
     * @return 查询结果 {@see SysMenu}
     */
    SysMenu queryOneSelective(@Param("fields") String[] fields, @Param("e") SysMenu sysMenu);

    /**
     * 条件匹配查询SysMenu所有数据
     *
     * @param sysMenu {@see SysMenu}查询条件
     * @return 查询结果 {@see SysMenu}
     */
    List<SysMenu> queryAll(@Param("e") SysMenu sysMenu);

    /**
     * 条件匹配查询SysMenu所有数据指定column
     *
     * @param sysMenu {@see SysMenu}查询条件
     * @return 查询结果 {@see SysMenu}
     */
    List<SysMenu> queryAllSelective(@Param("fields") String[] fields, @Param("e") SysMenu sysMenu);

    /**
     * 条件匹配分页查询SysMenu所有数据
     *
     * @param page    分页参数
     * @param sysMenu {@see SysMenu}查询条件
     * @return 查询结果 {@see SysMenu}
     */
    Page<SysMenu> pageAll(@Param("page") IPage page, @Param("e") SysMenu sysMenu);

    /**
     * 条件匹配分页查询SysMenu所有数据指定column
     *
     * @param page    分页参数
     * @param sysMenu {@see SysMenu}查询条件
     * @return 查询结果 {@see SysMenu}
     */
    Page<SysMenu> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") SysMenu sysMenu);

    /**
     * 条件匹配查询SysMenu匹配数据总数
     *
     * @param sysMenu {@see SysMenu}查询条件
     * @return 总数
     */
    int count(@Param("e") SysMenu sysMenu);

    /**
     * 根据指定字段分组
     *
     * @param fields 分组字段集
     * @return {@see SysMenu}数据集
     */
    List<SysMenu> countGroupBy(@Param("fields") String fields);

    void insertBatch(@Param("list") List<SysMenu> entities);
}
