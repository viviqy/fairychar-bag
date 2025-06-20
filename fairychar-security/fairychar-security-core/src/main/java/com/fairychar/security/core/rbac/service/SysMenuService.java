package com.fairychar.security.core.rbac.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.security.core.rbac.entity.SysMenu;
import com.fairychar.security.core.rbac.mapper.SysMenuMapper;
import com.fairychar.security.core.rbac.pojo.dto.SysMenuDTO;
import com.fairychar.security.core.rbac.pojo.query.SysMenuQuery;
import com.fairychar.security.core.rbac.service.interfaces.ISysMenuService;
import com.fairychar.security.core.rbac.service.structure.SysMenuStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 系统菜单(SysMenu)表服务实现类
 *
 * @author chiyo
 */
@Service("sysMenuService")
@Transactional(rollbackFor = Exception.class)
public class SysMenuService extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysMenuStructure sysMenuStructure;

    /**
     * 条件全等匹配查询SysMenu单条数据
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 查询结果 {@link SysMenuDTO}
     */
    @Override
    public SysMenuDTO findOne(SysMenuQuery sysMenuQuery) {
        SysMenu entity = this.sysMenuStructure.queryToEntity(sysMenuQuery);
        SysMenu one = super.getOne(new QueryWrapper<SysMenu>(entity));
        return this.sysMenuStructure.entityToDto(one);
    }

    /**
     * 条件匹配查询SysMenu所有数据
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 查询结果 {@link SysMenuDTO}
     */
    @Override
    public List<SysMenuDTO> queryAll(SysMenuQuery sysMenuQuery) {
        SysMenu entity = this.sysMenuStructure.queryToEntity(sysMenuQuery);
        List<SysMenu> list = this.sysMenuMapper.queryAll(entity);
        return this.sysMenuStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询SysMenu所有数据
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 查询结果 {@link SysMenuDTO}
     */
    @Override
    public Page<SysMenuDTO> pageAll(SysMenuQuery sysMenuQuery) {
        SysMenu entity = this.sysMenuStructure.queryToEntity(sysMenuQuery);
        Page<SysMenu> queries = this.sysMenuMapper.pageAll(sysMenuQuery.getPageQuery(), entity);
        List<SysMenuDTO> dtos = this.sysMenuStructure.entitiesToDtos(queries.getRecords());
        Page<SysMenuDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean save(SysMenuQuery sysMenuQuery) {
        SysMenu entity = this.sysMenuStructure.queryToEntity(sysMenuQuery);
        return this.save(entity);
    }

    /**
     * 更新
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean updateById(SysMenuQuery sysMenuQuery) {
        SysMenu entity = this.sysMenuStructure.queryToEntity(sysMenuQuery);
        return super.updateById(entity);
    }

    /**
     * 分页查询(全等匹配)
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 查询结果 {@link SysMenuDTO}
     */
    @Override
    public Page<SysMenuDTO> page(SysMenuQuery sysMenuQuery) {
        SysMenu entity = this.sysMenuStructure.queryToEntity(sysMenuQuery);
        return super.page(sysMenuQuery.getPageQuery(), new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(SysMenuQuery sysMenuQuery) {
        SysMenu entity = this.sysMenuStructure.queryToEntity(sysMenuQuery);
        return this.sysMenuMapper.count(entity);
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
    public boolean saveBatch(List<SysMenuQuery> batch) {
        List<SysMenu> entities = this.sysMenuStructure.queriesToEntities(batch);
        return super.saveBatch(entities);
    }

    /**
     * 条件全等匹配查询SysMenu所有数据
     *
     * @param sysMenuQuery {@link SysMenuQuery}查询条件
     * @return 查询结果 {@link SysMenuDTO}
     */
    @Override
    public List<SysMenuDTO> findAll(SysMenuQuery sysMenuQuery) {
        SysMenu entity = this.sysMenuStructure.queryToEntity(sysMenuQuery);
        List<SysMenu> list = super.list(new QueryWrapper<SysMenu>(entity));
        return this.sysMenuStructure.entitiesToDtos(list);
    }
}
