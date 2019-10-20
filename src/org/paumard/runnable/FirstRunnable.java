package org.paumard.runnable;

public class FirstRunnable {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable =  () -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am running in : " + Thread.currentThread().getName());
        };
        Runnable donotwait =  new Runnable() {
            @Override
            public void run() {
                System.out.println("I am running in : " + Thread.currentThread().getName());
            }
        };
        Thread t = new Thread(runnable);
        Thread t1 = new Thread(donotwait);
        t.setName("My Thread");
        t1.setName("donatwait");
        t.start();
        t1.start();
        System.out.println("I am running in : " + Thread.currentThread().getName());
    }
}
