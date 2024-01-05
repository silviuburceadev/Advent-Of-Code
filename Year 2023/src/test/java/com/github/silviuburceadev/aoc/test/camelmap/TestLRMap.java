package com.github.silviuburceadev.aoc.test.camelmap;

import com.github.silviuburceadev.aoc.camelmap.LRMap;
import com.github.silviuburceadev.aoc.camelmap.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLRMap {

    @Test
    public void testLeftRight() {
        final LRMap map = new LRMap();
        map.addNode(new Node("AAA", "BBB", "CCC"));
        map.addNode(new Node("CCC", "ZZZ", "GGG"));
        map.addNode(new Node("ZZZ", "ZZZ", "ZZZ"));
        assertEquals("AAA", map.initialize().label());
        assertEquals("CCC", map.goRight().label());
        assertEquals("ZZZ", map.goLeft().label());
    }

    @Test
    public void testNavigate() {
        final LRMap map = new LRMap();
        map.addNode(new Node("AAA", "BBB", "CCC"));
        map.addNode(new Node("BBB", "DDD", "EEE"));
        map.addNode(new Node("CCC", "ZZZ", "GGG"));
        map.addNode(new Node("DDD", "DDD", "DDD"));
        map.addNode(new Node("EEE", "EEE", "EEE"));
        map.addNode(new Node("GGG", "GGG", "GGG"));
        map.addNode(new Node("ZZZ", "ZZZ", "ZZZ"));
        assertEquals("AAA", map.initialize().label());
        assertEquals(2, map.stepsTo("ZZZ", "RL"));
    }

    @Test
    public void testSampleInput() {
        final LRMap map = new LRMap();
        map.addNode(new Node("AAA", "BBB", "BBB"));
        map.addNode(new Node("BBB", "AAA", "ZZZ"));
        map.addNode(new Node("ZZZ", "ZZZ", "ZZZ"));
        assertEquals("AAA", map.initialize().label());
        assertEquals(6, map.stepsTo("ZZZ", "LLR"));
    }
}
