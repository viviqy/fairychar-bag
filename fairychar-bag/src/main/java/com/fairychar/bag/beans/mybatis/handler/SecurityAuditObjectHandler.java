package com.fairychar.bag.beans.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.fairychar.bag.domain.security.AuditUser;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * 基于spring security的mybatis用户审计操作拦截赋值器
 *
 * @author chiyo
 */
public class SecurityAuditObjectHandler implements MetaObjectHandler {

    public SecurityAuditObjectHandler() {
        this.createBy = "createBy";
        this.createTime = "createTime";
        this.updateBy = "updateBy";
        this.updateTime = "updateTime";
        this.tenantId = "tenantId";
    }

    public SecurityAuditObjectHandler(String createBy, String createTime, String updateBy, String updateTime, String tenantId) {
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.tenantId = tenantId;
    }

    private final String createBy;
    private final String createTime;
    private final String updateBy;
    private final String updateTime;
    private final String tenantId;

    @Override
    public void insertFill(MetaObject metaObject) {
        AuditUser user = Optional.ofNullable(SecurityContextHolder.getContext()).map(c -> c.getAuthentication())
                .map(a -> ((AuditUser) a.getPrincipal())).orElse(null);
        if (metaObject.hasSetter(this.createBy)) {
            this.setFieldValByName(this.createBy, Optional.ofNullable(user).map(u -> u.getUserId()).orElse(null), metaObject);
        }

        if (metaObject.hasSetter(this.createTime)) {
            this.setFieldValByName(this.createTime, LocalDateTime.now(), metaObject);
        }
        if (metaObject.hasSetter(this.tenantId)) {
            this.setFieldValByName(this.tenantId, Optional.ofNullable(user).map(u -> u.getTenantId()).orElse(null), metaObject);
        }
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        Serializable userId = Optional.ofNullable(SecurityContextHolder.getContext()).map(c -> c.getAuthentication())
                .map(a -> ((AuditUser) a.getPrincipal())).map(u -> u.getUserId()).orElse(null);
        if (metaObject.hasSetter(this.updateBy)) {
            this.setFieldValByName(this.updateBy, userId, metaObject);
        }

        if (metaObject.hasSetter(this.updateTime)) {
            this.setFieldValByName(this.updateTime, LocalDateTime.now(), metaObject);
        }
    }


}
