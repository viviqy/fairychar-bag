package com.fairychar.bag.beans.mybatis.handler;

import cn.hutool.crypto.symmetric.AES;
import com.google.common.base.Strings;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>mybatis aes typeHandler{@link org.apache.ibatis.type.TypeHandler}</p>
 * <p>在数据入库前会先aes加密,查询出库后解密</p>
 *
 * @author chiyo
 * @since 1.0
 */
public class AesTypeHandler extends BaseTypeHandler<String> {

    private static AES aes;


    public static void setKey(AES aes) {
        AesTypeHandler.aes = aes;
    }


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        try {
            if (!Strings.isNullOrEmpty(parameter)) {
                ps.setString(i, aes.encryptHex(parameter));
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
            return aes.decryptStr(value);
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
            return aes.decryptStr(value);
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
            return aes.decryptStr(value);
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    public static String encryptHex(String source) {
        return aes.encryptHex(source);
    }

    public static String decrypt(String ciphertext) {
        return aes.decryptStr(ciphertext);
    }
}
