package com.colin;

public class DeltaTime {

    private long last, current, delta;

    public DeltaTime() {
        setLast(System.currentTimeMillis());
        setCurrent(getLast());
    }

    public void update() {
        setCurrent(System.currentTimeMillis());
        setDelta(getCurrent() - getLast());
        setLast(getCurrent());
    }

    public long get() {
        return delta;
    }

    public long getLast() {
        return last;
    }

    public long getCurrent() {
        return current;
    }

    public void setLast(long num) {
        last = num;
    }

    public void setCurrent(long num) {
        current = num;
    }

    public void setDelta(long num) {
        delta = num;
    }
}
