package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.SysDict;
import com.fairychar.security.core.rbac.pojo.dto.SysDictDTO;
import com.fairychar.security.core.rbac.pojo.query.SysDictQuery;

import java.io.Serializable;
import java.util.List;

/**
 * 数据字典详情(SysDict)表服务接口
 *
 * @author chiyo
 */
public interface ISysDictService extends IService<SysDict> {

    /**
     * 条件匹配查询SysDict单条数据
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 查询结果 {@link SysDictDTO}
     */
    SysDictDTO findOne(SysDictQuery sysDictQuery);

    /**
     * 条件匹配查询SysDict所有数据
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 查询结果 {@link SysDictDTO}
     */
    List<SysDictDTO> queryAll(SysDictQuery sysDictQuery);

    /**
     * 条件匹配分页查询SysDict所有数据
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 查询结果 {@link SysDictDTO}
     */
    Page<SysDictDTO> pageAll(SysDictQuery sysDictQuery);

    /**
     * 插入
     *
     * @param sysDictQuery {@link SysDictQuery}插入query
     * @return 是否成功
     */
    boolean save(SysDictQuery sysDictQuery);

    /**
     * 更新
     *
     * @param sysDictQuery {@link SysDictQuery}更新query
     * @return 是否成功
     */
    boolean updateById(SysDictQuery sysDictQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 查询结果 {@link SysDictDTO}
     */
    Page<SysDictDTO> page(SysDictQuery sysDictQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link SysDictDTO}
     */
    SysDictDTO findById(Serializable id);

    /**
     * 条件查询总数
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 总数
     */
    int count(SysDictQuery sysDictQuery);

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    boolean saveBatch(List<SysDictQuery> batch);

    /**
     * 条件匹配查询SysDict所有数据
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 查询结果 {@link SysDictDTO}
     */
    List<SysDictDTO> findAll(SysDictQuery sysDictQuery);

}
