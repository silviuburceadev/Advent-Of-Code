package com.github.silviuburceadev.aoc.camelcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum HandType {

    FIVE, FOUR, FULL, THREE, TWO_PAIR, PAIR, HIGH;

    public static HandType parse(List<Card> cards) {
        final List<Card> sorted = new ArrayList<>(cards);
        Collections.sort(sorted);
        int m1 = 1, m2 = 1, current = 1;
        for (int i = 1; i < sorted.size(); i++) {
            if (sorted.get(i - 1).equals(sorted.get(i))) {
                current++;
            } else {
                if (current > m1) {
                    m2 = m1;
                    m1 = current;
                } else if (current > m2) {
                    m2 = current;
                }
                current = 1;
            }
            if (i == sorted.size() - 1) {
                if (current > m1) {
                    m2 = m1;
                    m1 = current;
                } else if (current > m2) {
                    m2 = current;
                }
            }
        }



        if (m1 == 5) {
            return FIVE;
        } else if (m1 == 4) {
            return FOUR;
        } else if (m1 == 3) {
            if (m2 == 1) {
                return THREE;
            } else {
                return FULL;
            }
        } else if (m1 == 2) {
            if (m2 == 1) {
                return PAIR;
            } else {
                return TWO_PAIR;
            }
        } else {
            return HIGH;
        }
    }
}
