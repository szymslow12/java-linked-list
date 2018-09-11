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
        if (index > length - 1) {
            add(data);
            return;
        }
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(data, length++);
        DoubleLinkedNode<T> currentNode = getNodeByIndex(index);
        DoubleLinkedNode<T> previousNode = currentNode.getPreviousNode();
        newNode.setNextNode(currentNode);
        newNode.setPreviousNode(previousNode);
        if (previousNode != null) {
            previousNode.setNextNode(newNode);
        } else {
            head = newNode;
        }
        currentNode.setPreviousNode(newNode);
        incrementIndexes(currentNode);
    }

    private DoubleLinkedNode<T> getNodeByIndex(int index) {
        DoubleLinkedNode<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.getIndex() == index) {
                return currentNode;
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    private void incrementIndexes(DoubleLinkedNode<T> node) {
        while (node != null) {
            node.setIndex(node.getIndex() + 1);
            node = node.getNextNode();
        }
    }

    public T get(int index) {
        DoubleLinkedNode<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.getIndex() == index) {
                return currentNode.getData();
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
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
