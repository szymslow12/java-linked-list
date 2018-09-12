package com.codecool.queue;

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


    public String peek() {
        return head != null ? head.getValue(): null;
    }


    public String dequeue() {
        String value = head.getValue();
        head = head.getNextNode();
        size--;
        return value;
    }


    public int queueSize() {
        return 0;
    }


    public boolean isEmpty() {
        return head == null;
    }
}