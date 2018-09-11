package com.codecool.linkedList;

public class SingleLinkedNode<T> {

    private T data;
    private SingleLinkedNode<T> nextNode;
    private int index;

    public SingleLinkedNode(T data) {
        this.data = data;
        nextNode = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNextNode(SingleLinkedNode<T> node) {
        nextNode = node;
    }

    public SingleLinkedNode<T> getNextNode() {
        return nextNode;
    }

    public String toString() {
        return data.toString();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
