package org.sayner.sandbox.interview.library;

public interface Logger {
    void info(String message);
    void info(String message, Object... arguments);
    void error(String message);
    void error(String message, Object... arguments);
}
