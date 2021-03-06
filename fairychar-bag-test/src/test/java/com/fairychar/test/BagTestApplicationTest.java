package com.fairychar.test;

import com.fairychar.bag.domain.exceptions.FailToGetLockException;
import com.fairychar.bag.function.Action;
import com.fairychar.test.service.LockTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

/**
 * Datetime: 2020/6/2 16:29 <br>
 *
 * @author chiyo <br>
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BagTestApplicationTest {
    @Autowired
    private LockTestService lockTestService;


    @Test
    public void test5() throws InterruptedException {
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
