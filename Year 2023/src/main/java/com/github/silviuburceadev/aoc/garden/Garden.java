package com.github.silviuburceadev.aoc.garden;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record Garden(List<Integer> seeds) {
    public static Garden parse(String[] input) {
        final String seeds = input[0].substring("seeds: ".length());
        System.out.println(seeds);
        return new Garden(Arrays.stream(seeds.split("\\D+")).map(Integer::valueOf).toList());

    }

    public List<Integer> getSeeds() {
        return new ArrayList<>();
    }
}
