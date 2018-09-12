package com.codecool.stack;

public class Stack<T> {

    private int stackSize;
    private Node<T> topNode;
    private int nodesInStack;

    public Stack(int size) {
        stackSize = size;
        topNode = null;
        nodesInStack = 0;
    }

    public void push(T data) {
        if (nodesInStack == stackSize) {
            throw new StackOverflowError("Stack is full, can't add item!");
        } else {
            Node<T> newNode = new Node<>(data);
            nodesInStack++;
            if (topNode == null) {
                topNode = newNode;
                return;
            }

            newNode.setNextNode(topNode);
            topNode = newNode;
        }
    }


    public T pop() {
        if (nodesInStack == 0) {
            throw new StackOverflowError("Stack is empty, can't pop item!");
        } else {
            T data = topNode.getData();
            Node<T> newTop = topNode.getNextNode();
            topNode.setNextNode(null);
            newTop.setNextNode(null);
            topNode = newTop;
            nodesInStack--;
            return data;
        }
    }

    public String toString() {
        StringBuilder sB = new StringBuilder(topNode != null ? topNode.toString(): "");
        Node<T> currentNode = topNode;

        while (currentNode.getNextNode() != null) {
            Node<T> nextNode = currentNode.getNextNode();
            sB.append(String.format(" %s", nextNode.toString()));
            currentNode = nextNode;
        }
        return sB.toString();
    }
}
