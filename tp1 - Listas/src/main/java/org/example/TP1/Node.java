package org.example.TP1;

import java.util.Objects;

public class Node<T extends Comparable<T>>{
    private T info;
    private Node<T> next;

    public Node() {
        this.info = null;
        this.next = null;
    }

    public Node(T info, Node<T> next) {
        this.info = info;
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "Node{" + info;
    }

    @Override
    public boolean equals(Object o) {
        T obj = (T) o;
        if(this.info==o){
            return true;
        }
        return false;
    }
}

