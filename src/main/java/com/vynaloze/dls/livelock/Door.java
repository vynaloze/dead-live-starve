package com.vynaloze.dls.livelock;

import java.util.ArrayList;
import java.util.List;

public class Door {
    private Gentleman first;
    private List<Gentleman> waiting = new ArrayList<>();

    public synchronized Gentleman whoIsFirst() {
        return first;
    }

    public synchronized void setFirst(Gentleman first) {
        this.first = first;
    }

    public synchronized List<Gentleman> whoIsWaiting() {
        return waiting;
    }

    public synchronized void addToWaiting(Gentleman gentleman) {
        this.waiting.add(gentleman);
    }

    public synchronized void removeFromWaiting(Gentleman gentleman) {
        this.waiting.remove(gentleman);
    }
}
