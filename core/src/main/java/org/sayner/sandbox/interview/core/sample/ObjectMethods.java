package org.sayner.sandbox.interview.core.sample;

import org.sayner.sandbox.interview.library.SampleI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectMethods implements SampleI {
    private final Logger LOGGER = LoggerFactory.getLogger(ObjectMethods.class);
    private final Object sample;

    public ObjectMethods() {
        sample = new Object();
    }

    public void runExample() {
        LOGGER.info("Here is basic Object.class functions");
        LOGGER.info("For example let's create simple Object sample = new Object()");
        LOGGER.info("toString(): {}", sample.toString());
        LOGGER.info("equals(): {}", sample.equals(new Object()));
        LOGGER.info("hashCode(): {}", sample.hashCode());
        LOGGER.info("wait()");
        LOGGER.info("notify()");
        LOGGER.info("notifyAll()");
        LOGGER.info("finalize() - deprecated in Java 9+");
        LOGGER.info("getClass(): {}", sample.getClass());
    }
}
