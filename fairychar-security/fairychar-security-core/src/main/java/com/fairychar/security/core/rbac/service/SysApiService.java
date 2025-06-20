package com.fairychar.security.core.rbac.service;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.domain.exceptions.RestException;
import com.fairychar.security.core.rbac.entity.SysApi;
import com.fairychar.security.core.rbac.mapper.SysApiMapper;
import com.fairychar.security.core.rbac.pojo.dto.SysApiDTO;
import com.fairychar.security.core.rbac.pojo.query.AddSysApiQuery;
import com.fairychar.security.core.rbac.pojo.query.SysApiQuery;
import com.fairychar.security.core.rbac.pojo.query.UpdateSysApiQuery;
import com.fairychar.security.core.rbac.service.interfaces.ISysApiService;
import com.fairychar.security.core.rbac.service.structure.SysApiStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (SysApi)表服务实现类
 *
 * @author chiyo
 */
@Service("sysApiService")
@Transactional(rollbackFor = Exception.class)
public class SysApiService extends ServiceImpl<SysApiMapper, SysApi> implements ISysApiService {
    @Autowired
    private SysApiMapper sysApiMapper;
    @Autowired
    private SysApiStructure sysApiStructure;


    /**
     * 条件全等匹配查询SysApi单条数据
     *
     * @param sysApiQuery {@link SysApiQuery}查询条件
     * @return 查询结果 {@link SysApiDTO}
     */
    @Override
    public SysApiDTO findOne(SysApiQuery sysApiQuery) {
        SysApi entity = this.sysApiStructure.queryToEntity(sysApiQuery);
        SysApi one = super.getOne(new QueryWrapper<SysApi>(entity));
        return this.sysApiStructure.entityToDto(one);
    }

    /**
     * 条件匹配查询SysApi所有数据
     *
     * @param sysApiQuery {@link SysApiQuery}查询条件
     * @return 查询结果 {@link SysApiDTO}
     */
    @Override
    public List<SysApiDTO> queryAll(SysApiQuery sysApiQuery) {
        SysApi entity = this.sysApiStructure.queryToEntity(sysApiQuery);
        List<SysApi> list = this.sysApiMapper.queryAll(entity);
        return this.sysApiStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询SysApi所有数据
     *
     * @param sysApiQuery {@link SysApiQuery}查询条件
     * @return 查询结果 {@link SysApiDTO}
     */
    @Override
    public Page<SysApiDTO> pageAll(SysApiQuery sysApiQuery) {
        SysApi entity = this.sysApiStructure.queryToEntity(sysApiQuery);
        Page<SysApi> queries = this.sysApiMapper.pageAll(sysApiQuery.getPageQuery(), entity);
        List<SysApiDTO> dtos = this.sysApiStructure.entitiesToDtos(queries.getRecords());
        Page<SysApiDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param addSysApiQuery {@link SysApiQuery}查询条件
     * @return 是否成功
     */
    @Override
    public int save(AddSysApiQuery addSysApiQuery) {
        String httpMethod = addSysApiQuery.getHttpMethod();
        SysApiDTO one = this.findOne(new SysApiQuery().setUri(addSysApiQuery.getUri()).setHttpMethod(httpMethod));
        Assert.isNull(one, () -> new RestException(RestErrorCode.DATA_EXIST));
        SysApi entity = this.sysApiStructure.addQueryToEntity(addSysApiQuery);
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
     * @param updateSysApiQuery {@link SysApiQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean updateById(UpdateSysApiQuery updateSysApiQuery) {
        int count = this.sysApiMapper.count(new SysApi().setId(updateSysApiQuery.getId()));
        Assert.isTrue(count == 1, () -> new RestException(RestErrorCode.DATA_NOT_EXIST));
        SysApi entity = this.sysApiStructure.updateQueryToEntity(updateSysApiQuery);
        SysApi one = this.sysApiMapper.queryOne(new SysApi().setHttpMethod(updateSysApiQuery.getHttpMethod())
                .setUri(updateSysApiQuery.getUri()));
        //不存在或者存在的是自己本身
        Assert.isTrue(one == null || one.getId().equals(entity.getId()), () -> new RestException(RestErrorCode.DATA_EXIST));
        return super.updateById(entity);
    }

    /**
     * 分页查询(全等匹配)
     *
     * @param sysApiQuery {@link SysApiQuery}查询条件
     * @return 查询结果 {@link SysApiDTO}
     */
    @Override
    public Page<SysApiDTO> page(SysApiQuery sysApiQuery) {
        SysApi entity = this.sysApiStructure.queryToEntity(sysApiQuery);
        return super.page(sysApiQuery.getPageQuery(), new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     *
     * @param sysApiQuery {@link SysApiQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(SysApiQuery sysApiQuery) {
        SysApi entity = this.sysApiStructure.queryToEntity(sysApiQuery);
        return this.sysApiMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link SysApiDTO}
     */
    @Override
    public SysApiDTO findById(Serializable id) {
        SysApiDTO one = this.sysApiStructure.entityToDto(this.getById(id));
        return one;
    }

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    @Override
    public boolean saveBatch(List<AddSysApiQuery> batch) {
        //batch 根据httpMethod+uri去重
        Map<String, List<AddSysApiQuery>> groupingBy = batch.stream().collect(Collectors.groupingBy(q -> q.getHttpMethod().concat(": ").concat(q.getUri())));
        List<String> repeats = groupingBy.entrySet().stream().filter(e -> e.getValue().size() > 1).map(e -> e.getKey()).toList();
        if (repeats.size() > 0) {
            String repeatStr = repeats.stream().collect(Collectors.joining(";"));
            throw new RestException(RestErrorCode.DATA_EXIST, repeatStr);
        }
        List<SysApi> apis = this.sysApiMapper.listByMethodAndUri(batch);
        if (!apis.isEmpty()) {
            String existApisStr = apis.stream().map(sysApi -> sysApi.getHttpMethod().concat(": ").concat(sysApi.getUri()))
                    .collect(Collectors.joining(";"));
            throw new RestException(RestErrorCode.DATA_EXIST, existApisStr);
        }
        List<SysApi> entities = this.sysApiStructure.addQueriesToEntities(batch);
        try {
            return super.saveBatch(entities);
        } catch (DuplicateKeyException e) {
            throw new RestException(RestErrorCode.DATA_EXIST);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 条件全等匹配查询SysApi所有数据
     *
     * @param sysApiQuery {@link SysApiQuery}查询条件
     * @return 查询结果 {@link SysApiDTO}
     */
    @Override
    public List<SysApiDTO> findAll(SysApiQuery sysApiQuery) {
        SysApi entity = this.sysApiStructure.queryToEntity(sysApiQuery);
        List<SysApi> list = super.list(new QueryWrapper<SysApi>(entity));
        return this.sysApiStructure.entitiesToDtos(list);
    }
}
