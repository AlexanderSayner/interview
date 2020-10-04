package org.sayner.sandbox.interview.core;

import org.sayner.sandbox.interview.library.Logger;

public class LibraryLogger implements Logger {
    private final org.slf4j.Logger logger;

    public LibraryLogger(org.slf4j.Logger logger) {
        this.logger = logger;
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void info(String message, Object... arguments) {
        logger.info(message, arguments);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void error(String message, Object... arguments) {
        logger.error(message, arguments);
    }
}
