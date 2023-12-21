package com.github.silviuburceadev.aoc.test.scratchcard;

import com.github.silviuburceadev.aoc.scratchcard.Game;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestGame {

    @Test
    public void testParsingGame() {
        final Game game = Game.parse("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
        assertNotNull(game.winningNumbers());
        assertEquals(5, game.winningNumbers().size());
        assertNotNull(game.playingNumbers());
        assertEquals(8, game.playingNumbers().size());
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

    @Test
    public void testPointsMainInput() throws IOException {
        try (InputStream resource = TestGame.class.getResourceAsStream("day4.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                int sum = bufferedReader.lines()
                        .map(Game::parse)
                        .mapToInt(Game::getPoints)
                        .sum();
                assertEquals(18653, sum);

            }
        }
    }

    @Test
    public void testMatches() {
        final Game game = Game.parse("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
        assertEquals(4, game.getMatches());
    }
}
