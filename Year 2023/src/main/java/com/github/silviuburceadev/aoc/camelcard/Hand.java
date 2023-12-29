package com.github.silviuburceadev.aoc.camelcard;

import java.util.List;

public record Hand(List<Card> cards, HandType type, int power) {
    private static final int FACTOR = 15;


    public static Hand parse(String hand) {
        final List<Card> cards = hand.chars()
                .mapToObj(c -> Card.parse((char) c))
                .toList();

        final HandType type = HandType.parse(cards);
        final int power = cards.stream().map((c) -> c.power).reduce(1, (a, b) -> a * FACTOR + b);
        return new Hand(cards, type, power);
    }

}
