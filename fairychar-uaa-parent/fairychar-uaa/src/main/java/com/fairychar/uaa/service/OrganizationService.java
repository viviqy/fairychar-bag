package com.fairychar.uaa.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.uaa.entity.Organization;
import com.fairychar.uaa.mapper.OrganizationMapper;
import com.fairychar.uaa.pojo.dto.OrganizationDTO;
import com.fairychar.uaa.pojo.query.OrganizationQuery;
import com.fairychar.uaa.service.interfaces.IOrganizationService;
import com.fairychar.uaa.service.structure.OrganizationStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * (Organization)表服务实现类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:36
 */
@Service("organizationService")
@Transactional(rollbackFor = Exception.class)
public class OrganizationService extends ServiceImpl<OrganizationMapper, Organization> implements IOrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private OrganizationStructure organizationStructure;

    /**
     * 条件匹配查询Organization所有数据
     *
     * @param organizationQuery {@link OrganizationQuery}查询条件
     * @return 查询结果 {@link OrganizationDTO}
     */
    @Override
    public List<OrganizationDTO> queryAll(OrganizationQuery organizationQuery) {
        Organization entity = this.organizationStructure.queryToEntity(organizationQuery);
        List<Organization> list = this.organizationMapper.queryAll(entity);
        return this.organizationStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询Organization所有数据
     *
     * @param page              分页参数
     * @param organizationQuery {@link OrganizationQuery}查询条件
     * @return 查询结果 {@link OrganizationDTO}
     */
    @Override
    public IPage<OrganizationDTO> pageAll(Page page, OrganizationQuery organizationQuery) {
        Organization entity = this.organizationStructure.queryToEntity(organizationQuery);
        IPage<Organization> queries = this.organizationMapper.pageAll(page, entity);
        List<OrganizationDTO> dtos = this.organizationStructure.entitiesToDtos(queries.getRecords());
        Page<OrganizationDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param organizationQuery {@link OrganizationQuery}查询条件
     * @return 是否成功
     */
    @Override
    public OrganizationDTO save(OrganizationQuery organizationQuery) {
        Organization entity = this.organizationStructure.queryToEntity(organizationQuery);
        return super.save(entity) == true ? this.organizationStructure.entityToDto(entity) : null;
    }

    /**
     * 更新
     *
     * @param organizationQuery {@link OrganizationQuery}查询条件
     * @return 是否成功
     */
    @Override
    public OrganizationDTO updateById(OrganizationQuery organizationQuery) {
        Organization entity = this.organizationStructure.queryToEntity(organizationQuery);
        return super.updateById(entity) == true ? this.organizationStructure.entityToDto(entity) : null;
    }

    /**
     * 分页查询(全等匹配)
     *
     * @param page              分页对象
     * @param organizationQuery {@link OrganizationQuery}查询条件
     * @return 查询结果 {@link OrganizationDTO}
     */
    @Override
    public IPage<OrganizationDTO> page(Page page, OrganizationQuery organizationQuery) {
        Organization entity = this.organizationStructure.queryToEntity(organizationQuery);
        return this.page(page, new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     *
     * @param organizationQuery {@link OrganizationQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(OrganizationQuery organizationQuery) {
        Organization entity = this.organizationStructure.queryToEntity(organizationQuery);
        return this.organizationMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link OrganizationDTO}
     */
    @Override
    public OrganizationDTO findOne(Serializable id) {
        OrganizationDTO one = this.organizationStructure.entityToDto(super.getById(id));
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
    public boolean saveBatch(List<OrganizationQuery> batch) {
        List<Organization> queries = this.organizationStructure.queriesToEntities(batch);
        return this.saveBatch(queries);
    }
}