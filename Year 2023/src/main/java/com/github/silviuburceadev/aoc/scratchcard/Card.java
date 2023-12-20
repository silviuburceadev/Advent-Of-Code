package com.github.silviuburceadev.aoc.scratchcard;

import java.util.List;

import static java.util.Arrays.stream;

public record Card(List<Integer> numbers) {

    public Card(String input) {
        // +/- 2 to skip the target character and the space near it
        this(toNumbers(input.substring(input.indexOf(":") + 2, input.indexOf("|") - 2)));
    }

    private static List<Integer> toNumbers(String input) {
        return stream(input.split("\\D+"))
                .map(Integer::parseInt)
                .toList();
    }
}

