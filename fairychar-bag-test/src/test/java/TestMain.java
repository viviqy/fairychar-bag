import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Datetime: 2020/6/2 14:47 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class TestMain {
    @Test
    public void test1() throws InterruptedException {
        String a="aa";
        String b="aa";
        new Thread(()->{
            System.out.println("a:"+a);
            synchronized (a){
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            synchronized (b){
                System.out.println(b);
            }
        }).start();
        Thread.currentThread().join();
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