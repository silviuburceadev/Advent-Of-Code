package com.github.silviuburceadev.aoc.test.cage;

import com.github.silviuburceadev.aoc.cage.Loop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoop {

    @Test
    public void testNoLoop() {
        final String[] sample = """
                ...
                ...
                """.split(lineSeparator());
        Assertions.assertThrows(IllegalStateException.class, () -> Loop.parse(sample));
    }

    @Test
    public void testBounds() {
        final String[] sampleNorthWest = """
                S-7.
                |.|.
                L-J.
                ....
                """.split(lineSeparator());
        assertEquals(8, Loop.parse(sampleNorthWest).size());

        final String[] sampleNorthEast = """
                .F-S
                .|.|
                .L-J
                ....
                """.split(lineSeparator());
        assertEquals(8, Loop.parse(sampleNorthEast).size());
    }

    @Test
    public void testParseSquareLoop() {
        final String[] sample = """
                .....
                .S-7.
                .|.|.
                .L-J.
                .....
                """.split(lineSeparator());
        final Loop loop = Loop.parse(sample);
        assertEquals(8, loop.size());
    }

    @Test
    public void testParseNonConnectedLoop() {
        final String[] sample = """
                -L|F7
                7S-7|
                L|7||
                -L-J|
                L|-JF
                """.split(lineSeparator());
        final Loop loop = Loop.parse(sample);
        assertEquals(8, loop.size());
    }

    @Test
    public void testParseComplexLoop() {
        final String[] sample = """
                ..F7.
                .FJ|.
                SJ.L7
                |F--J
                LJ...
                """.split(lineSeparator());
        final Loop loop = Loop.parse(sample);
        assertEquals(16, loop.size());
    }

    @Test
    public void testParseComplexNonLoop() {
        final String[] sample = """
                7-F7-
                .FJ|7
                SJLL7
                |F--J
                LJ.LJ
                """.split(lineSeparator());
        final Loop loop = Loop.parse(sample);
        assertEquals(16, loop.size());
    }

    @Test
    public void testMainInput() throws IOException {
        try (InputStream resource = TestLoop.class.getResourceAsStream("day10.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                final List<String> lines = bufferedReader.lines().toList();
                final Loop loop = Loop.parse(lines);
                assertEquals(6738, loop.farthest());
            }
        }
    }
}
