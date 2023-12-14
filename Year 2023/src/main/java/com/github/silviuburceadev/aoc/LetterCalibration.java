package com.github.silviuburceadev.aoc;

public class LetterCalibration extends Calibration {

    @Override
    public int parse(String input) {
        final String filtered = filter(input);
        return super.parse(filtered);
    }

    private String filter(final String input) {
        return input.replace("two", "2").replace("nine", "9");
    }
}
