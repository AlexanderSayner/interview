package org.sayner.sandbox.interview.concurrency.waiting;

import org.sayner.sandbox.interview.library.Logger;
import org.sayner.sandbox.interview.library.SampleI;

import java.util.*;

public class Waiting implements SampleI {
    private final List<Logger> loggers;

    public Waiting(Logger... loggers) {
        this.loggers = new ArrayList<>();
        this.loggers.addAll(Arrays.asList(loggers));
    }

    @Override
    public void runExample() {
        final Store store = new Store(loggers.get(0));
        final Producer producer = new Producer(store);
        final Consumer consumer = new Consumer(store);
        final Thread consumerThread = new Thread(consumer);
        consumerThread.setName("Consumer-Thread");
        final Thread producerThread = new Thread(producer);
        producerThread.setName("Producer-Thread");
        consumerThread.start();
        producerThread.start();
    }
}
