package com.vynaloze.dls.deadlock;

public class DeadlockCase {
    private static final long DURATION = 15000;

    public static void start() {
        Obj nine = new Obj(9);
        Obj eleven = new Obj(11);
        Thread thread1 = new Thread(new DeadlockWorker(nine, eleven));
        Thread thread2 = new Thread(new DeadlockWorker(eleven, nine));

        thread1.start();
        thread2.start();

        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < DURATION) {
            //nothing
        }
        System.exit(0);
    }
}
