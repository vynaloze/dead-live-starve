package com.vynaloze.dls.livelock;

public class LivelockCase {
    private static final long DURATION = 10000;

    public static void start() {
        Queue queue = new Queue();
        LivelockWorker greg = new LivelockWorker("Gentle Greg", queue);
        LivelockWorker hugo = new LivelockWorker("Humble Hugo", queue);

        queue.setFirst(greg);
        queue.addToWaiting(hugo);

        new Thread(greg).start();
        new Thread(hugo).start();

        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < DURATION) {
            //nothing
        }
        System.exit(0);
    }
}
