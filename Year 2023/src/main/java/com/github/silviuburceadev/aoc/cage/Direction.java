package com.github.silviuburceadev.aoc.cage;

import java.util.List;

public enum Direction {
    NORTH("|F7", -1, 0) {
        @Override
        public Direction next(char symbol) {
            return switch (symbol) {
                case '|' -> NORTH;
                case 'F' -> EAST;
                case '7' -> WEST;
                default -> null;
            };
        }
    },
    EAST("-7J", 0, 1) {
        @Override
        public Direction next(char symbol) {
            return switch (symbol) {
                case '-' -> EAST;
                case '7' -> SOUTH;
                case 'J' -> NORTH;
                default -> null;
            };
        }
    },
    SOUTH("|LJ", 1, 0) {
        @Override
        public Direction next(char symbol) {
            return switch (symbol) {
                case '|' -> SOUTH;
                case 'L' -> EAST;
                case 'J' -> WEST;
                default -> null;
            };
        }
    },
    WEST("-LF", 0, -1) {
        @Override
        public Direction next(char symbol) {
            return switch (symbol) {
                case '-' -> WEST;
                case 'L' -> NORTH;
                case 'F' -> SOUTH;
                default -> null;
            };
        }
    };

    private final String acceptableChars;
    private final int moveX, moveY;

    Direction(String acceptableChars, int moveX, int moveY) {
        this.acceptableChars = acceptableChars;
        this.moveX = moveX;
        this.moveY = moveY;
    }

    public abstract Direction next(char symbol);

    public boolean accept(Node node, List<String> input, int i, int j) {
        int row = i + moveX;
        int column = j + moveY;
        if (row < 0 || row >= input.size()) return false;
        if (column < 0 || column >= input.get(row).length()) return false;
        char symbol = input.get(row).charAt(column);
        if (acceptableChars.indexOf(symbol) != -1) {
            Node temp = new Node(symbol);
            node.setNext(temp);
            temp.setPrev(node);
            return next(symbol).accept(temp, input, row, column);
        } else if (symbol == 'S') {
            Node start = node;
            while (start.getSymbol() != 'S') {
                start = start.getPrev();
            }
            node.setNext(start);
            start.setPrev(node);
            return true;
        }
        return false;
    }
}
