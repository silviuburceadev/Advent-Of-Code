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
}
