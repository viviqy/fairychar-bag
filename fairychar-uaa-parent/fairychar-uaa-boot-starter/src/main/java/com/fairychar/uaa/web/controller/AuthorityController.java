package com.fairychar.uaa.web.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.bag.pojo.vo.HttpResult;
import com.fairychar.uaa.pojo.dto.AuthorityDTO;
import com.fairychar.uaa.pojo.query.AuthorityQuery;
import com.fairychar.uaa.service.interfaces.IAuthorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (Authority)表服务接口类
 *
 * @author chiyo
 * @since 2021-02-08 17:38:23
 */
@RestController
@RequestMapping("authority")
@Api(tags = "接口")
public class AuthorityController {
    /**
     * 服务类
     */
    @Autowired
    @Qualifier("authorityService")
    private IAuthorityService authorityService;

    @PostMapping("count")
    @ApiOperation(value = "条件查询匹配数据总数", notes = "string类型模糊匹配,非string为全等匹配")
    public ResponseEntity<HttpResult<Integer>> count(@ApiParam("查询条件") @RequestBody AuthorityQuery query) throws Exception {
        int count = this.authorityService.count(query);
        return ResponseEntity.ok(HttpResult.ok(count));
    }

    @PostMapping("match")
    @ApiOperation(value = "条件查询所有数据", notes = "string类型模糊匹配,非string为全等匹配")
    public ResponseEntity<HttpResult<List<AuthorityDTO>>> matchAll(@ApiParam("查询条件") @RequestBody AuthorityQuery query) throws Exception {
        List<AuthorityDTO> list = this.authorityService.queryAll(query);
        return ResponseEntity.ok(HttpResult.ok(list));
    }

    @PostMapping("pageMatch")
    @ApiOperation(value = "分页条件查询所有数据", notes = "string类型模糊匹配,非string为全等匹配")
    public ResponseEntity<HttpResult<IPage<AuthorityDTO>>> pageMatch(@ApiParam("查询条件") @RequestBody AuthorityQuery query, @ApiParam("分页参数") Page page) throws Exception {
        IPage<AuthorityDTO> pageAll = this.authorityService.pageAll(page, query);
        return ResponseEntity.ok(HttpResult.ok(pageAll));
    }

    /**
     * 分页查询所有数据(全等匹配)
     *
     * @param page  分页对象
     * @param query 查询实体
     * @return 所有数据
     */
    @PostMapping("page")
    @ApiOperation(value = "分页查询所有数据", notes = "字段全等匹配方式查询")
    public ResponseEntity<HttpResult<IPage<AuthorityDTO>>> findAll(@ApiParam("查询实体") @RequestBody AuthorityQuery query, @ApiParam("分页对象") Page page) throws Exception {
        return ResponseEntity.ok(HttpResult.ok(this.authorityService.page(page, query)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "通过主键查询单条数据")
    public ResponseEntity<HttpResult<AuthorityDTO>> findOne(@PathVariable @ApiParam("主键") Serializable id) throws Exception {
        return ResponseEntity.ok(HttpResult.ok(this.authorityService.findOne(id)));
    }

    /**
     * 新增数据
     *
     * @param query 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation(value = "新增数据")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<HttpResult> insert(@RequestBody @ApiParam("实体对象") AuthorityQuery query) throws Exception {
        this.authorityService.save(query);
        return ResponseEntity.ok(HttpResult.ok());
    }

    /**
     * 批量新增数据
     *
     * @param queries 实体对象集合
     * @return 新增结果
     */
    @PostMapping("saveBatch")
    @ApiOperation(value = "批量新增数据")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<HttpResult> batchInsert(@RequestBody @ApiParam("实体对象") List<AuthorityQuery> queries) throws Exception {
        this.authorityService.saveBatch(queries);
        return ResponseEntity.ok(HttpResult.ok());
    }

    /**
     * 修改数据
     *
     * @param query 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation(value = "修改数据")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<HttpResult> updateById(@RequestBody @ApiParam("实体对象") AuthorityQuery query) throws Exception {
        this.authorityService.updateById(query);
        return ResponseEntity.ok(HttpResult.ok());
    }

    /**
     * 删除数据
     *
     * @param id
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除数据")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<HttpResult<Boolean>> delete(@PathVariable("id") @ApiParam("主键") Serializable id) throws Exception {
        return ResponseEntity.ok(HttpResult.ok(this.authorityService.removeById(id)));
    }
}