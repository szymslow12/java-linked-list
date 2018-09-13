package com.codecool.queue;

import com.codecool.exceptions.QueueIsEmpty;

public class CustomQueue {

    private Node head;
    private Node tail;
    private int size;
    private int highestPriority;

    public CustomQueue() {
        head = null;
        tail = null;
        size = 0;
        highestPriority = 0;
    }


    public void enqueue(String value, Integer priority) {
        Node newNode = new Node(value, priority);
        highestPriority = priority > highestPriority ? priority: highestPriority;
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
        return getNodeWithHighestPriority().getValue();
    }


    public String dequeue() throws QueueIsEmpty {
        if (head == null) {
            throw new QueueIsEmpty("Can't dequeue! Queue is empty!");
        }
        Node highestPriorityNode = getNodeWithHighestPriority();
        String value = highestPriorityNode.getValue();
        changeNodePointerBeforeHighestPriorityNode(highestPriorityNode);
        highestPriority = findHighestPriority();
        size--;
        return value;
    }


    private Node getNodeWithHighestPriority() {
        Node currentNode = head;

        while (currentNode != null) {
            Node nextNode = currentNode.getNextNode();
            if (currentNode.getPriority() == highestPriority) {
                return currentNode;
            }
            currentNode = nextNode;
        }
        return null;
    }


    private void changeNodePointerBeforeHighestPriorityNode(Node highestPriorityNode) {
        Node currentNode = head;

        while (currentNode.getNextNode() != null) {
            Node nextNode = currentNode.getNextNode();
            if (nextNode == highestPriorityNode) {
                currentNode.setNextNode(highestPriorityNode.getNextNode());
                highestPriorityNode.setNextNode(null);
            }
            currentNode = nextNode;
        }
    }


    private int findHighestPriority() {
        Node currentNode = head;
        int highest = currentNode.getPriority();
        while (currentNode.getNextNode() != null) {
            Node nextNode = currentNode.getNextNode();
            if (nextNode.getPriority() > highest) {
                highest = nextNode.getPriority();
            }
            currentNode = nextNode;
        }
        return highest;
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
