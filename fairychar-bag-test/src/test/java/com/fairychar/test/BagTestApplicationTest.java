package com.fairychar.test;

import com.fairychar.bag.beans.netty.server.SimpleNettyServer;
import com.fairychar.bag.domain.exceptions.FailToGetLockException;
import com.fairychar.bag.function.Action;
import com.fairychar.test.service.IHandler;
import com.fairychar.test.service.LockTestService;
import com.fairychar.test.service.UserHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Datetime: 2020/6/2 16:29 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BagTestApplication.class})
public class BagTestApplicationTest {
    @Autowired
    private LockTestService lockTestService;

    @Autowired
    private Redisson redisson;


    @Autowired
    private IHandler handler;

    @Autowired
    private SimpleNettyServer simpleNettyServer;


    @Test
    public void testNettyAdvice(){
        simpleNettyServer.start();
    }

    @Test
    public void testHandler(){
        System.out.println(this.handler);
        UserHandler handler = (UserHandler) this.handler;
        handler.hi("hi");

    }

    @Test
    public void test5() throws InterruptedException {
        RLock lock = redisson.getLock("dave");
        if (lock.tryLock(1, 30, TimeUnit.SECONDS)) {
            System.out.println("dave");
            TimeUnit.SECONDS.sleep(3);
        } else {
            System.out.println("dave 没拿到锁");
        }
        lock.unlock();
        if (lock.tryLock(1, 30, TimeUnit.SECONDS)) {
            System.out.println("dave1");
            TimeUnit.SECONDS.sleep(3);
        } else {
            System.out.println("dave1 没拿到锁");
        }
        lock.unlock();
        Thread.currentThread().join();
//        batchRun(() -> {
//            try {
//                String jerry = this.lockTestService.getJerry();
//                System.out.println(Thread.currentThread().getName() + ": " + jerry);
//            } catch (FailToGetLockException e) {
//                System.out.println(Thread.currentThread().getName() + ": 没有抢到锁redis");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }, 5);
//
//        batchRun(() -> {
//            try {
//                String huruta = this.lockTestService.getHuruta();
//                System.out.println(huruta);
//            } catch (FailToGetLockException e) {
//                System.out.println(Thread.currentThread().getName() + ": 没有抢到锁zk");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }, 5);

        batchRun(() -> {
            try {
                String huruta = this.lockTestService.global("global");
                System.out.println(Thread.currentThread().getName() + ": " + huruta);
            } catch (FailToGetLockException e) {
                System.out.println(Thread.currentThread().getName() + ": 没有抢到锁zk");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 5);
        Thread.currentThread().join();
    }

    @Test
    public void test4() throws Exception {

        System.out.println(lockTestService.getTom());
        System.out.println(lockTestService.getJerry());
        System.out.println(lockTestService.getHuruta());
    }

    @Test
    public void test3() {
        lockTestService.run1("test3");
        lockTestService.run1();
        lockTestService.run1("test3");
        lockTestService.run1();

    }

    @Test
    public void run2() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 10).forEach(i -> executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            lockTestService.run1();
        }));
        Thread.currentThread().join();
    }

    @Test
    public void run1() {
        lockTestService.run1();
        lockTestService.run1();
        lockTestService.run1();
        lockTestService.run1();
        lockTestService.run1();
        lockTestService.run1();
        lockTestService.run1();
    }

    private final static void batchRun(Action action, int task) {
        ExecutorService pool = Executors.newFixedThreadPool(task);
        CountDownLatch latch = new CountDownLatch(task);
        for (int i = 0; i < task; i++) {
            pool.execute(() -> {
                latch.countDown();
                try {
                    action.doAction();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
