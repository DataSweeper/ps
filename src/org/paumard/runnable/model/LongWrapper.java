package org.paumard.runnable.model;

public class LongWrapper {
    private long l;

    public LongWrapper(long l) {
        this.l = l;
    }

    public long getLong() {
        return l;
    }

    public synchronized void  increamentLong() {
        l += 1;
    }
}
