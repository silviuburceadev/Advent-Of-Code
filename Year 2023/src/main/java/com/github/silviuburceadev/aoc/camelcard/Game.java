package com.github.silviuburceadev.aoc.camelcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record Game(List<PlayingHand> playingHands) {

    public int winnings() {
        List<PlayingHand> copy = new ArrayList<>(playingHands);
        Collections.sort(copy);
        int total = 0;
        for (int i = 0; i < copy.size(); i++) {
            total += copy.get(i).bet() * (i + 1);
        }
        return total;
    }
}
