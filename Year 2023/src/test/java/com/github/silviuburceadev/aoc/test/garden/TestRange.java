package com.github.silviuburceadev.aoc.test.garden;

import com.github.silviuburceadev.aoc.garden.Range;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRange {

    @Test
    public void testRangeBefore() {
        final Range target = new Range(31, 41);

        Range range = new Range(19, 35);
        List<Range> split = range.split(target);
        assertEquals(2, split.size());
        assertEquals(new Range(19, 31), split.get(0));
        assertEquals(new Range(31, 35), split.get(1));

        range = new Range(19, 46);
        split = range.split(target);
        assertEquals(3, split.size());
        assertEquals(new Range(19, 31), split.get(0));
        assertEquals(new Range(31, 41), split.get(1));
        assertEquals(new Range(41, 46), split.get(2));
    }

    @Test
    public void testRangeAfter() {
        final Range target = new Range(19, 45);

        Range range = new Range(31, 35);
        List<Range> split = range.split(target);
        assertEquals(1, split.size());
        assertEquals(range, split.get(0));

        range = new Range(31, 50);
        split = range.split(target);
        assertEquals(2, split.size());
        assertEquals(new Range(31, 45), split.get(0));
        assertEquals(new Range(45,50), split.get(1));
    }

    @Test
    public void testRangeSameStart() {
        final Range target = new Range(19, 45);
        List<Range> split = target.split(target);
        assertEquals(1, split.size());
        assertEquals(target, split.get(0));


        Range range = new Range(19, 31);
        split = range.split(target);
        assertEquals(1, split.size());
        assertEquals(range, split.get(0));

        range = new Range(19, 50);
        split = range.split(target);
        assertEquals(2, split.size());
        assertEquals(target, split.get(0));
        assertEquals(new Range(45, 50), split.get(1));
    }
}
