package com.github.silviuburceadev.aoc.race;

public record Race(int time, int distance) {
    public int waysToWin() {
        int waysToWin = 0;
        for (int i = time / 2; i > 0; i--) {
            if (i * (time - i) >= distance) {
                // we count twice, because holding for i seconds and going for (time - i) seconds is the same
                // as holding for (time - i) seconds and going for i seconds
                waysToWin += 2;
            }
        }
        if (time % 2 == 0) waysToWin++;
        return waysToWin;
    }
}
