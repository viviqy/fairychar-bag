package com.fairychar.uaa.service.interfaces;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.uaa.entity.Authority;
import com.fairychar.uaa.pojo.dto.AuthorityDTO;
import com.fairychar.uaa.pojo.query.AuthorityQuery;
import org.springframework.cache.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (Authority)表服务接口
 *
 * @author chiyo
 * @since 2021-02-08 17:38:25
 */
@CacheConfig(cacheNames = "simple:authority:")
public interface IAuthorityService extends IService<Authority> {
    /**
     * 条件匹配查询Authority所有数据
     *
     * @param authorityQuery {@link AuthorityQuery}查询条件
     * @return 查询结果 {@link AuthorityDTO}
     */
    List<AuthorityDTO> queryAll(AuthorityQuery authorityQuery);

    /**
     * 条件匹配分页查询Authority所有数据
     *
     * @param page           分页参数
     * @param authorityQuery {@link AuthorityQuery}查询条件
     * @return 查询结果 {@link AuthorityDTO}
     */
    IPage<AuthorityDTO> pageAll(Page page, AuthorityQuery authorityQuery);

    /**
     * 插入
     *
     * @param authorityQuery {@link AuthorityQuery}插入query
     * @return 是否成功
     */
    @Caching(put = {
            @CachePut(key = "#authorityQuery.id", unless = "#result!=null", condition = "#authorityQuery!=null && #authorityQuery.id!=null")
    })
    AuthorityDTO save(AuthorityQuery authorityQuery);

    /**
     * 更新
     *
     * @param authorityQuery {@link AuthorityQuery}更新query
     * @return 是否成功
     */
    @Caching(put = {
            @CachePut(key = "#authorityQuery.id", unless = "#result!=null", condition = "#authorityQuery!=null && #authorityQuery.id!=null")
    })
    AuthorityDTO updateById(AuthorityQuery authorityQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param page           分页对象
     * @param authorityQuery {@link AuthorityQuery}查询条件
     * @return 查询结果 {@link AuthorityDTO}
     */
    IPage<AuthorityDTO> page(Page page, AuthorityQuery authorityQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link AuthorityDTO}
     */
    @Caching(cacheable = {
            @Cacheable(key = "#id", unless = "#result==null", condition = "#id!=null")
    })
    AuthorityDTO findOne(Serializable id);

    /**
     * 条件查询总数
     *
     * @param authorityQuery {@link AuthorityQuery}查询条件
     * @return 总数
     */
    int count(AuthorityQuery authorityQuery);

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
    boolean saveBatch(List<AuthorityQuery> batch);

}