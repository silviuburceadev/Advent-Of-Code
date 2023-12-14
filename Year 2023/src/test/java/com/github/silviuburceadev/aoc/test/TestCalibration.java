package com.github.silviuburceadev.aoc.test;

import com.github.silviuburceadev.aoc.Calibration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalibration {

    private static final Calibration INSTANCE = new Calibration();

    @Test
    public void testParseLeadTailDigit() {
        assertEquals(12, INSTANCE.parse("1abc2"));
    }
    
    @Test
    public void testParseTwoDigitsInside() {
        assertEquals(38, INSTANCE.parse("pqr3stu8vwx"));
    }
}
