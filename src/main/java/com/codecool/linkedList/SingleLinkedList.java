package com.codecool.linkedList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

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


    public T get(int index) {
        SingleLinkedNode<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.getIndex() == index) {
                return currentNode.getData();
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }


    public void insert(int index, T data) {
//        SingleLinkedNode<T> currentNode = head;
        SingleLinkedNode<T> newNode = new SingleLinkedNode<>(data);
        SingleLinkedNode<T> currentNode = getNodeByIndex(index);

        newNode.setNextNode(currentNode);
        newNode.setIndex(index);
        getNodeByIndex(index - 1).setNextNode(newNode);
        incrementIndexes(currentNode);
        /*while (currentNode != null) {
            if (currentNode.getIndex() == index) {
                newNode.setNextNode(currentNode);
            }
            currentNode = currentNode.getNextNode();
        }*/
    }

    private SingleLinkedNode<T> getNodeByIndex(int index) {
        SingleLinkedNode<T> curentNode = head;

        while (curentNode != null) {
            if (curentNode.getIndex() == index) {
                return curentNode;
            }
            curentNode = curentNode.getNextNode();
        }
        return null;
    }

    private void incrementIndexes(SingleLinkedNode<T> node) {
        while (node != null) {
            node.setIndex(node.getIndex() + 1);
            node = node.getNextNode();
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
