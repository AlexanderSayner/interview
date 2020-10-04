package org.sayner.sandbox.interview.core;

import org.sayner.sandbox.interview.concurrency.Synchronization;
import org.sayner.sandbox.interview.core.sample.*;
import org.sayner.sandbox.interview.library.Resources;
import org.sayner.sandbox.interview.library.SampleI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    private static final List<SampleI> samples = new ArrayList<>(32);

    public static void main(String[] args) {
        LOGGER.info("Start quiz");
        core();
        concurrency();
        getOut();
    }

    private static void core() {
        getIn(
                new ObjectMethods(),
                new StringPool(),
                new EqualsOverriding()
        );
    }

    private static void concurrency() {
        getIn(
                new Synchronization(
                        new LibraryLogger(LoggerFactory.getLogger("ConcurrencyLogger-" + Resources.getCounter())),
                        new LibraryLogger(LoggerFactory.getLogger("ConcurrencyLogger-" + Resources.getCounter())),
                        new LibraryLogger(LoggerFactory.getLogger("ConcurrencyLogger-" + Resources.getCounter())),
                        new LibraryLogger(LoggerFactory.getLogger("ConcurrencyLogger-" + Resources.getCounter())),
                        new LibraryLogger(LoggerFactory.getLogger("ConcurrencyLogger-" + Resources.getCounter()))
                )
        );
    }

    private static void getIn(final SampleI... samples) {
        Application.samples.addAll(Arrays.asList(samples));
    }

    private static void getOut() {
        samples.forEach(SampleI::runExample);
    }
}
