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
    void testAddItem() {
        Heap heap = new Heap(3);
        heap.add(1);
        heap.add(2);
        heap.add(3);

        String expected = "[3, 1, 2]";
        String actual = heap.toString();

        assertEquals(expected, actual);
    }


    @Test
    void testAddItemAddsItemInProperOrderBiggestNumberAdded() {
        Heap heap = getHeap(10);
        heap.add(123);

        int expected = 123;
        int actual = heap.peek();

        assertEquals(expected, actual);
    }


    @Test
    void testAddItemAddsItemInProperOrderLowestNumberAdded() {
        Heap heap = getHeap(10);
        heap.add(-123);

        int expected = 9;
        int actual = heap.peek();

        assertEquals(expected, actual);
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


    @Test
    void testPollReturnProperItemFromHeap() {
        Heap heap = getHeap(10);

        int expected = 9;
        int actual = heap.poll();

        assertEquals(expected, actual);
    }


    @Test
    void testPollRemoveAndMoveToNextItem() {
        Heap heap = getHeap(10);
        heap.poll();

        int expected = 8;
        int actual = heap.peek();

        assertEquals(expected, actual);
    }
}