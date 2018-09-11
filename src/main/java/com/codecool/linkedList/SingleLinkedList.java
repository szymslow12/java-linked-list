package com.codecool.linkedList;

public class SingleLinkedList<T> {

    private SingleLinkedNode<T> head;
    private SingleLinkedNode<T> last;
    private int length;

    public SingleLinkedList() {
        head = null;
        last = null;
        length = 0;
    }

    public void add(T data) {
        SingleLinkedNode<T> node = new SingleLinkedNode<>(data);
        node.setIndex(length++);

        if (head == null) {
            head = node;
            last = node;
            return;
        }

        last.setNextNode(node);
        last = node;
    }

    public void remove(T data) {
        if (head == null) return;
        if (head.getData().equals(data)) {
            head = head.getNextNode();
        }
        SingleLinkedNode<T> currentNode = head;

        while (currentNode.getNextNode() != null) {
            SingleLinkedNode<T> nextNode = currentNode.getNextNode();
            if (nextNode.getData().equals(data)) {
                currentNode.setNextNode(nextNode.getNextNode());
                return;
            }
            currentNode = nextNode;
        }
    }

    public String toString() {
        StringBuilder sB = new StringBuilder(head.toString());
        SingleLinkedNode<T> current = head;

        while(current.getNextNode() != null) {
            sB.append(String.format(" %s", current.getNextNode().toString()));
            current = current.getNextNode();
        }

        return sB.toString();
    }

    public void print() {
        SingleLinkedNode<T> current = head;
        while(current != null) {
            System.out.println(current.getIndex() + ". " + current);
            current = current.getNextNode();
        }
    }

    public int length() {
        return length;
    }
}
