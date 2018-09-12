package com.codecool.stack;

import com.codecool.exceptions.StackOverflow;
import com.codecool.exceptions.StackUnderflow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack<Integer> getIntegerStack() throws StackOverflow {
        Stack<Integer> integerStack = new Stack<>(10);

        for (int i = 0; i < 10; i++) {
            integerStack.push(i);
        }

        return integerStack;
    }


    @Test
    void testPushItemsToStack() throws StackOverflow {
        Stack<Integer> integerStack = getIntegerStack();

        String expected = "9 8 7 6 5 4 3 2 1 0";
        String actual = integerStack.toString();

        assertEquals(expected, actual);
    }


    @Test
    void testPushThrowsErrorWhenStackIsFull() throws StackOverflow {
        Stack<Integer> integerStack = getIntegerStack();

        assertThrows(StackOverflow.class, () -> {
            integerStack.push(10);
        });
    }


    @Test
    void testPopReturnProperItem() throws StackOverflow, StackUnderflow {
        Stack<Integer> integerStack = getIntegerStack();

        int expected = 9;
        int actual = integerStack.pop();

        assertEquals(expected, actual);
    }


    @Test
    void testPopProperlyRemovesItem() throws StackOverflow, StackUnderflow {
        Stack<Integer> integerStack = getIntegerStack();

        integerStack.pop();
        integerStack.pop();

        String expected = "7 6 5 4 3 2 1 0";
        String actual = integerStack.toString();

        assertEquals(expected, actual);
    }


    @Test
    void testPopThrowsErrorWhenStackIsEmpty() {
        Stack<Integer> integerStack = new Stack<>(0);

        assertThrows(StackUnderflow.class, () -> {
           integerStack.pop();
        });
    }


    @Test
    void testPeekReturnsProperItem() throws StackOverflow {
        Stack<Integer> integerStack = getIntegerStack();

        int expected = 9;
        int actual = integerStack.peek();

        assertEquals(expected, actual);
    }


    @Test
    void testPeekReturnNullIfStackIsEmpty() {
        Stack<Integer> integerStack = new Stack(0);

        assertNull(integerStack.peek());
    }


    @Test
    void testSizeReturnsProperStackSize() {
        Stack<Integer> integerStack = new Stack<>(10);

        int expected = 10;
        int actual = integerStack.size();

        assertEquals(expected, actual);
    }

    @Test
    void testGetAvailableSpaceReturnsProperFreeSpaceInEmptyStack() {
        Stack<Integer> integerStack = new Stack<>(10);

        int expected = 10;
        int actual = integerStack.getAvailableSpace();

        assertEquals(expected, actual);
    }


    @Test
    void testGetAvailableSpaceReturnsProperFreeSpaceInFullStack() throws StackOverflow {
        Stack<Integer> integerStack = getIntegerStack();

        int expected = 0;
        int actual = integerStack.getAvailableSpace();

        assertEquals(expected, actual);
    }

}