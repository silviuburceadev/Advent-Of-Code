package com.github.silviuburceadev.aoc.garden;

import java.util.List;

public record SectionRange(String name, List<DestSrcRange> ranges) {

    public long apply(long seed) {
        for (DestSrcRange range : ranges) {
            if (range.accepts(seed)) {
                return range.apply(seed);
            }
        }
        return seed;
    }
}
