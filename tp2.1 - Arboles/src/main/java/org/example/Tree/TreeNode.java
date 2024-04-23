package org.example.Tree;

import java.util.Objects;

public class TreeNode<T extends Comparable<T>>{

    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;
    private int factorDeEquilibrio;

    public TreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        factorDeEquilibrio = 0;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int compareTo(T obj2) {
        return value.compareTo(obj2);
    }

    public int getFactorDeEquilibrio() {
        return factorDeEquilibrio;
    }

    public void setFactorDeEquilibrio(int factorDeEquilibrio) {
        this.factorDeEquilibrio = factorDeEquilibrio;
    }

    @Override
    public boolean equals(Object o) {
        if (this.getValue() == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TreeNode<?> treeNode = (TreeNode<?>) o;

        return Objects.equals(value, treeNode.value);
    }

}