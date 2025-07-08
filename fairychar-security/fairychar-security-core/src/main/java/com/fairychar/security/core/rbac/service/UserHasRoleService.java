package com.fairychar.security.core.rbac.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.security.core.rbac.entity.UserHasRole;
import com.fairychar.security.core.rbac.mapper.UserHasRoleMapper;
import com.fairychar.security.core.rbac.pojo.dto.UserHasRoleDTO;
import com.fairychar.security.core.rbac.pojo.query.UserHasRoleQuery;
import com.fairychar.security.core.rbac.service.interfaces.IUserHasRoleService;
import com.fairychar.security.core.rbac.service.structure.UserHasRoleStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 用户角色关联(UserHasRole)表服务实现类
 *
 * @author chiyo
 */
@Service("userHasRoleService")

public class UserHasRoleService extends ServiceImpl<UserHasRoleMapper, UserHasRole> implements IUserHasRoleService {
    @Autowired
    private UserHasRoleMapper userHasRoleMapper;
    @Autowired
    private UserHasRoleStructure userHasRoleStructure;

    /**
     * 条件全等匹配查询UserHasRole单条数据
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 查询结果 {@link UserHasRoleDTO}
     */
    @Override
    public UserHasRoleDTO findOne(UserHasRoleQuery userHasRoleQuery) {
        UserHasRole entity = this.userHasRoleStructure.queryToEntity(userHasRoleQuery);
        UserHasRole one = super.getOne(new QueryWrapper<UserHasRole>(entity));
        return this.userHasRoleStructure.entityToDto(one);
    }

    /**
     * 条件匹配查询UserHasRole所有数据
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 查询结果 {@link UserHasRoleDTO}
     */
    @Override
    public List<UserHasRoleDTO> queryAll(UserHasRoleQuery userHasRoleQuery) {
        UserHasRole entity = this.userHasRoleStructure.queryToEntity(userHasRoleQuery);
        List<UserHasRole> list = this.userHasRoleMapper.queryAll(entity);
        return this.userHasRoleStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询UserHasRole所有数据
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 查询结果 {@link UserHasRoleDTO}
     */
    @Override
    public Page<UserHasRoleDTO> pageAll(UserHasRoleQuery userHasRoleQuery) {
        UserHasRole entity = this.userHasRoleStructure.queryToEntity(userHasRoleQuery);
        Page<UserHasRole> queries = this.userHasRoleMapper.pageAll(userHasRoleQuery.getPageQuery(), entity);
        List<UserHasRoleDTO> dtos = this.userHasRoleStructure.entitiesToDtos(queries.getRecords());
        Page<UserHasRoleDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean save(UserHasRoleQuery userHasRoleQuery) {
        UserHasRole entity = this.userHasRoleStructure.queryToEntity(userHasRoleQuery);
        return this.save(entity);
    }

    /**
     * 更新
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean updateById(UserHasRoleQuery userHasRoleQuery) {
        UserHasRole entity = this.userHasRoleStructure.queryToEntity(userHasRoleQuery);
        return super.updateById(entity);
    }

    /**
     * 分页查询(全等匹配)
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 查询结果 {@link UserHasRoleDTO}
     */
    @Override
    public Page<UserHasRoleDTO> page(UserHasRoleQuery userHasRoleQuery) {
        UserHasRole entity = this.userHasRoleStructure.queryToEntity(userHasRoleQuery);
        return super.page(userHasRoleQuery.getPageQuery(), new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(UserHasRoleQuery userHasRoleQuery) {
        UserHasRole entity = this.userHasRoleStructure.queryToEntity(userHasRoleQuery);
        return this.userHasRoleMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     * @param id id
     * @return 查询结果 {@link UserHasRoleDTO}
     */
    @Override
    public UserHasRoleDTO findById(Serializable id) {
        UserHasRoleDTO one = this.userHasRoleStructure.entityToDto(this.getById(id));
        return one;
    }

    /**
     * 批量新增
     * @param batch 新增数据 
     * @return 是否成功
     */
    @Override
    public boolean saveBatch(List<UserHasRoleQuery> batch) {
        List<UserHasRole> entities = this.userHasRoleStructure.queriesToEntities(batch);
        return super.saveBatch(entities);
    }

    /**
     * 条件全等匹配查询UserHasRole所有数据
     *
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 查询结果 {@link UserHasRoleDTO}
     */
    @Override
    public List<UserHasRoleDTO> findAll(UserHasRoleQuery userHasRoleQuery) {
        UserHasRole entity = this.userHasRoleStructure.queryToEntity(userHasRoleQuery);
        List<UserHasRole> list = super.list(new QueryWrapper<UserHasRole>(entity));
        return this.userHasRoleStructure.entitiesToDtos(list);
    }
}
