package com.fairychar.bag.beans.mybatis.handler;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.google.common.base.Strings;
import lombok.Setter;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>mybatis aes typeHandler{@link org.apache.ibatis.type.TypeHandler}</p>
 * <p>在数据入库前会先rsa加密,查询出库后解密</p>
 *
 * @author chiyo
 * @since 1.0
 */
public class RsaTypeHandler extends BaseTypeHandler<String> {

    @Setter
    private static RSA rsa;


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        try {
            if (!Strings.isNullOrEmpty(parameter)) {
                ps.setString(i, rsa.encryptBase64(parameter, KeyType.PublicKey));
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
            return rsa.decryptStr(value, KeyType.PrivateKey);
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
            return rsa.decryptStr(value, KeyType.PrivateKey);
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
            return rsa.decryptStr(value, KeyType.PrivateKey);
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }


    public static String encryptBase64(String source) {
        return rsa.encryptBase64(source, KeyType.PublicKey);
    }

    public static String decrypt(String ciphertext) {
        return rsa.decryptStr(ciphertext, KeyType.PrivateKey);
    }
}
