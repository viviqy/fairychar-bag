package com.fairychar.bag.extension.concurrent;

import com.fairychar.bag.function.Action;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**

 *
 * @author chiyo
 */
@Slf4j
public class RoundTaskExecutor {
    private final Phaser phaser;
    private final List<List<Action>> tasklist;
    /**
     * 总任务执行轮数
     */
    @Getter
    private final AtomicInteger executeRound;
    /**
     * 已执行完成的任务数量
     */
    @Getter
    private final AtomicInteger executedTaskCount;
    /**
     * 目前执行到的任务轮数
     */
    @Getter
    private final AtomicInteger executedRound;
    private final ExecutorService executorService;

    private RoundTaskExecutor(@NotNull List<List<Action>> tasklist, int executeRound) {
        assert tasklist != null;
        this.phaser = new Phaser(tasklist.size());
        this.tasklist = tasklist;
        this.executorService = Executors.newFixedThreadPool(tasklist.size());
        this.executeRound = new AtomicInteger(executeRound);
        this.executedRound = new AtomicInteger(0);
        this.executedTaskCount = new AtomicInteger(0);
    }

    public static RoundTaskExecutor boxedTaskList(@NotNull List<List<Action>> tasklist) {
        return boxedTaskList(tasklist, 0);
    }

    public static RoundTaskExecutor boxedTaskList(@NotNull List<List<Action>> tasklist, int round) {
        Integer max = tasklist.stream().map(List::size).max(Integer::compareTo).get();
        tasklist.forEach(l -> {
            for (int i = l.size(); i < max; i++) {
                l.add(() -> {
                    //do nothing
                });
            }
        });
        return new RoundTaskExecutor(Collections.unmodifiableList(tasklist), round);
    }

    public void start(Consumer<InterruptedException> onInterrupted, Consumer<TimeoutException> onTimeout) {
        this.tasklist.forEach(list -> executorService.execute(() -> list.forEach(task -> {
            try {
                int now = this.executedRound.get();
                task.doAction();
                this.executedTaskCount.incrementAndGet();
                this.phaser.arriveAndAwaitAdvance();
                this.executedRound.compareAndSet(now, now + 1);
            } catch (InterruptedException e) {
                Optional.ofNullable(onInterrupted).ifPresent(interruptedExceptionConsumer -> interruptedExceptionConsumer.accept(e));
                this.phaser.arriveAndDeregister();
            } catch (TimeoutException e) {
                Optional.ofNullable(onTimeout).ifPresent(timeoutExceptionConsumer -> timeoutExceptionConsumer.accept(e));
                this.phaser.arriveAndDeregister();
            } finally {
            }
        })));
    }

    public void start() {
        start(null, null);
    }


    public void awaitTaskDone() {
        this.phaser.register();
        this.phaser.arriveAndAwaitAdvance();
    }

    public void stop() {
        this.phaser.forceTermination();
    }
}
/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG


         佛曰:  

       写字楼里写字间，写字间里程序员；  
       程序人员写程序，又拿程序换酒钱。  
       酒醒只在网上坐，酒醉还来网下眠；  
       酒醉酒醒日复日，网上网下年复年。  
       但愿老死电脑间，不愿鞠躬老板前；  
       奔驰宝马贵者趣，公交自行程序员。  
       别人笑我忒疯癫，我笑自己命太贱；  
       不见满街漂亮妹，哪个归得程序员？ 
*/