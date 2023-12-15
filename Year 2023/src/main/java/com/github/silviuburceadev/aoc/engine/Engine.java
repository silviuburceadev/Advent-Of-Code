package com.github.silviuburceadev.aoc.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public record Engine(List<Cog> cogs, List<PartNumber> parts) {

    public static Engine parse(String input) {
        return parse(input.split("\\r?\\n"));
    }

    public static Engine parse(String[] rows) {
        final List<Cog> cogs = new ArrayList<>();
        final List<PartNumber> parts = new ArrayList<>();

        for (int i = 0; i < rows.length; i++) {
            final char[] chars = rows[i].toCharArray();
            int value = 0;
            Coords start = null;
            for (int j = 0; j < chars.length; j++) {
                char cell = chars[j];
                if (Character.isDigit(cell)) {
                    if (value == 0) {
                        // we started parsing a number, saving the starting coords
                        start = new Coords(i, j);
                    }
                    value = value * 10 + (cell - '0');
                } else {
                    if (value != 0) {
                        // we were parsing a number, need to save it
                        final Coords end = new Coords(i, j);
                        parts.add(new PartNumber(value, start, end));
                        value = 0;
                    }
                    if (cell != '.') {
                        // we have a cog
                        cogs.add(new Cog(cell, new Coords(i, j)));
                    }
                }
            }
        }

        return new Engine(cogs, parts);
    }

    public int getCogTotal(Cog cog) {
        return getAdjacentParts(cog).mapToInt(PartNumber::value).sum();
    }

    public int getTotal() {
        return cogs.stream()
                .flatMap(this::getAdjacentParts)
                // do not count part numbers multiple times if they are near 2+ cogs
                .distinct()
                .mapToInt(PartNumber::value).sum();
    }

    private Stream<PartNumber> getAdjacentParts(Cog cog) {
        return parts.stream()
                // get the parts on the row before, current and row after the cog
                .filter(p -> Math.abs(p.start().row() - cog.coords().row()) <= 1)
                // and is between start - 1 and end + 1 columns (+1/-1 to account for diagonal)
                .filter(p -> p.start().column() - 1 <= cog.coords().column() && cog.coords().column() <= p.end().column() + 1);
    }
}
