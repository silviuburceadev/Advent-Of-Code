package com.github.silviuburceadev.aoc;

import static java.lang.Character.digit;

public class Calibration {

    public int parse(String input) {
        return digit(input.charAt(0), 10) * 10 + digit(input.charAt(input.length() - 1), 10);
    }
}
