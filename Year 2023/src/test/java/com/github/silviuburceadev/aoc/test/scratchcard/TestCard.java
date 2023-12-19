package com.github.silviuburceadev.aoc.test.scratchcard;

import com.github.silviuburceadev.aoc.scratchcard.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestCard {

    @Test
    public void testParsingGame() {
        final Game game = Game.parse("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
        assertNotNull(game.winningCard());
        assertEquals(5, game.winningCard().numbers().size());
        assertNotNull(game.playingCard());
        assertEquals(8, game.playingCard().numbers().size());
    }
}
