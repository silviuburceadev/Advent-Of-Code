package com.github.silviuburceadev.aoc.garden;

import static java.lang.Integer.parseInt;

public record DestSrcRange(int destination, int source, int range) {
    public DestSrcRange(String input) {
        this(input.split("\\s+"));
    }

    private DestSrcRange(String[] input) {
        this(parseInt(input[0]), parseInt(input[1]), parseInt(input[2]));
    }

    public int map(int seed) {
        if (seed < source || seed >= source + range) return seed;
        return seed + (destination - source);
    }
}
