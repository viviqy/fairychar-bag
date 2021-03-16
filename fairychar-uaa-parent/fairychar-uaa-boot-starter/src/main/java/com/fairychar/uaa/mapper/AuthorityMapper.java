package com.fairychar.uaa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.uaa.entity.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Authority)表数据库访问层
 *
 * @author chiyo
 * @since 2021-02-08 17:38:27
 */
public interface AuthorityMapper extends BaseMapper<Authority> {

    /**
     * 条件匹配查询Authority所有数据
     *
     * @param authority {@link Authority}查询条件
     * @return 查询结果 {@link Authority}
     */
    List<Authority> queryAll(Authority authority);

    /**
     * 条件匹配分页查询Authority所有数据
     *
     * @param page      分页参数
     * @param authority {@link Authority}查询条件
     * @return 查询结果 {@link Authority}
     */
    IPage<Authority> pageAll(@Param("page") Page page, @Param("authority") Authority authority);

    /**
     * 条件匹配查询Authority匹配数据总数
     *
     * @param authority {@link Authority}查询条件
     * @return 总数
     */
    int count(Authority authority);
}