package com.github.silviuburceadev.aoc.garden;

import java.util.List;

import static java.lang.Long.parseLong;

public record DestSrcRange(long destination, Range range) {
    public DestSrcRange(String input) {
        this(input.split("\\s+"));
    }

    private DestSrcRange(String[] input) {
        this(parseLong(input[0]), new Range(parseLong(input[1]), parseLong(input[1]) + parseLong(input[2])));
    }

    private long offset() {
        return destination - range.low();
    }

    public long apply(long seed) {
        if (!accepts(seed)) return seed;
        return seed + offset();
    }

    public List<Range> apply(Range range) {
        final List<Range> ranges = range.split(this.range);
        for (int i = 0; i < ranges.size(); i++) {
            Range current = ranges.get(i);
            if (this.range.contains(current)) {
                ranges.set(i, current.addOffset(offset()));
            }
        }
        return ranges;
    }

    public boolean accepts(long seed) {
        return seed >= range.low() && seed < range.high();
    }
}
