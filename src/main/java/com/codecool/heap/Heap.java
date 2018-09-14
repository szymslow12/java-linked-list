package com.codecool.heap;

public class Heap {

    private int capacity;
    private int size;
    private int[] heapItems;

    public Heap(int capacity) {
        this.capacity = capacity;
        size = 0;
        heapItems = new int[capacity];
    }


    public Heap() {
        capacity = 10;
        size = 0;
        heapItems = new int[capacity];
    }


    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }


    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }


    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }


    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }


    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }


    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }


    private int leftChild(int parentIndex) {
        return heapItems[getLeftChildIndex(parentIndex)];
    }


    private int rightChild(int parentIndex) {
        return heapItems[getRightChildIndex(parentIndex)];
    }


    private int parent(int childIndex) {
        return heapItems[getParentIndex(childIndex)];
    }
}
