package com.github.silviuburceadev.aoc.test.gamecube;

import com.github.silviuburceadev.aoc.gamecube.GameCube;
import com.github.silviuburceadev.aoc.gamecube.GameCubeSet;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGameCubeParser {


    @Test
    public void testParseGame() {
        assertEquals(new GameCube(1, Arrays.asList(
                new GameCubeSet(4, 0, 3),
                new GameCubeSet(1, 2, 6),
                new GameCubeSet(0, 2, 0)
        )), GameCube.parse("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
    }
}
