package com.fairychar.bag.beans.mybatis.handler;

import com.fairychar.bag.utils.AesUtil;
import com.google.common.base.Strings;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Datetime: 2021/10/27 14:47 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class AesTypeHandler extends BaseTypeHandler<String> {

    private static String key;


    public static void setKey(String key) {
        AesTypeHandler.key = key;
    }


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        try {
            if (!Strings.isNullOrEmpty(parameter)) {
                ps.setString(i, AesUtil.encrypt(parameter, key));
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if (Strings.isNullOrEmpty(value)) {
            return null;
        }
        try {
            return AesUtil.decrypt(value, key);
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if (Strings.isNullOrEmpty(value)) {
            return null;
        }
        try {
            return AesUtil.decrypt(value, key);
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if (Strings.isNullOrEmpty(value)) {
            return null;
        }
        try {
            return AesUtil.decrypt(value, key);
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
}
