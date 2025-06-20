package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.SysMenu;
import com.fairychar.security.core.rbac.pojo.dto.SysMenuDTO;
import com.fairychar.security.core.rbac.pojo.query.SysMenuQuery;

import java.io.Serializable;
import java.util.List;

/**
 * 系统菜单(SysMenu)表服务接口
 *
 * @author chiyo
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 条件匹配查询SysMenu单条数据
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 查询结果 {@link SysMenuDTO}
     */
    SysMenuDTO findOne(SysMenuQuery sysMenuQuery);

    /**
     * 条件匹配查询SysMenu所有数据
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 查询结果 {@link SysMenuDTO}
     */
    List<SysMenuDTO> queryAll(SysMenuQuery sysMenuQuery);

    /**
     * 条件匹配分页查询SysMenu所有数据
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 查询结果 {@link SysMenuDTO}
     */
    Page<SysMenuDTO> pageAll(SysMenuQuery sysMenuQuery);

    /**
     * 插入
     *
     * @param sysMenuQuery {@link SysMenuQuery}插入query
     * @return 是否成功
     */
    boolean save(SysMenuQuery sysMenuQuery);

    /**
     * 更新
     *
     * @param sysMenuQuery {@link SysMenuQuery}更新query
     * @return 是否成功
     */
    boolean updateById(SysMenuQuery sysMenuQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 查询结果 {@link SysMenuDTO}
     */
    Page<SysMenuDTO> page(SysMenuQuery sysMenuQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link SysMenuDTO}
     */
    SysMenuDTO findById(Serializable id);

    /**
     * 条件查询总数
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 总数
     */
    int count(SysMenuQuery sysMenuQuery);

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    boolean saveBatch(List<SysMenuQuery> batch);

    /**
     * 条件匹配查询SysMenu所有数据
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 查询结果 {@link SysMenuDTO}
     */
    List<SysMenuDTO> findAll(SysMenuQuery sysMenuQuery);

}
