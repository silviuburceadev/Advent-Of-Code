package com.github.silviuburceadev.aoc.garden;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public record Garden(List<Integer> seeds, List<SectionRange> sections) {
    public static Garden parse(String[] input) {
        final String seeds = input[0].substring("seeds: ".length());
        return new Garden(
            stream(seeds.split("\\D+")).map(Integer::valueOf).toList(),
            new ArrayList<>()
        );

    }

    public List<Integer> getSeeds() {
        return seeds;
    }
}
