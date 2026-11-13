package com.fairychar.security.core.rbac.service;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.security.core.rbac.entity.MenuHasApi;
import com.fairychar.security.core.rbac.entity.RoleHasMenu;
import com.fairychar.security.core.rbac.entity.SysApi;
import com.fairychar.security.core.rbac.entity.SysDict;
import com.fairychar.security.core.rbac.entity.SysMenu;
import com.fairychar.security.core.rbac.entity.SystemRole;
import com.fairychar.security.core.rbac.entity.SystemUser;
import com.fairychar.security.core.rbac.entity.UserHasRole;
import com.fairychar.security.core.rbac.service.interfaces.IMenuHasApiService;
import com.fairychar.security.core.rbac.service.interfaces.IRoleHasMenuService;
import com.fairychar.security.core.rbac.service.interfaces.ISysApiService;
import com.fairychar.security.core.rbac.service.interfaces.ISysDictService;
import com.fairychar.security.core.rbac.service.interfaces.ISysMenuService;
import com.fairychar.security.core.rbac.service.interfaces.ISystemRoleService;
import com.fairychar.security.core.rbac.service.interfaces.ISystemUserService;
import com.fairychar.security.core.rbac.service.interfaces.IUserHasRoleService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MybatisPlusSpringCompatibilityTest {

    @Test
    public void allRbacServicesResolveServiceImpl() {
        List<Class<?>> services = List.of(MenuHasApiService.class, RoleHasMenuService.class, SysApiService.class,
                SysDictService.class, SysMenuService.class, SystemRoleService.class, SystemUserService.class,
                UserHasRoleService.class);
        for (Class<?> service : services) {
            Assert.assertTrue(service.getName(), ServiceImpl.class.isAssignableFrom(service));
        }
    }

    @Test
    public void allRbacServiceInterfacesResolveIService() {
        List<Class<?>> interfaces = List.of(IMenuHasApiService.class, IRoleHasMenuService.class, ISysApiService.class,
                ISysDictService.class, ISysMenuService.class, ISystemRoleService.class, ISystemUserService.class,
                IUserHasRoleService.class);
        for (Class<?> serviceInterface : interfaces) {
            Assert.assertTrue(serviceInterface.getName(), IService.class.isAssignableFrom(serviceInterface));
        }
    }

    @Test
    public void allRbacEntitiesResolveActiveRecordModel() {
        List<Class<?>> entities = List.of(MenuHasApi.class, RoleHasMenu.class, SysApi.class, SysDict.class,
                SysMenu.class, SystemRole.class, SystemUser.class, UserHasRole.class);
        for (Class<?> entity : entities) {
            Assert.assertTrue(entity.getName(), Model.class.isAssignableFrom(entity));
        }
    }
}
