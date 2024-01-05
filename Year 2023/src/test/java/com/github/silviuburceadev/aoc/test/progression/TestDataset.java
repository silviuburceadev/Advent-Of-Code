package com.github.silviuburceadev.aoc.test.progression;

import com.github.silviuburceadev.aoc.progression.Dataset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDataset {

    @Test
    public void testIsConstant() {
        assertFalse(new Dataset(0, 3, 6, 9, 12, 15).isConstant());
        assertTrue(new Dataset(0, 0, 0, 0, 0, 0).isConstant());
    }

    @Test
    public void testProgression() {
        final Dataset dataset = new Dataset(0, 3, 6, 9, 12, 15);
        final Dataset progression = dataset.getProgression();
        final Dataset expected = new Dataset(3, 3, 3, 3, 3);
        assertNotNull(progression);
        assertEquals(expected, progression);
        assertTrue(progression.isConstant());
    }

    @Test
    public void testNextValue() {
        assertEquals(18, new Dataset(0, 3, 6, 9, 12, 15).getNextValue());
        assertEquals(28, new Dataset(1, 3, 6, 10, 15, 21).getNextValue());
        assertEquals(68, new Dataset(10, 13, 16, 21, 30, 45).getNextValue());
    }
}
