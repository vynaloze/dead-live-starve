package com.vynaloze.dls.livelock;

public class Pedestrian implements Runnable {
    private final String name;
    private final Street street;
    private int x;
    private int y;
    private int direction;

    public Pedestrian(String name, Street street, int x, int y, int direction) {
        this.name = name;
        this.street = street;
        this.x = x;
        this.y = y;
        this.direction = direction;
        street.occupy(x, y);
    }

    public String getName() {
        return name;
    }

    public void goForward(int direction) {
//        synchronized (street) {
            if (street.isOccupied(x, y + direction)) {
                switchSide();
            } else {
                street.occupy(x, y + direction);
                street.leave(x, y);
                y += direction;
            }
//        }
    }

    private void switchSide() {
        street.occupy(x, y ^ 1);
        street.leave(x, y);
        x ^= 1;
    }

    @Override
    public String toString() {
        return "Pedestrian{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public void run() {
        while (true) {
            goForward(direction);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

