package com.codecool.linkedList;

public class DoubleLinkedList<T> {

    private DoubleLinkedNode<T> head;
    private DoubleLinkedNode<T> last;
    private int length;

    public DoubleLinkedList() {
        head = null;
        last = null;
        length = 0;
    }

    public void add(T data) {
        DoubleLinkedNode<T> node = new DoubleLinkedNode<>(data, length++);

        if (head == null) {
            head = node;
            last = node;
            head.setPreviousNode(null);
            return;
        }
        node.setPreviousNode(last);
        last.setNextNode(node);
        last = node;
    }

    public void remove(T data) {

    }

    public void insert(int index, T data) {

    }

    public T get(int index) {
        return head.getData();
    }

    public int length() {
        return length;
    }

    public String toString() {
        StringBuilder sB = new StringBuilder(head.toString());
        DoubleLinkedNode<T> current = head;

        while(current.getNextNode() != null) {
            sB.append(String.format(" %s", current.getNextNode().toString()));
            current = current.getNextNode();
        }

        return sB.toString();
    }
}
