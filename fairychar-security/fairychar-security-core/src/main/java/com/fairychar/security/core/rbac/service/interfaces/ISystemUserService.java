package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.SystemUser;
import com.fairychar.security.core.rbac.pojo.dto.SystemUserDTO;
import com.fairychar.security.core.rbac.pojo.query.SystemUserQuery;

import java.io.Serializable;
import java.util.List;

/**
 * 系统用户(SystemUser)表服务接口
 *
 * @author chiyo
 */
public interface ISystemUserService extends IService<SystemUser> {

    /**
     * 条件匹配查询SystemUser单条数据
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 查询结果 {@link SystemUserDTO}
     */
    SystemUserDTO findOne(SystemUserQuery systemUserQuery);

    /**
     * 条件匹配查询SystemUser所有数据
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 查询结果 {@link SystemUserDTO}
     */
    List<SystemUserDTO> queryAll(SystemUserQuery systemUserQuery);

    /**
     * 条件匹配分页查询SystemUser所有数据
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 查询结果 {@link SystemUserDTO}
     */
    Page<SystemUserDTO> pageAll(SystemUserQuery systemUserQuery);

    /**
     * 插入
     *
     * @param systemUserQuery {@link SystemUserQuery}插入query
     * @return 是否成功
     */
    boolean save(SystemUserQuery systemUserQuery);

    /**
     * 更新
     *
     * @param systemUserQuery {@link SystemUserQuery}更新query
     * @return 是否成功
     */
    boolean updateById(SystemUserQuery systemUserQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 查询结果 {@link SystemUserDTO}
     */
    Page<SystemUserDTO> page(SystemUserQuery systemUserQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link SystemUserDTO}
     */
    SystemUserDTO findById(Serializable id);

    /**
     * 条件查询总数
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 总数
     */
    int count(SystemUserQuery systemUserQuery);

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    boolean saveBatch(List<SystemUserQuery> batch);

    /**
     * 条件匹配查询SystemUser所有数据
     *
     * @param systemUserQuery {@link SystemUserQuery}查询条件
     * @return 查询结果 {@link SystemUserDTO}
     */
    List<SystemUserDTO> findAll(SystemUserQuery systemUserQuery);

}
