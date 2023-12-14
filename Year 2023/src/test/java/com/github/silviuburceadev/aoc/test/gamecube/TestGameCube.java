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
        assertEquals(new GameCube(1, Arrays.asList(
                new GameCubeSet(4, 0, 3),
                new GameCubeSet(1, 2, 6),
                new GameCubeSet(0, 2, 0)
        )), GameCube.parse("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
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
}
