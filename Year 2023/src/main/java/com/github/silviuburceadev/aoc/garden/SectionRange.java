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
                List<Range> mappedRanges = mapper.apply(currentRange);
                if (mappedRanges.size() == 1) {
                    results.addAll(mappedRanges);
                } else {
                    for (Range mapped : mappedRanges) {
                        if (mapped.low() == mapper.destination()) {
                            // do not reprocess it by other mappers
                            results.add(mapped);
                        } else {
                            // this is a part of the given range, but it wasn't processed by the current mapper
                            toProcess.add(mapped);
                        }
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
