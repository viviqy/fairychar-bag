package com.fairychar.bag.utils;

import com.fairychar.bag.domain.exceptions.FailToGetLockException;
import com.fairychar.bag.function.Action;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * redis 锁 util
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RedisLockUtil {


    public static void lock(RLock lock, Action checkIsPresent, Action action, int time, TimeUnit timeUnit) {
        lock(lock, checkIsPresent, checkIsPresent, action, time, timeUnit);
    }

    public static void lock(RLock lock, Action checkIsPresent, Action action) {
        lock(lock, checkIsPresent, checkIsPresent, action);
    }


    public static void lock(RLock lock, Action beforeSearch, Action searchAgain, Action action) {
        try {
            beforeSearch.doAction();
            lock.lock();
            searchAgain.doAction();
            action.doAction();
        } catch (InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw e;
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
            }
        }
    }

    public static void lock(RLock lock, Action beforeSearch, Action searchAgain, Action action, int time, TimeUnit timeUnit) {
        try {
            beforeSearch.doAction();
            lock.lock(time, timeUnit);
            searchAgain.doAction();
            action.doAction();
        } catch (InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw e;
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
            }
        }
    }


    public static void tryLock(RLock lock, Action checkIsPresent, Action action, int time, TimeUnit timeUnit) {
        tryLock(lock, checkIsPresent, checkIsPresent, action, time, timeUnit);
    }

    public static void tryLock(RLock lock, Action checkIsPresent, Action action) {
        tryLock(lock, checkIsPresent, checkIsPresent, action);
    }

    public static void tryLock(RLock lock, Action beforeSearch, Action searchAgain, Action action) {
        try {
            beforeSearch.doAction();
            if (lock.tryLock()) {
                searchAgain.doAction();
                action.doAction();
            } else {
                throw new FailToGetLockException();
            }
        } catch (InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw e;
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
            }
        }
    }

    public static void tryLock(RLock lock, Action beforeSearch, Action searchAgain, Action action, int time, TimeUnit timeUnit) {
        try {
            beforeSearch.doAction();
            if (lock.tryLock(time, timeUnit)) {
                searchAgain.doAction();
                action.doAction();
            } else {
                throw new FailToGetLockException();
            }
        } catch (InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw e;
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
            }
        }
    }

}
