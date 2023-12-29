package com.github.silviuburceadev.aoc.test.race;

import com.github.silviuburceadev.aoc.race.Championship;
import com.github.silviuburceadev.aoc.race.Race;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestChampionship {

    @Test
    public void testParseChampionship() {
        List<String> input = asList("""
            Time:      7  15   30
            Distance:  9  40  200
            """.split(System.lineSeparator()));
        final Championship championship = Championship.parse(input.get(0), input.get(1));
        assertEquals(3, championship.races().size());
    }

    @Test
    public void testWaysToWin() {
        final Championship championship = new Championship(asList(
            new Race(7, 9),
            new Race(15, 40),
            new Race(30, 200)
        ));
        assertEquals(288, championship.waysToWin());
    }
}
