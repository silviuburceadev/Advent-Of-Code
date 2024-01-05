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
}
