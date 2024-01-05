package com.github.silviuburceadev.aoc.test.progression;

import com.github.silviuburceadev.aoc.progression.Dataset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDataset {

    @Test
    public void testIsConstant() {
        assertEquals(false, new Dataset(0, 3, 6, 9, 12, 15).isConstant());
        assertEquals(false, new Dataset(0, 0, 0, 0, 0, 0).isConstant());
    }
}
