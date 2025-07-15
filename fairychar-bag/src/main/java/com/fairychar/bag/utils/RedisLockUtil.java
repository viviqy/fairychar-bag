package com.fairychar.bag.utils;

import com.fairychar.bag.domain.exceptions.FailToGetLockException;
import com.fairychar.bag.function.Action;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * redis 锁 util
 *
 * @author chiyo <br>
 * @since 1.0.2
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RedisLockUtil {

    private static final Action EMPTY_ACTION = () -> {
    };

    public static void lock(RLock lock, Action checkIsPresent, Action action, int time, TimeUnit timeUnit) {
        lock(lock, checkIsPresent, checkIsPresent, action, time, timeUnit);
    }

    public static void lock(RLock lock, Action action, int time, TimeUnit timeUnit) {
        lock(lock, EMPTY_ACTION, EMPTY_ACTION, action, time, timeUnit);
    }

    public static void lock(RLock lock, Action action) {
        lock(lock, EMPTY_ACTION, EMPTY_ACTION, action);
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
        } catch (Exception e) {
            throw e;
        } finally {
            if (lock.isHeldByCurrentThread()) {
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
        } catch (Exception e) {
            throw e;
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }


    public static void tryLock(RLock lock, Action action, int time, TimeUnit timeUnit) {
        tryLock(lock, EMPTY_ACTION, EMPTY_ACTION, action, time, timeUnit);
    }

    public static void tryLock(RLock lock, Action checkIsPresent, Action action, int time, TimeUnit timeUnit) {
        tryLock(lock, checkIsPresent, checkIsPresent, action, time, timeUnit);
    }

    public static void tryLock(RLock lock, Action action) {
        tryLock(lock, EMPTY_ACTION, EMPTY_ACTION, action);
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
        } catch (Exception e) {
            throw e;
        } finally {
            if (lock.isHeldByCurrentThread()) {
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
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw e;
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

}
