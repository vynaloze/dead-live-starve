package com.vynaloze.dls.livelock;

public class Gentleman {
    private final String name;
    private boolean isWaiting;

    public Gentleman(String name) {
        this.name = name;
        this.isWaiting = true;
    }

    public String getName() {
        return name;
    }

    public boolean isWaiting() {
        return isWaiting;
    }

    public void setWaiting(boolean waiting) {
        isWaiting = waiting;
    }

    public void goThroughDoor(Door door) {
        while (isWaiting) {
            if (door.whoIsFirst() != this) {
                System.out.println("I'm not first so I'll wait - said " + name);
            } else if (door.whoIsWaiting().size() != 0) {
                Gentleman firstInLine = door.whoIsWaiting().get(0);
                System.out.println("I insist that you go first, " + firstInLine.getName() + " - said " + name);
                door.removeFromWaiting(firstInLine);
                door.setFirst(firstInLine);
                door.addToWaiting(this);
            } else {
                System.out.println("I got through the door - said " + name);
                door.setFirst(null);
                isWaiting = false;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
