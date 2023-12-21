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
        DestSrcRange range = new DestSrcRange(52L, 50L, 48L);
        assertEquals(81L, range.apply(79L));
        assertEquals(14L, range.apply(14L));
        assertEquals(57L, range.apply(55L));
        assertEquals(100L, range.apply(100L));
    }
}
