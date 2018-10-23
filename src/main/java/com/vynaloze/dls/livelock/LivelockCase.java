package com.vynaloze.dls.livelock;

public class LivelockCase {
    private static final long DURATION = 10000;

    public static void start() {
        Queue queue = new Queue();
        LivelockWorker greg = new LivelockWorker("Gentle Greg", queue);
        LivelockWorker hugo = new LivelockWorker("Humble Hugo", queue);

        queue.setFirst(greg);
        queue.addToWaiting(hugo);

        Thread thread1 = new Thread(greg);
        thread1.start();
        Thread thread2 = new Thread(hugo);
        thread2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (thread1.getState() != Thread.State.TERMINATED
                && thread2.getState() != Thread.State.TERMINATED) {
            System.out.println("Thread1 state: " + thread1.getState());
            System.out.println("Thread2 state: " + thread2.getState());
            if (thread1.getState() == Thread.State.TIMED_WAITING
                    && thread2.getState() == Thread.State.TIMED_WAITING) {
                System.out.println("Livelock detected!");
                System.out.println("Exiting...");
                System.exit(1);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
