package com.fairychar.security.core.rbac.service;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.domain.exceptions.RestException;
import com.fairychar.security.core.rbac.entity.UserHasRole;
import com.fairychar.security.core.rbac.mapper.UserHasRoleMapper;
import com.fairychar.security.core.rbac.pojo.dto.UserHasRoleDTO;
import com.fairychar.security.core.rbac.pojo.query.AddUserHasRoleQuery;
import com.fairychar.security.core.rbac.pojo.query.UserHasRoleQuery;
import com.fairychar.security.core.rbac.service.interfaces.IUserHasRoleService;
import com.fairychar.security.core.rbac.service.structure.UserHasRoleStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

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

    @Override
    public Page<UserHasRoleDTO> pageAll(UserHasRoleQuery query) {
        UserHasRole entity = this.userHasRoleStructure.queryToEntity(query);
        Page<UserHasRole> queries = this.userHasRoleMapper.pageAll(query.getPageQuery(), entity);
        List<UserHasRoleDTO> dtos = this.userHasRoleStructure.entitiesToDtos(queries.getRecords());
        Page<UserHasRoleDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param addUserHasRoleQuery {@link AddUserHasRoleQuery}查询条件
     * @return 是否成功
     */
    @Override
    public Integer save(AddUserHasRoleQuery addUserHasRoleQuery) {
        UserHasRole entity = this.userHasRoleStructure.addQueryToEntity(addUserHasRoleQuery);
        int existCount = this.userHasRoleMapper.count(entity);
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
    public List<UserHasRole> saveBatch(List<AddUserHasRoleQuery> batch) {
        List<UserHasRole> entities = this.userHasRoleStructure.addQueriesToEntities(batch);
        List<UserHasRole> apis = this.userHasRoleMapper.listByUserIdAndRoleId(entities);
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
    public void removeByUserIds(List<Integer> userIds) {
        if (userIds.isEmpty()) {
            return;
        }
        super.remove(new QueryWrapper<UserHasRole>().in(UserHasRole.USER_ID, userIds));
    }
}
