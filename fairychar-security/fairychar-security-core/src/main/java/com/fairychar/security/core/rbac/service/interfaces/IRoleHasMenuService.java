package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.RoleHasMenu;
import com.fairychar.security.core.rbac.pojo.dto.RoleHasMenuDTO;
import com.fairychar.security.core.rbac.pojo.query.AddRoleHasMenuQuery;
import com.fairychar.security.core.rbac.pojo.query.RoleHasMenuQuery;

import java.util.List;

/**
 * 角色菜单关联(RoleHasMenu)表服务接口
 *
 * @author chiyo
 */
public interface IRoleHasMenuService extends IService<RoleHasMenu> {

    Page<RoleHasMenuDTO> pageAll(RoleHasMenuQuery query);

    Integer save(AddRoleHasMenuQuery addRoleHasMenuQuery);

    List<RoleHasMenu> saveBatch(List<AddRoleHasMenuQuery> batch);

    void removeBatch(List<Integer> ids);

    void removeByRoleIds(List<Integer> menuIds);
}
