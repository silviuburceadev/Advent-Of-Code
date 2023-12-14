package com.github.silviuburceadev.aoc.test;

import com.github.silviuburceadev.aoc.LetterCalibration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLetterCalibration {
    private static final LetterCalibration INSTANCE = new LetterCalibration();

    @Test
    public void testParseLeadTailLetters() {
        assertEquals(29, INSTANCE.parse("two1nine"));
    }

    @Test
    public void testParsingOrder() {
        // 8 before 2
        assertEquals(83, INSTANCE.parse("eightwothree"));
        // 2 before 1
        assertEquals(24, INSTANCE.parse("xtwone3four"));
        // 1 before 8
        assertEquals(14, INSTANCE.parse("zoneight234"));
    }

    @Test
    public void testParseLettersInside() {
        assertEquals(13, INSTANCE.parse("abcone2threexyz"));
        assertEquals(42, INSTANCE.parse("4nineeightseven2"));
        assertEquals(76, INSTANCE.parse("7pqrstsixteen"));
    }

}
