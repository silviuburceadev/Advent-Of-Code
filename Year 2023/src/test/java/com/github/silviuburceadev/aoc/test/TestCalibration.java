package com.github.silviuburceadev.aoc.test;

import com.github.silviuburceadev.aoc.Calibration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCalibration {

    private static final Calibration INSTANCE = new Calibration();

    @Test
    public void testParseLeadTailDigit() {
        Assertions.assertEquals(12, INSTANCE.parse("1abc2"));
    }
}
