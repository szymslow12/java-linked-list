package com.codecool.heap;

import java.util.Arrays;

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


    private void swapItems(int firstIndex, int secondIndex) {
        int tempItem = heapItems[firstIndex];
        heapItems[firstIndex] = heapItems[secondIndex];
        heapItems[secondIndex] = tempItem;
    }


    private void ensureExtraCapacity() {
        if (size == capacity) {
            heapItems = Arrays.copyOf(heapItems, capacity * 2);
            capacity *= 2;
        }
    }


    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty!");
        }
        return heapItems[0];
    }


    public int poll() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty!");
        }
        int heapItem = heapItems[0];
        heapItems[0] = heapItems[size - 1];
        size--;
        heapifyDown();
        return heapItem;
    }


    public void add(int heapItem) {
        ensureExtraCapacity();
        heapItems[size] = heapItem;
        size++;
        heapifyUp();
    }


    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (heapItems[index] > heapItems[smallerChildIndex]) {
                return;
            } else {
                swapItems(index, smallerChildIndex);
                index = smallerChildIndex;
            }
        }
    }


    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) < heapItems[index]) {
            swapItems(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
}
