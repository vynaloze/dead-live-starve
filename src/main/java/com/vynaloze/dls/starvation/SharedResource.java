package com.vynaloze.dls.starvation;

class SharedResource {
    private static final long DURATION = 100;

    synchronized int whatIsTheMeaningOfLife() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < DURATION) {
            //nothing
        }
        return 42;
    }

}
