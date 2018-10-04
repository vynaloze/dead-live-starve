package com.vynaloze.dls.livelock;

public class Street {
    public boolean[][] grid = new boolean[2][6];

    public boolean isOccupied(int x, int y) {
        return grid[x][y];
    }

    public void occupy(int x, int y) {
        this.grid[x][y] = true;
    }

    public void leave(int x, int y) {
        this.grid[x][y] = false;
    }
}
