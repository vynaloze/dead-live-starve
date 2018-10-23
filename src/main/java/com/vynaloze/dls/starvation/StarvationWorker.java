package com.vynaloze.dls.starvation;

public class StarvationWorker implements Runnable {
    private final SharedResource sharedResource;
    private final String id;
    private final long duration;

    public StarvationWorker(final SharedResource sharedResource, final String id, final long duration) {
        this.sharedResource = sharedResource;
        this.id = id;
        this.duration = duration;
    }

    @Override
    public void run() {
        System.out.println("Me, " + id + ", asked for The Resource");
        sharedResource.getResource(duration, id);
        System.out.println("Me, " + id + ", finished with The Resource");
    }
}
