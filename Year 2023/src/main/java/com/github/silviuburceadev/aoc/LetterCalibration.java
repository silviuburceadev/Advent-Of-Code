package com.github.silviuburceadev.aoc;

public class LetterCalibration extends Calibration {

    /**
     * Digit replacements for their letter counterpart. Note that 2 and 3 must come after 8, because
     * <code>eightwo</code> must become <code>8wo</code>, not <code>eigh2</code> to preserve left-to-right parsing.
     */
    enum Digit {
        ONE("1"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TWO("2"), THREE("3");

        public final String value;

        Digit(String value) {
            this.value = value;
        }
    }

    @Override
    public int parse(String input) {
        final String filtered = filter(input);
        return super.parse(filtered);
    }

    private String filter(String input) {
        for (Digit digit : Digit.values()) {
            input = input.replace(digit.name().toLowerCase(), digit.value);
        }
        return input;
    }
}
