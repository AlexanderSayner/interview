package org.sayner.sandbox.interview.concurrency;

import org.sayner.sandbox.interview.concurrency.synch.CommonResource;
import org.sayner.sandbox.interview.concurrency.synch.CountThread;
import org.sayner.sandbox.interview.library.Logger;
import org.sayner.sandbox.interview.library.SampleI;

import java.util.*;

public class Synchronization implements SampleI {
    private final List<Logger> loggers;
    private final CommonResource commonResource = new CommonResource(1);

    public Synchronization(Logger ... loggers) {
        this.loggers =new ArrayList<>();
        this.loggers.addAll(Arrays.asList(loggers));
    }

    @Override
    public void runExample() {
            for (int i = 1; i < 6; i++) {
                Thread t = new Thread(new CountThread(loggers.get(i - 1), commonResource));
                t.setName("Thread-" + i);
                t.start();
            }
    }
}
