package com.fairychar.bag.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

/**
 * 常用常量属性
 *
 * @author chiyo
 * @since 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Consts {

    public static final String EMPTY_STR = "";
    public static final long KB_PER_B = 1024;
    public static final long MB_PER_B = 1024 * 1024;
    public static final long GB_PER_B = 1024 * 1024 * 1024;
    public static final long TB_PER_B = 1024 * 1024 * 1024 * 1024;
    public static final long PB_PER_B = 1024 * 1024 * 1024 * 1024 * 1024;

    public static final String NONE = "none";

    public static final String SIMPLE_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter SIMPLE_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(SIMPLE_DATETIME_FORMAT);

    public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";

    public static final DateTimeFormatter SIMPLE_DATE_FORMATTER = DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMAT);


    public static final class OAuth2 {
        public static final String AUTHORIZATION_CODE = "authorization_code";
        public static final String PASSWORD = "password";
        public static final String CLIENT_CREDENTIALS = "client_credentials";
        public static final String IMPLICIT = "implicit";
        public static final String REFRESH_TOKEN = "refresh_token";
    }

    public static final class Regex {
        public static final String IP = "^(\\d{1,3}\\.){3}\\d{1,3}$";
        public static final String URL = "^(http|https):\\/\\/[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}([\\/a-zA-Z0-9#.-]*)*$";
    }
}
