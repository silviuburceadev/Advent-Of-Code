package com.github.silviuburceadev.aoc.test.race;

import com.github.silviuburceadev.aoc.race.Race;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRace {

    @Test
    public void testRace() {
        final Race race = new Race(7, 9);
        assertEquals(4, race.waysToWin());
    }
}
