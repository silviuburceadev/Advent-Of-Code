package com.github.silviuburceadev.aoc.test.engine;

import com.github.silviuburceadev.aoc.engine.Engine;
import org.junit.jupiter.api.Test;

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
        Engine engine = Engine.parse(SAMPLE);
        assertEquals(6, engine.cogs().size());
        assertEquals(10, engine.parts().size());
    }
}
