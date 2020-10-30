package com.fairychar.bag.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Datetime: 2020/10/30 14:24 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Consts {

    public final static String EMPTY_STR = "";

    public final static class OAuth2 {
        public final static String AUTHORIZATION_CODE = "authorization_code";
        public final static String PASSWORD = "password";
        public final static String CLIENT_CREDENTIALS = "client_credentials";
        public final static String IMPLICIT = "implicit";
        public final static String REFRESH_TOKEN = "refresh_token";
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