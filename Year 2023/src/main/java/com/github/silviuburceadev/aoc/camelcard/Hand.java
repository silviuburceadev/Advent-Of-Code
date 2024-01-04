package com.github.silviuburceadev.aoc.camelcard;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.github.silviuburceadev.aoc.camelcard.HandType.*;
import static java.util.stream.Collectors.counting;

public record Hand(List<Card> cards, HandType type, int power) {
    private static final int FACTOR = 15;


    private static final Function<List<Card>, HandType> NORMAL_TYPE_PARSER = (cards) -> {
        final Map<Card, Long> frequency = cards.stream().collect(Collectors.groupingBy(c -> c, counting()));
        long m1 = 0, m2 = 0;
        for (Map.Entry<Card, Long> entry : frequency.entrySet()) {
            long current = entry.getValue();
            if (current > m1) {
                m2 = m1;
                m1 = current;
            } else if (current > m2) {
                m2 = current;
            }
        }

        if (m1 == 5) {
            return FIVE;
        } else if (m1 == 4) {
            return FOUR;
        } else if (m1 == 3) {
            if (m2 == 1) {
                return THREE;
            } else {
                return FULL;
            }
        } else if (m1 == 2) {
            if (m2 == 1) {
                return PAIR;
            } else {
                return TWO_PAIR;
            }
        } else {
            return HIGH;
        }
    };

    private static final Function<List<Card>, Integer> NORMAL_POWER_PARSER = (cards) ->
            cards.stream().map((c) -> c.power).reduce(1, (a, b) -> a * FACTOR + b);
    public static final Function<String, Hand> NORMAL_HAND_PARSER = (hand) -> {
        final List<Card> cards = hand.chars()
                .mapToObj(c -> Card.parse((char) c))
                .toList();

        final HandType type = NORMAL_TYPE_PARSER.apply(cards);
        final int power = NORMAL_POWER_PARSER.apply(cards);

        return new Hand(cards, type, power);
    };

    private static final Function<List<Card>, HandType> JOKER_TYPE_PARSER = (cards) -> {
        final Map<Card, Long> frequency = cards.stream().collect(Collectors.groupingBy(c -> c, counting()));

        long m1 = 0, m2 = 0, joker = frequency.getOrDefault(Card.JACK, 0L);
        frequency.remove(Card.JACK);

        for (Map.Entry<Card, Long> entry : frequency.entrySet()) {
            long current = entry.getValue();
            if (current > m1) {
                m2 = m1;
                m1 = current;
            } else if (current > m2) {
                m2 = current;
            }
        }

        m1 += joker;

        if (m1 == 5) {
            return FIVE;
        } else if (m1 == 4) {
            return FOUR;
        } else if (m1 == 3) {
            if (m2 == 1) {
                return THREE;
            } else {
                return FULL;
            }
        } else if (m1 == 2) {
            if (m2 == 1) {
                return PAIR;
            } else {
                return TWO_PAIR;
            }
        } else {
            return HIGH;
        }
    };

    private static final Function<List<Card>, Integer> JOKER_POWER_PARSER = (cards) ->
            cards.stream().map((c) -> c == Card.JACK ? 1 : c.power).reduce(1, (a, b) -> a * FACTOR + b);

    public static final Function<String, Hand> JOKER_HAND_PARSER = (hand) -> {
        final List<Card> cards = hand.chars()
                .mapToObj(c -> Card.parse((char) c))
                .toList();

        final HandType type = JOKER_TYPE_PARSER.apply(cards);
        final int power = JOKER_POWER_PARSER.apply(cards);

        return new Hand(cards, type, power);
    };

}
