package com.github.silviuburceadev.aoc.garden;

import java.util.List;

public record SectionRange(String name, List<DestSrcRange> ranges) {

    public long apply(long seed) {
        return 0;
    }
}
