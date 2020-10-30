import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Datetime: 2020/6/2 14:47 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class TestMain {
    @Test
    public void test13(){
        for (int i = 1; i <= 99; i++) {
            System.out.println("认错x"+i);
        }
    }

    @Test
    public void test2() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(() -> reentrantLock.lock()).start();
        TimeUnit.SECONDS.sleep(1);
        Thread thread = new Thread(() -> {

            try {
                reentrantLock.tryLock(3, TimeUnit.SECONDS);
                System.out.println(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        Thread.currentThread().join();
    }

    @Test
    public void test1() throws InterruptedException {
        String a = "aa";
        String b = "aa";
        new Thread(() -> {
            System.out.println("a:" + a);
            synchronized (a) {
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            synchronized (b) {
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