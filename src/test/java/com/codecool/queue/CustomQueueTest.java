package com.codecool.queue;

import com.codecool.exceptions.QueueIsEmpty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {

    private CustomQueue createQueue(int size) {
        CustomQueue queue = new CustomQueue();

        for (int i = 0; i < size; i++) {
            queue.enqueue(String.format("Test %s", Integer.toString(i)), i);
        }
        return queue;
    }

    @Test
    void testAddItems() {
        CustomQueue queue = createQueue(3);

        String expected = "Test 0, Test 1, Test 2";
        String actual = queue.toString();

        assertEquals(expected, actual);
    }


    @Test
    void testPeekReturnProperValue() throws QueueIsEmpty {
        CustomQueue queue = createQueue(3);

        String expected = "Test 0";
        String actual = queue.peek();

        assertEquals(expected, actual);
    }


    @Test
    void testPeekThrowsExceptionWhenQueueIsEmpty() {
        CustomQueue queue = new CustomQueue();

        assertThrows(QueueIsEmpty.class, () -> {
            queue.peek();
        });
    }


    @Test
    void testDequeueReturnProperValue() throws QueueIsEmpty {
        CustomQueue queue = createQueue(3);

        String expected = "Test 0";
        String actual = queue.dequeue();

        assertEquals(expected, actual);
    }


    @Test
    void testDequeueProperlyMovesToNextItem() throws QueueIsEmpty {
        CustomQueue queue = createQueue(3);

        queue.dequeue();

        String expected = "Test 1";
        String actual = queue.peek();

        assertEquals(expected, actual);
    }


    @Test
    void testDequeueThrowsExceptionWhenQueueIsEmpty() {
        CustomQueue queue = new CustomQueue();

        assertThrows(QueueIsEmpty.class, () -> {
            queue.dequeue();
        });
    }


    @Test
    void testQueueSizeReturnProperSize() {
        CustomQueue queue = createQueue(5);

        int expected = 5;
        int actual = queue.queueSize();

        assertEquals(expected, actual);
    }


    @Test
    void testQueueSizeReturnProperSizeWhenIsEmpty() {
        CustomQueue queue = new CustomQueue();

        int expected = 0;
        int actual = queue.queueSize();

        assertEquals(expected, actual);
    }


    @Test
    void testIsEmptyShowIfQueueIsEmpty() {
        CustomQueue queue = new CustomQueue();

        boolean expected = true;
        boolean actual = queue.isEmpty();

        assertEquals(expected, actual);
    }


    @Test
    void testIsEmptyShowIfQueueIsNotEmpty() {
        CustomQueue queue = createQueue(3);

        boolean expected = false;
        boolean actual = queue.isEmpty();

        assertEquals(expected, actual);
    }

}