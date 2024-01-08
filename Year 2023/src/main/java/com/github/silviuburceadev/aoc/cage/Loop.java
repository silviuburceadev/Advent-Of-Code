package com.github.silviuburceadev.aoc.cage;

import java.util.Arrays;
import java.util.List;

public record Loop(Node start) {

    public static Loop parse(List<String> input) {
        final Node start = new Node('S');
        for (int i = 0; i < input.size(); i++) {
            final char[] line = input.get(i).toCharArray();
            for (int j = 0; j < line.length; j++) {
                if (line[j] == 'S') {
                    detectLoop(start, input, i, j);
                    return new Loop(start);
                }
            }
        }
        throw new IllegalStateException("Loop should have been detected");
    }
    public static Loop parse(String[] input) {
        return parse(Arrays.asList(input));
    }

    private static void detectLoop(Node start, List<String> input, int i, int j) {
        for (Direction direction : Direction.values()) {
            boolean accepted = direction.accept(start, input, i, j);
            if (accepted) break;
        }
    }

    public int size() {
        int i = 1;
        Node copy = start.getNext();
        while (copy.getSymbol() != 'S') {
            copy = copy.getNext();
            i++;
        }
        return i;
    }

    public int farthest() {
        return size() / 2;
    }
}
