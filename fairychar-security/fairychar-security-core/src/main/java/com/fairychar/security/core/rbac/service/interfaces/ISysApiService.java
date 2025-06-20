package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.SysApi;
import com.fairychar.security.core.rbac.pojo.dto.SysApiDTO;
import com.fairychar.security.core.rbac.pojo.query.AddSysApiQuery;
import com.fairychar.security.core.rbac.pojo.query.SysApiQuery;
import com.fairychar.security.core.rbac.pojo.query.UpdateSysApiQuery;

import java.io.Serializable;
import java.util.List;

/**
 * (SysApi)表服务接口
 *
 * @author chiyo
 */
public interface ISysApiService extends IService<SysApi> {



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
     * @param addSysApiQuery {@link SysApiQuery}插入query
     * @return 是否成功
     */
    int save(AddSysApiQuery addSysApiQuery);

    /**
     * 更新
     *
     * @param updateSysApiQuery {@link SysApiQuery}更新query
     * @return 是否成功
     */
    boolean updateById(UpdateSysApiQuery updateSysApiQuery);

    /**
     * 根据id查询一个对象
     * @param id id
     * @return 查询结果 {@link SysApiDTO}
     */
    SysApiDTO findById(Serializable id);


    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    List<SysApi> saveBatch(List<AddSysApiQuery> batch);

    boolean updateByIdBatch(List<UpdateSysApiQuery> batch);

    void removeBatch(List<Integer> ids);


}
