package com.github.silviuburceadev.aoc;

import java.util.List;

import static java.lang.Character.digit;

public class Calibration {

    public int parse(final String input) {
        final String filtered = filter(input);
        return digit(filtered.charAt(0), 10) * 10 + digit(filtered.charAt(filtered.length() - 1), 10);
    }

    private String filter(final String input) {
        // max 2 digits are expected
        final StringBuilder sb = new StringBuilder(2);
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public int calibrate(List<String> lines) {
        return lines.stream().mapToInt(this::parse).sum();
    }
}
