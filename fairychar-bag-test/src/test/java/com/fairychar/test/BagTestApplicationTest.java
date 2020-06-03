package com.fairychar.test;

import com.fairychar.test.service.LockTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
    public void test3(){
        lockTestService.run1("test3");
        lockTestService.run1();
        lockTestService.run1("test3");
        lockTestService.run1();
    }

    @Test
    public void run2() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0,10).forEach(i->{
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName());
                lockTestService.run1();
            });
        });
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
}
