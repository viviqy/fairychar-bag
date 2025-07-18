package com.fairychar.security.core.rbac.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.domain.exceptions.RestException;
import com.fairychar.bag.utils.MappingObjectUtil;
import com.fairychar.bag.utils.ReflectUtil;
import com.fairychar.security.core.rbac.entity.SysMenu;
import com.fairychar.security.core.rbac.mapper.SysMenuMapper;
import com.fairychar.security.core.rbac.pojo.dto.SysMenuDTO;
import com.fairychar.security.core.rbac.pojo.query.AddSysMenuQuery;
import com.fairychar.security.core.rbac.pojo.query.SysMenuQuery;
import com.fairychar.security.core.rbac.pojo.query.UpdateSysMenuQuery;
import com.fairychar.security.core.rbac.service.interfaces.ISysMenuService;
import com.fairychar.security.core.rbac.service.structure.SysMenuStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 系统菜单(SysMenu)表服务实现类
 *
 * @author chiyo
 */
@Service("sysMenuService")
public class SysMenuService extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysMenuStructure sysMenuStructure;

    /**
     * 条件匹配分页查询SysMenu所有数据
     *
     * @param sysApiQuery {@link SysMenuQuery}查询条件
     * @return 查询结果 {@link SysMenuDTO}
     */
    @Override
    public Page<SysMenuDTO> pageByRoot(SysMenuQuery sysApiQuery) {
        sysApiQuery.setPid(0);
        SysMenu entity = this.sysMenuStructure.queryToEntity(sysApiQuery);
        Page<SysMenu> queries = this.sysMenuMapper.pageAll(sysApiQuery.getPageQuery(), entity);
        List<SysMenuDTO> dtos = this.sysMenuStructure.entitiesToDtos(queries.getRecords());
        if (!dtos.isEmpty()) {
            List<Integer> pids = dtos.stream().map(s -> s.getId()).toList();
            List<SysMenu> recursiveSearchChild = ReflectUtil.recursiveSearchChild("id", pids, (Function<List<Integer>, List<SysMenu>>) pidParams -> {
                List<SysMenu> childList = super.list(new QueryWrapper<SysMenu>().in(SysMenu.PID, pidParams));
                return childList;
            });
            List<SysMenuDTO> recursiveSearchChildDtos = this.sysMenuStructure.entitiesToDtos(recursiveSearchChild);
            recursiveSearchChildDtos.addAll(dtos);
            dtos = MappingObjectUtil.listToTree(recursiveSearchChildDtos, "pid", "id", "child", 0L);
        }
        Page<SysMenuDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }


    /**
     * 插入
     *
     * @param addSysMenuQuery {@link SysMenuQuery}查询条件
     * @return 是否成功
     */
    @Override
    public int save(AddSysMenuQuery addSysMenuQuery) {
        Integer pid = addSysMenuQuery.getPid();
        if (!pid.equals(0)) {
            int parentCount = this.sysMenuMapper.count(new SysMenu().setId(pid));
            Assert.isTrue(parentCount == 1, () -> new RestException(RestErrorCode.DATA_NOT_EXIST, "父级菜单不存在"));
        }
        SysMenu one = this.sysMenuMapper.queryOne(new SysMenu().setCode(addSysMenuQuery.getCode()));
        Assert.isNull(one, () -> new RestException(RestErrorCode.DATA_EXIST));
        SysMenu entity = this.sysMenuStructure.addQueryToEntity(addSysMenuQuery);
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
     * @param updateSysMenuQuery {@link SysMenuQuery}查询条件
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(UpdateSysMenuQuery updateSysMenuQuery) {
        int count = this.sysMenuMapper.count(new SysMenu().setId(updateSysMenuQuery.getId()));
        Assert.isTrue(count == 1, () -> new RestException(RestErrorCode.DATA_NOT_EXIST));
        SysMenu entity = this.sysMenuStructure.updateQueryToEntity(updateSysMenuQuery);
        SysMenu one = this.sysMenuMapper.queryOne(new SysMenu().setHttpMethod(updateSysMenuQuery.getHttpMethod())
                .setUri(updateSysMenuQuery.getUri()));
        //不存在或者存在的是自己本身
        Assert.isTrue(one == null || one.getId().equals(entity.getId()), () -> new RestException(RestErrorCode.DATA_EXIST));
        return super.updateById(entity);
    }


    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link SysMenuDTO}
     */
    @Override
    public SysMenuDTO findById(Serializable id) {
        SysMenuDTO one = this.sysMenuStructure.entityToDto(this.getById(id));
        return one;
    }

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<SysMenu> saveBatch(List<AddSysMenuQuery> batch) {
        //batch 根据httpMethod+uri去重
        Map<String, List<AddSysMenuQuery>> groupingBy = batch.stream().collect(Collectors.groupingBy(q -> q.getHttpMethod().concat(": ").concat(q.getUri())));
        List<String> repeats = groupingBy.entrySet().stream().filter(e -> e.getValue().size() > 1).map(e -> e.getKey()).toList();
        if (repeats.size() > 0) {
            String repeatStr = repeats.stream().collect(Collectors.joining(";"));
            throw new RestException(RestErrorCode.DATA_EXIST, repeatStr);
        }
        List<SysMenu> entities = this.sysMenuStructure.addQueriesToEntities(batch);
        List<SysMenu> apis = this.sysMenuMapper.listByMethodAndUri(entities);
        if (!apis.isEmpty()) {
            String existApisStr = apis.stream().map(sysApi -> sysApi.getHttpMethod().concat(": ").concat(sysApi.getUri()))
                    .collect(Collectors.joining(";"));
            throw new RestException(RestErrorCode.DATA_EXIST, existApisStr);
        }
        try {
            super.saveBatch(entities);
            return entities;
        } catch (DuplicateKeyException e) {
            throw new RestException(RestErrorCode.DATA_EXIST);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 更新
     *
     * @param batch {@link SysMenuQuery}查询条件
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateByIdBatch(List<UpdateSysMenuQuery> batch) {
        //batch 根据httpMethod+uri去重
        Map<String, List<UpdateSysMenuQuery>> groupingBy = batch.stream().collect(Collectors.groupingBy(q -> q.getHttpMethod().concat(": ").concat(q.getUri())));
        List<String> repeats = groupingBy.entrySet().stream().filter(e -> e.getValue().size() > 1).map(e -> e.getKey()).toList();
        if (repeats.size() > 0) {
            String repeatStr = repeats.stream().collect(Collectors.joining(";"));
            throw new RestException(RestErrorCode.DATA_EXIST, repeatStr);
        }
        List<SysMenu> entities = this.sysMenuStructure.updateQueriesToEntities(batch);
        List<SysMenu> apis = this.sysMenuMapper.listByMethodAndUri(entities);
        apis.forEach(api -> {
            String key = api.getHttpMethod().concat(": ").concat(api.getUri());
            List<UpdateSysMenuQuery> mayExist = groupingBy.get(key);
            if (CollectionUtil.isNotEmpty(mayExist)) {
                UpdateSysMenuQuery one = mayExist.get(0);
                //不存在或者存在的是自己本身
                Assert.isTrue(one == null || one.getId().equals(api.getId()), () -> new RestException(RestErrorCode.DATA_EXIST));
            }
        });
        try {
            return super.updateBatchById(entities);
        } catch (DuplicateKeyException e) {
            throw new RestException(RestErrorCode.DATA_EXIST);
        } catch (Exception e) {
            throw e;
        }
    }

}
