package com.github.silviuburceadev.aoc.cage;

import java.util.List;

import static com.github.silviuburceadev.aoc.cage.Direction.*;
import static java.util.Arrays.asList;

public enum Symbol {
    START('S') {
        @Override
        public List<Direction> directions() {
            return asList(NORTH, EAST, SOUTH, WEST);
        }
    },
    VERTICAL('|') {
        @Override
        public List<Direction> directions() {
            return asList(NORTH, SOUTH);
        }
    },
    HORIZONTAL('-') {
        @Override
        public List<Direction> directions() {
            return asList(WEST, EAST);
        }
    },
    NE('L') {
        @Override
        public List<Direction> directions() {
            return asList(NORTH, EAST);
        }
    },
    NW('J') {
        @Override
        public List<Direction> directions() {
            return asList(NORTH, WEST);
        }
    },
    SW('7') {
        @Override
        public List<Direction> directions() {
            return asList(SOUTH, WEST);
        }
    },
    SE('F') {
        @Override
        public List<Direction> directions() {
            return asList(SOUTH, EAST);
        }
    };


    private final char symbol;

    Symbol(char symbol) {
        this.symbol = symbol;
    }

    public abstract List<Direction> directions();

    public static Symbol valueOf(char c) {
        for (Symbol symbol : Symbol.values()) {
            if (symbol.symbol == c) return symbol;
        }
        throw new IllegalStateException("Should not happen");
    }
}
