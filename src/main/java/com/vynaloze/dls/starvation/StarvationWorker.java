package com.vynaloze.dls.starvation;

public class StarvationWorker implements Runnable {
    private final SharedResource sharedResource;
    private final int id;
    private int invocations;

    public StarvationWorker(final SharedResource sharedResource, int id) {
        this.sharedResource = sharedResource;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getInvocations() {
        return invocations;
    }

    @Override
    public void run() {
        invocations = 0;
        while (true) {
            sharedResource.whatIsTheMeaningOfLife();
            invocations++;
        }
    }
}
