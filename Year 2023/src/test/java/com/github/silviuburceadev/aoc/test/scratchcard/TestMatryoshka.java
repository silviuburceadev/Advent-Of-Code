package com.github.silviuburceadev.aoc.test.scratchcard;

import com.github.silviuburceadev.aoc.scratchcard.Game;
import com.github.silviuburceadev.aoc.scratchcard.Matryoshka;
import org.junit.jupiter.api.Test;

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
}
