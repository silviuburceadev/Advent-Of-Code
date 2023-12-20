package com.github.silviuburceadev.aoc.scratchcard;

import java.util.Arrays;
import java.util.List;

public record Matryoshka(List<Game> games) {
    public int getTotalCards() {
        final int[] cards = new int[games.size()];
        Arrays.fill(cards, 1);
        for (int i = 0; i < cards.length; i++) {
            int matches = games.get(0).getMatches();
            for (int j = i + 1; j < cards.length && j <= i + matches; j++) {
                cards[j] += cards[i];
            }
        }
        return Arrays.stream(cards).sum();
    }
}
