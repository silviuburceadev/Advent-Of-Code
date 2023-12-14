package com.github.silviuburceadev.aoc;

public class LetterCalibration extends Calibration {
    private static final String[] DIGITS = {
        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private String filter(final String input) {
        int i = 0;
        final StringBuilder sb = new StringBuilder(input);
        while(i < sb.length()) {
            // ignore checking actual digits
            if (Character.isDigit(sb.charAt(i))) {
                i++;
                continue;
            }
            // if current char does not start with lead character for one, two, three, etc., delete it
            if ("otfsen".indexOf(sb.charAt(i)) == -1) {
                sb.deleteCharAt(i);
                continue;
            }
            // current char might be the start of one, two, three, etc., let's check and maybe replace
            for (int j = 1; j <= DIGITS.length; j++) {
                final String digit = DIGITS[j - 1];
                if (sb.indexOf(digit, i) == i) {
                    // if a digit is found, replace it
                    sb.replace(i, i + digit.length(), "" + j);
                    break;
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override
    public int parse(String input) {
        return super.parse(filter(input));
    }
}
