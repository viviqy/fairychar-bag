package com.fairychar.uaa.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.uaa.entity.Authority;
import com.fairychar.uaa.mapper.AuthorityMapper;
import com.fairychar.uaa.pojo.dto.AuthorityDTO;
import com.fairychar.uaa.pojo.query.AuthorityQuery;
import com.fairychar.uaa.service.interfaces.IAuthorityService;
import com.fairychar.uaa.service.structure.AuthorityStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * (Authority)表服务实现类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:24
 */
@Service("authorityService")
@Transactional(rollbackFor = Exception.class)
public class AuthorityService extends ServiceImpl<AuthorityMapper, Authority> implements IAuthorityService {
    @Autowired
    private AuthorityMapper authorityMapper;
    @Autowired
    private AuthorityStructure authorityStructure;

    /**
     * 条件匹配查询Authority所有数据
     *
     * @param authorityQuery {@link AuthorityQuery}查询条件
     * @return 查询结果 {@link AuthorityDTO}
     */
    @Override
    public List<AuthorityDTO> queryAll(AuthorityQuery authorityQuery) {
        Authority entity = this.authorityStructure.queryToEntity(authorityQuery);
        List<Authority> list = this.authorityMapper.queryAll(entity);
        return this.authorityStructure.entitiesToDtos(list);
    }

    /**
     * 条件匹配分页查询Authority所有数据
     *
     * @param page           分页参数
     * @param authorityQuery {@link AuthorityQuery}查询条件
     * @return 查询结果 {@link AuthorityDTO}
     */
    @Override
    public IPage<AuthorityDTO> pageAll(Page page, AuthorityQuery authorityQuery) {
        Authority entity = this.authorityStructure.queryToEntity(authorityQuery);
        IPage<Authority> queries = this.authorityMapper.pageAll(page, entity);
        List<AuthorityDTO> dtos = this.authorityStructure.entitiesToDtos(queries.getRecords());
        Page<AuthorityDTO> resultPage = new Page<>(queries.getCurrent(), queries.getSize(), queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     *
     * @param authorityQuery {@link AuthorityQuery}查询条件
     * @return 是否成功
     */
    @Override
    public AuthorityDTO save(AuthorityQuery authorityQuery) {
        Authority entity = this.authorityStructure.queryToEntity(authorityQuery);
        return super.save(entity) == true ? this.authorityStructure.entityToDto(entity) : null;
    }

    /**
     * 更新
     *
     * @param authorityQuery {@link AuthorityQuery}查询条件
     * @return 是否成功
     */
    @Override
    public AuthorityDTO updateById(AuthorityQuery authorityQuery) {
        Authority entity = this.authorityStructure.queryToEntity(authorityQuery);
        return super.updateById(entity) == true ? this.authorityStructure.entityToDto(entity) : null;
    }

    /**
     * 分页查询(全等匹配)
     *
     * @param page           分页对象
     * @param authorityQuery {@link AuthorityQuery}查询条件
     * @return 查询结果 {@link AuthorityDTO}
     */
    @Override
    public IPage<AuthorityDTO> page(Page page, AuthorityQuery authorityQuery) {
        Authority entity = this.authorityStructure.queryToEntity(authorityQuery);
        return this.page(page, new QueryWrapper<>(entity));
    }

    /**
     * 条件查询匹配总数
     *
     * @param authorityQuery {@link AuthorityQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(AuthorityQuery authorityQuery) {
        Authority entity = this.authorityStructure.queryToEntity(authorityQuery);
        return this.authorityMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     *
     * @param id id
     * @return 查询结果 {@link AuthorityDTO}
     */
    @Override
    public AuthorityDTO findOne(Serializable id) {
        AuthorityDTO one = this.authorityStructure.entityToDto(super.getById(id));
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
    public boolean saveBatch(List<AuthorityQuery> batch) {
        List<Authority> queries = this.authorityStructure.queriesToEntities(batch);
        return this.saveBatch(queries);
    }
}