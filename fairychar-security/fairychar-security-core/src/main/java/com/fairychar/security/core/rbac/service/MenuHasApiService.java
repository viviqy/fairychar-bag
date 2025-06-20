package com.fairychar.security.core.rbac.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.security.core.rbac.entity.MenuHasApi;
import com.fairychar.security.core.rbac.mapper.MenuHasApiMapper;
import com.fairychar.security.core.rbac.pojo.dto.MenuHasApiDTO;
import com.fairychar.security.core.rbac.pojo.query.MenuHasApiQuery;
import com.fairychar.security.core.rbac.service.interfaces.IMenuHasApiService;
import com.fairychar.security.core.rbac.service.structure.MenuHasApiStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * (MenuHasApi)表服务实现类
 *
 * @author chiyo
 */
@Service("menuHasApiService")
@Transactional(rollbackFor = Exception.class)
public class MenuHasApiService extends ServiceImpl<MenuHasApiMapper, MenuHasApi> implements IMenuHasApiService {
    @Autowired
    private MenuHasApiMapper menuHasApiMapper;
    @Autowired
    private MenuHasApiStructure menuHasApiStructure;

    /**
     * 条件全等匹配查询MenuHasApi单条数据
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 查询结果 {@link MenuHasApiDTO}
     */
    @Override
    public MenuHasApiDTO findOne(MenuHasApiQuery menuHasApiQuery) {
        MenuHasApi entity = this.menuHasApiStructure.queryToEntity(menuHasApiQuery);
        MenuHasApi one = super.getOne(new QueryWrapper<MenuHasApi>(entity));
        return this.menuHasApiStructure.entityToDto(one);
    }

    /**
     * 条件匹配查询MenuHasApi所有数据
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 查询结果 {@link MenuHasApiDTO}
     */
    @Override
    public List<MenuHasApiDTO> queryAll(MenuHasApiQuery menuHasApiQuery) {
        MenuHasApi entity = this.menuHasApiStructure.queryToEntity(menuHasApiQuery);
        List<MenuHasApi> list = this.menuHasApiMapper.queryAll(entity);
        return this.menuHasApiStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询MenuHasApi所有数据
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 查询结果 {@link MenuHasApiDTO}
     */
    @Override
    public Page<MenuHasApiDTO> pageAll(MenuHasApiQuery menuHasApiQuery) {
        MenuHasApi entity = this.menuHasApiStructure.queryToEntity(menuHasApiQuery);
        Page<MenuHasApi> queries = this.menuHasApiMapper.pageAll(menuHasApiQuery.getPageQuery(), entity);
        List<MenuHasApiDTO> dtos = this.menuHasApiStructure.entitiesToDtos(queries.getRecords());
        Page<MenuHasApiDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean save(MenuHasApiQuery menuHasApiQuery) {
        MenuHasApi entity = this.menuHasApiStructure.queryToEntity(menuHasApiQuery);
        return this.save(entity);
    }

    /**
     * 更新
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean updateById(MenuHasApiQuery menuHasApiQuery) {
        MenuHasApi entity = this.menuHasApiStructure.queryToEntity(menuHasApiQuery);
        return super.updateById(entity);
    }

    /**
     * 分页查询(全等匹配)
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 查询结果 {@link MenuHasApiDTO}
     */
    @Override
    public Page<MenuHasApiDTO> page(MenuHasApiQuery menuHasApiQuery) {
        MenuHasApi entity = this.menuHasApiStructure.queryToEntity(menuHasApiQuery);
        return super.page(menuHasApiQuery.getPageQuery(), new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(MenuHasApiQuery menuHasApiQuery) {
        MenuHasApi entity = this.menuHasApiStructure.queryToEntity(menuHasApiQuery);
        return this.menuHasApiMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     * @param id id
     * @return 查询结果 {@link MenuHasApiDTO}
     */
    @Override
    public MenuHasApiDTO findById(Serializable id) {
        MenuHasApiDTO one = this.menuHasApiStructure.entityToDto(this.getById(id));
        return one;
    }

    /**
     * 批量新增
     * @param batch 新增数据 
     * @return 是否成功
     */
    @Override
    public boolean saveBatch(List<MenuHasApiQuery> batch) {
        List<MenuHasApi> entities = this.menuHasApiStructure.queriesToEntities(batch);
        return super.saveBatch(entities);
    }

    /**
     * 条件全等匹配查询MenuHasApi所有数据
     *
     * @param menuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 查询结果 {@link MenuHasApiDTO}
     */
    @Override
    public List<MenuHasApiDTO> findAll(MenuHasApiQuery menuHasApiQuery) {
        MenuHasApi entity = this.menuHasApiStructure.queryToEntity(menuHasApiQuery);
        List<MenuHasApi> list = super.list(new QueryWrapper<MenuHasApi>(entity));
        return this.menuHasApiStructure.entitiesToDtos(list);
    }
}
