package com.github.silviuburceadev.aoc.cage;

public record Loop(Node start) {
    public static Loop parse(String[] input) {
        final Node start = new Node('S');
        for (int i = 0; i < input.length; i++) {
            final char[] line = input[i].toCharArray();
            for (int j = 0; j < line.length; j++) {
                if (line[j] == 'S') {
                    detectLoop(start, input, i, j);
                    return new Loop(start);
                }
            }
        }
        throw new IllegalStateException("Loop should have been detected");
    }

    private static void detectLoop(Node start, String[] input, int i, int j) {
        for (Direction direction : Direction.values()) {
            direction.accept(start, input, i, j);
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
}
