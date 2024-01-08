package com.github.silviuburceadev.aoc.test.cage;

import com.github.silviuburceadev.aoc.cage.Loop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLoop {

    @Test
    public void parseLoop() {
        final String[] sample = """
            .....
            .S-7.
            .|.|.
            .L-J.
            .....
            """.split(System.lineSeparator());
        Assertions.assertEquals(8, Loop.parse(sample).size());
    }
}
