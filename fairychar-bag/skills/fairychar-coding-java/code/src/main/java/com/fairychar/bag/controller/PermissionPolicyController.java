package com.zxsc.data.permission.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.bag.domain.annotations.RequestLog;
import com.fairychar.bag.pojo.vo.HttpResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zxsc.data.permission.service.pojo.dto.PermissionPolicyDTO;
import com.zxsc.data.permission.service.pojo.query.CreatePermissionPolicyQuery;
import com.zxsc.data.permission.service.pojo.query.PermissionPolicyQuery;
import com.zxsc.data.permission.service.pojo.query.UpdatePermissionPolicyQuery;
import com.zxsc.data.permission.service.service.PermissionPolicyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * 权限策略管理接口。
 *
 * @author codex
 */
@RestController
@RequestMapping("/api/policies")
@Tag(name = "权限策略管理接口")
@ApiSupport(order = 1)
public class PermissionPolicyController {
    @Autowired
    private PermissionPolicyService permissionPolicyService;

    @RequestLog
    @GetMapping("page")
    @Operation(description = "分页查询")
    @ApiOperationSupport(order = 10)
    public HttpResult page(@RequestBody PermissionPolicyQuery query) {
        Page<PermissionPolicyDTO> result = this.permissionPolicyService.page(query);
        return HttpResult.ok(result);
    }

    @RequestLog
    @PostMapping
    @Operation(description = "保存")
    @ApiOperationSupport(order = 20)
    public HttpResult save(@RequestBody @Validated CreatePermissionPolicyQuery query) {
        boolean result = this.permissionPolicyService.save(query);
        return HttpResult.ok(result);
    }

    @RequestLog
    @GetMapping("/{id}")
    @Operation(description = "根据id查询")
    @ApiOperationSupport(order = 30)
    public HttpResult findById(@PathVariable("id") Serializable id) {
        PermissionPolicyDTO result = this.permissionPolicyService.findById(id);
        return HttpResult.ok(result);
    }

    @RequestLog
    @PutMapping("/update")
    @Operation(description = "根据id更新")
    @ApiOperationSupport(order = 40)
    public HttpResult update(@RequestBody @Validated UpdatePermissionPolicyQuery query) {
        boolean result = this.permissionPolicyService.updateById(query);
        return HttpResult.ok(result);
    }

    @RequestLog
    @DeleteMapping("/{id}")
    @Operation(description = "根据id删除")
    @ApiOperationSupport(order = 50)
    public HttpResult delete(@PathVariable("id") Serializable id) {
        boolean result = this.permissionPolicyService.removeById(id);
        return HttpResult.ok(result);
    }
}
