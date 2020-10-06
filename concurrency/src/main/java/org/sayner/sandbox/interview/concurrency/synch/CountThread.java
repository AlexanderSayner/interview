package org.sayner.sandbox.interview.concurrency.synch;

import org.sayner.sandbox.interview.concurrency.CommonResource;
import org.sayner.sandbox.interview.library.Logger;

public class CountThread implements Runnable {
    private final Logger logger;
    private final CommonResource resource;

    public CountThread(Logger logger, CommonResource resource) {
        this.logger = logger;
        this.resource = resource;
    }

    public void run() {
        synchronized (resource) {
            resource.setX(1);
            for (int i = 1; i < 5; i++) {
                logger.info("{} {}", Thread.currentThread().getName(), resource.getX());
                resource.iterateInteger();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }
}
