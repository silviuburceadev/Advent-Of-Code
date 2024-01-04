package com.github.silviuburceadev.aoc.test.camelcard;

import com.github.silviuburceadev.aoc.camelcard.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCard {

    @Test
    public void testParse() {
        assertEquals(9, Card.parse('9').power);
        assertEquals(12, Card.parse('Q').power);

        assertThrows(IllegalArgumentException.class, () -> Card.parse('X'));
    }
}
