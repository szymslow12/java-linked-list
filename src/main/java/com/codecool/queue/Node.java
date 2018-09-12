package com.codecool.queue;

public class Node {

    private String value;
    private Node nextNode;

    public Node(String value) {
        this.value = value;
        nextNode = null;
    }


    public Node getNextNode() {
        return nextNode;
    }


    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public String toString() {
        return value;
    }
}
