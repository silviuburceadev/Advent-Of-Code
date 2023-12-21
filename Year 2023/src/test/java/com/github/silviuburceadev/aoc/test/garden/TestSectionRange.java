package com.github.silviuburceadev.aoc.test.garden;

import com.github.silviuburceadev.aoc.garden.DestSrcRange;
import com.github.silviuburceadev.aoc.garden.SectionRange;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSectionRange {

    @Test
    public void testSimpleMatch() {
        SectionRange section = new SectionRange("demo-section", Arrays.asList(
                new DestSrcRange(50, 98, 2),
                new DestSrcRange(52, 50, 48)
        ));
        assertEquals(81L, section.apply(79L));
        assertEquals(14L, section.apply(14L));
        assertEquals(57L, section.apply(55L));
        assertEquals(100L, section.apply(100L));
    }
}
