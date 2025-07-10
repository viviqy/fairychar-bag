package com.fairychar.security.core.rbac.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.security.core.rbac.entity.MenuHasApi;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (MenuHasApi)表数据库访问层
 *
 * @author chiyo
 */
public interface MenuHasApiMapper extends BaseMapper<MenuHasApi> {


    /**
     * 条件匹配查询MenuHasApi单条数据
     *
     * @param menuHasApi {@see MenuHasApi}查询条件
     * @return 查询结果 {@see MenuHasApi}
     */
    MenuHasApi queryOne(@Param("e") MenuHasApi menuHasApi);

    /**
     * 条件匹配查询MenuHasApi单条数据指定column
     *
     * @param menuHasApi {@see MenuHasApi}查询条件
     * @return 查询结果 {@see MenuHasApi}
     */
    MenuHasApi queryOneSelective(@Param("fields") String[] fields, @Param("e") MenuHasApi menuHasApi);

    /**
     * 条件匹配查询MenuHasApi所有数据
     *
     * @param menuHasApi {@see MenuHasApi}查询条件
     * @return 查询结果 {@see MenuHasApi}
     */
    List<MenuHasApi> queryAll(@Param("e") MenuHasApi menuHasApi);

    /**
     * 条件匹配查询MenuHasApi所有数据指定column
     *
     * @param menuHasApi {@see MenuHasApi}查询条件
     * @return 查询结果 {@see MenuHasApi}
     */
    List<MenuHasApi> queryAllSelective(@Param("fields") String[] fields, @Param("e") MenuHasApi menuHasApi);

    /**
     * 条件匹配分页查询MenuHasApi所有数据
     *
     * @param page       分页参数
     * @param menuHasApi {@see MenuHasApi}查询条件
     * @return 查询结果 {@see MenuHasApi}
     */
    Page<MenuHasApi> pageAll(@Param("page") IPage page, @Param("e") MenuHasApi menuHasApi);

    /**
     * 条件匹配分页查询MenuHasApi所有数据指定column
     *
     * @param page       分页参数
     * @param menuHasApi {@see MenuHasApi}查询条件
     * @return 查询结果 {@see MenuHasApi}
     */
    Page<MenuHasApi> pageAllSelective(@Param("fields") String[] fields, @Param("page") IPage page, @Param("e") MenuHasApi menuHasApi);

    /**
     * 条件匹配查询MenuHasApi匹配数据总数
     *
     * @param menuHasApi {@see MenuHasApi}查询条件
     * @return 总数
     */
    int count(@Param("e") MenuHasApi menuHasApi);

    /**
     * 根据指定字段分组
     *
     * @param fields 分组字段集
     * @return {@see MenuHasApi}数据集
     */
    List<MenuHasApi> countGroupBy(@Param("fields") String fields);

    void insertBatch(@Param("list") List<MenuHasApi> entities);

    List<MenuHasApi> listByMenuIdAndApiId(@Param("list") List<MenuHasApi> entities);
}
