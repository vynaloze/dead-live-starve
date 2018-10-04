package com.vynaloze.dls.livelock;

import java.util.Arrays;
import java.util.List;

public class LivelockCase {
    private static final long DURATION = 300000;

    public static void start() {
        Street street = new Street();
        List<Pedestrian> pedestrians = Arrays.asList(
                new Pedestrian("1", street, 0, 0, 1),
                new Pedestrian("2", street, 0, 5, -1)
        );

        for (Pedestrian pedestrian : pedestrians) {
            new Thread(pedestrian).start();
        }

        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < DURATION) {
            for (Pedestrian pedestrian : pedestrians) {
                System.out.println(pedestrian);
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
