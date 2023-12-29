package com.github.silviuburceadev.aoc.test.race;

import com.github.silviuburceadev.aoc.race.Race;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRace {

    @Test
    public void testRace() {
        assertEquals(4, new Race(7, 9).waysToWin());
        assertEquals(8, new Race(15, 40).waysToWin());
        assertEquals(9, new Race(30, 200).waysToWin());
    }
}
