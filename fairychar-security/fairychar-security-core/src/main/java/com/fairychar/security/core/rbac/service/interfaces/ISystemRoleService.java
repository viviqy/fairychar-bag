package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.SystemRole;
import com.fairychar.security.core.rbac.pojo.dto.SystemRoleDTO;
import com.fairychar.security.core.rbac.pojo.query.AddSystemRoleQuery;
import com.fairychar.security.core.rbac.pojo.query.SystemRoleQuery;
import com.fairychar.security.core.rbac.pojo.query.UpdateSystemRoleQuery;

import java.io.Serializable;
import java.util.List;

/**
 * 角色表(SystemRole)表服务接口
 *
 * @author chiyo
 */
public interface ISystemRoleService extends IService<SystemRole> {


    Page<SystemRoleDTO> pageByRoot(SystemRoleQuery sysApiQuery);

    int save(AddSystemRoleQuery addSystemRoleQuery);

    boolean updateById(UpdateSystemRoleQuery updateSystemRoleQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link SystemRoleDTO}
     */
    SystemRoleDTO findById(Serializable id);


    List<SystemRole> saveBatch(List<AddSystemRoleQuery> batch);

    boolean updateByIdBatch(List<UpdateSystemRoleQuery> batch);
}
