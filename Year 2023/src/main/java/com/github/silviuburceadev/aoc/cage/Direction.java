package com.github.silviuburceadev.aoc.cage;

import com.github.silviuburceadev.aoc.engine.Coords;

import java.util.List;

public enum Direction {
    NORTH(-1, 0, "|7FS"),
    EAST(0, 1, "-J7S"),
    SOUTH(1, 0, "|JLS"),
    WEST(0, -1, "-FLS");


    private final int moveX, moveY;
    private final String accepted;

    Direction(int moveX, int moveY, String accepted) {
        this.moveX = moveX;
        this.moveY = moveY;
        this.accepted = accepted;
    }

    public Coords canGo(Coords from, List<String> input, List<Coords> loop) {
        int row = from.row() + moveX;
        int column = from.column() + moveY;
        // can't go out of bounds when start symbol is:
        // - in the top row, trying to go north
        // - in the top-right corner, eventually trying to go east
        if (row < 0) return null;
        if (column >= input.get(row).length()) return null;

        char symbol = input.get(row).charAt(column);
        // can't go with wrong symbol
        if (accepted.indexOf(symbol) == -1) return null;
        final Coords coords = new Coords(row, column);
        // can't go back
        if (loop.contains(coords)) return null;
        return coords;
    }
}
