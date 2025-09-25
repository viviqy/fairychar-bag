package com.fairychar.security.core.rbac.service;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.domain.exceptions.RestException;
import com.fairychar.security.core.rbac.entity.SystemRole;
import com.fairychar.security.core.rbac.mapper.SystemRoleMapper;
import com.fairychar.security.core.rbac.pojo.dto.SystemRoleDTO;
import com.fairychar.security.core.rbac.pojo.query.AddSystemRoleQuery;
import com.fairychar.security.core.rbac.pojo.query.SystemRoleQuery;
import com.fairychar.security.core.rbac.pojo.query.UpdateSystemRoleQuery;
import com.fairychar.security.core.rbac.service.interfaces.ISystemRoleService;
import com.fairychar.security.core.rbac.service.structure.SystemRoleStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 角色表(SystemRole)表服务实现类
 *
 * @author chiyo
 */
@Service("systemRoleService")
public class SystemRoleService extends ServiceImpl<SystemRoleMapper, SystemRole> implements ISystemRoleService {
    @Autowired
    private SystemRoleMapper systemRoleMapper;
    @Autowired
    private SystemRoleStructure systemRoleStructure;

    /**
     * 条件匹配分页查询SysMenu所有数据
     *
     * @param sysApiQuery {@link SystemRoleQuery}查询条件
     * @return 查询结果 {@link SystemRoleDTO}
     */
    @Override
    public Page<SystemRoleDTO> pageByRoot(SystemRoleQuery sysApiQuery) {
        SystemRole entity = this.systemRoleStructure.queryToEntity(sysApiQuery);
        Page<SystemRole> queries = this.systemRoleMapper.pageAll(sysApiQuery.getPageQuery(), entity);
        List<SystemRoleDTO> dtos = this.systemRoleStructure.entitiesToDtos(queries.getRecords());
        Page<SystemRoleDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }


    /**
     * 插入
     *
     * @param addSystemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 是否成功
     */
    @Override
    public int save(AddSystemRoleQuery addSystemRoleQuery) {
//        Integer pid = addSystemRoleQuery.getPid();
//        if (!pid.equals(0)) {
//            int parentCount = this.systemRoleMapper.count(new SystemRole().setId(pid));
//            Assert.isTrue(parentCount == 1, () -> new RestException(RestErrorCode.DATA_NOT_EXIST, "父级菜单不存在"));
//        }
        SystemRole one = this.systemRoleMapper.queryOne(new SystemRole().setName(addSystemRoleQuery.getName()));
        Assert.isNull(one, () -> new RestException(RestErrorCode.DATA_EXIST));
        SystemRole entity = this.systemRoleStructure.addQueryToEntity(addSystemRoleQuery);
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
     * 更新
     *
     * @param updateSystemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean updateById(UpdateSystemRoleQuery updateSystemRoleQuery) {
        int count = this.systemRoleMapper.count(new SystemRole().setId(updateSystemRoleQuery.getId()));
        Assert.isTrue(count == 1, () -> new RestException(RestErrorCode.DATA_NOT_EXIST));
        SystemRole entity = this.systemRoleStructure.updateQueryToEntity(updateSystemRoleQuery);
        SystemRole one = this.systemRoleMapper.queryOne(new SystemRole().setName(updateSystemRoleQuery.getName()));
        //不存在或者存在的是自己本身
        Assert.isTrue(one == null || one.getId().equals(entity.getId()), () -> new RestException(RestErrorCode.DATA_EXIST));
        return super.updateById(entity);
    }


    /**
     * 根据id查询一个对象
     *
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
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    @Override
    public List<SystemRole> saveBatch(List<AddSystemRoleQuery> batch) {
        if (batch.size() == 0) {
            return List.of();
        }
        //batch 根据code去重
        Set<String> nameSet = batch.stream().map(m -> m.getName()).collect(Collectors.toSet());
        if (nameSet.size() != batch.size()) {
            throw new RestException(RestErrorCode.DATA_EXIST, "有重复code");
        }
        List<SystemRole> entities = this.systemRoleStructure.addQueriesToEntities(batch);
        List<SystemRole> apis = super.list(new QueryWrapper<SystemRole>().in(SystemRole.NAME, nameSet));
        if (!apis.isEmpty()) {
            String existApisStr = apis.stream().map(sysApi -> sysApi.getName())
                    .collect(Collectors.joining(";"));
            throw new RestException(RestErrorCode.DATA_EXIST, existApisStr);
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

    /**
     * 更新
     *
     * @param batch {@link SystemRoleQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean updateByIdBatch(List<UpdateSystemRoleQuery> batch) {
        //batch 根据code去重
        Set<String> codeSet = batch.stream().map(m -> m.getName()).collect(Collectors.toSet());
        if (codeSet.size() != batch.size()) {
            throw new RestException(RestErrorCode.DATA_EXIST, "有重复code");
        }
        List<SystemRole> entities = this.systemRoleStructure.updateQueriesToEntities(batch);
        Map<String, Integer> codeIdMap = entities.stream().collect(Collectors.toMap(k -> k.getName(), v -> v.getId()));
        //检查当前code对应的id在更新的batch里,即不会跟已存在的code更新重复
        List<SystemRole> otherApis = super.list(new QueryWrapper<SystemRole>().in(SystemRole.NAME, codeSet)
                .notIn(SystemRole.ID, codeIdMap.values()));
        Assert.isTrue(otherApis.size() == 0, () -> new RestException(RestErrorCode.DATA_EXIST, "有重复code"));
        try {
            return super.updateBatchById(entities);
        } catch (DuplicateKeyException e) {
            throw new RestException(RestErrorCode.DATA_EXIST);
        } catch (Exception e) {
            throw e;
        }
    }
}
