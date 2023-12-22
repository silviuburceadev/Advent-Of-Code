package com.github.silviuburceadev.aoc.test.garden;

import com.github.silviuburceadev.aoc.garden.DestSrcRange;
import com.github.silviuburceadev.aoc.garden.Range;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDestSrcRange {

    @Test
    public void testParseRange() {
        DestSrcRange range = new DestSrcRange("50 98 2");
        assertEquals(50, range.destination());
        assertEquals(98, range.range().low());
        assertEquals(100, range.range().high());
        assertEquals(2, range.range().length());
    }

    @Test
    public void testApply() {
        DestSrcRange range = new DestSrcRange(52L, new Range(50L, 98L));
        assertEquals(81L, range.apply(79L));
        assertEquals(14L, range.apply(14L));
        assertEquals(57L, range.apply(55L));
        assertEquals(100L, range.apply(100L));
    }

    @Test
    public void testRangeApply() {
        DestSrcRange range = new DestSrcRange(52L, new Range(50L, 98L));
        assertEquals(asList(new Range(81L, 82L)), range.apply(new Range(79L, 80L)));
        assertEquals(asList(new Range(14L, 15L)), range.apply(new Range(14L, 15L)));
        assertEquals(asList(new Range(57L, 58L)), range.apply(new Range(55L, 56L)));
        assertEquals(asList(new Range(100L, 101L)), range.apply(new Range(100L, 101L)));
    }

    @Test
    public void testPartialRangeApply() {
        DestSrcRange range = new DestSrcRange(52L, new Range(50L, 98L));
        assertEquals(asList(new Range(15L, 50L), new Range(52L, 55L)),
                range.apply(new Range(15L, 53L)));
        assertEquals(asList(new Range(15L, 50L), new Range(52L, 100L), new Range(98L, 100L)),
                range.apply(new Range(15L, 100L)));
    }
}
