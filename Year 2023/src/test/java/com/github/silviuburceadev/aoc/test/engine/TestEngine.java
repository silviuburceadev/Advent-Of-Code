package com.github.silviuburceadev.aoc.test.engine;

import com.github.silviuburceadev.aoc.engine.Cog;
import com.github.silviuburceadev.aoc.engine.Engine;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEngine {

    private static final String SAMPLE =
        """
        467..114..
        ...*......
        ..35..633.
        ......#...
        617*......
        .....+.58.
        ..592.....
        ......755.
        ...$.*....
        .664.598..
        """;

    @Test
    public void testParseEngine() {
        final Engine engine = Engine.parse(SAMPLE);
        assertEquals(6, engine.cogs().size());
        assertEquals(10, engine.parts().size());
    }

    @Test
    public void testCogTotal() {
        final Engine engine = Engine.parse(SAMPLE);
        // get the star
        final Cog cog = engine.cogs().get(0);
        assertEquals(502, engine.getCogTotal(cog));
    }

    @Test
    public void testSampleEngineTotal() {
        final Engine engine = Engine.parse(SAMPLE);
        assertEquals(4361, engine.getTotal());
    }

    @Test
    public void testMainEngineTotal() throws IOException {
        try (InputStream resource = TestEngine.class.getResourceAsStream("day3.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                final String[] lines = bufferedReader.lines().toArray(String[]::new);
                final Engine engine = Engine.parse(lines);
                assertEquals(531561, engine.getTotal());
            }
        }
    }

    @Test
    public void testRatio() {
        final Engine engine = Engine.parse("""
            123...*456
            *789......
            """);
        assertEquals(2, engine.cogs().size());
        assertEquals(0, engine.getCogRatio(engine.cogs().get(0)));
        assertEquals(97047, engine.getCogRatio(engine.cogs().get(1)));
    }
}
