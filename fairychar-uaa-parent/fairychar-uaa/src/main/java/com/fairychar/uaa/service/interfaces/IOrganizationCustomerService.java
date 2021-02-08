package com.fairychar.uaa.service.interfaces;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.uaa.entity.OrganizationCustomer;
import com.fairychar.uaa.pojo.dto.OrganizationCustomerDTO;
import com.fairychar.uaa.pojo.query.OrganizationCustomerQuery;
import org.springframework.cache.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (OrganizationCustomer)表服务接口
 *
 * @author chiyo
 * @since 2021-02-08 17:38:39
 */
@CacheConfig(cacheNames = "simple:organizationCustomer:")
public interface IOrganizationCustomerService extends IService<OrganizationCustomer> {
    /**
     * 条件匹配查询OrganizationCustomer所有数据
     *
     * @param organizationCustomerQuery {@link OrganizationCustomerQuery}查询条件
     * @return 查询结果 {@link OrganizationCustomerDTO}
     */
    List<OrganizationCustomerDTO> queryAll(OrganizationCustomerQuery organizationCustomerQuery);

    /**
     * 条件匹配分页查询OrganizationCustomer所有数据
     *
     * @param page                      分页参数
     * @param organizationCustomerQuery {@link OrganizationCustomerQuery}查询条件
     * @return 查询结果 {@link OrganizationCustomerDTO}
     */
    IPage<OrganizationCustomerDTO> pageAll(Page page, OrganizationCustomerQuery organizationCustomerQuery);

    /**
     * 插入
     *
     * @param organizationCustomerQuery {@link OrganizationCustomerQuery}插入query
     * @return 是否成功
     */
    @Caching(put = {
            @CachePut(key = "#organizationCustomerQuery.id", unless = "#result!=null", condition = "#organizationCustomerQuery!=null && #organizationCustomerQuery.id!=null")
    })
    OrganizationCustomerDTO save(OrganizationCustomerQuery organizationCustomerQuery);

    /**
     * 更新
     *
     * @param organizationCustomerQuery {@link OrganizationCustomerQuery}更新query
     * @return 是否成功
     */
    @Caching(put = {
            @CachePut(key = "#organizationCustomerQuery.id", unless = "#result!=null", condition = "#organizationCustomerQuery!=null && #organizationCustomerQuery.id!=null")
    })
    OrganizationCustomerDTO updateById(OrganizationCustomerQuery organizationCustomerQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param page                      分页对象
     * @param organizationCustomerQuery {@link OrganizationCustomerQuery}查询条件
     * @return 查询结果 {@link OrganizationCustomerDTO}
     */
    IPage<OrganizationCustomerDTO> page(Page page, OrganizationCustomerQuery organizationCustomerQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link OrganizationCustomerDTO}
     */
    @Caching(cacheable = {
            @Cacheable(key = "#id", unless = "#result==null", condition = "#id!=null")
    })
    OrganizationCustomerDTO findOne(Serializable id);

    /**
     * 条件查询总数
     *
     * @param organizationCustomerQuery {@link OrganizationCustomerQuery}查询条件
     * @return 总数
     */
    int count(OrganizationCustomerQuery organizationCustomerQuery);

    /**
     * 根据id删除一条数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Caching(evict = {
            @CacheEvict(key = "#id", condition = "#id!=null")
    })
    boolean removeById(Serializable id);

    /**
     * 批量新增
     *
     * @param batch 新增数据
     * @return 是否成功
     */
    boolean saveBatch(List<OrganizationCustomerQuery> batch);

}