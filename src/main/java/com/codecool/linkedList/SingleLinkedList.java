package com.codecool.linkedList;

public class SingleLinkedList<T> {

    private SingleLinkedNode<T> head;
    private SingleLinkedList<T> last;
    private int length;

    public SingleLinkedList() {
        head = null;
        last = null;
        length = 0;
    }
}
