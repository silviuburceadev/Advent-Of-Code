package com.github.silviuburceadev.aoc;

public class LetterCalibration extends Calibration {

    /**
     * Digit replacements for their letter counterpart. Note that the digits are not in their natural order, to
     * preserve the left-to-right parsing.
     * - 8 precedes 2 and 3, so <code>eightwo</code> becomes <code>8wo</code>, not <code>eigh2</code>
     * - 1, 5 and 9 must precede 8, so <code>fiveight</code> becomes <code>5ight</code>
     * - 7 must precede 9, so <code>sevenine</code> becomes <code>7ine</code>
     * - 2 must precede 1, so <code>twone</code> becomes <code>2ne</code>
     */
    enum Digit {
        ONE("1"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), NINE("9"), EIGHT("8"), TWO("2"), THREE("3");

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
