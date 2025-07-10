package com.fairychar.security.core.rbac.service;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.domain.exceptions.RestException;
import com.fairychar.security.core.rbac.entity.MenuHasApi;
import com.fairychar.security.core.rbac.mapper.MenuHasApiMapper;
import com.fairychar.security.core.rbac.pojo.dto.MenuHasApiDTO;
import com.fairychar.security.core.rbac.pojo.query.AddMenuHasApiQuery;
import com.fairychar.security.core.rbac.pojo.query.MenuHasApiQuery;
import com.fairychar.security.core.rbac.service.interfaces.IMenuHasApiService;
import com.fairychar.security.core.rbac.service.structure.MenuHasApiStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (MenuHasApi)表服务实现类
 *
 * @author chiyo
 */
@Service("menuHasApiService")
public class MenuHasApiService extends ServiceImpl<MenuHasApiMapper, MenuHasApi> implements IMenuHasApiService {
    @Autowired
    private MenuHasApiMapper menuHasApiMapper;
    @Autowired
    private MenuHasApiStructure menuHasApiStructure;

    @Override
    public Page<MenuHasApiDTO> pageAll(MenuHasApiQuery query) {
        MenuHasApi entity = this.menuHasApiStructure.queryToEntity(query);
        Page<MenuHasApi> queries = this.menuHasApiMapper.pageAll(query.getPageQuery(), entity);
        List<MenuHasApiDTO> dtos = this.menuHasApiStructure.entitiesToDtos(queries.getRecords());
        Page<MenuHasApiDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param addMenuHasApiQuery {@link MenuHasApiQuery}查询条件
     * @return 是否成功
     */
    @Override
    public Integer save(AddMenuHasApiQuery addMenuHasApiQuery) {
        MenuHasApi entity = this.menuHasApiStructure.addQueryToEntity(addMenuHasApiQuery);
        int existCount = this.menuHasApiMapper.count(entity);
        Assert.isTrue(existCount == 0, () -> new RestException(RestErrorCode.DATA_EXIST));
        try {
            super.save(entity);
            return entity.getId();
        } catch (DuplicateKeyException e) {
            throw new RestException(RestErrorCode.DATA_EXIST);
        } catch (Exception e) {
            throw e;
        }
    }


    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    @Override
    public List<MenuHasApi> saveBatch(List<AddMenuHasApiQuery> batch) {
        List<MenuHasApi> entities = this.menuHasApiStructure.addQueriesToEntities(batch);
        List<MenuHasApi> apis = this.menuHasApiMapper.listByMenuIdAndApiId(entities);
        if (!apis.isEmpty()) {
            throw new RestException(RestErrorCode.DATA_EXIST);
        }
        try {
            super.saveBatch(entities);
            return entities;
        } catch (DuplicateKeyException e) {
            throw new RestException(RestErrorCode.DATA_EXIST);
        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public void removeBatch(List<Integer> ids) {
        if (ids.isEmpty()) {
            return;
        }
        super.removeByIds(ids);
    }


    @Override
    public void removeByMenuIds(List<Integer> menuIds) {
        if (menuIds.isEmpty()) {
            return;
        }
        super.remove(new QueryWrapper<MenuHasApi>().in(MenuHasApi.MENU_ID, menuIds));
    }

}
