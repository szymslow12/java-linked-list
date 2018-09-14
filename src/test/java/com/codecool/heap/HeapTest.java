package com.codecool.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    private Heap getHeap(int size) {
        Heap heap = new Heap(size);
        for (int i = 0; i < size; i++) {
            heap.add(i);
        }
        return heap;
    }


    @Test
    void testPeekReturnProperItem() {
        Heap heap = getHeap(10);

        int expected = 9;
        int actual = heap.peek();

        assertEquals(expected, actual);
    }


    @Test
    void testPeekThrowExceptionWhenHeapIsEmpty() {
        Heap heap = new Heap();

        assertThrows(IllegalStateException.class, () -> {
            heap.peek();
        });
    }
}