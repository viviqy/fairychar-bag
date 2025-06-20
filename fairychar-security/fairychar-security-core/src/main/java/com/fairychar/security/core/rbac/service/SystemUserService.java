package com.fairychar.security.core.rbac.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.security.core.rbac.entity.SystemUser;
import com.fairychar.security.core.rbac.mapper.SystemUserMapper;
import com.fairychar.security.core.rbac.pojo.dto.SystemUserDTO;
import com.fairychar.security.core.rbac.pojo.query.SystemUserQuery;
import com.fairychar.security.core.rbac.service.interfaces.ISystemUserService;
import com.fairychar.security.core.rbac.service.structure.SystemUserStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 系统用户(SystemUser)表服务实现类
 *
 * @author chiyo
 */
@Service("systemUserService")
@Transactional(rollbackFor = Exception.class)
public class SystemUserService extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {
    @Autowired
    private SystemUserMapper systemUserMapper;
    @Autowired
    private SystemUserStructure systemUserStructure;

    /**
     * 条件全等匹配查询SystemUser单条数据
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 查询结果 {@link SystemUserDTO}
     */
    @Override
    public SystemUserDTO findOne(SystemUserQuery systemUserQuery) {
        SystemUser entity = this.systemUserStructure.queryToEntity(systemUserQuery);
        SystemUser one = super.getOne(new QueryWrapper<SystemUser>(entity));
        return this.systemUserStructure.entityToDto(one);
    }

    /**
     * 条件匹配查询SystemUser所有数据
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 查询结果 {@link SystemUserDTO}
     */
    @Override
    public List<SystemUserDTO> queryAll(SystemUserQuery systemUserQuery) {
        SystemUser entity = this.systemUserStructure.queryToEntity(systemUserQuery);
        List<SystemUser> list = this.systemUserMapper.queryAll(entity);
        return this.systemUserStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询SystemUser所有数据
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 查询结果 {@link SystemUserDTO}
     */
    @Override
    public Page<SystemUserDTO> pageAll(SystemUserQuery systemUserQuery) {
        SystemUser entity = this.systemUserStructure.queryToEntity(systemUserQuery);
        Page<SystemUser> queries = this.systemUserMapper.pageAll(systemUserQuery.getPageQuery(), entity);
        List<SystemUserDTO> dtos = this.systemUserStructure.entitiesToDtos(queries.getRecords());
        Page<SystemUserDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean save(SystemUserQuery systemUserQuery) {
        SystemUser entity = this.systemUserStructure.queryToEntity(systemUserQuery);
        return this.save(entity);
    }

    /**
     * 更新
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean updateById(SystemUserQuery systemUserQuery) {
        SystemUser entity = this.systemUserStructure.queryToEntity(systemUserQuery);
        return super.updateById(entity);
    }

    /**
     * 分页查询(全等匹配)
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 查询结果 {@link SystemUserDTO}
     */
    @Override
    public Page<SystemUserDTO> page(SystemUserQuery systemUserQuery) {
        SystemUser entity = this.systemUserStructure.queryToEntity(systemUserQuery);
        return super.page(systemUserQuery.getPageQuery(), new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(SystemUserQuery systemUserQuery) {
        SystemUser entity = this.systemUserStructure.queryToEntity(systemUserQuery);
        return this.systemUserMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link SystemUserDTO}
     */
    @Override
    public SystemUserDTO findById(Serializable id) {
        SystemUserDTO one = this.systemUserStructure.entityToDto(this.getById(id));
        return one;
    }

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    @Override
    public boolean saveBatch(List<SystemUserQuery> batch) {
        List<SystemUser> entities = this.systemUserStructure.queriesToEntities(batch);
        return super.saveBatch(entities);
    }

    /**
     * 条件全等匹配查询SystemUser所有数据
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 查询结果 {@link SystemUserDTO}
     */
    @Override
    public List<SystemUserDTO> findAll(SystemUserQuery systemUserQuery) {
        SystemUser entity = this.systemUserStructure.queryToEntity(systemUserQuery);
        List<SystemUser> list = super.list(new QueryWrapper<SystemUser>(entity));
        return this.systemUserStructure.entitiesToDtos(list);
    }
}
