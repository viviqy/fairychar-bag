package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.SystemRole;
import com.fairychar.security.core.rbac.pojo.dto.SystemRoleDTO;
import com.fairychar.security.core.rbac.pojo.query.SystemRoleQuery;

import java.io.Serializable;
import java.util.List;

/**
 * 角色表(SystemRole)表服务接口
 *
 * @author chiyo
 */
public interface ISystemRoleService extends IService<SystemRole> {

    /**
     * 条件匹配查询SystemRole单条数据
     *
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 查询结果 {@link SystemRoleDTO}
     */
    SystemRoleDTO findOne(SystemRoleQuery systemRoleQuery);

    /**
     * 条件匹配查询SystemRole所有数据
     *
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 查询结果 {@link SystemRoleDTO}
     */
    List<SystemRoleDTO> queryAll(SystemRoleQuery systemRoleQuery);

    /**
     * 条件匹配分页查询SystemRole所有数据
     *
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 查询结果 {@link SystemRoleDTO}
     */
    Page<SystemRoleDTO> pageAll(SystemRoleQuery systemRoleQuery);

    /**
     * 插入
     *
     * @param systemRoleQuery {@link SystemRoleQuery}插入query
     * @return 是否成功
     */
    boolean save(SystemRoleQuery systemRoleQuery);

    /**
     * 更新
     *
     * @param systemRoleQuery {@link SystemRoleQuery}更新query
     * @return 是否成功
     */
    boolean updateById(SystemRoleQuery systemRoleQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 查询结果 {@link SystemRoleDTO}
     */
    Page<SystemRoleDTO> page(SystemRoleQuery systemRoleQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link SystemRoleDTO}
     */
    SystemRoleDTO findById(Serializable id);

    /**
     * 条件查询总数
     *
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 总数
     */
    int count(SystemRoleQuery systemRoleQuery);

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    boolean saveBatch(List<SystemRoleQuery> batch);

    /**
     * 条件匹配查询SystemRole所有数据
     *
     * @param systemRoleQuery {@link SystemRoleQuery}查询条件
     * @return 查询结果 {@link SystemRoleDTO}
     */
    List<SystemRoleDTO> findAll(SystemRoleQuery systemRoleQuery);

}
