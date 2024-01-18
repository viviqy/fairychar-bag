package com.fairychar.bag.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

/**
 * 常用常量属性
 *
 * @author chiyo <br>
 * @since 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Consts {

    public static String EMPTY_STR = "";
    public static long KB_PER_B = 1024;
    public static long MB_PER_B = 1024 * 1024;
    public static long GB_PER_B = 1024 * 1024 * 1024;
    public static long TB_PER_B = 1024 * 1024 * 1024 * 1024;
    public static long PB_PER_B = 1024 * 1024 * 1024 * 1024 * 1024;

    public static String NONE = "none";

    public static String SIMPLE_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static DateTimeFormatter SIMPLE_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(SIMPLE_DATETIME_FORMAT);

    public static String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";

    public static DateTimeFormatter SIMPLE_DATE_FORMATTER = DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMAT);


    public static final class OAuth2 {
        public final static String AUTHORIZATION_CODE = "authorization_code";
        public final static String PASSWORD = "password";
        public final static String CLIENT_CREDENTIALS = "client_credentials";
        public final static String IMPLICIT = "implicit";
        public final static String REFRESH_TOKEN = "refresh_token";
    }

    public static final class Regex {
        public static String IP = "^(\\d{1,3}\\.){3}\\d{1,3}$";
        public static String URL = "^(http|https):\\/\\/[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}([\\/a-zA-Z0-9#.-]*)*$";
    }
}
/*
                                      /[-])//  ___        
                                 __ --\ `_/~--|  / \      
                               /_-/~~--~~ /~~~\\_\ /\     
                               |  |___|===|_-- | \ \ \    
____________ _/~~~~~~~~|~~\,   ---|---\___/----|  \/\-\   
____________ ~\________|__/   / // \__ |  ||  / | |   | | 
                      ,~-|~~~~~\--, | \|--|/~|||  |   | | 
                      [3-|____---~~ _--'==;/ _,   |   |_| 
                                  /   /\__|_/  \  \__/--/ 
                                 /---/_\  -___/ |  /,--|  
                                 /  /\/~--|   | |  \///   
                                /  / |-__ \    |/         
                               |--/ /      |-- | \        
                              \^~~\\/\      \   \/- _     
                               \    |  \     |~~\~~| \    
                                \    \  \     \   \  | \  
                                  \    \ |     \   \    \ 
                                   |~~|\/\|     \   \   | 
                                  |   |/         \_--_- |\
                                  |  /            /   |/\/
                                   ~~             /  /    
                                                 |__/   W<

*/