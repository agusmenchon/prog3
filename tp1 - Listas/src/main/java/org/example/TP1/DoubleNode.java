package org.example.TP1;

public class DoubleNode<T extends Comparable<T>> extends Node<T> {

    private T info;
    private DoubleNode next;
    private DoubleNode previous;

    public DoubleNode(T info, DoubleNode next, DoubleNode previous) {
        this.info = info;
        this.next = next;
        this.previous = previous;
    }

    public DoubleNode(T info) {
        this.info = info;
        this.next = null;
        this.previous = null;
    }

    public DoubleNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }
}
