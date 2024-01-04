package com.github.silviuburceadev.aoc.camelcard;

import java.util.Comparator;
import java.util.function.Function;

public record PlayingHand(Hand hand, long bet) implements Comparable<PlayingHand> {

    public static PlayingHand parse(String input, Function<String, Hand> parser) {
        final String[] parts = input.split(" ");
        final Hand hand = parser.apply(parts[0]);
        final int bet = Integer.parseInt(parts[1]);
        return new PlayingHand(hand, bet);
    }

    @Override
    public int compareTo(PlayingHand o) {
        return Comparator
                .<PlayingHand>comparingInt(ph -> ph.hand.type().ordinal())
                .reversed()
                .thenComparingInt(ph -> ph.hand.power())
                .compare(this, o);
    }
}
