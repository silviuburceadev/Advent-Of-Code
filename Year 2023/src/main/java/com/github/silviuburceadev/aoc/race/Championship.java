package com.github.silviuburceadev.aoc.race;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.stream;

public record Championship(List<Race> races) {
    public static final Function<String, List<Long>> MANY_RACES = (input) ->
            stream(input.replaceAll("^[^:]+:", "").trim().split("\\s+"))
                .map(Long::parseLong)
                .toList();
    public static final Function<String, List<Long>> ONE_RACE = (input) ->
            stream(input.replaceAll("^[^:]+:|\\s", "").trim().split("\\s+"))
                .map(Long::parseLong)
                .toList();


    public static Championship parse(String timesRow, String distancesRow, Function<String, List<Long>> toNumbers) {
        final List<Long> times = toNumbers.apply(timesRow);
        final List<Long> distances = toNumbers.apply(distancesRow);
        final List<Race> races = new ArrayList<>();
        for (int i = 0; i < times.size(); i++) {
            races.add(new Race(times.get(i), distances.get(i)));
        }
        return new Championship(races);
    }

    public int waysToWin() {
        return races.stream().mapToInt(Race::waysToWin).reduce(1, (a, b) -> a * b);
    }
}
