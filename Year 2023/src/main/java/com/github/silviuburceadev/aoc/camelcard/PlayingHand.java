package com.github.silviuburceadev.aoc.camelcard;

import java.util.Comparator;

public record PlayingHand(Hand hand, int bet) implements Comparable<PlayingHand> {

    public static PlayingHand parse(String input) {
        final String[] parts = input.split(" ");
        final Hand hand = Hand.parse(parts[0]);
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
