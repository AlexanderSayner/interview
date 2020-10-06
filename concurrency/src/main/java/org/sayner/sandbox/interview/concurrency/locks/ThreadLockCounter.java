package org.sayner.sandbox.interview.concurrency.locks;

import org.sayner.sandbox.interview.concurrency.CommonResource;
import org.sayner.sandbox.interview.library.Logger;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockCounter implements Runnable {
    private final Logger logger;
    private final CommonResource commonResource;
    private final ReentrantLock reentrantLock;

    public ThreadLockCounter(Logger logger, CommonResource commonResource, ReentrantLock reentrantLock) {
        this.logger = logger;
        this.commonResource = commonResource;
        this.reentrantLock = reentrantLock;
    }

    public void run() {
        reentrantLock.lock();
        try {
            commonResource.setX(1);
            for (int i = 1; i < 5; i++) {
                logger.info("{} {}", Thread.currentThread().getName(), commonResource.getX());
                commonResource.iterateInteger();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        } finally {
            reentrantLock.unlock();
        }
    }
}
