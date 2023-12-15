package com.github.silviuburceadev.aoc.engine;

import java.util.ArrayList;
import java.util.List;

public record Engine(List<Cog> cogs, List<PartNumber> parts) {

    public static Engine parse(String input) {
        final String[] rows = input.split("\\r?\\n");

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
        return 0;
    }
}
