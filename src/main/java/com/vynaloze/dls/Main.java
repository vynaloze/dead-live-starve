package com.vynaloze.dls;

import com.vynaloze.dls.deadlock.DeadlockCase;
import com.vynaloze.dls.livelock.LivelockCase;
import com.vynaloze.dls.starvation.StarvationCase;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong number of command line arguments.");
            System.exit(1);
        }
        switch (args[0]) {
            case "--deadlock":
                System.out.println("Deadlock.");
                DeadlockCase.start();
                break;
            case "--livelock":
                System.out.println("Livelock.");
                LivelockCase.start();
                break;
            case "--starvation":
                System.out.println("Starvation.");
                StarvationCase.start();
                break;
            default:
                System.out.println("Unrecognised command line argument.");
                System.out.println("Possible options: --livelock --livelock --starvation");
                System.exit(1);
        }
    }
}
