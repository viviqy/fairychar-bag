package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.MenuHasApi;
import com.fairychar.security.core.rbac.pojo.dto.MenuHasApiDTO;
import com.fairychar.security.core.rbac.pojo.query.MenuHasApiQuery;

import java.io.Serializable;
import java.util.List;

/**
 * (MenuHasApi)表服务接口
 *
 * @author chiyo
 */
public interface IMenuHasApiService extends IService<MenuHasApi> {

    /**
     * 条件匹配查询MenuHasApi单条数据
     *
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 查询结果 {@link MenuHasApiDTO}
     */
    MenuHasApiDTO findOne(MenuHasApiQuery menuHasApiQuery);

    /**
     * 条件匹配查询MenuHasApi所有数据
     *
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 查询结果 {@link MenuHasApiDTO}
     */
    List<MenuHasApiDTO> queryAll(MenuHasApiQuery menuHasApiQuery);

    /**
     * 条件匹配分页查询MenuHasApi所有数据
     *
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 查询结果 {@link MenuHasApiDTO}
     */
    Page<MenuHasApiDTO> pageAll(MenuHasApiQuery menuHasApiQuery);

    /**
     * 插入
     *
     * @param menuHasApiQuery {@link MenuHasApiQuery}插入query
     * @return 是否成功
     */
    boolean save(MenuHasApiQuery menuHasApiQuery);

    /**
     * 更新
     *
     * @param menuHasApiQuery {@link MenuHasApiQuery}更新query
     * @return 是否成功
     */
    boolean updateById(MenuHasApiQuery menuHasApiQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 查询结果 {@link MenuHasApiDTO}
     */
    Page<MenuHasApiDTO> page(MenuHasApiQuery menuHasApiQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link MenuHasApiDTO}
     */
    MenuHasApiDTO findById(Serializable id);

    /**
     * 条件查询总数
     *
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 总数
     */
    int count(MenuHasApiQuery menuHasApiQuery);

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    boolean saveBatch(List<MenuHasApiQuery> batch);

    /**
     * 条件匹配查询MenuHasApi所有数据
     *
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 查询结果 {@link MenuHasApiDTO}
     */
    List<MenuHasApiDTO> findAll(MenuHasApiQuery menuHasApiQuery);

}
