package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.SysMenu;
import com.fairychar.security.core.rbac.pojo.dto.SysMenuDTO;
import com.fairychar.security.core.rbac.pojo.query.AddSysMenuQuery;
import com.fairychar.security.core.rbac.pojo.query.SysMenuQuery;
import com.fairychar.security.core.rbac.pojo.query.UpdateSysMenuQuery;

import java.io.Serializable;
import java.util.List;

/**
 * 系统菜单(SysMenu)表服务接口
 *
 * @author chiyo
 */
public interface ISysMenuService extends IService<SysMenu> {

    Page<SysMenuDTO> pageByRoot(SysMenuQuery sysApiQuery);

    int save(AddSysMenuQuery addSysMenuQuery);

    boolean updateById(UpdateSysMenuQuery updateSysMenuQuery);

    SysMenuDTO findById(Serializable id);

    List<SysMenu> saveBatch(List<AddSysMenuQuery> batch);
}
