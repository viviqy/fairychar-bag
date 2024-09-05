package com.fairychar.bag.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author chiyo <br>
 * @since 1.3.2
 */
@AllArgsConstructor
@Getter
public enum RestErrorCode implements IRestErrorCode {
    //10000-11000 参数校验相关
    PARAM_INVALIDATE(1_0000, "参数校验失败"),
    CONTENT_TYPE_NOT_SUPPORT(1_0001, "请求类型不支持"),
    PARAM_ERROR(1_0002, "参数错误"),

    FILE_FORMAT_NOT_SUPPORT(1_0012, "文件类型不支持"),
    FILE_TOO_LARGE(1_00013, "文件超大"),
    FILE_TOO_SMALL(1_0014, "文件太小"),
    FILE_EMPTY(1_0015, "文件为空"),
    FILE_NAME_ILLEGAL(1_0016, "文件名不合法"),
    FILE_UPLOAD_FAILED(1_0017, "文件上传失败"),

    //11001-12000 data操作业务相关
    DATA_EXIST(1_2000, "数据已存在"),
    DATA_NOT_EXIST(1_2001, "数据不存在"),
    DUPLICATE_SAVE(1_2002, "重复保存"),
    DATA_DELETE_FAILED(1_2003, "数据删除失败"),
    DATA_UPDATE_FAILED(1_2004, "数据更新失败"),
    DATA_LOCKED(1_2005, "数据被锁定"),
    DATA_HIDDEN(1_2006, "数据不可见"),
    DATA_SYNC_ERROR(1_2007, "数据同步错误"),
    DATA_TRANSFER_ERROR(1_2008, "数据传输错误"),
    DATA_CONVERT_ERROR(1_2009, "数据转换错误"),
    DATA_LOAD_ERROR(1_2010, "数据加载错误"),
    DATA_HAS_RELATION(1_2011, "数据被其他数据关联"),

    //13000-14000


    //14000-15000 权限相关
    AUTHENTICATION_FAILED(1_4000, "认证失败"),
    ACCESS_DEFINED(1_4003, "权限不足"),
    USER_NOT_FOUND(1_4004, "用户不存在"),
    PASSWORD_ERROR(1_4005, "密码错误"),
    TOKEN_NOT_EXIST(1_4006, "token不存在"),
    TOKEN_INVALID(1_4007, "token不合法"),
    TOKEN_EXPIRED(1_4008, "token过期"),
    USER_FROZEN(1_4009, "用户被冻结"),
    USER_NO_PERMISSION(1_4010, "用户没有权限"),
    ROLE_FROZEN(1_4011, "角色被冻结"),
    PERMISSION_FROZEN(1_4012, "权限被冻结"),


    //18000-19000 通用业务异常
    OPERATION_FAILED(1_8000, "操作失败"),
    SIGN_ERROR(1_8001, "签名错误"),
    THIRD_REQUEST_FAILED(1_8002, "第三方请求失败"),
    THIRD_CALLBACK_FAILED(1_8003, "第三方回调失败"),
    AUDIT_FAILED(1_8004, "审核失败"),
    GENERATE_FAILED(1_8005, "生成失败"),
    RATE_LIMIT_ERROR(1_8006, "频率达到上限"),
    LOCK_FAILED(1_8007, "锁失败"),
    SYNC_FAILED(1_8008, "同步失败"),

    //19001-19999 微服务相关
    FALLBACK(1_9001, "fallback"),

    //20000
    UNKNOWN_ERROR(2_0000, "未知异常"),
    ;

    private final int code;
    private final String message;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
