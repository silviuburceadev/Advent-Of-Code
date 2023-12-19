package com.github.silviuburceadev.aoc.test.scratchcard;

import com.github.silviuburceadev.aoc.scratchcard.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCard {

    @Test
    public void testCard() {
        Assertions.assertNotNull(Card.parse("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"));
    }
}
