package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.UserHasRole;
import com.fairychar.security.core.rbac.pojo.dto.UserHasRoleDTO;
import com.fairychar.security.core.rbac.pojo.query.AddUserHasRoleQuery;
import com.fairychar.security.core.rbac.pojo.query.UserHasRoleQuery;

import java.util.List;

/**
 * 用户角色关联(UserHasRole)表服务接口
 *
 * @author chiyo
 */
public interface IUserHasRoleService extends IService<UserHasRole> {

    Page<UserHasRoleDTO> pageAll(UserHasRoleQuery query);

    Integer save(AddUserHasRoleQuery addUserHasRoleQuery);

    List<UserHasRole> saveBatch(List<AddUserHasRoleQuery> batch);

    void removeBatch(List<Integer> ids);

    void removeByUserIds(List<Integer> roleIds);
}
