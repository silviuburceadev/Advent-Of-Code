package com.github.silviuburceadev.aoc.garden;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Range> apply(Range range) {
        List<Range> results = new ArrayList<>();
        List<Range> toProcess = new ArrayList<>(Arrays.asList(range));
        while (!toProcess.isEmpty()) {
            final Range currentRange = toProcess.remove(0);
            boolean isProcessed = false;
            for (DestSrcRange mapper : ranges) {
                if (!currentRange.hasOverlap(mapper.range())) {
                    continue;
                }
                List<Range> unmapped = currentRange.split(mapper.range());
                for (Range toMap : unmapped) {
                    if (mapper.range().contains(toMap)) {
                        results.addAll(mapper.apply(toMap));
                    } else {
                        toProcess.add(toMap);
                    }
                }
                isProcessed = true;
                break;
            }
            if (!isProcessed) {
                results.add(currentRange);
            }
        }
        return results;
    }
}
