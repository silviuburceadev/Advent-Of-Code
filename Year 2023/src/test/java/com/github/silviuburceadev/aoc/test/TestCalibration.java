package com.github.silviuburceadev.aoc.test;

import com.github.silviuburceadev.aoc.Calibration;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

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

    @Test
    public void testParseMultipleDigits() {
        assertEquals(15, INSTANCE.parse("a1b2c3d4e5f"));
    }

    @Test
    public void testParseOneDigit() {
        assertEquals(77, INSTANCE.parse("treb7uchet"));
    }

    @Test
    public void testMultiLinesOfSample() {
        assertEquals(142, INSTANCE.calibrate(
            List.of("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet")));
    }

    @Test
    public void testMultiLinesOfMainInput() throws IOException {
        try (InputStream resource = TestCalibration.class.getResourceAsStream("day1.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                List<String> lines = bufferedReader.lines().toList();
                assertEquals(55971, INSTANCE.calibrate(lines));
            }
        }
    }
}
