package com.github.silviuburceadev.aoc.test.gamecube;

import com.github.silviuburceadev.aoc.gamecube.GameCube;
import com.github.silviuburceadev.aoc.gamecube.GameCubeSet;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGameCube {

    @Test
    public void testParseGame() {
        // Note: yellow will be ignored
        assertEquals(new GameCube(1, Arrays.asList(
                new GameCubeSet(4, 0, 3),
                new GameCubeSet(1, 2, 6),
                new GameCubeSet(0, 2, 0)
        )), GameCube.parse("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green, 5 yellow"));
    }

    @Test
    public void testMultiLinesOfSampleInput() throws IOException {
        try (InputStream resource = TestGameCube.class.getResourceAsStream("day2.sample.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                long count = bufferedReader.lines()
                        .map(GameCube::parse)
                        .filter(g -> g.isValid(12, 13, 14))
                        .mapToInt(GameCube::id)
                        .sum();
                assertEquals(8, count);
            }
        }
    }

    @Test
    public void testMultiLinesOfMainInput() throws IOException {
        try (InputStream resource = TestGameCube.class.getResourceAsStream("day2.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                long count = bufferedReader.lines()
                        .map(GameCube::parse)
                        .filter(g -> g.isValid(12, 13, 14))
                        .mapToInt(GameCube::id)
                        .sum();
                assertEquals(2810, count);
            }
        }
    }

    @Test
    public void testMinimumToPlay() {
        final GameCube gameCube = GameCube.parse("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        final GameCubeSet minToPlay = new GameCubeSet(4, 2, 6);
        assertEquals(minToPlay, gameCube.getMinimumToPlay());
    }

    @Test
    public void testGameSetPower() {
        final GameCubeSet set = new GameCubeSet(4, 2, 6);
        assertEquals(48, set.getPower());
    }

    @Test
    public void testMultipleGameSetPower() throws IOException {
        try (InputStream resource = TestGameCube.class.getResourceAsStream("day2.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                long count = bufferedReader.lines()
                        .map(GameCube::parse)
                        .map(GameCube::getMinimumToPlay)
                        .mapToInt(GameCubeSet::getPower)
                        .sum();
                assertEquals(69110, count);
            }
        }
    }
}
