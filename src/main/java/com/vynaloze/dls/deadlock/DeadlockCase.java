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

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (thread1.getState() != Thread.State.TERMINATED
                && thread2.getState() != Thread.State.TERMINATED) {
            System.out.println("Thread1 state: " + thread1.getState());
            System.out.println("Thread2 state: " + thread2.getState());
            if (thread1.getState() == Thread.State.BLOCKED
                    && thread2.getState() == Thread.State.BLOCKED) {
                System.out.println("Deadlock detected!");
                System.out.println("Exiting...");
                System.exit(1);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
