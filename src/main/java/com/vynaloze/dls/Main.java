package com.vynaloze.dls;

import com.vynaloze.dls.livelock.LivelockCase;
import com.vynaloze.dls.starvation.StarvationCase;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong number of command line arguments.");
            System.exit(1);
        }
        if (args[0].equals("--deadlock")) {
            System.out.println("Deadlock.");
        } else if (args[0].equals("--livelock")) {
            System.out.println("Livelock.");
            LivelockCase.start();
        } else if (args[0].equals("--starvation")) {
            System.out.println("Starvation.");
            StarvationCase.start();
        } else {
            System.out.println("Unrecognised command line argument.");
            System.out.println("Possible options: --livelock --livelock --starvation");
            System.exit(1);
        }
    }
}
