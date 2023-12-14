package com.github.silviuburceadev.aoc;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.lang.Character.digit;

public class Calibration {

    public int parse(String input) {
        final String filtered = filter(input);
        return digit(filtered.charAt(0), 10) * 10 + digit(filtered.charAt(filtered.length() - 1), 10);
    }

    private String filter(String input) {
        // 2 digits are expected
        final StringBuilder sb = new StringBuilder(2);
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
