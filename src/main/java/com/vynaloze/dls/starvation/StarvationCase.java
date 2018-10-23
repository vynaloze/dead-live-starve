package com.vynaloze.dls.starvation;

public class StarvationCase {
    private static final long DURATION = 30000;

    public static void start() {
        final SharedResource sharedResource = new SharedResource();

        StarvationWorker workerGUI = new StarvationWorker(sharedResource, "Light GUI form", 100);
        StarvationWorker workerDownload = new StarvationWorker(sharedResource, "Heavy Download", 5000);
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

        while (threadDownload.getState() != Thread.State.TERMINATED
                && threadGUI.getState() != Thread.State.TERMINATED) {
            if (threadGUI.getState() == Thread.State.BLOCKED
                    && threadDownload.getState() == Thread.State.RUNNABLE) {
                threadDownload.interrupt();
                threadDownload = new Thread(workerDownload);
                threadDownload.start();
            }
        }
    }
}
