package com.github.silviuburceadev.aoc;

import java.util.stream.Collector;

import static java.lang.Character.digit;

public class Calibration {

    public int parse(String input) {
        final String filtered = filter(input);
        return digit(filtered.charAt(0), 10) * 10 + digit(filtered.charAt(filtered.length() - 1), 10);
    }

    private String filter(String input) {
        return input.chars().filter(Character::isDigit).mapToObj(c -> (char) c).collect(
            Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString
            )
        );
    }
}
