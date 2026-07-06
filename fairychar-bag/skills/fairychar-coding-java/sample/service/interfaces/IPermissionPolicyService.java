package com.zxsc.data.permission.service.service.interfaces;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxsc.data.permission.service.entity.PermissionPolicy;
import com.zxsc.data.permission.service.pojo.dto.PermissionPolicyDTO;
import com.zxsc.data.permission.service.pojo.query.PermissionPolicyQuery;

import java.io.Serializable;
import java.util.List;

/**
 * 权限策略表(PermissionPolicy)表服务接口
 *
 * @author makejava
 */
public interface IPermissionPolicyService extends IService<PermissionPolicy> {

    /**
     * 条件匹配查询PermissionPolicy单条数据
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 查询结果 {@link PermissionPolicyDTO}
     */
    PermissionPolicyDTO findOne(PermissionPolicyQuery permissionPolicyQuery);

    /**
     * 条件匹配查询PermissionPolicy所有数据
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 查询结果 {@link PermissionPolicyDTO}
     */
    List<PermissionPolicyDTO> queryAll(PermissionPolicyQuery permissionPolicyQuery);

    /**
     * 条件匹配分页查询PermissionPolicy所有数据
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 查询结果 {@link PermissionPolicyDTO}
     */
    Page<PermissionPolicyDTO> pageAll(PermissionPolicyQuery permissionPolicyQuery);

    /**
     * 插入
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}插入query
     * @return 是否成功
     */
    boolean save(PermissionPolicyQuery permissionPolicyQuery);

    /**
     * 更新
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}更新query
     * @return 是否成功
     */
    boolean updateById(PermissionPolicyQuery permissionPolicyQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 查询结果 {@link PermissionPolicyDTO}
     */
    Page<PermissionPolicyDTO> page(PermissionPolicyQuery permissionPolicyQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link PermissionPolicyDTO}
     */
    PermissionPolicyDTO findById(Serializable id);

    /**
     * 条件查询总数
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 总数
     */
    int count(PermissionPolicyQuery permissionPolicyQuery);

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    boolean saveBatch(List<PermissionPolicyQuery> batch);

    /**
     * 条件匹配查询PermissionPolicy所有数据
     *
     * @param permissionPolicyQuery {@link PermissionPolicyQuery}查询条件
     * @return 查询结果 {@link PermissionPolicyDTO}
     */
    List<PermissionPolicyDTO> findAll(PermissionPolicyQuery permissionPolicyQuery);

    /**
     * 发布策略。
     *
     * @param id 策略ID
     * @return 是否成功
     */
    boolean publish(Serializable id);

}
