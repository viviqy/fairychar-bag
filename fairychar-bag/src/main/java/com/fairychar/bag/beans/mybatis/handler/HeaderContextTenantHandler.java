package com.fairychar.bag.beans.mybatis.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.fairychar.bag.domain.security.TenantUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
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
public class HeaderContextTenantHandler implements TenantLineHandler {

    public HeaderContextTenantHandler(List<String> ignoreTables, ObjectMapper objectMapper) {
        this.ignoreTables = Collections.unmodifiableList(ignoreTables);
        this.objectMapper = objectMapper;
    }

    public HeaderContextTenantHandler(List<String> ignoreTables, ObjectMapper objectMapper, String columnName, String header) {
        this.ignoreTables = Collections.unmodifiableList(ignoreTables);
        this.objectMapper = objectMapper;
        this.columnName = columnName;
        this.header = header;
    }

    private final List<String> ignoreTables;
    private final ObjectMapper objectMapper;
    private String columnName = "tenant_id";
    private String header = "user";

    @Override
    public Expression getTenantId() {
        return Optional.ofNullable(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()))
                .map(s -> s.getRequest())
                .map(r -> r.getHeader(this.header))
                .map(s -> {
                    try {
                        return this.objectMapper.readValue(s, TenantUser.class);
                    } catch (IOException e) {
                        return null;
                    }
                })
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
