package com.fairychar.uaa.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.uaa.entity.OrganizationCustomer;
import com.fairychar.uaa.mapper.OrganizationCustomerMapper;
import com.fairychar.uaa.pojo.dto.OrganizationCustomerDTO;
import com.fairychar.uaa.pojo.query.OrganizationCustomerQuery;
import com.fairychar.uaa.service.interfaces.IOrganizationCustomerService;
import com.fairychar.uaa.service.structure.OrganizationCustomerStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * (OrganizationCustomer)表服务实现类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:39
 */
@Service("organizationCustomerService")
@Transactional(rollbackFor = Exception.class)
public class OrganizationCustomerService extends ServiceImpl<OrganizationCustomerMapper, OrganizationCustomer> implements IOrganizationCustomerService {
    @Autowired
    private OrganizationCustomerMapper organizationCustomerMapper;
    @Autowired
    private OrganizationCustomerStructure organizationCustomerStructure;

    /**
     * 条件匹配查询OrganizationCustomer所有数据
     *
     * @param organizationCustomerQuery {@link OrganizationCustomerQuery}查询条件
     * @return 查询结果 {@link OrganizationCustomerDTO}
     */
    @Override
    public List<OrganizationCustomerDTO> queryAll(OrganizationCustomerQuery organizationCustomerQuery) {
        OrganizationCustomer entity = this.organizationCustomerStructure.queryToEntity(organizationCustomerQuery);
        List<OrganizationCustomer> list = this.organizationCustomerMapper.queryAll(entity);
        return this.organizationCustomerStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询OrganizationCustomer所有数据
     *
     * @param page                      分页参数
     * @param organizationCustomerQuery {@link OrganizationCustomerQuery}查询条件
     * @return 查询结果 {@link OrganizationCustomerDTO}
     */
    @Override
    public IPage<OrganizationCustomerDTO> pageAll(Page page, OrganizationCustomerQuery organizationCustomerQuery) {
        OrganizationCustomer entity = this.organizationCustomerStructure.queryToEntity(organizationCustomerQuery);
        IPage<OrganizationCustomer> queries = this.organizationCustomerMapper.pageAll(page, entity);
        List<OrganizationCustomerDTO> dtos = this.organizationCustomerStructure.entitiesToDtos(queries.getRecords());
        Page<OrganizationCustomerDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param organizationCustomerQuery {@link OrganizationCustomerQuery}查询条件
     * @return 是否成功
     */
    @Override
    public OrganizationCustomerDTO save(OrganizationCustomerQuery organizationCustomerQuery) {
        OrganizationCustomer entity = this.organizationCustomerStructure.queryToEntity(organizationCustomerQuery);
        return super.save(entity) == true ? this.organizationCustomerStructure.entityToDto(entity) : null;
    }

    /**
     * 更新
     *
     * @param organizationCustomerQuery {@link OrganizationCustomerQuery}查询条件
     * @return 是否成功
     */
    @Override
    public OrganizationCustomerDTO updateById(OrganizationCustomerQuery organizationCustomerQuery) {
        OrganizationCustomer entity = this.organizationCustomerStructure.queryToEntity(organizationCustomerQuery);
        return super.updateById(entity) == true ? this.organizationCustomerStructure.entityToDto(entity) : null;
    }

    /**
     * 分页查询(全等匹配)
     *
     * @param page                      分页对象
     * @param organizationCustomerQuery {@link OrganizationCustomerQuery}查询条件
     * @return 查询结果 {@link OrganizationCustomerDTO}
     */
    @Override
    public IPage<OrganizationCustomerDTO> page(Page page, OrganizationCustomerQuery organizationCustomerQuery) {
        OrganizationCustomer entity = this.organizationCustomerStructure.queryToEntity(organizationCustomerQuery);
        return this.page(page, new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     *
     * @param organizationCustomerQuery {@link OrganizationCustomerQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(OrganizationCustomerQuery organizationCustomerQuery) {
        OrganizationCustomer entity = this.organizationCustomerStructure.queryToEntity(organizationCustomerQuery);
        return this.organizationCustomerMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link OrganizationCustomerDTO}
     */
    @Override
    public OrganizationCustomerDTO findOne(Serializable id) {
        OrganizationCustomerDTO one = this.organizationCustomerStructure.entityToDto(super.getById(id));
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
    public boolean saveBatch(List<OrganizationCustomerQuery> batch) {
        List<OrganizationCustomer> queries = this.organizationCustomerStructure.queriesToEntities(batch);
        return this.saveBatch(queries);
    }
}