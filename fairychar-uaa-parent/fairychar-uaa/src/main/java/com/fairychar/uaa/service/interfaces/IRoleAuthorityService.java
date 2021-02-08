package com.fairychar.uaa.service.interfaces;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.uaa.entity.RoleAuthority;
import com.fairychar.uaa.pojo.dto.RoleAuthorityDTO;
import com.fairychar.uaa.pojo.query.RoleAuthorityQuery;
import org.springframework.cache.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (RoleAuthority)表服务接口
 *
 * @author chiyo
 * @since 2021-02-08 17:38:46
 */
@CacheConfig(cacheNames = "simple:roleAuthority:")
public interface IRoleAuthorityService extends IService<RoleAuthority> {
    /**
     * 条件匹配查询RoleAuthority所有数据
     *
     * @param roleAuthorityQuery {@link RoleAuthorityQuery}查询条件
     * @return 查询结果 {@link RoleAuthorityDTO}
     */
    List<RoleAuthorityDTO> queryAll(RoleAuthorityQuery roleAuthorityQuery);

    /**
     * 条件匹配分页查询RoleAuthority所有数据
     *
     * @param page               分页参数
     * @param roleAuthorityQuery {@link RoleAuthorityQuery}查询条件
     * @return 查询结果 {@link RoleAuthorityDTO}
     */
    IPage<RoleAuthorityDTO> pageAll(Page page, RoleAuthorityQuery roleAuthorityQuery);

    /**
     * 插入
     *
     * @param roleAuthorityQuery {@link RoleAuthorityQuery}插入query
     * @return 是否成功
     */
    @Caching(put = {
            @CachePut(key = "#roleAuthorityQuery.id", unless = "#result!=null", condition = "#roleAuthorityQuery!=null && #roleAuthorityQuery.id!=null")
    })
    RoleAuthorityDTO save(RoleAuthorityQuery roleAuthorityQuery);

    /**
     * 更新
     *
     * @param roleAuthorityQuery {@link RoleAuthorityQuery}更新query
     * @return 是否成功
     */
    @Caching(put = {
            @CachePut(key = "#roleAuthorityQuery.id", unless = "#result!=null", condition = "#roleAuthorityQuery!=null && #roleAuthorityQuery.id!=null")
    })
    RoleAuthorityDTO updateById(RoleAuthorityQuery roleAuthorityQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param page               分页对象
     * @param roleAuthorityQuery {@link RoleAuthorityQuery}查询条件
     * @return 查询结果 {@link RoleAuthorityDTO}
     */
    IPage<RoleAuthorityDTO> page(Page page, RoleAuthorityQuery roleAuthorityQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link RoleAuthorityDTO}
     */
    @Caching(cacheable = {
            @Cacheable(key = "#id", unless = "#result==null", condition = "#id!=null")
    })
    RoleAuthorityDTO findOne(Serializable id);

    /**
     * 条件查询总数
     *
     * @param roleAuthorityQuery {@link RoleAuthorityQuery}查询条件
     * @return 总数
     */
    int count(RoleAuthorityQuery roleAuthorityQuery);

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
    boolean saveBatch(List<RoleAuthorityQuery> batch);

}