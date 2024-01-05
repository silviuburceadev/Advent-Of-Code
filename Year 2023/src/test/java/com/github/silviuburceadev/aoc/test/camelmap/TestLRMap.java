package com.github.silviuburceadev.aoc.test.camelmap;

import com.github.silviuburceadev.aoc.camelmap.LRMap;
import com.github.silviuburceadev.aoc.camelmap.Node;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLRMap {

    @Test
    public void testParse() {
        final String[] input = """
            RL
            
            AAA = (BBB, CCC)
            BBB = (DDD, EEE)
            CCC = (ZZZ, GGG)
            DDD = (DDD, DDD)
            EEE = (EEE, EEE)
            GGG = (GGG, GGG)
            ZZZ = (ZZZ, ZZZ)""".split(System.lineSeparator());
        final LRMap map = new LRMap(input);
        assertEquals("RL", map.getDirection());
        assertEquals(2, map.steps(label -> label.equals("AAA"), label -> label.equals("ZZZ")));
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
        map.setDirection("RL");
        assertEquals(2, map.steps(label -> label.equals("AAA"), label -> label.equals("ZZZ")));
    }

    @Test
    public void testSampleInput() {
        final LRMap map = new LRMap();
        map.addNode(new Node("AAA", "BBB", "BBB"));
        map.addNode(new Node("BBB", "AAA", "ZZZ"));
        map.addNode(new Node("ZZZ", "ZZZ", "ZZZ"));
        map.setDirection("LLR");
        assertEquals(6, map.steps(label -> label.equals("AAA"), label -> label.equals("ZZZ")));
    }

    @Test
    public void testMainInput() throws IOException {
        try (InputStream resource = TestLRMap.class.getResourceAsStream("day8.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                final String[] lines = bufferedReader.lines().toArray(String[]::new);
                final LRMap map = new LRMap(lines);
                assertEquals(14893, map.steps(label -> label.equals("AAA"), label -> label.equals("ZZZ")));
            }
        }
    }

    @Test
    public void testMainMultipleInput() throws IOException {
        try (InputStream resource = TestLRMap.class.getResourceAsStream("day8.in")) {
            assert resource != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(resource, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                final String[] lines = bufferedReader.lines().toArray(String[]::new);
                final LRMap map = new LRMap(lines);
                assertEquals(10241191004509L, map.steps((label) -> label.endsWith("A"), (label) -> label.endsWith("Z")));
            }
        }
    }
}
