package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.RoleHasMenu;
import com.fairychar.security.core.rbac.pojo.dto.RoleHasMenuDTO;
import com.fairychar.security.core.rbac.pojo.query.RoleHasMenuQuery;

import java.io.Serializable;
import java.util.List;

/**
 * 角色菜单关联(RoleHasMenu)表服务接口
 *
 * @author chiyo
 */
public interface IRoleHasMenuService extends IService<RoleHasMenu> {

    /**
     * 条件匹配查询RoleHasMenu单条数据
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 查询结果 {@link RoleHasMenuDTO}
     */
    RoleHasMenuDTO findOne(RoleHasMenuQuery roleHasMenuQuery);

    /**
     * 条件匹配查询RoleHasMenu所有数据
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 查询结果 {@link RoleHasMenuDTO}
     */
    List<RoleHasMenuDTO> queryAll(RoleHasMenuQuery roleHasMenuQuery);

    /**
     * 条件匹配分页查询RoleHasMenu所有数据
     *
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 查询结果 {@link RoleHasMenuDTO}
     */
    Page<RoleHasMenuDTO> pageAll(RoleHasMenuQuery roleHasMenuQuery);

    /**
     * 插入
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}插入query
     * @return 是否成功
     */
    boolean save(RoleHasMenuQuery roleHasMenuQuery);

    /**
     * 更新
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}更新query
     * @return 是否成功
     */
    boolean updateById(RoleHasMenuQuery roleHasMenuQuery);

    /**
     * 分页查询(全等匹配)
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 查询结果 {@link RoleHasMenuDTO}
     */
    Page<RoleHasMenuDTO> page(RoleHasMenuQuery roleHasMenuQuery);

    /**
     * 根据id查询一个对象
     * @param id id
     * @return 查询结果 {@link RoleHasMenuDTO}
     */
    RoleHasMenuDTO findById(Serializable id);

    /**
     * 条件查询总数
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 总数
     */
    int count(RoleHasMenuQuery roleHasMenuQuery);

    /**
     * 批量新增
     * @param batch 新增数据 
     * @return 是否成功
     */
    boolean saveBatch(List<RoleHasMenuQuery> batch);

    /**
     * 条件匹配查询RoleHasMenu所有数据
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 查询结果 {@link RoleHasMenuDTO}
     */
    List<RoleHasMenuDTO> findAll(RoleHasMenuQuery roleHasMenuQuery);

}
