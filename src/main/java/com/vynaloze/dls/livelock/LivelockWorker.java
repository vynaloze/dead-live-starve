package com.vynaloze.dls.livelock;

public class LivelockWorker implements Runnable {
    private final String name;
    private Queue queue;
    private boolean isWaiting;

    public LivelockWorker(String name, Queue queue) {
        this.name = name;
        this.queue = queue;
        this.isWaiting = true;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        while (isWaiting) {
            if (queue.whoIsFirst() != this) {
                System.out.println(name + ": Waiting for my turn.");
            } else if (queue.whoIsWaiting().size() != 0) {
                LivelockWorker firstInLine = queue.whoIsWaiting().get(0);
                System.out.println(name + ": Let " + firstInLine.getName() + " go first.");
                queue.removeFromWaiting(firstInLine);
                queue.setFirst(firstInLine);
                queue.addToWaiting(this);
            } else {
                System.out.println(name + ": Finished.");
                queue.setFirst(null);
                isWaiting = false;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
