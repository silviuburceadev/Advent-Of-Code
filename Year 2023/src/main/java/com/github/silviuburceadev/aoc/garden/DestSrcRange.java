package com.github.silviuburceadev.aoc.garden;

import static java.lang.Long.parseLong;

public record DestSrcRange(long destination, long source, long range) {
    public DestSrcRange(String input) {
        this(input.split("\\s+"));
    }

    private DestSrcRange(String[] input) {
        this(parseLong(input[0]), parseLong(input[1]), parseLong(input[2]));
    }

    public long apply(long seed) {
        if (!accepts(seed)) return seed;
        return seed + (destination - source);
    }

    public boolean accepts(long seed) {
        return seed >= source && seed < source + range;
    }
}
