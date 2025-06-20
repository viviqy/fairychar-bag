package com.fairychar.security.core.rbac.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.security.core.rbac.entity.SystemRole;
import com.fairychar.security.core.rbac.mapper.SystemRoleMapper;
import com.fairychar.security.core.rbac.pojo.dto.SystemRoleDTO;
import com.fairychar.security.core.rbac.pojo.query.SystemRoleQuery;
import com.fairychar.security.core.rbac.service.interfaces.ISystemRoleService;
import com.fairychar.security.core.rbac.service.structure.SystemRoleStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 角色表(SystemRole)表服务实现类
 *
 * @author chiyo
 */
@Service("systemRoleService")
@Transactional(rollbackFor = Exception.class)
public class SystemRoleService extends ServiceImpl<SystemRoleMapper, SystemRole> implements ISystemRoleService {
    @Autowired
    private SystemRoleMapper systemRoleMapper;
    @Autowired
    private SystemRoleStructure systemRoleStructure;

    /**
     * 条件全等匹配查询SystemRole单条数据
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 查询结果 {@link SystemRoleDTO}
     */
    @Override
    public SystemRoleDTO findOne(SystemRoleQuery systemRoleQuery) {
        SystemRole entity = this.systemRoleStructure.queryToEntity(systemRoleQuery);
        SystemRole one = super.getOne(new QueryWrapper<SystemRole>(entity));
        return this.systemRoleStructure.entityToDto(one);
    }

    /**
     * 条件匹配查询SystemRole所有数据
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 查询结果 {@link SystemRoleDTO}
     */
    @Override
    public List<SystemRoleDTO> queryAll(SystemRoleQuery systemRoleQuery) {
        SystemRole entity = this.systemRoleStructure.queryToEntity(systemRoleQuery);
        List<SystemRole> list = this.systemRoleMapper.queryAll(entity);
        return this.systemRoleStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询SystemRole所有数据
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 查询结果 {@link SystemRoleDTO}
     */
    @Override
    public Page<SystemRoleDTO> pageAll(SystemRoleQuery systemRoleQuery) {
        SystemRole entity = this.systemRoleStructure.queryToEntity(systemRoleQuery);
        Page<SystemRole> queries = this.systemRoleMapper.pageAll(systemRoleQuery.getPageQuery(), entity);
        List<SystemRoleDTO> dtos = this.systemRoleStructure.entitiesToDtos(queries.getRecords());
        Page<SystemRoleDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean save(SystemRoleQuery systemRoleQuery) {
        SystemRole entity = this.systemRoleStructure.queryToEntity(systemRoleQuery);
        return this.save(entity);
    }

    /**
     * 更新
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean updateById(SystemRoleQuery systemRoleQuery) {
        SystemRole entity = this.systemRoleStructure.queryToEntity(systemRoleQuery);
        return super.updateById(entity);
    }

    /**
     * 分页查询(全等匹配)
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 查询结果 {@link SystemRoleDTO}
     */
    @Override
    public Page<SystemRoleDTO> page(SystemRoleQuery systemRoleQuery) {
        SystemRole entity = this.systemRoleStructure.queryToEntity(systemRoleQuery);
        return super.page(systemRoleQuery.getPageQuery(), new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(SystemRoleQuery systemRoleQuery) {
        SystemRole entity = this.systemRoleStructure.queryToEntity(systemRoleQuery);
        return this.systemRoleMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     * @param id id
     * @return 查询结果 {@link SystemRoleDTO}
     */
    @Override
    public SystemRoleDTO findById(Serializable id) {
        SystemRoleDTO one = this.systemRoleStructure.entityToDto(this.getById(id));
        return one;
    }

    /**
     * 批量新增
     * @param batch 新增数据 
     * @return 是否成功
     */
    @Override
    public boolean saveBatch(List<SystemRoleQuery> batch) {
        List<SystemRole> entities = this.systemRoleStructure.queriesToEntities(batch);
        return super.saveBatch(entities);
    }

    /**
     * 条件全等匹配查询SystemRole所有数据
     *
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 查询结果 {@link SystemRoleDTO}
     */
    @Override
    public List<SystemRoleDTO> findAll(SystemRoleQuery systemRoleQuery) {
        SystemRole entity = this.systemRoleStructure.queryToEntity(systemRoleQuery);
        List<SystemRole> list = super.list(new QueryWrapper<SystemRole>(entity));
        return this.systemRoleStructure.entitiesToDtos(list);
    }
}
