package com.fairychar.bag.utils;

import com.fairychar.bag.domain.exceptions.FBException;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 *
 * @author chiyo <br>
 * @since 1.3.2
 */
public class ConcurrentUtil {

    public static void getFutures(List<Future> futures) {
        for (Future future : futures) {
            try {
                future.get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new FBException(e);
            } catch (ExecutionException e) {
                throw new FBException(e);
            }
        }
    }
}
