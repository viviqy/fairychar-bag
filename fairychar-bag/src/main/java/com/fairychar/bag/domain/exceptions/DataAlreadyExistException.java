package com.fairychar.bag.domain.exceptions;

import java.sql.SQLException;

/**
 * Created with IDEA
 * User: qiyue
 * Date: 2020/02/21
 * time: 12:32
 *
 * <p>数据已存在异常</p>
 *
 * @author qiyue
 */
public class DataAlreadyExistException extends SQLException {
    public DataAlreadyExistException() {
        super("数据已存在");
    }

    public DataAlreadyExistException(String reason) {
        super(reason);
    }

    public DataAlreadyExistException(Throwable cause) {
        super(cause);
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