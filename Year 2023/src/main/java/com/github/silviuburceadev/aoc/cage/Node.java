package com.github.silviuburceadev.aoc.cage;

public class Node {
    private final char symbol;
    private Node prev, next;

    public Node(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.symbol);
        Node copy = this.next;
        while (copy != this && copy != null) {
            sb.append(copy.symbol);
            copy = copy.next;
        }
        return sb.toString();
    }
}
