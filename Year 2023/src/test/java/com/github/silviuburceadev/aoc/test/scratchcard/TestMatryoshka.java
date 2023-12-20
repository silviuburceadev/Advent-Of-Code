package com.github.silviuburceadev.aoc.test.scratchcard;

import com.github.silviuburceadev.aoc.scratchcard.Game;
import com.github.silviuburceadev.aoc.scratchcard.Matryoshka;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMatryoshka {
    @Test
    public void testAddCopy() {
        String[] gameOneWithOneHit = """
                Card 1: 10 15 | 20 15  3
                Card 2:  5 20 |  7 19 31
                """.split(System.lineSeparator());
        final List<Game> games = Arrays.stream(gameOneWithOneHit)
                .map(Game::parse)
                .toList();
        Matryoshka game = new Matryoshka(games);
        assertEquals(3, game.getTotalCards());
    }

    @Test
    public void testAddCopyOfCopy() {
        // game 1 has 2 hits, game 2 has 1 hit
        String[] gameCards = """
                Card 1:  3 10 15 | 20 15  3
                Card 2:  9 10 15 | 20 15  3
                Card 3: 17  5 20 |  7 19 31
                """.split(System.lineSeparator());
        final List<Game> games = Arrays.stream(gameCards)
                .map(Game::parse)
                .toList();
        final Matryoshka game = new Matryoshka(games);
        // so we should end up with 1 card #1, 2 card #2, 4 card #3
        // as one is given, one is a copy straight from card #1 and two are copies coming from card #2
        assertEquals(7, game.getTotalCards());
    }

    @Test
    public void testSample() {
        final String[] sample = """
            Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
            Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
            Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
            Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
            Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
            Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
            """.split(System.lineSeparator());
        final List<Game> games = Arrays.stream(sample)
                .map(Game::parse)
                .toList();
        final Matryoshka game = new Matryoshka(games);
        assertEquals(30, game.getTotalCards());
    }

    @Test
    public void testMainInput() throws IOException {
        try (InputStream resource = TestMatryoshka.class.getResourceAsStream("day4.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                final List<Game> games = bufferedReader.lines()
                        .map(Game::parse)
                        .toList();
                final Matryoshka game = new Matryoshka(games);
                assertEquals(5921508, game.getTotalCards());
            }
        }
    }
}
