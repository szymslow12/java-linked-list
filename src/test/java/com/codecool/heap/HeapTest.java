package com.codecool.heap;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    private Heap getHeap(int size) {
        Heap heap = new Heap(size);
        for (int i = 0; i < size; i++) {
            heap.add(i);
        }
        return heap;
    }

}