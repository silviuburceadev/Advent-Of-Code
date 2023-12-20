package com.github.silviuburceadev.aoc.test.calibration;

import com.github.silviuburceadev.aoc.calibration.LetterCalibration;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

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

    @Test
    public void testMultiLinesOfSample() {
        assertEquals(281, INSTANCE.calibrate(List.of("two1nine", "eightwothree", "abcone2threexyz", "xtwone3four", "4nineeightseven2", "zoneight234", "7pqrstsixteen")));
    }

    @Test
    public void testMultiLinesOfMainInput() throws IOException {
        try (InputStream resource = TestLetterCalibration.class.getResourceAsStream("day1.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                List<String> lines = bufferedReader.lines().toList();
                assertEquals(54719, INSTANCE.calibrate(lines));
            }
        }
    }

}
