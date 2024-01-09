package com.github.silviuburceadev.aoc.test.cage;

import com.github.silviuburceadev.aoc.cage.Symbol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSymbol {

    @Test
    public void testIllegalSymbol() {
        Assertions.assertThrows(IllegalStateException.class, () -> Symbol.valueOf('*'));
    }
}
