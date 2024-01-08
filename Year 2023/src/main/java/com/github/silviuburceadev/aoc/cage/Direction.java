package com.github.silviuburceadev.aoc.cage;

import java.util.List;

import static java.util.Arrays.asList;

public enum Direction {
    NORTH("|F7", -1, 0) {
        @Override
        public List<Direction> availableDirections() {
            return asList(NORTH, EAST, WEST);
        }
    },
    EAST("-7J", 0, 1) {
        @Override
        public List<Direction> availableDirections() {
            return asList(NORTH, EAST, SOUTH);
        }
    },
    SOUTH("|LJ", 1, 0) {
        @Override
        public List<Direction> availableDirections() {
            return asList(EAST, SOUTH, WEST);
        }
    },
    WEST("-LF", 0, -1) {
        @Override
        public List<Direction> availableDirections() {
            return asList(NORTH, SOUTH, WEST);
        }
    };

    private final String acceptableChars;
    private final int moveX, moveY;

    Direction(String acceptableChars, int moveX, int moveY) {
        this.acceptableChars = acceptableChars;
        this.moveX = moveX;
        this.moveY = moveY;
    }

    public abstract List<Direction> availableDirections();

    public void accept(Node node, String[] input, int i, int j) {
        int row = i + moveX;
        int column = j + moveY;
        char c = input[row].charAt(column);
        if (acceptableChars.indexOf(c) != -1) {
            Node temp = new Node(c);
            node.setNext(temp);
            temp.setPrev(node);
            for (Direction direction : availableDirections()) {
                direction.accept(temp, input, row, column);
            }
        } else if (c == 'S') {
            Node start = node;
            while (start.getSymbol() != 'S') {
                start = start.getPrev();
            }
            node.setNext(start);
            start.setPrev(node);
        }
    }
}
