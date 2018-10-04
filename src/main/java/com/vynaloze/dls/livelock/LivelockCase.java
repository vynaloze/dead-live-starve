package com.vynaloze.dls.livelock;

public class LivelockCase {
    private static final long DURATION = 10000;

    public static void start() {
        Door door = new Door();
        Gentleman Bob = new Gentleman("Bob");
        Gentleman Dave = new Gentleman("Dave");

        door.setFirst(Bob);
        door.addToWaiting(Dave);

        new Thread(() -> Bob.goThroughDoor(door)).start();

        new Thread(() -> Dave.goThroughDoor(door)).start();

        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < DURATION) {
            //nothing
        }
        System.exit(0);
    }
}
