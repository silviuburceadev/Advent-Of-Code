package com.github.silviuburceadev.aoc.race;

public record Race(int time, int distance) {
    public int waysToWin() {
        int waysToWin = 0;
        for (int i = time / 2; i > 0 && canBeatRecord(i, time - i, distance); i--) {
            // we count twice, because holding for <code>i</code> seconds and going for (time - i) seconds
            // is the same as holding for (time - i) seconds and going for <code>i</code> seconds
            waysToWin += 2;
        }
        // avoid counting it twice
        if (time % 2 == 0 && canBeatRecord(time / 2, time / 2, distance)) waysToWin--;
        return waysToWin;
    }

    private boolean canBeatRecord(int speed, int time, int distance) {
        return speed * time > distance;
    }
}
