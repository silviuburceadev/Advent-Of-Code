package com.github.silviuburceadev.aoc.test.race;

import com.github.silviuburceadev.aoc.race.Championship;
import com.github.silviuburceadev.aoc.race.Race;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.github.silviuburceadev.aoc.race.Championship.MANY_RACES;
import static com.github.silviuburceadev.aoc.race.Championship.ONE_RACE;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestChampionship {

    @Test
    public void testParseChampionship() {
        List<String> input = asList("""
            Time:      7  15   30
            Distance:  9  40  200
            """.split(System.lineSeparator()));
        final Championship championship = Championship.parse(input.get(0), input.get(1), MANY_RACES);
        assertEquals(3, championship.races().size());
        final Championship oneRaceChamp = Championship.parse(input.get(0),input.get(1), ONE_RACE);
        assertEquals(1, oneRaceChamp.races().size());
    }

    @Test
    public void testWaysToWin() {
        final Championship championship = new Championship(asList(
            new Race(7, 9),
            new Race(15, 40),
            new Race(30, 200)
        ));
        assertEquals(288, championship.waysToWin());
        final Championship oneRaceChamp = new Championship(asList(
                new Race(71530, 940200)
        ));
        assertEquals(71503, oneRaceChamp.waysToWin());
    }

    @Test
    public void testWaysToWinMainInput() throws IOException {
        try (InputStream resource = TestChampionship.class.getResourceAsStream("day6.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                final List<String> lines = bufferedReader.lines().toList();
                assertEquals(505494, Championship.parse(lines.get(0), lines.get(1), MANY_RACES).waysToWin());
            }
        }
    }

    @Test
    public void testWaysToWinAsOneRaceMainInput() throws IOException {
        try (InputStream resource = TestChampionship.class.getResourceAsStream("day6.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                final List<String> lines = bufferedReader.lines().toList();
                assertEquals(23632299, Championship.parse(lines.get(0), lines.get(1), ONE_RACE).waysToWin());
            }
        }
    }
}
