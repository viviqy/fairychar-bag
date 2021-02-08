package com.fairychar.uaa.service.interfaces;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.uaa.entity.Organization;
import com.fairychar.uaa.pojo.dto.OrganizationDTO;
import com.fairychar.uaa.pojo.query.OrganizationQuery;
import org.springframework.cache.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (Organization)表服务接口
 *
 * @author chiyo
 * @since 2021-02-08 17:38:36
 */
@CacheConfig(cacheNames = "simple:organization:")
public interface IOrganizationService extends IService<Organization> {
    /**
     * 条件匹配查询Organization所有数据
     *
     * @param organizationQuery {@link OrganizationQuery}查询条件
     * @return 查询结果 {@link OrganizationDTO}
     */
    List<OrganizationDTO> queryAll(OrganizationQuery organizationQuery);

    /**
     * 条件匹配分页查询Organization所有数据
     *
     * @param page              分页参数
     * @param organizationQuery {@link OrganizationQuery}查询条件
     * @return 查询结果 {@link OrganizationDTO}
     */
    IPage<OrganizationDTO> pageAll(Page page, OrganizationQuery organizationQuery);

    /**
     * 插入
     *
     * @param organizationQuery {@link OrganizationQuery}插入query
     * @return 是否成功
     */
    @Caching(put = {
            @CachePut(key = "#organizationQuery.id", unless = "#result!=null", condition = "#organizationQuery!=null && #organizationQuery.id!=null")
    })
    OrganizationDTO save(OrganizationQuery organizationQuery);

    /**
     * 更新
     *
     * @param organizationQuery {@link OrganizationQuery}更新query
     * @return 是否成功
     */
    @Caching(put = {
            @CachePut(key = "#organizationQuery.id", unless = "#result!=null", condition = "#organizationQuery!=null && #organizationQuery.id!=null")
    })
    OrganizationDTO updateById(OrganizationQuery organizationQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param page              分页对象
     * @param organizationQuery {@link OrganizationQuery}查询条件
     * @return 查询结果 {@link OrganizationDTO}
     */
    IPage<OrganizationDTO> page(Page page, OrganizationQuery organizationQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link OrganizationDTO}
     */
    @Caching(cacheable = {
            @Cacheable(key = "#id", unless = "#result==null", condition = "#id!=null")
    })
    OrganizationDTO findOne(Serializable id);

    /**
     * 条件查询总数
     *
     * @param organizationQuery {@link OrganizationQuery}查询条件
     * @return 总数
     */
    int count(OrganizationQuery organizationQuery);

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
    boolean saveBatch(List<OrganizationQuery> batch);

}