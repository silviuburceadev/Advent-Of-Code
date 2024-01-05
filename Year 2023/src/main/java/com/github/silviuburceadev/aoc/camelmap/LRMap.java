package com.github.silviuburceadev.aoc.camelmap;

import java.util.HashMap;
import java.util.Map;

public class LRMap {

    private final Map<String, Node> nodes = new HashMap<>();

    private Node currentNode;
    public void addNode(Node node) {
        nodes.put(node.label(), node);
    }

    public Node initialize() {
        return currentNode = nodes.get("AAA");
    }

    public Node goLeft() {
        return currentNode = nodes.get(currentNode.left());
    }

    public Node goRight() {
        return currentNode = nodes.get(currentNode.right());
    }

    private Node go(char direction) {
        return direction == 'L' ? goLeft() : goRight();
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public int stepsTo(String endLabel, String directions) {
        int steps = 0;
        char[] chars = directions.toCharArray();
        int length = directions.length();
        while (!currentNode.label().equals(endLabel)) {
            currentNode = go(chars[steps++ % length]);
        }
        return steps;
    }
}
