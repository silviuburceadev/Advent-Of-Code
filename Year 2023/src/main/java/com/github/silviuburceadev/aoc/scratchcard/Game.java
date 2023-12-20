package com.github.silviuburceadev.aoc.scratchcard;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public record Game(Card winningCard, Card playingCard) {
    public static Game parse(String input) {
        String[] cards = input.substring(input.indexOf(":") + 1).split("\\|");
        final Card winningCard = new Card(stream(cards[0].trim().split("\\D+")).map(Integer::valueOf).toList());
        final Card playingCard = new Card(stream(cards[1].trim().split("\\D+")).map(Integer::valueOf).toList());
        return new Game(winningCard, playingCard);
    }

    public int getPoints() {
        final List<Integer> copy = new ArrayList<>(winningCard.numbers());
        copy.retainAll(playingCard.numbers());
        int numbersInCommon = copy.size();
        return numbersInCommon == 0 ? 0 : 1 << (numbersInCommon - 1);
    }

    public int getMatches() {
        return 0;
    }
}
