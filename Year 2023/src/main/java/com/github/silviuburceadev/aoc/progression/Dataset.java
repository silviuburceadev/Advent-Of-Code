package com.github.silviuburceadev.aoc.progression;

import java.util.List;

import static java.util.Arrays.asList;

public record Dataset(List<Integer> values) {

    public Dataset(Integer... values) {
        this(asList(values));
    }

    public boolean isConstant() {
        return false;
    }
}
