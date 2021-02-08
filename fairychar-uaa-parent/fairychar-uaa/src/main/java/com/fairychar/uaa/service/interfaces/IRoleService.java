package com.fairychar.uaa.service.interfaces;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.uaa.entity.Role;
import com.fairychar.uaa.pojo.dto.RoleDTO;
import com.fairychar.uaa.pojo.query.RoleQuery;
import org.springframework.cache.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (Role)表服务接口
 *
 * @author chiyo
 * @since 2021-02-08 17:38:43
 */
@CacheConfig(cacheNames = "simple:role:")
public interface IRoleService extends IService<Role> {
    /**
     * 条件匹配查询Role所有数据
     *
     * @param roleQuery {@link RoleQuery}查询条件
     * @return 查询结果 {@link RoleDTO}
     */
    List<RoleDTO> queryAll(RoleQuery roleQuery);

    /**
     * 条件匹配分页查询Role所有数据
     *
     * @param page      分页参数
     * @param roleQuery {@link RoleQuery}查询条件
     * @return 查询结果 {@link RoleDTO}
     */
    IPage<RoleDTO> pageAll(Page page, RoleQuery roleQuery);

    /**
     * 插入
     *
     * @param roleQuery {@link RoleQuery}插入query
     * @return 是否成功
     */
    @Caching(put = {
            @CachePut(key = "#roleQuery.id", unless = "#result!=null", condition = "#roleQuery!=null && #roleQuery.id!=null")
    })
    RoleDTO save(RoleQuery roleQuery);

    /**
     * 更新
     *
     * @param roleQuery {@link RoleQuery}更新query
     * @return 是否成功
     */
    @Caching(put = {
            @CachePut(key = "#roleQuery.id", unless = "#result!=null", condition = "#roleQuery!=null && #roleQuery.id!=null")
    })
    RoleDTO updateById(RoleQuery roleQuery);

    /**
     * 分页查询(全等匹配)
     *
     * @param page      分页对象
     * @param roleQuery {@link RoleQuery}查询条件
     * @return 查询结果 {@link RoleDTO}
     */
    IPage<RoleDTO> page(Page page, RoleQuery roleQuery);

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link RoleDTO}
     */
    @Caching(cacheable = {
            @Cacheable(key = "#id", unless = "#result==null", condition = "#id!=null")
    })
    RoleDTO findOne(Serializable id);

    /**
     * 条件查询总数
     *
     * @param roleQuery {@link RoleQuery}查询条件
     * @return 总数
     */
    int count(RoleQuery roleQuery);

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
    boolean saveBatch(List<RoleQuery> batch);

}