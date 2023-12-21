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
        }
        if (!input.get(input.size() - 1).isBlank()) {
            // add last section
            sections.add(new SectionRange(name, ranges));
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
        return 0;
    }
}
