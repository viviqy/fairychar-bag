import com.fairychar.bag.beans.netty.server.SimpleNettyServer;
import com.fairychar.bag.domain.abstracts.AbstractScheduleAction;
import com.fairychar.bag.function.Action;
import com.fairychar.bag.template.ActionSelectorTemplate;
import com.fairychar.test.web.controller.SimpleController;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * Datetime: 2020/6/2 14:47 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
public class TestMain {


    @Test
    public void test16() throws Exception {
        SimpleNettyServer simpleNettyServer = new SimpleNettyServer(1, 10, 10000);
        simpleNettyServer.start();
        Thread.currentThread().join();
    }

    @Test
    public void testSwap() {
        int a = 1, b = 2;
        int c = a ^ b;
        a = c ^ a;
        b = c ^ b;
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void testNIO() throws Exception {
        ActionSelectorTemplate actionSelectorTemplate = new ActionSelectorTemplate();
        Action action = new Action() {
            private int a = new Random().nextInt();

            @Override
            public void doAction() throws InterruptedException, TimeoutException {
                System.out.println(Thread.currentThread().getName());
            }
        };
        actionSelectorTemplate.put("task", 1000, action);
        actionSelectorTemplate.put("task1", 500, action);
        actionSelectorTemplate.put("task2", 700, action);
        actionSelectorTemplate.start();
        TimeUnit.SECONDS.sleep(5);
        actionSelectorTemplate.remove("task");
        Thread.currentThread().join();
    }

    @Test
    public void test15() throws Exception {

        ExecutorService single = Executors.newFixedThreadPool(2);
        AbstractScheduleAction scheduleAction = (AbstractScheduleAction) new FinalScheduleAction();

        Runnable runnable = () -> {
            try {
                scheduleAction.doAction0();
            } catch (TimeoutException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        single.execute(runnable);
        TimeUnit.SECONDS.sleep(1);
        single.execute(runnable);
        TimeUnit.SECONDS.sleep(5);
        scheduleAction.interruptAll();
        single.execute(runnable);
        single.execute(runnable);
        Thread.currentThread().join();
    }

    static class FinalScheduleAction extends AbstractScheduleAction {
        /**
         * 执行任务
         *
         * @throws InterruptedException 打断触发
         * @throws TimeoutException     超时触发
         */
        @Override
        public void doAction() throws InterruptedException, TimeoutException {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().isInterrupted());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

    }


    @Test
    public void test14() {
        SimpleController controller = new SimpleController();
        Method[] methods = controller.getClass().getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getDeclaringClass().getName()
                    .concat(method.getName());
            String returnName = method.getReturnType().getName();
            String parameterName = "";
            for (Class<?> parameterType : method.getParameterTypes()) {
                parameterName = parameterName.concat(parameterType.getName()).concat(",");
            }
            System.out.println(methodName);
            System.out.println(returnName);
            System.out.println(parameterName);
        }
    }

    @Test
    public void testStreamDistinct() {
        ArrayList<Integer> collect = Arrays.asList(1, 2, 3, 4).stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(Integer::intValue)))
                        , ArrayList::new)
                );

    }

    @Test
    public void test13() {
        for (int i = 1; i <= 99; i++) {
            System.out.println("认错x" + i);
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