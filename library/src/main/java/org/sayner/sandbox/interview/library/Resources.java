package org.sayner.sandbox.interview.library;

public class Resources {
    private static Integer counter = 1;

    protected Resources() {
    }

    public static Integer getCounter() {
        return counter++;
    }
}
