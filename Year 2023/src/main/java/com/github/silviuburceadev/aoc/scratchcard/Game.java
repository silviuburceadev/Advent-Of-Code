package com.github.silviuburceadev.aoc.scratchcard;

import static java.util.Arrays.stream;

public record Game(Card winningCard, Card playingCard) {
    public static Game parse(String input) {
        String[] cards = input.substring(input.indexOf(":") + 1).split("\\|");
        final Card winningCard = new Card(stream(cards[0].trim().split("\\D+")).map(Integer::valueOf).toList());
        final Card playingCard = new Card(stream(cards[1].trim().split("\\D+")).map(Integer::valueOf).toList());
        return new Game(winningCard, playingCard);
    }
}
