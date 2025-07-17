package com.fairychar.security.core.rbac.service;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.domain.exceptions.RestException;
import com.fairychar.security.core.rbac.entity.RoleHasMenu;
import com.fairychar.security.core.rbac.mapper.RoleHasMenuMapper;
import com.fairychar.security.core.rbac.pojo.dto.RoleHasMenuDTO;
import com.fairychar.security.core.rbac.pojo.query.AddRoleHasMenuQuery;
import com.fairychar.security.core.rbac.pojo.query.RoleHasMenuQuery;
import com.fairychar.security.core.rbac.service.interfaces.IRoleHasMenuService;
import com.fairychar.security.core.rbac.service.structure.RoleHasMenuStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色菜单关联(RoleHasMenu)表服务实现类
 *
 * @author chiyo
 */
@Service("roleHasMenuService")

public class RoleHasMenuService extends ServiceImpl<RoleHasMenuMapper, RoleHasMenu> implements IRoleHasMenuService {
    @Autowired
    private RoleHasMenuMapper roleHasMenuMapper;
    @Autowired
    private RoleHasMenuStructure roleHasMenuStructure;

    @Override
    public Page<RoleHasMenuDTO> pageAll(RoleHasMenuQuery query) {
        RoleHasMenu entity = this.roleHasMenuStructure.queryToEntity(query);
        Page<RoleHasMenu> queries = this.roleHasMenuMapper.pageAll(query.getPageQuery(), entity);
        List<RoleHasMenuDTO> dtos = this.roleHasMenuStructure.entitiesToDtos(queries.getRecords());
        Page<RoleHasMenuDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param addRoleHasMenuQuery {@link AddRoleHasMenuQuery}查询条件
     * @return 是否成功
     */
    @Override
    public Integer save(AddRoleHasMenuQuery addRoleHasMenuQuery) {
        RoleHasMenu entity = this.roleHasMenuStructure.addQueryToEntity(addRoleHasMenuQuery);
        int existCount = this.roleHasMenuMapper.count(entity);
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
    public List<RoleHasMenu> saveBatch(List<AddRoleHasMenuQuery> batch) {
        List<RoleHasMenu> entities = this.roleHasMenuStructure.addQueriesToEntities(batch);
        List<RoleHasMenu> apis = this.roleHasMenuMapper.listByRoleIdAndMenuId(entities);
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
    public void removeByRoleIds(List<Integer> roleIds) {
        if (roleIds.isEmpty()) {
            return;
        }
        super.remove(new QueryWrapper<RoleHasMenu>().in(RoleHasMenu.ROLE_ID, roleIds));
    }
}
