package com.codecool.queue;

public class Node {

    private String value;
    private Node nextNode;
    private Integer priority;

    public Node(String value, int priority) {
        this.value = value;
        nextNode = null;
        this.priority = priority;
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


    public Integer getPriority() {
        return priority;
    }


    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String toString() {
        return value;
    }
}
