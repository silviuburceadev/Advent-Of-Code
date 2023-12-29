package com.github.silviuburceadev.aoc.race;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public record Championship(List<Race> races) {

    public static Championship parse(String timesRow, String distancesRow) {
        final List<Integer> times = toNumbers(timesRow);
        final List<Integer> distances = toNumbers(distancesRow);
        final List<Race> races = new ArrayList<>();
        for (int i = 0; i < times.size(); i++) {
            races.add(new Race(times.get(i), distances.get(i)));
        }
        return new Championship(races);
    }

    private static List<Integer> toNumbers(String input) {
        return stream(input.replaceAll("^[^:]+:", "").trim().split("\\s+"))
                .map(Integer::parseInt)
                .toList();
    }

    public int waysToWin() {
        return races.stream().mapToInt(Race::waysToWin).reduce(1, (a, b) -> a * b);
    }
}
