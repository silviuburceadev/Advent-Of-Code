package com.github.silviuburceadev.aoc.garden;

import static java.lang.Integer.parseInt;

public record DestSrcRange(long destination, long source, long range) {
    public DestSrcRange(String input) {
        this(input.split("\\s+"));
    }

    private DestSrcRange(String[] input) {
        this(parseInt(input[0]), parseInt(input[1]), parseInt(input[2]));
    }

    public long apply(long seed) {
        if (!accepts(seed)) return seed;
        return seed + (destination - source);
    }

    public boolean accepts(long seed) {
        return seed >= source && seed < source + range;
    }
}
