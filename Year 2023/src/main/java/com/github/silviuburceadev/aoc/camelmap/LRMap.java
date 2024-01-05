package com.github.silviuburceadev.aoc.camelmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LRMap {

    private String direction;
    private final Map<String, Node> nodes = new HashMap<>();

    private Node currentNode;

    public LRMap() {
    }

    public LRMap(String[] input) {
        direction = input[0];

        Arrays.stream(input).skip(2).map(line -> {
            final String[] parts = line.split("([=(),]|\\s)+");
            return new Node(parts[0], parts[1], parts[2]);
        }).forEach(this::addNode);
    }

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

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public int stepsTo(String endLabel) {
        int steps = 0;
        char[] chars = direction.toCharArray();
        int length = direction.length();
        while (!currentNode.label().equals(endLabel)) {
            currentNode = go(chars[steps++ % length]);
        }
        return steps;
    }
}
