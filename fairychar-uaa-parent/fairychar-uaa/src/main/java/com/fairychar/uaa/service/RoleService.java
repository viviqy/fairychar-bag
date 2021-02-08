package com.fairychar.uaa.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.uaa.entity.Role;
import com.fairychar.uaa.mapper.RoleMapper;
import com.fairychar.uaa.pojo.dto.RoleDTO;
import com.fairychar.uaa.pojo.query.RoleQuery;
import com.fairychar.uaa.service.interfaces.IRoleService;
import com.fairychar.uaa.service.structure.RoleStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:42
 */
@Service("roleService")
@Transactional(rollbackFor = Exception.class)
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleStructure roleStructure;

    /**
     * 条件匹配查询Role所有数据
     *
     * @param roleQuery {@link RoleQuery}查询条件
     * @return 查询结果 {@link RoleDTO}
     */
    @Override
    public List<RoleDTO> queryAll(RoleQuery roleQuery) {
        Role entity = this.roleStructure.queryToEntity(roleQuery);
        List<Role> list = this.roleMapper.queryAll(entity);
        return this.roleStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询Role所有数据
     *
     * @param page      分页参数
     * @param roleQuery {@link RoleQuery}查询条件
     * @return 查询结果 {@link RoleDTO}
     */
    @Override
    public IPage<RoleDTO> pageAll(Page page, RoleQuery roleQuery) {
        Role entity = this.roleStructure.queryToEntity(roleQuery);
        IPage<Role> queries = this.roleMapper.pageAll(page, entity);
        List<RoleDTO> dtos = this.roleStructure.entitiesToDtos(queries.getRecords());
        Page<RoleDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param roleQuery {@link RoleQuery}查询条件
     * @return 是否成功
     */
    @Override
    public RoleDTO save(RoleQuery roleQuery) {
        Role entity = this.roleStructure.queryToEntity(roleQuery);
        return super.save(entity) == true ? this.roleStructure.entityToDto(entity) : null;
    }

    /**
     * 更新
     *
     * @param roleQuery {@link RoleQuery}查询条件
     * @return 是否成功
     */
    @Override
    public RoleDTO updateById(RoleQuery roleQuery) {
        Role entity = this.roleStructure.queryToEntity(roleQuery);
        return super.updateById(entity) == true ? this.roleStructure.entityToDto(entity) : null;
    }

    /**
     * 分页查询(全等匹配)
     *
     * @param page      分页对象
     * @param roleQuery {@link RoleQuery}查询条件
     * @return 查询结果 {@link RoleDTO}
     */
    @Override
    public IPage<RoleDTO> page(Page page, RoleQuery roleQuery) {
        Role entity = this.roleStructure.queryToEntity(roleQuery);
        return this.page(page, new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     *
     * @param roleQuery {@link RoleQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(RoleQuery roleQuery) {
        Role entity = this.roleStructure.queryToEntity(roleQuery);
        return this.roleMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link RoleDTO}
     */
    @Override
    public RoleDTO findOne(Serializable id) {
        RoleDTO one = this.roleStructure.entityToDto(super.getById(id));
        return one;
    }

    /**
     * 根据id删除一条数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    @Override
    public boolean saveBatch(List<RoleQuery> batch) {
        List<Role> queries = this.roleStructure.queriesToEntities(batch);
        return this.saveBatch(queries);
    }
}