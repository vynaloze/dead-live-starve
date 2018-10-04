package com.vynaloze.dls.livelock;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private LivelockWorker first;
    private List<LivelockWorker> waiting = new ArrayList<>();

    public synchronized LivelockWorker whoIsFirst() {
        return first;
    }

    public synchronized void setFirst(LivelockWorker first) {
        this.first = first;
    }

    public synchronized List<LivelockWorker> whoIsWaiting() {
        return waiting;
    }

    public synchronized void addToWaiting(LivelockWorker livelockWorker) {
        this.waiting.add(livelockWorker);
    }

    public synchronized void removeFromWaiting(LivelockWorker livelockWorker) {
        this.waiting.remove(livelockWorker);
    }
}
