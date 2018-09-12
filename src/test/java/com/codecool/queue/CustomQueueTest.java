package com.codecool.queue;

import com.codecool.exceptions.QueueIsEmpty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {

    private CustomQueue createQueue(int size) {
        CustomQueue queue = new CustomQueue();

        for (int i = 0; i < size; i++) {
            queue.enqueue(String.format("Test %s", Integer.toString(i)));
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

}