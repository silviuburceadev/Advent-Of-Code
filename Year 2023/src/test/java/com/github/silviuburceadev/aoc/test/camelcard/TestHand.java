package com.github.silviuburceadev.aoc.test.camelcard;

import com.github.silviuburceadev.aoc.camelcard.Hand;
import org.junit.jupiter.api.Test;

import static com.github.silviuburceadev.aoc.camelcard.HandType.FIVE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHand {

    @Test
    public void testParse() {
        final Hand hand = Hand.parse("AAAAA");
        assertEquals(5, hand.cards().size());
        assertEquals(FIVE, hand.type());
        assertEquals(1518749, hand.power());
    }
}
