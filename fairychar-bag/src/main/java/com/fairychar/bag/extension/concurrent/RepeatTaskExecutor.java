package com.fairychar.bag.extension.concurrent;

import com.fairychar.bag.function.Action;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * <p>
 * 任务编排循环执行工具
 * <p>
 * 传入任务列表后,将会根据批次无限循环执行
 * </p>
 *
 * @author chiyo
 */
@Slf4j
public final class RepeatTaskExecutor {
    private final CyclicBarrier cyclicBarrier;
    private final List<Action> runnables;
    private final ExecutorService executorService;
    private final AtomicLong executeTimes;

    private RepeatTaskExecutor(List<Action> runnables) {
        this.cyclicBarrier = new CyclicBarrier(runnables.size());
        this.runnables = runnables;
        this.executeTimes = new AtomicLong(0);


        this.executorService = Executors.newFixedThreadPool(runnables.size(), r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });
    }

    /**
     * 创建任务批次执行工具类
     *
     * @param tasklist 任务列表
     * @return
     */
    public static RepeatTaskExecutor createCycle(List<Action> tasklist) {
        return new RepeatTaskExecutor(tasklist);
    }


    /**
     * 使用默认参数启动任务执行
     */
    public void start() {
        start(null, null, null, Integer.MAX_VALUE);
    }


    /**
     * 启动任务执行
     *
     * @param onInterrupted 当任务被打断时的异常处理
     * @param onTimeout     当任务超时时的异常处理
     * @param onBroken      当任务被终止时的异常处理
     * @param waitMillis    当前批次中执行完的任务等待未执行完的任务的最长毫秒数(超时会触发{@link BrokenBarrierException})
     */
    public void start(Consumer<InterruptedException> onInterrupted, Consumer<TimeoutException> onTimeout, Consumer<BrokenBarrierException> onBroken, long waitMillis) {
        runnables.forEach(action -> executorService.execute(() -> {
            while (true) {
                try {
                    if (this.cyclicBarrier.isBroken()) {
                        return;
                    }
                    action.doAction();
                    this.cyclicBarrier.await(waitMillis, TimeUnit.MILLISECONDS);
                    this.executeTimes.incrementAndGet();
                } catch (InterruptedException e) {
                    Optional.ofNullable(onInterrupted).ifPresent(interruptedExceptionConsumer -> interruptedExceptionConsumer.accept(e));
                    return;
                } catch (TimeoutException e) {
                    Optional.ofNullable(onTimeout).ifPresent(timeoutExceptionConsumer -> timeoutExceptionConsumer.accept(e));
                    return;
                } catch (BrokenBarrierException e) {
                    Optional.ofNullable(onBroken).ifPresent(brokenBarrierExceptionConsumer -> brokenBarrierExceptionConsumer.accept(e));
                    return;
                } finally {
                }
            }
        }));
    }

    /**
     * 获取已执行任务次数
     *
     * @return
     */
    public long getExecutedTimes() {
        return this.executeTimes.get();
    }


    /**
     * 停止
     */
    public void stop() {
        this.cyclicBarrier.reset();
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