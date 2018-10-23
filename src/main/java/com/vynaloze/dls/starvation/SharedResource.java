package com.vynaloze.dls.starvation;

class SharedResource {
    synchronized int getResource(long duration, String id) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < duration) {
            System.out.println("Serving data for " + id);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return 42;
    }

}
