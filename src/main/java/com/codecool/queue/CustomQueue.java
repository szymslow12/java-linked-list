package com.codecool.queue;

import com.codecool.exceptions.QueueIsEmpty;

public class CustomQueue {

    private Node head;
    private Node tail;
    private int size;

    public CustomQueue() {
        head = null;
        tail = null;
        size = 0;
    }


    public void enqueue(String value) {
        Node newNode = new Node(value);
        size++;
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.setNextNode(newNode);
        tail = newNode;
    }


    public String peek() throws QueueIsEmpty {
        if (head == null) {
            throw new QueueIsEmpty("Can't peek! Queue is empty!");
        }
        return head.getValue();
    }


    public String dequeue() throws QueueIsEmpty {
        if (head == null) {
            throw new QueueIsEmpty("Can't dequeue! Queue is empty!");
        }
        String value = head.getValue();
        head = head.getNextNode();
        size--;
        return value;
    }


    public int queueSize() {
        return size;
    }


    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        StringBuilder sB = new StringBuilder(head.toString());
        Node currentNode = head;

        while (currentNode.getNextNode() != null) {
            Node nextNode = currentNode.getNextNode();
            sB.append(String.format(", %s", nextNode.toString()));
            currentNode = nextNode;
        }
        return sB.toString();
    }
}
