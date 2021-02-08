package com.fairychar.uaa.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.uaa.entity.CustomerRole;
import com.fairychar.uaa.mapper.CustomerRoleMapper;
import com.fairychar.uaa.pojo.dto.CustomerRoleDTO;
import com.fairychar.uaa.pojo.query.CustomerRoleQuery;
import com.fairychar.uaa.service.interfaces.ICustomerRoleService;
import com.fairychar.uaa.service.structure.CustomerRoleStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * (CustomerRole)表服务实现类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:32
 */
@Service("customerRoleService")
@Transactional(rollbackFor = Exception.class)
public class CustomerRoleService extends ServiceImpl<CustomerRoleMapper, CustomerRole> implements ICustomerRoleService {
    @Autowired
    private CustomerRoleMapper customerRoleMapper;
    @Autowired
    private CustomerRoleStructure customerRoleStructure;

    /**
     * 条件匹配查询CustomerRole所有数据
     *
     * @param customerRoleQuery {@link CustomerRoleQuery}查询条件
     * @return 查询结果 {@link CustomerRoleDTO}
     */
    @Override
    public List<CustomerRoleDTO> queryAll(CustomerRoleQuery customerRoleQuery) {
        CustomerRole entity = this.customerRoleStructure.queryToEntity(customerRoleQuery);
        List<CustomerRole> list = this.customerRoleMapper.queryAll(entity);
        return this.customerRoleStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询CustomerRole所有数据
     *
     * @param page              分页参数
     * @param customerRoleQuery {@link CustomerRoleQuery}查询条件
     * @return 查询结果 {@link CustomerRoleDTO}
     */
    @Override
    public IPage<CustomerRoleDTO> pageAll(Page page, CustomerRoleQuery customerRoleQuery) {
        CustomerRole entity = this.customerRoleStructure.queryToEntity(customerRoleQuery);
        IPage<CustomerRole> queries = this.customerRoleMapper.pageAll(page, entity);
        List<CustomerRoleDTO> dtos = this.customerRoleStructure.entitiesToDtos(queries.getRecords());
        Page<CustomerRoleDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param customerRoleQuery {@link CustomerRoleQuery}查询条件
     * @return 是否成功
     */
    @Override
    public CustomerRoleDTO save(CustomerRoleQuery customerRoleQuery) {
        CustomerRole entity = this.customerRoleStructure.queryToEntity(customerRoleQuery);
        return super.save(entity) == true ? this.customerRoleStructure.entityToDto(entity) : null;
    }

    /**
     * 更新
     *
     * @param customerRoleQuery {@link CustomerRoleQuery}查询条件
     * @return 是否成功
     */
    @Override
    public CustomerRoleDTO updateById(CustomerRoleQuery customerRoleQuery) {
        CustomerRole entity = this.customerRoleStructure.queryToEntity(customerRoleQuery);
        return super.updateById(entity) == true ? this.customerRoleStructure.entityToDto(entity) : null;
    }

    /**
     * 分页查询(全等匹配)
     *
     * @param page              分页对象
     * @param customerRoleQuery {@link CustomerRoleQuery}查询条件
     * @return 查询结果 {@link CustomerRoleDTO}
     */
    @Override
    public IPage<CustomerRoleDTO> page(Page page, CustomerRoleQuery customerRoleQuery) {
        CustomerRole entity = this.customerRoleStructure.queryToEntity(customerRoleQuery);
        return this.page(page, new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     *
     * @param customerRoleQuery {@link CustomerRoleQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(CustomerRoleQuery customerRoleQuery) {
        CustomerRole entity = this.customerRoleStructure.queryToEntity(customerRoleQuery);
        return this.customerRoleMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link CustomerRoleDTO}
     */
    @Override
    public CustomerRoleDTO findOne(Serializable id) {
        CustomerRoleDTO one = this.customerRoleStructure.entityToDto(super.getById(id));
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
    public boolean saveBatch(List<CustomerRoleQuery> batch) {
        List<CustomerRole> queries = this.customerRoleStructure.queriesToEntities(batch);
        return this.saveBatch(queries);
    }
}