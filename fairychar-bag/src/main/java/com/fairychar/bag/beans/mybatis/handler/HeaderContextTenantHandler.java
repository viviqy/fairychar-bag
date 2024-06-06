package com.fairychar.bag.beans.mybatis.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.fairychar.bag.domain.security.TenantUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * 该类实现了MyBatis-Plus的TenantLineHandler接口，用于处理多租户的功能。
 * 在该类中，通过获取HTTP请求的Header中的用户信息，从中提取出租户ID，并将其作为租户ID的表达式返回。
 * 除此之外，该类还提供了获取租户ID列名和判断是否忽略某个表的方法。
 *
 * @author chiyo
 * @since 1.0
 */
@Slf4j
public class HeaderContextTenantHandler implements TenantLineHandler {

    public HeaderContextTenantHandler(Set<String> ignoreTables, ObjectMapper objectMapper) {
        this.ignoreTables = Collections.unmodifiableSet(ignoreTables);
        this.objectMapper = objectMapper;
    }

    public HeaderContextTenantHandler(Set<String> ignoreTables, ObjectMapper objectMapper, String columnName, String header) {
        this.ignoreTables = Collections.unmodifiableSet(ignoreTables);
        this.objectMapper = objectMapper;
        this.columnName = columnName;
        this.header = header;
    }

    private final Set<String> ignoreTables;
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
                //修改为String兼容性更高
                .map(id -> ((Expression) new StringValue(id))).orElseThrow(() -> new IllegalArgumentException("expected tenant id but not provided"));
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
