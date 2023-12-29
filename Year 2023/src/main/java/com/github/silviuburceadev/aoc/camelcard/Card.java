package com.github.silviuburceadev.aoc.camelcard;

public enum Card {
    ACE(14, 'A'), KING(13, 'K'), QUEEN(12, 'Q'),
    JACK(11, 'J'), TEN(10, 'T'), NINE(9, '9'), EIGHT(8, '8'),
    SEVEN(7, '7'), SIX(6, '6'), FIVE(5, '5'),
    FOUR(4, '4'), THREE(3, '3'), TWO(2, '2');
    public final int power;
    public final char symbol;

    Card(int power, char symbol) {
        this.power = power;
        this.symbol = symbol;
    }

    public static Card parse(char input) {
        for (Card card : Card.values()) {
            if (card.symbol == input) {
                return card;
            }
        }
        throw new IllegalArgumentException();
    }
}
