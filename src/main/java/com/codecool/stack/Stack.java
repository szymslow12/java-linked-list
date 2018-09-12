package com.codecool.stack;

import com.codecool.linkedList.DoubleLinkedNode;

public class Stack<T> {

    private int stackSize;
    private DoubleLinkedNode<T> topNode;

    public Stack(int size) {
        stackSize = size;
        topNode = null;
    }


}
