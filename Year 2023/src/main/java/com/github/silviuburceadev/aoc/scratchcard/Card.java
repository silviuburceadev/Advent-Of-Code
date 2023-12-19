package com.github.silviuburceadev.aoc.scratchcard;

import java.util.List;

import static java.util.Arrays.stream;

public record Card(List<Integer> numbers) {
    public static Card parse(String input) {
        // +/- 2 to skip the target character and the space next to it
        List<Integer> numbers = stream(input.substring(input.indexOf(":") + 2, input.indexOf("|") - 2).split("\\D+"))
                .map(Integer::parseInt)
                .toList();
        return new Card(numbers);
    }
}
