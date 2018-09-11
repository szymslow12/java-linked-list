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
}
