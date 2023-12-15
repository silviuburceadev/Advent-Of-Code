package com.github.silviuburceadev.aoc.gamecube;

import java.util.logging.Logger;

public record GameCubeSet(int red, int green, int blue) {
    private static final Logger LOG = Logger.getLogger(GameCubeSet.class.getName());

    public static GameCubeSet parse(final String input) {
        int red = 0, green = 0, blue = 0;
        for (String part : input.split(", ")) {
            int value = Integer.parseInt(part.replaceAll("\\D+", ""), 10);
            String type = part.replaceAll("\\d+", "").trim();
            switch (type) {
                case "red":
                    red = value;
                    break;
                case "green":
                    green = value;
                    break;
                case "blue":
                    blue = value;
                    break;
                default:
                    LOG.warning("Unrecognized type: " + type);
                    break;
            }
        }
        return new GameCubeSet(red, green, blue);
    }

    public int getPower() {
        return 0;
    }
}
