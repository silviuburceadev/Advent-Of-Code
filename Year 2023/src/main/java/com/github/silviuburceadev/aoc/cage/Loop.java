package com.github.silviuburceadev.aoc.cage;

import com.github.silviuburceadev.aoc.engine.Coords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record Loop(List<Coords> coords) {

    public static Loop parse(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            final char[] line = input.get(i).toCharArray();
            for (int j = 0; j < line.length; j++) {
                if (line[j] == 'S') {
                    List<Coords> nodes = new ArrayList<>();
                    final Coords start = new Coords(i, j);
                    nodes.add(start);
                    Coords next = start;
                    while ((next = next(next, input, nodes)) != null) {
                        nodes.add(next);
                    }
                    return new Loop(nodes);
                }
            }
        }
        throw new IllegalStateException("Loop should have been detected");
    }

    private static Coords next(Coords from, List<String> input, List<Coords> nodes) {
        Symbol symbol = Symbol.valueOf(input.get(from.row()).charAt(from.column()));
        for (Direction direction : symbol.directions()) {
            Coords next = direction.canGo(from, input, nodes);
            if (next != null) return next;
        }
        return null;
    }
    public static Loop parse(String[] input) {
        return parse(Arrays.asList(input));
    }

    public int size() {
        return coords().size();
    }

    public int farthest() {
        return size() / 2;
    }
}
