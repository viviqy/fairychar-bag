package com.fairychar.bag.domain.exceptions;

import java.sql.SQLException;

/**
 * Created with IDEA <br>
 * User: qiyue <br>
 * Date: 2020/02/21 <br>
 * time: 12:32 <br>
 *
 * @author qiyue <br>
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