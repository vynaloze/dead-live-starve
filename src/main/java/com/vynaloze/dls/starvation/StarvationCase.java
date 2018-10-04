package com.vynaloze.dls.starvation;

import java.util.ArrayList;
import java.util.List;

public class StarvationCase {
    private static final long DURATION = 30000;

    public static void start() {
        final SharedResource sharedResource = new SharedResource();
        List<StarvationWorker> workers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            StarvationWorker worker = new StarvationWorker(sharedResource, i);
            workers.add(worker);
            new Thread(worker).start();
        }

        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < DURATION) {
            System.out.print('\r');
            for(StarvationWorker worker : workers){
                System.out.print(String.format("%s->%2s    ", worker.getId(), worker.getInvocations()));
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);

    }
}
