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
        if (head == null) return;
        if (head.getData().equals(data)) {
            head = head.getNextNode();
            head.setPreviousNode(null);
            decrementIndexes(head);
            length--;
        }
        DoubleLinkedNode<T> currentNode = head;

        while (currentNode.getNextNode() != null) {
            DoubleLinkedNode<T> nextNode = currentNode.getNextNode();
            if (nextNode.getData().equals(data)) {
                DoubleLinkedNode<T> nodeAfterNextNode = nextNode.getNextNode();

                if (nodeAfterNextNode != null) {
                    nodeAfterNextNode.setPreviousNode(currentNode);
                }

                currentNode.setNextNode(nodeAfterNextNode);
                decrementIndexes(nodeAfterNextNode);
                length--;
                return;
            }
            currentNode = nextNode;
        }
    }

    private void decrementIndexes(DoubleLinkedNode<T> node) {
        while (node != null) {
            node.setIndex(node.getIndex() - 1);
            node = node.getNextNode();
        }
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
