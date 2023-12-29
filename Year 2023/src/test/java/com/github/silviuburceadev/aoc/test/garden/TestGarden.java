package com.github.silviuburceadev.aoc.test.garden;

import com.github.silviuburceadev.aoc.garden.Garden;
import com.github.silviuburceadev.aoc.garden.Range;
import com.github.silviuburceadev.aoc.garden.SectionRange;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static com.github.silviuburceadev.aoc.garden.Garden.RANGE_SEED;
import static com.github.silviuburceadev.aoc.garden.Garden.SINGLE_SEED;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGarden {

    private static final String[] SAMPLE = """
            seeds: 79 14 55 13
                    
            seed-to-soil map:
            50 98 2
            52 50 48
                    
            soil-to-fertilizer map:
            0 15 37
            37 52 2
            39 0 15
                    
            fertilizer-to-water map:
            49 53 8
            0 11 42
            42 0 7
            57 7 4
                    
            water-to-light map:
            88 18 7
            18 25 70
                    
            light-to-temperature map:
            45 77 23
            81 45 19
            68 64 13
                    
            temperature-to-humidity map:
            0 69 1
            1 0 69
                    
            humidity-to-location map:
            60 56 37
            56 93 4
            """.split(System.lineSeparator());

    @Test
    public void testParseGarden() {
        final Garden garden = Garden.parse(SAMPLE, SINGLE_SEED);
        assertEquals(4, garden.getTotalSeeds());
        assertEquals(4, garden.getSeeds().size());
        assertEquals(7, garden.sections().size());

        final SectionRange section = garden.sections().get(0);
        assertEquals("seed-to-soil", section.name());
        assertEquals(2, section.ranges().size());
    }

    @Test
    public void testParseRangeGarden() {
        final Garden garden = Garden.parse(SAMPLE, RANGE_SEED);
        assertEquals(27, garden.getTotalSeeds());
        assertEquals(2, garden.getSeeds().size());
        assertEquals(7, garden.sections().size());
    }

    @Test
    public void testApplyGarden() {
        final Garden garden = Garden.parse(SAMPLE, SINGLE_SEED);
        assertEquals(82L, garden.apply(79L));
        assertEquals(43L, garden.apply(14L));
        assertEquals(86L, garden.apply(55L));
        assertEquals(35L, garden.apply(13L));
    }

    @Test
    public void testLowestLocation() {
        final Garden garden = Garden.parse(SAMPLE, SINGLE_SEED);
        assertEquals(35, garden.lowestLocation());
    }

    @Test
    public void testApplyMainInput() throws IOException {
        try (InputStream resource = TestGarden.class.getResourceAsStream("day5.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                final Garden garden = Garden.parse(bufferedReader.lines().toList(), SINGLE_SEED);
                assertEquals(107430936L, garden.lowestLocation());
            }
        }
    }

    @Test
    public void testSeedsAsRange() {
        final Garden garden = Garden.parse(SAMPLE, Garden.RANGE_SEED);
        assertEquals(27, garden.getTotalSeeds());
    }

    @Test
    public void testRangeLowestLocation() {
        final Garden garden = Garden.parse(SAMPLE, Garden.RANGE_SEED);
        assertEquals(46L, garden.lowestLocation());
    }

    @Test
    public void testRangeApply() {
        final Garden garden = Garden.parse(SAMPLE, RANGE_SEED);
        assertEquals(asList(new Range(82L, 83L)), garden.apply(new Range(79L, 80L)));
        assertEquals(asList(new Range(43L, 44L)), garden.apply(new Range(14L, 15L)));
        assertEquals(asList(new Range(86L, 87L)), garden.apply(new Range(55L, 56L)));
        assertEquals(asList(new Range(35L, 36L)), garden.apply(new Range(13L, 14L)));
    }

    @Test
    public void testRangeApplyMainInput() throws IOException {
        try (InputStream resource = TestGarden.class.getResourceAsStream("day5.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                final Garden garden = Garden.parse(bufferedReader.lines().toList(), Garden.RANGE_SEED);
                assertEquals(23738616L, garden.lowestLocation());
            }
        }
    }
}
