package com.github.silviuburceadev.aoc.scratchcard;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public record Game(List<Integer> winningNumbers, List<Integer> playingNumbers) {
    public static Game parse(String input) {
        String[] cards = input.substring(input.indexOf(":") + 1).split("\\|");
        List<Integer> winningNumbers = stream(cards[0].trim().split("\\D+")).map(Integer::valueOf).toList();
        List<Integer> playingNumbers = stream(cards[1].trim().split("\\D+")).map(Integer::valueOf).toList();
        return new Game(winningNumbers, playingNumbers);
    }

    public int getPoints() {
        final int matches = getMatches();
        return matches == 0 ? 0 : 1 << (matches - 1);
    }

    public int getMatches() {
        final List<Integer> copy = new ArrayList<>(winningNumbers);
        copy.retainAll(playingNumbers);
        return copy.size();
    }
}
