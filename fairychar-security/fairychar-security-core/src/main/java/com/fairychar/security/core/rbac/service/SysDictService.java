package com.fairychar.security.core.rbac.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.security.core.rbac.entity.SysDict;
import com.fairychar.security.core.rbac.mapper.SysDictMapper;
import com.fairychar.security.core.rbac.pojo.dto.SysDictDTO;
import com.fairychar.security.core.rbac.pojo.query.SysDictQuery;
import com.fairychar.security.core.rbac.service.interfaces.ISysDictService;
import com.fairychar.security.core.rbac.service.structure.SysDictStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 数据字典详情(SysDict)表服务实现类
 *
 * @author chiyo
 */
@Service("sysDictService")
@Transactional(rollbackFor = Exception.class)
public class SysDictService extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {
    @Autowired
    private SysDictMapper sysDictMapper;
    @Autowired
    private SysDictStructure sysDictStructure;

    /**
     * 条件全等匹配查询SysDict单条数据
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 查询结果 {@link SysDictDTO}
     */
    @Override
    public SysDictDTO findOne(SysDictQuery sysDictQuery) {
        SysDict entity = this.sysDictStructure.queryToEntity(sysDictQuery);
        SysDict one = super.getOne(new QueryWrapper<SysDict>(entity));
        return this.sysDictStructure.entityToDto(one);
    }

    /**
     * 条件匹配查询SysDict所有数据
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 查询结果 {@link SysDictDTO}
     */
    @Override
    public List<SysDictDTO> queryAll(SysDictQuery sysDictQuery) {
        SysDict entity = this.sysDictStructure.queryToEntity(sysDictQuery);
        List<SysDict> list = this.sysDictMapper.queryAll(entity);
        return this.sysDictStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询SysDict所有数据
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 查询结果 {@link SysDictDTO}
     */
    @Override
    public Page<SysDictDTO> pageAll(SysDictQuery sysDictQuery) {
        SysDict entity = this.sysDictStructure.queryToEntity(sysDictQuery);
        Page<SysDict> queries = this.sysDictMapper.pageAll(sysDictQuery.getPageQuery(), entity);
        List<SysDictDTO> dtos = this.sysDictStructure.entitiesToDtos(queries.getRecords());
        Page<SysDictDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean save(SysDictQuery sysDictQuery) {
        SysDict entity = this.sysDictStructure.queryToEntity(sysDictQuery);
        return this.save(entity);
    }

    /**
     * 更新
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean updateById(SysDictQuery sysDictQuery) {
        SysDict entity = this.sysDictStructure.queryToEntity(sysDictQuery);
        return super.updateById(entity);
    }

    /**
     * 分页查询(全等匹配)
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 查询结果 {@link SysDictDTO}
     */
    @Override
    public Page<SysDictDTO> page(SysDictQuery sysDictQuery) {
        SysDict entity = this.sysDictStructure.queryToEntity(sysDictQuery);
        return super.page(sysDictQuery.getPageQuery(), new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(SysDictQuery sysDictQuery) {
        SysDict entity = this.sysDictStructure.queryToEntity(sysDictQuery);
        return this.sysDictMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link SysDictDTO}
     */
    @Override
    public SysDictDTO findById(Serializable id) {
        SysDictDTO one = this.sysDictStructure.entityToDto(this.getById(id));
        return one;
    }

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    @Override
    public boolean saveBatch(List<SysDictQuery> batch) {
        List<SysDict> entities = this.sysDictStructure.queriesToEntities(batch);
        return super.saveBatch(entities);
    }

    /**
     * 条件全等匹配查询SysDict所有数据
     *
     * @param sysDictQuery {@link SysDictQuery}查询条件
     * @return 查询结果 {@link SysDictDTO}
     */
    @Override
    public List<SysDictDTO> findAll(SysDictQuery sysDictQuery) {
        SysDict entity = this.sysDictStructure.queryToEntity(sysDictQuery);
        List<SysDict> list = super.list(new QueryWrapper<SysDict>(entity));
        return this.sysDictStructure.entitiesToDtos(list);
    }
}
