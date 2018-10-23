package com.vynaloze.dls.starvation;

public class StarvationCase {
    private static final long DURATION = 30000;

    public static void start() {
        final SharedResource sharedResource = new SharedResource();

        StarvationWorker workerGUI = new StarvationWorker(sharedResource, "Light GUI form", 100);
        StarvationWorker workerDownload = new StarvationWorker(sharedResource, "Heavy Download", 20000);
        Thread threadDownload = new Thread(workerDownload);
        threadDownload.setPriority(Thread.MIN_PRIORITY);
        threadDownload.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread threadGUI = new Thread(workerGUI);
        threadGUI.setPriority(Thread.MAX_PRIORITY);
        threadGUI.start();

        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < DURATION) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);

    }
}
