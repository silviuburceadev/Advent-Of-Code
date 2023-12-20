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

    @Test
    public void testPoints() {
        final Game game1 = Game.parse("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
        assertEquals(8, game1.getPoints());
        final Game game2 = Game.parse("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19");
        assertEquals(2, game2.getPoints());
        final Game game3 = Game.parse("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36");
        assertEquals(0, game3.getPoints());
    }
}
