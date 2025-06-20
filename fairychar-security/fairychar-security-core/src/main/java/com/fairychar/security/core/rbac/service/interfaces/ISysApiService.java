package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.SysApi;
import com.fairychar.security.core.rbac.pojo.dto.SysApiDTO;
import com.fairychar.security.core.rbac.pojo.query.SysApiQuery;

import java.io.Serializable;
import java.util.List;

/**
 * (SysApi)表服务接口
 *
 * @author chiyo
 */
public interface ISysApiService extends IService<SysApi> {

    /**
     * 条件匹配查询SysApi单条数据
     *
     * @param sysApiQuery {@link SysApiQuery}查询条件
     * @return 查询结果 {@link SysApiDTO}
     */
    SysApiDTO findOne(SysApiQuery sysApiQuery);

    /**
     * 条件匹配查询SysApi所有数据
     *
     * @param sysApiQuery {@link SysApiQuery}查询条件
     * @return 查询结果 {@link SysApiDTO}
     */
    List<SysApiDTO> queryAll(SysApiQuery sysApiQuery);

    /**
     * 条件匹配分页查询SysApi所有数据
     *
     * @param sysApiQuery {@link SysApiQuery}查询条件
     * @return 查询结果 {@link SysApiDTO}
     */
    Page<SysApiDTO> pageAll(SysApiQuery sysApiQuery);

    /**
     * 插入
     *
     * @param sysApiQuery {@link SysApiQuery}插入query
     * @return 是否成功
     */
    boolean save(SysApiQuery sysApiQuery);

    /**
     * 更新
     *
     * @param sysApiQuery {@link SysApiQuery}更新query
     * @return 是否成功
     */
    boolean updateById(SysApiQuery sysApiQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param sysApiQuery {@link SysApiQuery}查询条件
     * @return 查询结果 {@link SysApiDTO}
     */
    Page<SysApiDTO> page(SysApiQuery sysApiQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link SysApiDTO}
     */
    SysApiDTO findById(Serializable id);

    /**
     * 条件查询总数
     *
     * @param sysApiQuery {@link SysApiQuery}查询条件
     * @return 总数
     */
    int count(SysApiQuery sysApiQuery);

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    boolean saveBatch(List<SysApiQuery> batch);

    /**
     * 条件匹配查询SysApi所有数据
     *
     * @param sysApiQuery {@link SysApiQuery}查询条件
     * @return 查询结果 {@link SysApiDTO}
     */
    List<SysApiDTO> findAll(SysApiQuery sysApiQuery);

}
