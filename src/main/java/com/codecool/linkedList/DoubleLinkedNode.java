package com.codecool.linkedList;

public class DoubleLinkedNode<T> {

    private T data;
    private DoubleLinkedNode<T> nextNode;
    private DoubleLinkedNode<T> previousNode;
    private int index;

    public DoubleLinkedNode(T data, int index) {
        this.data = data;
        this.index = index;
        nextNode = null;
    }

    public DoubleLinkedNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleLinkedNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public DoubleLinkedNode<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoubleLinkedNode<T> previousNode) {
        this.previousNode = previousNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String toString() {
        return data.toString();
    }
}
