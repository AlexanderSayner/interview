package org.sayner.sandbox.interview.concurrency.waiting;

import org.sayner.sandbox.interview.library.Logger;

/**
 * Конкурирующий ресурс
 */
public class Store {
    private final Logger logger;
    private int product = 0;

    public Store(Logger logger) {
        this.logger = logger;
    }

    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
        }
        product--;
        logger.info("Buyer bought one product");
        logger.info("Here is {} products in thr store", product);
        notify();
    }

    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
        }
        product++;
        logger.info("Manufacturer added 1 article");
        logger.info("Here is {} products in warehouse", product);
        notify();
    }
}
