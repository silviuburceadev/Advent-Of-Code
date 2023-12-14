package com.github.silviuburceadev.aoc;

public class Calibration {

    public int parse(String input) {
        return (input.charAt(0) - '0') * 10 + (input.charAt(input.length() - 1) - '0');
    }
}
