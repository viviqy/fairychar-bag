package com.fairychar.security.core.rbac.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.security.core.rbac.entity.RoleHasMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色菜单关联(RoleHasMenu)表数据库访问层
 *
 * @author chiyo
 */
public interface RoleHasMenuMapper extends BaseMapper<RoleHasMenu> {


    /**
     * 条件匹配查询RoleHasMenu单条数据
     *
     * @param roleHasMenu {@see RoleHasMenu}查询条件
     * @return 查询结果 {@see RoleHasMenu}
     */
    RoleHasMenu queryOne(@Param("e") RoleHasMenu roleHasMenu);

    /**
     * 条件匹配查询RoleHasMenu单条数据指定column
     *
     * @param roleHasMenu {@see RoleHasMenu}查询条件
     * @return 查询结果 {@see RoleHasMenu}
     */
    RoleHasMenu queryOneSelective(@Param("fields") String[] fields, @Param("e") RoleHasMenu roleHasMenu);

    /**
     * 条件匹配查询RoleHasMenu所有数据
     *
     * @param roleHasMenu {@see RoleHasMenu}查询条件
     * @return 查询结果 {@see RoleHasMenu}
     */
    List<RoleHasMenu> queryAll(@Param("e") RoleHasMenu roleHasMenu);

    /**
     * 条件匹配查询RoleHasMenu所有数据指定column
     *
     * @param roleHasMenu {@see RoleHasMenu}查询条件
     * @return 查询结果 {@see RoleHasMenu}
     */
    List<RoleHasMenu> queryAllSelective(@Param("fields") String[] fields, @Param("e") RoleHasMenu roleHasMenu);

    /**
     * 条件匹配分页查询RoleHasMenu所有数据
     *
     * @param page        分页参数
     * @param roleHasMenu {@see RoleHasMenu}查询条件
     * @return 查询结果 {@see RoleHasMenu}
     */
    Page<RoleHasMenu> pageAll(@Param("page") IPage page, @Param("e") RoleHasMenu roleHasMenu);

    /**
     * 条件匹配分页查询RoleHasMenu所有数据指定column
     *
     * @param page        分页参数
     * @param roleHasMenu {@see RoleHasMenu}查询条件
     * @return 查询结果 {@see RoleHasMenu}
     */
    Page<RoleHasMenu> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") RoleHasMenu roleHasMenu);

    /**
     * 条件匹配查询RoleHasMenu匹配数据总数
     *
     * @param roleHasMenu {@see RoleHasMenu}查询条件
     * @return 总数
     */
    int count(@Param("e") RoleHasMenu roleHasMenu);

    /**
     * 根据指定字段分组
     *
     * @param fields 分组字段集
     * @return {@see RoleHasMenu}数据集
     */
    List<RoleHasMenu> countGroupBy(@Param("fields") String fields);

    void insertBatch(@Param("list") List<RoleHasMenu> entities);
}
