package com.fairychar.uaa.service.interfaces;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.uaa.entity.CustomerRole;
import com.fairychar.uaa.pojo.dto.CustomerRoleDTO;
import com.fairychar.uaa.pojo.query.CustomerRoleQuery;
import org.springframework.cache.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (CustomerRole)表服务接口
 *
 * @author chiyo
 * @since 2021-02-08 17:38:33
 */
@CacheConfig(cacheNames = "simple:customerRole:")
public interface ICustomerRoleService extends IService<CustomerRole> {
    /**
     * 条件匹配查询CustomerRole所有数据
     *
     * @param customerRoleQuery {@link CustomerRoleQuery}查询条件
     * @return 查询结果 {@link CustomerRoleDTO}
     */
    List<CustomerRoleDTO> queryAll(CustomerRoleQuery customerRoleQuery);

    /**
     * 条件匹配分页查询CustomerRole所有数据
     *
     * @param page              分页参数
     * @param customerRoleQuery {@link CustomerRoleQuery}查询条件
     * @return 查询结果 {@link CustomerRoleDTO}
     */
    IPage<CustomerRoleDTO> pageAll(Page page, CustomerRoleQuery customerRoleQuery);

    /**
     * 插入
     *
     * @param customerRoleQuery {@link CustomerRoleQuery}插入query
     * @return 是否成功
     */
    @Caching(put = {
            @CachePut(key = "#customerRoleQuery.id", unless = "#result!=null", condition = "#customerRoleQuery!=null && #customerRoleQuery.id!=null")
    })
    CustomerRoleDTO save(CustomerRoleQuery customerRoleQuery);

    /**
     * 更新
     *
     * @param customerRoleQuery {@link CustomerRoleQuery}更新query
     * @return 是否成功
     */
    @Caching(put = {
            @CachePut(key = "#customerRoleQuery.id", unless = "#result!=null", condition = "#customerRoleQuery!=null && #customerRoleQuery.id!=null")
    })
    CustomerRoleDTO updateById(CustomerRoleQuery customerRoleQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param page              分页对象
     * @param customerRoleQuery {@link CustomerRoleQuery}查询条件
     * @return 查询结果 {@link CustomerRoleDTO}
     */
    IPage<CustomerRoleDTO> page(Page page, CustomerRoleQuery customerRoleQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link CustomerRoleDTO}
     */
    @Caching(cacheable = {
            @Cacheable(key = "#id", unless = "#result==null", condition = "#id!=null")
    })
    CustomerRoleDTO findOne(Serializable id);

    /**
     * 条件查询总数
     *
     * @param customerRoleQuery {@link CustomerRoleQuery}查询条件
     * @return 总数
     */
    int count(CustomerRoleQuery customerRoleQuery);

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
    boolean saveBatch(List<CustomerRoleQuery> batch);

}