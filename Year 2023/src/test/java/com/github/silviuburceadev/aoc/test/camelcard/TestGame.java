package com.github.silviuburceadev.aoc.test.camelcard;

import com.github.silviuburceadev.aoc.camelcard.Game;
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

import static com.github.silviuburceadev.aoc.camelcard.Hand.JOKER_HAND_PARSER;
import static com.github.silviuburceadev.aoc.camelcard.Hand.NORMAL_HAND_PARSER;

public class TestGame {

    @Test
    public void testSample() {
        Game game = new Game(Arrays.asList(
                new PlayingHand(NORMAL_HAND_PARSER.apply("32T3K"), 765),
                new PlayingHand(NORMAL_HAND_PARSER.apply("T55J5"), 684),
                new PlayingHand(NORMAL_HAND_PARSER.apply("KK677"), 28),
                new PlayingHand(NORMAL_HAND_PARSER.apply("KTJJT"), 220),
                new PlayingHand(NORMAL_HAND_PARSER.apply("QQQJA"), 483)
        ));
        Assertions.assertEquals(6440L, game.winnings());
    }
    @Test
    public void testJokerSample() {
        Game game = new Game(Arrays.asList(
                new PlayingHand(JOKER_HAND_PARSER.apply("32T3K"), 765),
                new PlayingHand(JOKER_HAND_PARSER.apply("T55J5"), 684),
                new PlayingHand(JOKER_HAND_PARSER.apply("KK677"), 28),
                new PlayingHand(JOKER_HAND_PARSER.apply("KTJJT"), 220),
                new PlayingHand(JOKER_HAND_PARSER.apply("QQQJA"), 483)
        ));
        Assertions.assertEquals(5905L, game.winnings());
    }

    @Test
    public void testMainInput() throws IOException {
        try (InputStream resource = TestGame.class.getResourceAsStream("day7.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                final List<PlayingHand> playingHands = bufferedReader.lines().map(line -> PlayingHand.parse(line, NORMAL_HAND_PARSER)).toList();
                final Game game = new Game(playingHands);
                Assertions.assertEquals(247961593L, game.winnings());
            }
        }
    }

    @Test
    public void testJokerMainInput() throws IOException {
        try (InputStream resource = TestGame.class.getResourceAsStream("day7.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                final List<PlayingHand> playingHands = bufferedReader.lines().map(line -> PlayingHand.parse(line, JOKER_HAND_PARSER)).toList();
                final Game game = new Game(playingHands);
                Assertions.assertEquals(248750699L, game.winnings());
            }
        }
    }
}
