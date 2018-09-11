package com.codecool.linkedList;

public class SingleLinkedNode<T> {

    private T data;
    private SingleLinkedNode<T> nextNode;

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
}
