package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.UserHasRole;
import com.fairychar.security.core.rbac.pojo.dto.UserHasRoleDTO;
import com.fairychar.security.core.rbac.pojo.query.UserHasRoleQuery;

import java.io.Serializable;
import java.util.List;

/**
 * 用户角色关联(UserHasRole)表服务接口
 *
 * @author chiyo
 */
public interface IUserHasRoleService extends IService<UserHasRole> {

    /**
     * 条件匹配查询UserHasRole单条数据
     *
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 查询结果 {@link UserHasRoleDTO}
     */
    UserHasRoleDTO findOne(UserHasRoleQuery userHasRoleQuery);

    /**
     * 条件匹配查询UserHasRole所有数据
     *
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 查询结果 {@link UserHasRoleDTO}
     */
    List<UserHasRoleDTO> queryAll(UserHasRoleQuery userHasRoleQuery);

    /**
     * 条件匹配分页查询UserHasRole所有数据
     *
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 查询结果 {@link UserHasRoleDTO}
     */
    Page<UserHasRoleDTO> pageAll(UserHasRoleQuery userHasRoleQuery);

    /**
     * 插入
     *
     * @param userHasRoleQuery {@link UserHasRoleQuery}插入query
     * @return 是否成功
     */
    boolean save(UserHasRoleQuery userHasRoleQuery);

    /**
     * 更新
     *
     * @param userHasRoleQuery {@link UserHasRoleQuery}更新query
     * @return 是否成功
     */
    boolean updateById(UserHasRoleQuery userHasRoleQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 查询结果 {@link UserHasRoleDTO}
     */
    Page<UserHasRoleDTO> page(UserHasRoleQuery userHasRoleQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link UserHasRoleDTO}
     */
    UserHasRoleDTO findById(Serializable id);

    /**
     * 条件查询总数
     *
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 总数
     */
    int count(UserHasRoleQuery userHasRoleQuery);

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    boolean saveBatch(List<UserHasRoleQuery> batch);

    /**
     * 条件匹配查询UserHasRole所有数据
     *
     * @param userHasRoleQuery {@link UserHasRoleQuery}查询条件
     * @return 查询结果 {@link UserHasRoleDTO}
     */
    List<UserHasRoleDTO> findAll(UserHasRoleQuery userHasRoleQuery);

}
