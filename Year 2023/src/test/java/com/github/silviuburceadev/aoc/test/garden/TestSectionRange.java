package com.github.silviuburceadev.aoc.test.garden;

import com.github.silviuburceadev.aoc.garden.DestSrcRange;
import com.github.silviuburceadev.aoc.garden.Range;
import com.github.silviuburceadev.aoc.garden.SectionRange;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSectionRange {

    @Test
    public void testApply() {
        final SectionRange section = new SectionRange("demo-section", asList(
                new DestSrcRange(50, new Range(98, 100)),
                new DestSrcRange(52, new Range(50, 98))
        ));
        assertEquals(81L, section.apply(79L));
        assertEquals(14L, section.apply(14L));
        assertEquals(57L, section.apply(55L));
        assertEquals(100L, section.apply(100L));
    }
    
    @Test
    public void testSimpleRangeApply() {
        final SectionRange section = new SectionRange("demo-section", asList(
                new DestSrcRange(50, new Range(98, 100)),
                new DestSrcRange(52, new Range(50, 98))
        ));
        assertEquals(asList(new Range(81L, 82L)), section.apply(new Range(79L, 80L)));
        assertEquals(asList(new Range(14L, 15L)), section.apply(new Range(14L, 15L)));
        assertEquals(asList(new Range(57L, 58L)), section.apply(new Range(55L, 56L)));
        assertEquals(asList(new Range(100L, 101L)), section.apply(new Range(100L, 101L)));
    }
}
