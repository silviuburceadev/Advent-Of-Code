package com.github.silviuburceadev.aoc.garden;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.lang.Long.parseLong;

public record Garden(List<Range> seeds, List<SectionRange> sections) {

    public static final Function<String, List<Range>> SINGLE_SEED = (input) -> {
        final String[] seeds = input.split("\\s+");
        final List<Range> seedRanges = new ArrayList<>();
        for (String seed : seeds) {
            long seedNo = Long.parseLong(seed);
            seedRanges.add(new Range(seedNo, seedNo + 1L));
        }
        return seedRanges;
    };
    public static final Function<String, List<Range>> RANGE_SEED = (input) -> {
        final String[] seeds = input.split("\\s+");
        final List<Range> seedRanges = new ArrayList<>();
        for (int i = 0; i < seeds.length; i+=2) {
            long seedLow = parseLong(seeds[i]);
            long length = parseLong(seeds[i + 1]);
            seedRanges.add(new Range(seedLow, seedLow + length));
        }
        return seedRanges;
    };

    public static Garden parse(String[] input, Function<String, List<Range>> seedsParser) {
        return parse(Arrays.asList(input), seedsParser);
    }

    public static Garden parse(List<String> input, Function<String, List<Range>> seedsParser) {
        final String seeds = input.get(0).substring("seeds: ".length());
        String name = null;
        List<SectionRange> sections = new ArrayList<>();
        List<DestSrcRange> ranges = new ArrayList<>();

        for (int i = 2; i < input.size(); i++) {
            final String line = input.get(i).trim();
            if (line.endsWith("map:")) {
                name = line.replaceAll("\\s+map:$", "");
            } else if (!line.isBlank()) {
                ranges.add(new DestSrcRange(line));
            } else {
                // empty line, section end
                sections.add(new SectionRange(name, ranges));
                // reset ranges
                ranges = new ArrayList<>();
            }
            if (i == input.size() - 1) {
                // add last section
                sections.add(new SectionRange(name, ranges));
            }
        }

        return new Garden(
            seedsParser.apply(seeds),
            sections
        );
    }

    public List<Range> getSeeds() {
        return seeds;
    }

    public long getTotalSeeds() {
        return seeds.stream().mapToLong(Range::length).sum();
    }

    public long apply(long seed) {
        for (SectionRange section : sections) {
            seed = section.apply(seed);
        }
        return seed;
    }

    public long lowestLocation() {
        long lowest = Long.MAX_VALUE;
        for (Range seedRange : seeds) {
            for (Long seed : seedRange) {
                lowest = Math.min(lowest, apply(seed));
            }
        }
        return lowest;
    }
}
