package com.zxsc.data.permission.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxsc.data.permission.service.domain.PermissionBusinessException;
import com.zxsc.data.permission.service.domain.PermissionConsts;
import com.zxsc.data.permission.service.domain.PermissionErrorCode;
import com.zxsc.data.permission.service.entity.PermissionPolicy;
import com.zxsc.data.permission.service.mapper.PermissionPolicyMapper;
import com.zxsc.data.permission.service.pojo.dto.PermissionPolicyDTO;
import com.zxsc.data.permission.service.pojo.query.PermissionPolicyQuery;
import com.zxsc.data.permission.service.service.interfaces.IPermissionPolicyService;
import com.zxsc.data.permission.service.service.structure.PermissionPolicyStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 权限策略表(PermissionPolicy)表服务实现类
 *
 * @author lmq
 */
@Service("permissionPolicyService")
public class PermissionPolicyService extends ServiceImpl<PermissionPolicyMapper, PermissionPolicy> implements IPermissionPolicyService {
    @Autowired
    private PermissionPolicyMapper permissionPolicyMapper;
    @Autowired
    private PermissionPolicyStructure permissionPolicyStructure;

    /**
     * 条件全等匹配查询PermissionPolicy单条数据
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 查询结果 {@link PermissionPolicyDTO}
     */
    @Override
    public PermissionPolicyDTO findOne(PermissionPolicyQuery permissionPolicyQuery) {
        PermissionPolicy entity = this.permissionPolicyStructure.queryToEntity(permissionPolicyQuery);
        PermissionPolicy one = super.getOne(new QueryWrapper<PermissionPolicy>(entity));
        return this.permissionPolicyStructure.entityToDto(one);
    }

    /**
     * 条件匹配查询PermissionPolicy所有数据
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 查询结果 {@link PermissionPolicyDTO}
     */
    @Override
    public List<PermissionPolicyDTO> queryAll(PermissionPolicyQuery permissionPolicyQuery) {
        PermissionPolicy entity = this.permissionPolicyStructure.queryToEntity(permissionPolicyQuery);
        List<PermissionPolicy> list = this.permissionPolicyMapper.queryAll(entity);
        return this.permissionPolicyStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询PermissionPolicy所有数据
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 查询结果 {@link PermissionPolicyDTO}
     */
    @Override
    public Page<PermissionPolicyDTO> pageAll(PermissionPolicyQuery permissionPolicyQuery) {
        PermissionPolicy entity = this.permissionPolicyStructure.queryToEntity(permissionPolicyQuery);
        Page<PermissionPolicy> queries = this.permissionPolicyMapper.pageAll(permissionPolicyQuery.getPageQuery(), entity);
        List<PermissionPolicyDTO> dtos = this.permissionPolicyStructure.entitiesToDtos(queries.getRecords());
        Page<PermissionPolicyDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean save(PermissionPolicyQuery permissionPolicyQuery) {
        this.validatePolicy(permissionPolicyQuery);
        this.validatePolicyCodeUnique(permissionPolicyQuery.getSystemId(), permissionPolicyQuery.getPolicyCode(), null);
        PermissionPolicy entity = this.permissionPolicyStructure.queryToEntity(permissionPolicyQuery);
        entity.setStatus(PermissionConsts.STATUS_DRAFT);
        return this.save(entity);
    }

    /**
     * 更新
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean updateById(PermissionPolicyQuery permissionPolicyQuery) {
        this.validatePolicy(permissionPolicyQuery);
        this.validatePolicyCodeUnique(permissionPolicyQuery.getSystemId(), permissionPolicyQuery.getPolicyCode(),
                permissionPolicyQuery.getId());
        PermissionPolicy entity = this.permissionPolicyStructure.queryToEntity(permissionPolicyQuery);
        return super.updateById(entity);
    }

    /**
     * 分页查询(全等匹配)
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 查询结果 {@link PermissionPolicyDTO}
     */
    @Override
    public Page<PermissionPolicyDTO> page(PermissionPolicyQuery permissionPolicyQuery) {
        PermissionPolicy entity = this.permissionPolicyStructure.queryToEntity(permissionPolicyQuery);
        Page<PermissionPolicy> queries = super.page(permissionPolicyQuery.getPageQuery(), new QueryWrapper<>(entity));
        List<PermissionPolicyDTO> dtos = this.permissionPolicyStructure.entitiesToDtos(queries.getRecords());
        Page<PermissionPolicyDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 条件查询匹配总数
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(PermissionPolicyQuery permissionPolicyQuery) {
        PermissionPolicy entity = this.permissionPolicyStructure.queryToEntity(permissionPolicyQuery);
        return this.permissionPolicyMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link PermissionPolicyDTO}
     */
    @Override
    public PermissionPolicyDTO findById(Serializable id) {
        PermissionPolicyDTO one = this.permissionPolicyStructure.entityToDto(this.getById(id));
        return one;
    }

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    @Override
    public boolean saveBatch(List<PermissionPolicyQuery> batch) {
        List<PermissionPolicy> entities = this.permissionPolicyStructure.queriesToEntities(batch);
        return super.saveBatch(entities);
    }

    /**
     * 条件全等匹配查询PermissionPolicy所有数据
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 查询结果 {@link PermissionPolicyDTO}
     */
    @Override
    public List<PermissionPolicyDTO> findAll(PermissionPolicyQuery permissionPolicyQuery) {
        PermissionPolicy entity = this.permissionPolicyStructure.queryToEntity(permissionPolicyQuery);
        List<PermissionPolicy> list = super.list(new QueryWrapper<PermissionPolicy>(entity));
        return this.permissionPolicyStructure.entitiesToDtos(list);
    }

    /**
     * 发布策略。
     *
     * @param id 策略ID
     * @return 是否成功
     */
    @Override
    public boolean publish(Serializable id) {
        PermissionPolicy policy = super.getById(id);
        if (policy == null) {
            throw new PermissionBusinessException(PermissionErrorCode.POLICY_NOT_FOUND);
        }
        policy.setStatus(PermissionConsts.STATUS_PUBLISHED);
        policy.setPublishedAt(LocalDateTime.now());
        policy.setUpdatedAt(LocalDateTime.now());
        return super.updateById(policy);
    }

    private void validatePolicy(PermissionPolicyQuery query) {
        if (query == null || query.getSystemId() == null || !StringUtils.hasText(query.getPolicyCode())
                || !StringUtils.hasText(query.getPolicyName()) || !StringUtils.hasText(query.getEffect())
                || !StringUtils.hasText(query.getConditionField()) || !StringUtils.hasText(query.getConditionOperator())
                || !StringUtils.hasText(query.getConditionValueType()) || !StringUtils.hasText(query.getConditionValue())) {
            throw new PermissionBusinessException(PermissionErrorCode.PARAM_ERROR, "策略必填字段不能为空");
        }
    }

    private void validatePolicyCodeUnique(Long systemId, String policyCode, Long ignoredId) {
        PermissionPolicy exists = super.getOne(new QueryWrapper<PermissionPolicy>()
                .eq(PermissionPolicy.SYSTEM_ID, systemId)
                .eq(PermissionPolicy.POLICY_CODE, policyCode)
                .ne(ignoredId != null, PermissionPolicy.ID, ignoredId), false);
        if (exists != null) {
            throw new PermissionBusinessException(PermissionErrorCode.POLICY_CODE_EXISTS);
        }
    }
}
