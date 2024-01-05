package com.github.silviuburceadev.aoc.camelmap;

import java.util.*;
import java.util.function.Predicate;

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

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public long steps(Predicate<String> from, Predicate<String> to) {
        return nodes.keySet().stream()
                .filter(from)
                .mapToLong(key -> this.steps(nodes.get(key), to))
                .reduce(1, (a, b) -> a * b / gcd(a, b));
    }

    private long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    private long steps(Node node, Predicate<String> to) {
        int steps = 0;
        char[] chars = direction.toCharArray();
        int length = direction.length();
        while (!to.test(node.label())) {
            char dir = chars[steps++ % length];
            node = dir == 'L' ? nodes.get(node.left()) : nodes.get(node.right());
        }
        return steps;
    }
}
