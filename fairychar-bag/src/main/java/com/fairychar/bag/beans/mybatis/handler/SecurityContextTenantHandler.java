package com.fairychar.bag.beans.mybatis.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.fairychar.bag.domain.security.TenantUser;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Datetime: 2021/10/28 9:39 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@Slf4j
public class SecurityContextTenantHandler implements TenantLineHandler {

    public SecurityContextTenantHandler(List<String> ignoreTables) {
        this.ignoreTables = Collections.unmodifiableList(ignoreTables);
    }

    public SecurityContextTenantHandler(List<String> ignoreTables, String columnName) {
        this.ignoreTables = Collections.unmodifiableList(ignoreTables);
        this.columnName = columnName;
    }

    private final List<String> ignoreTables;
    private String columnName = "tenant_id";

    @Override
    public Expression getTenantId() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(a -> ((TenantUser) a.getPrincipal()))
                .map(u -> u.getTenantId())
                .map(id -> ((Expression) new LongValue(id))).orElseThrow(() -> new IllegalArgumentException("expected tenant id but not provided"));
    }

    @Override
    public String getTenantIdColumn() {
        return this.columnName;
    }


    @Override
    public boolean ignoreTable(String tableName) {
        if (this.ignoreTables.contains(tableName)) {
            return true;
        }
        return false;
    }

}
