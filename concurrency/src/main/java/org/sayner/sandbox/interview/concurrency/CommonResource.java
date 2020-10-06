package org.sayner.sandbox.interview.concurrency;

public class CommonResource {
    private Integer x;

    public CommonResource(Integer x) {
        this.x = x;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void iterateInteger() {
        this.x++;
    }
}
