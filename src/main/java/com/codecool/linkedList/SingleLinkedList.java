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

        if (head == null) {
            head = node;
            last = node;
            length++;
            return;
        }

        last.setNextNode(node);
        last = node;
    }

    public void remove(T data) {
        SingleLinkedNode<T> currentNode = head;
        SingleLinkedNode<T> nodeBeforeCurrent = head;
        boolean dataHasNoMatch = true;
        while (dataHasNoMatch) {
            if (currentNode.getData().equals(data)) {
                nodeBeforeCurrent.setNextNode(currentNode.getNextNode());
                dataHasNoMatch = false;
            } else {
                nodeBeforeCurrent = currentNode;
                currentNode = currentNode.getNextNode();
            }
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
}
