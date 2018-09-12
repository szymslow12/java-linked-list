package com.codecool.stack;

import com.codecool.linkedList.DoubleLinkedNode;

public class Stack<T> {

    private int stackSize;
    private DoubleLinkedNode<T> topNode;
    private int nextIndex;

    public Stack(int size) {
        stackSize = size;
        topNode = null;
        nextIndex = 0;
    }

    public void push(T data) {
        if (nextIndex == stackSize) {
            throw new StackOverflowError("Stack is full, can't add item!");
        } else {
            DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(data, nextIndex++);
            if (topNode == null) {
                topNode = newNode;
                topNode.setPreviousNode(null);
                return;
            }

            topNode.setNextNode(newNode);
            newNode.setPreviousNode(topNode);
            topNode = newNode;
        }
    }


    public T pop() {
        if (nextIndex == 0) {
            throw new StackOverflowError("Stack is empty, can't pop item!");
        } else {
            T data = topNode.getData();
            DoubleLinkedNode<T> newTop = topNode.getPreviousNode();
            topNode.setNextNode(null);
            topNode.setPreviousNode(null);
            newTop.setNextNode(null);
            topNode = newTop;
            nextIndex--;
            return data;
        }
    }

    public String toString() {
        StringBuilder sB = new StringBuilder(topNode != null ? topNode.toString(): "");
        DoubleLinkedNode<T> currentNode = topNode;

        while (currentNode.getPreviousNode() != null) {
            DoubleLinkedNode<T> previousNode = currentNode.getPreviousNode();
            sB.append(String.format(" %s", previousNode.toString()));
            currentNode = previousNode;
        }
        return sB.toString();
    }
}
