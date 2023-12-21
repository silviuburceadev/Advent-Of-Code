package com.github.silviuburceadev.aoc.garden;

public record DestSrcRange(int destination, int source, int range) {
    public DestSrcRange(String input) {
        this(0, 0, 0);
    }
}
