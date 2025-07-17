package com.fairychar.security.core.rbac.service;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.domain.exceptions.RestException;
import com.fairychar.security.core.rbac.entity.SysDict;
import com.fairychar.security.core.rbac.mapper.SysDictMapper;
import com.fairychar.security.core.rbac.pojo.dto.SysDictDTO;
import com.fairychar.security.core.rbac.pojo.query.AddSysDictQuery;
import com.fairychar.security.core.rbac.pojo.query.SysDictQuery;
import com.fairychar.security.core.rbac.pojo.query.UpdateSysDictQuery;
import com.fairychar.security.core.rbac.service.interfaces.ISysDictService;
import com.fairychar.security.core.rbac.service.structure.SysDictStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 数据字典详情(SysDict)表服务实现类
 *
 * @author chiyo
 */
@Service("sysDictService")

public class SysDictService extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {
    @Autowired
    private SysDictMapper sysDictMapper;
    @Autowired
    private SysDictStructure sysDictStructure;


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
     * @param addSysDictQuery {@link SysDictQuery}查询条件
     * @return 是否成功
     */
    @Override
    public int save(AddSysDictQuery addSysDictQuery) {
        int existCount = this.sysDictMapper.count(new SysDict().setLabel(addSysDictQuery.getLabel()));
        Assert.isTrue(existCount == 0, () -> new RestException(RestErrorCode.DATA_EXIST));
        SysDict entity = this.sysDictStructure.addQueryToEntity(addSysDictQuery);
        entity.setUid(DefaultIdentifierGenerator.getInstance().nextId(null));
        try {
            super.save(entity);
            return entity.getId();
        } catch (DuplicateKeyException e) {
            throw new RestException(RestErrorCode.DATA_EXIST);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 更新
     *
     * @param updateSysApiQuery {@link SysDictQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean updateById(UpdateSysDictQuery updateSysApiQuery) {
        int count = this.sysDictMapper.count(new SysDict().setId(updateSysApiQuery.getId()));
        Assert.isTrue(count == 1, () -> new RestException(RestErrorCode.DATA_NOT_EXIST));
        SysDict entity = this.sysDictStructure.updateQueryToEntity(updateSysApiQuery);
        SysDict one = this.sysDictMapper.queryOne(new SysDict().setLabel(updateSysApiQuery.getLabel()));
        //不存在或者存在的是自己本身
        Assert.isTrue(one == null || one.getId().equals(entity.getId()), () -> new RestException(RestErrorCode.DATA_EXIST));
        return super.updateById(entity);
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


}
