package com.github.silviuburceadev.aoc.gamecube;

import java.util.List;

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
        return null;
    }
}
