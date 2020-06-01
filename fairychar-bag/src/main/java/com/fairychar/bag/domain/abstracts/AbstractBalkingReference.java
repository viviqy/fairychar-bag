package com.fairychar.bag.domain.abstracts;

import com.fairychar.bag.domain.concurrent.IBalkingReference;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 任务属性状态追踪
 *
 * @author chiyo
 */
@Slf4j
public abstract class AbstractBalkingReference<T> implements IBalkingReference<T> {
    protected AtomicBoolean isChanged = new AtomicBoolean(true);
    protected T t;

    public AbstractBalkingReference(T t) {
        this.t = t;
    }

    @Override
    public synchronized boolean save() {
        if (isChanged.get()) {
            boolean b = doSave();
            if (!b) {
                return false;
            }
            log.debug("save success");
            isChanged.set(false);
            return true;
        }
        return false;
    }

    @Override
    public synchronized boolean change(T t) {
        if (!this.isChanged.get()) {
            this.t = t;
            this.isChanged.set(true);
            return true;
        }
        return false;
    }

    public abstract boolean doSave();
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