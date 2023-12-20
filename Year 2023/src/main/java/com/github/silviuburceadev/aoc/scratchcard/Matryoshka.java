package com.github.silviuburceadev.aoc.scratchcard;

import java.util.List;

public record Matryoshka(List<Game> games) {
    public int getTotalCards() {
        return 0;
    }
}
