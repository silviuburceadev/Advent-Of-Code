package com.github.silviuburceadev.aoc.test.garden;

import com.github.silviuburceadev.aoc.garden.DestSrcRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDestSrcRange {

    @Test
    public void testParseRange() {
        DestSrcRange range = new DestSrcRange("50 98 2");
        assertEquals(50, range.destination());
        assertEquals(98, range.source());
        assertEquals(2, range.range());
    }

    @Test
    public void testMap() {
        DestSrcRange range = new DestSrcRange(52, 50, 48);
        assertEquals(81, range.apply(79));
        assertEquals(14, range.apply(14));
        assertEquals(57, range.apply(55));
        assertEquals(100, range.apply(100));
    }
}
