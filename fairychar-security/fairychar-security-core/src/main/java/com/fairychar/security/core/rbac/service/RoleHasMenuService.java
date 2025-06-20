package com.fairychar.security.core.rbac.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.security.core.rbac.entity.RoleHasMenu;
import com.fairychar.security.core.rbac.mapper.RoleHasMenuMapper;
import com.fairychar.security.core.rbac.pojo.dto.RoleHasMenuDTO;
import com.fairychar.security.core.rbac.pojo.query.RoleHasMenuQuery;
import com.fairychar.security.core.rbac.service.interfaces.IRoleHasMenuService;
import com.fairychar.security.core.rbac.service.structure.RoleHasMenuStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 角色菜单关联(RoleHasMenu)表服务实现类
 *
 * @author chiyo
 */
@Service("roleHasMenuService")
@Transactional(rollbackFor = Exception.class)
public class RoleHasMenuService extends ServiceImpl<RoleHasMenuMapper, RoleHasMenu> implements IRoleHasMenuService {
    @Autowired
    private RoleHasMenuMapper roleHasMenuMapper;
    @Autowired
    private RoleHasMenuStructure roleHasMenuStructure;

    /**
     * 条件全等匹配查询RoleHasMenu单条数据
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 查询结果 {@link RoleHasMenuDTO}
     */
    @Override
    public RoleHasMenuDTO findOne(RoleHasMenuQuery roleHasMenuQuery) {
        RoleHasMenu entity = this.roleHasMenuStructure.queryToEntity(roleHasMenuQuery);
        RoleHasMenu one = super.getOne(new QueryWrapper<RoleHasMenu>(entity));
        return this.roleHasMenuStructure.entityToDto(one);
    }

    /**
     * 条件匹配查询RoleHasMenu所有数据
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 查询结果 {@link RoleHasMenuDTO}
     */
    @Override
    public List<RoleHasMenuDTO> queryAll(RoleHasMenuQuery roleHasMenuQuery) {
        RoleHasMenu entity = this.roleHasMenuStructure.queryToEntity(roleHasMenuQuery);
        List<RoleHasMenu> list = this.roleHasMenuMapper.queryAll(entity);
        return this.roleHasMenuStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询RoleHasMenu所有数据
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 查询结果 {@link RoleHasMenuDTO}
     */
    @Override
    public Page<RoleHasMenuDTO> pageAll(RoleHasMenuQuery roleHasMenuQuery) {
        RoleHasMenu entity = this.roleHasMenuStructure.queryToEntity(roleHasMenuQuery);
        Page<RoleHasMenu> queries = this.roleHasMenuMapper.pageAll(roleHasMenuQuery.getPageQuery(), entity);
        List<RoleHasMenuDTO> dtos = this.roleHasMenuStructure.entitiesToDtos(queries.getRecords());
        Page<RoleHasMenuDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean save(RoleHasMenuQuery roleHasMenuQuery) {
        RoleHasMenu entity = this.roleHasMenuStructure.queryToEntity(roleHasMenuQuery);
        return this.save(entity);
    }

    /**
     * 更新
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean updateById(RoleHasMenuQuery roleHasMenuQuery) {
        RoleHasMenu entity = this.roleHasMenuStructure.queryToEntity(roleHasMenuQuery);
        return super.updateById(entity);
    }

    /**
     * 分页查询(全等匹配)
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 查询结果 {@link RoleHasMenuDTO}
     */
    @Override
    public Page<RoleHasMenuDTO> page(RoleHasMenuQuery roleHasMenuQuery) {
        RoleHasMenu entity = this.roleHasMenuStructure.queryToEntity(roleHasMenuQuery);
        return super.page(roleHasMenuQuery.getPageQuery(), new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(RoleHasMenuQuery roleHasMenuQuery) {
        RoleHasMenu entity = this.roleHasMenuStructure.queryToEntity(roleHasMenuQuery);
        return this.roleHasMenuMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     * @param id id
     * @return 查询结果 {@link RoleHasMenuDTO}
     */
    @Override
    public RoleHasMenuDTO findById(Serializable id) {
        RoleHasMenuDTO one = this.roleHasMenuStructure.entityToDto(this.getById(id));
        return one;
    }

    /**
     * 批量新增
     * @param batch 新增数据 
     * @return 是否成功
     */
    @Override
    public boolean saveBatch(List<RoleHasMenuQuery> batch) {
        List<RoleHasMenu> entities = this.roleHasMenuStructure.queriesToEntities(batch);
        return super.saveBatch(entities);
    }

    /**
     * 条件全等匹配查询RoleHasMenu所有数据
     *
     * @param roleHasMenuQuery {@link RoleHasMenuQuery}查询条件
     * @return 查询结果 {@link RoleHasMenuDTO}
     */
    @Override
    public List<RoleHasMenuDTO> findAll(RoleHasMenuQuery roleHasMenuQuery) {
        RoleHasMenu entity = this.roleHasMenuStructure.queryToEntity(roleHasMenuQuery);
        List<RoleHasMenu> list = super.list(new QueryWrapper<RoleHasMenu>(entity));
        return this.roleHasMenuStructure.entitiesToDtos(list);
    }
}
