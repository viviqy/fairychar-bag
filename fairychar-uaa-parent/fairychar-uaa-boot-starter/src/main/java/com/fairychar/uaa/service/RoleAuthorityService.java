package com.fairychar.uaa.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.uaa.entity.RoleAuthority;
import com.fairychar.uaa.mapper.RoleAuthorityMapper;
import com.fairychar.uaa.pojo.dto.RoleAuthorityDTO;
import com.fairychar.uaa.pojo.query.RoleAuthorityQuery;
import com.fairychar.uaa.service.interfaces.IRoleAuthorityService;
import com.fairychar.uaa.service.structure.RoleAuthorityStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * (RoleAuthority)表服务实现类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:45
 */
@Service("roleAuthorityService")
@Transactional(rollbackFor = Exception.class)
public class RoleAuthorityService extends ServiceImpl<RoleAuthorityMapper, RoleAuthority> implements IRoleAuthorityService {
    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;
    @Autowired
    private RoleAuthorityStructure roleAuthorityStructure;

    /**
     * 条件匹配查询RoleAuthority所有数据
     *
     * @param roleAuthorityQuery {@link RoleAuthorityQuery}查询条件
     * @return 查询结果 {@link RoleAuthorityDTO}
     */
    @Override
    public List<RoleAuthorityDTO> queryAll(RoleAuthorityQuery roleAuthorityQuery) {
        RoleAuthority entity = this.roleAuthorityStructure.queryToEntity(roleAuthorityQuery);
        List<RoleAuthority> list = this.roleAuthorityMapper.queryAll(entity);
        return this.roleAuthorityStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询RoleAuthority所有数据
     *
     * @param page               分页参数
     * @param roleAuthorityQuery {@link RoleAuthorityQuery}查询条件
     * @return 查询结果 {@link RoleAuthorityDTO}
     */
    @Override
    public IPage<RoleAuthorityDTO> pageAll(Page page, RoleAuthorityQuery roleAuthorityQuery) {
        RoleAuthority entity = this.roleAuthorityStructure.queryToEntity(roleAuthorityQuery);
        IPage<RoleAuthority> queries = this.roleAuthorityMapper.pageAll(page, entity);
        List<RoleAuthorityDTO> dtos = this.roleAuthorityStructure.entitiesToDtos(queries.getRecords());
        Page<RoleAuthorityDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param roleAuthorityQuery {@link RoleAuthorityQuery}查询条件
     * @return 是否成功
     */
    @Override
    public RoleAuthorityDTO save(RoleAuthorityQuery roleAuthorityQuery) {
        RoleAuthority entity = this.roleAuthorityStructure.queryToEntity(roleAuthorityQuery);
        return super.save(entity) == true ? this.roleAuthorityStructure.entityToDto(entity) : null;
    }

    /**
     * 更新
     *
     * @param roleAuthorityQuery {@link RoleAuthorityQuery}查询条件
     * @return 是否成功
     */
    @Override
    public RoleAuthorityDTO updateById(RoleAuthorityQuery roleAuthorityQuery) {
        RoleAuthority entity = this.roleAuthorityStructure.queryToEntity(roleAuthorityQuery);
        return super.updateById(entity) == true ? this.roleAuthorityStructure.entityToDto(entity) : null;
    }

    /**
     * 分页查询(全等匹配)
     *
     * @param page               分页对象
     * @param roleAuthorityQuery {@link RoleAuthorityQuery}查询条件
     * @return 查询结果 {@link RoleAuthorityDTO}
     */
    @Override
    public IPage<RoleAuthorityDTO> page(Page page, RoleAuthorityQuery roleAuthorityQuery) {
        RoleAuthority entity = this.roleAuthorityStructure.queryToEntity(roleAuthorityQuery);
        return this.page(page, new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     *
     * @param roleAuthorityQuery {@link RoleAuthorityQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(RoleAuthorityQuery roleAuthorityQuery) {
        RoleAuthority entity = this.roleAuthorityStructure.queryToEntity(roleAuthorityQuery);
        return this.roleAuthorityMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link RoleAuthorityDTO}
     */
    @Override
    public RoleAuthorityDTO findOne(Serializable id) {
        RoleAuthorityDTO one = this.roleAuthorityStructure.entityToDto(super.getById(id));
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
    public boolean saveBatch(List<RoleAuthorityQuery> batch) {
        List<RoleAuthority> queries = this.roleAuthorityStructure.queriesToEntities(batch);
        return this.saveBatch(queries);
    }
}