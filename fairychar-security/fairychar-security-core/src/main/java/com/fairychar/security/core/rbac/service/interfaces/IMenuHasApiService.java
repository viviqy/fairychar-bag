package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.MenuHasApi;
import com.fairychar.security.core.rbac.pojo.dto.MenuHasApiDTO;
import com.fairychar.security.core.rbac.pojo.query.AddMenuHasApiQuery;
import com.fairychar.security.core.rbac.pojo.query.MenuHasApiQuery;

import java.io.Serializable;
import java.util.List;

/**
 * (MenuHasApi)表服务接口
 *
 * @author chiyo
 */
public interface IMenuHasApiService extends IService<MenuHasApi> {

    Page<MenuHasApiDTO> pageAll(MenuHasApiQuery query);

    Integer save(AddMenuHasApiQuery addMenuHasApiQuery);

    List<MenuHasApi> saveBatch(List<AddMenuHasApiQuery> batch);

    void removeBatch(List<Integer> ids);

    void removeByMenuIds(List<Integer> menuIds);
}
