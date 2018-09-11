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

        /*SingleLinkedNode<T> currentNode = head;

        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }*/

        last.setNextNode(node);
        last = node;
    }
}
