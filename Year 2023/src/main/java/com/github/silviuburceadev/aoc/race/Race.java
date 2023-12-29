package com.github.silviuburceadev.aoc.race;

public record Race(long time, long distance) {
    public int waysToWin() {
        int waysToWin = 0;
        for (long i = time / 2; canBeatRecord(i, time - i, distance); i--) {
            // we count twice, because holding for <code>i</code> seconds and going for (time - i) seconds
            // is the same as holding for (time - i) seconds and going for <code>i</code> seconds
            waysToWin += 2;
        }
        // avoid counting it twice if number is even
        if (time % 2 == 0 && canBeatRecord(time / 2, time / 2, distance)) waysToWin--;
        return waysToWin;
    }

    private boolean canBeatRecord(long speed, long time, long distance) {
        return speed * time > distance;
    }
}
