package org.paumard.runnable;

import org.paumard.runnable.model.LongWrapper;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        LongWrapper longWrapper = new LongWrapper(0L);
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                longWrapper.increamentLong();
            }
        };
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(r);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println(longWrapper.getLong());
    }
}
