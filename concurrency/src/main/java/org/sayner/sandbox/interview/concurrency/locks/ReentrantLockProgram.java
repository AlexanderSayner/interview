package org.sayner.sandbox.interview.concurrency.locks;

import org.sayner.sandbox.interview.concurrency.CommonResource;
import org.sayner.sandbox.interview.library.Logger;
import org.sayner.sandbox.interview.library.SampleI;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockProgram implements SampleI {
    private final List<Logger> loggers;

    public ReentrantLockProgram(Logger... loggers) {
        this.loggers = new ArrayList<>();
        this.loggers.addAll(Arrays.asList(loggers));
    }

    @Override
    public void runExample() {
        final CommonResource commonResource = new CommonResource(1);
        final ReentrantLock locker = new ReentrantLock();
        for (int i = 1; i < 6; i++) {
            final Thread thread = new Thread(new ThreadLockCounter(loggers.get(i - 1), commonResource, locker));
            thread.setName("Reentrant-" + i);
            thread.start();
        }
    }
}
