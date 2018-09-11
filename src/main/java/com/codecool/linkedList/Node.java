package com.codecool.linkedList;

public class Node<T> {

    private T data;
    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNextNode(Node<T> node) {
        nextNode = node;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }
}
