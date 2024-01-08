package com.github.silviuburceadev.aoc.cage;

public record Loop(Node start) {
    public static Loop parse(String[] input) {
        final Node start = new Node('S');
        return new Loop(start);
    }

    public int size() {
        return 0;
    }
}
