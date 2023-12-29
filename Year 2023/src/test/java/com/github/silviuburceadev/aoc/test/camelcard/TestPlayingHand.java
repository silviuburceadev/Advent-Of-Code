package com.github.silviuburceadev.aoc.test.camelcard;

import com.github.silviuburceadev.aoc.camelcard.Hand;
import com.github.silviuburceadev.aoc.camelcard.PlayingHand;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPlayingHand {

    @Test
    public void testOrder() {
        final List<PlayingHand> playingHands = Arrays.asList(
            new PlayingHand(Hand.parse("32T3K"), 765),
            new PlayingHand(Hand.parse("T55J5"), 684),
            new PlayingHand(Hand.parse("KK677"), 28),
            new PlayingHand(Hand.parse("KTJJT"), 220),
            new PlayingHand(Hand.parse("QQQJA"), 483)
        );

        Collections.sort(playingHands);

        System.out.println(playingHands);

        assertEquals(765, playingHands.get(0).bet());
        assertEquals(220, playingHands.get(1).bet());
        assertEquals(28, playingHands.get(2).bet());
        assertEquals(684, playingHands.get(3).bet());
        assertEquals(483, playingHands.get(4).bet());
    }
}
