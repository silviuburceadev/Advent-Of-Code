package com.github.silviuburceadev.aoc.test.camelcard;

import com.github.silviuburceadev.aoc.camelcard.Game;
import com.github.silviuburceadev.aoc.camelcard.Hand;
import com.github.silviuburceadev.aoc.camelcard.PlayingHand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class TestGame {

    @Test
    public void testSample() {
        Game game = new Game(Arrays.asList(
                new PlayingHand(Hand.parse("32T3K"), 765),
                new PlayingHand(Hand.parse("T55J5"), 684),
                new PlayingHand(Hand.parse("KK677"), 28),
                new PlayingHand(Hand.parse("KTJJT"), 220),
                new PlayingHand(Hand.parse("QQQJA"), 483)
        ));
        Assertions.assertEquals(6440, game.winnings());
    }

    @Test
    public void testMainInput() throws IOException {
        try (InputStream resource = TestGame.class.getResourceAsStream("day7.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                final List<PlayingHand> playingHands = bufferedReader.lines().map(PlayingHand::parse).toList();
                final Game game = new Game(playingHands);
                Assertions.assertEquals(247961593, game.winnings());
            }
        }
    }
}
