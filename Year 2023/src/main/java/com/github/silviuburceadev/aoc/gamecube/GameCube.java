package com.github.silviuburceadev.aoc.gamecube;

import java.util.List;

import static java.lang.Math.max;
import static java.util.Arrays.stream;

public record GameCube(int id, List<GameCubeSet> sets) {

    public static GameCube parse(final String input) {
        final String[] parts = input.split(":");
        final int id = Integer.parseInt(parts[0].replace("Game ", ""), 10);
        final List<GameCubeSet> sets = stream(parts[1].split("; ")).map(GameCubeSet::parse).toList();
        return new GameCube(id, sets);
    }

    public boolean isValid(int red, int green, int blue) {
        return sets.stream()
                .noneMatch(set -> red < set.red() || green < set.green() || blue < set.blue());
    }

    public GameCubeSet getMinimumToPlay() {
        int red = 0;
        int green = 0;
        int blue = 0;
        for (GameCubeSet set : sets) {
            red = max(red, set.red());
            green = max(green, set.green());
            blue = max(blue, set.blue());
        }
        return new GameCubeSet(red, green, blue);
    }
}
