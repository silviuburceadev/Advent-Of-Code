package com.github.silviuburceadev.aoc.garden;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;

public record Garden(List<Long> seeds, List<SectionRange> sections) {
    public static Garden parse(String[] input) {
        return parse(Arrays.asList(input));
    }

    public static Garden parse(List<String> input) {
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
            stream(seeds.split("\\D+")).map(Long::valueOf).toList(),
            sections
        );
    }

    public List<Long> getSeeds() {
        return seeds;
    }

    public long apply(long seed) {
        for (SectionRange section : sections) {
            seed = section.apply(seed);
        }
        return seed;
    }

    public long lowestLocation() {
        // no need to check if optional is present, as we have more than 0 seeds
        // noinspection OptionalGetWithoutIsPresent
        return seeds.stream().mapToLong(this::apply).min().getAsLong();
    }

    public List<Long> seedsAsRange() {
        List<Long> totalSeeds = new ArrayList<>();
        for (int i = 0; i < seeds.size(); i+=2) {
            long start = seeds.get(i);
            long length = seeds.get(i + 1);
            for (int j = 0; j < length; j++) {
                totalSeeds.add(start + j);
            }
        }
        return totalSeeds;
    }

    public long rangeLowestLocation() {
        return 0;
    }
}
