package com.vynaloze.dls.deadlock;

public class DeadlockCase {
    private static final long DURATION = 10000;

    public static void start() {
//        Queue door = new Queue();
//        LivelockWorker Bob = new LivelockWorker("Bob");
//        LivelockWorker Dave = new LivelockWorker("Dave");
//
//        door.setFirst(Bob);
//        door.addToWaiting(Dave);
//
//        new Thread(() -> Bob.goThroughDoor(door)).start();
//
//        new Thread(() -> Dave.goThroughDoor(door)).start();

        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < DURATION) {
            //nothing
        }
        System.exit(0);
    }
}
