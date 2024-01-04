package com.github.silviuburceadev.aoc.test.camelcard;

import com.github.silviuburceadev.aoc.camelcard.Hand;
import org.junit.jupiter.api.Test;

import static com.github.silviuburceadev.aoc.camelcard.Hand.JOKER_HAND_PARSER;
import static com.github.silviuburceadev.aoc.camelcard.HandType.FIVE;
import static com.github.silviuburceadev.aoc.camelcard.HandType.FOUR;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHand {

    @Test
    public void testParse() {
        final Hand hand = Hand.NORMAL_HAND_PARSER.apply("AAAAA");
        assertEquals(5, hand.cards().size());
        assertEquals(FIVE, hand.type());
        assertEquals(1518749, hand.power());
    }

    @Test
    public void testJokerParse() {
        // Jokers - 5 of a kind
        assertEquals(FIVE, JOKER_HAND_PARSER.apply("AAAAA").type());
        assertEquals(FIVE, JOKER_HAND_PARSER.apply("JJJJJ").type());
        assertEquals(FIVE, JOKER_HAND_PARSER.apply("JJJJA").type());
        assertEquals(FIVE, JOKER_HAND_PARSER.apply("JJAAA").type());
        assertEquals(FIVE, JOKER_HAND_PARSER.apply("JAAAA").type());
        // No Jokers
        assertEquals(FOUR, JOKER_HAND_PARSER.apply("QAAAA").type());
        // Jokers - 4 of a kind
        assertEquals(FOUR, JOKER_HAND_PARSER.apply("AAAJQ").type());
    }
}
