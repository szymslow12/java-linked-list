package com.codecool.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack<Integer> getIntegerStack() {
        Stack<Integer> integerStack = new Stack<>(10);

        for (int i = 0; i < 10; i++) {
            integerStack.push(i);
        }

        return integerStack;
    }


    @Test
    void testPushItemsToStack() {
        Stack<Integer> integerStack = getIntegerStack();

        String expected = "9 8 7 6 5 4 3 2 1 0";
        String actual = integerStack.toString();

        assertEquals(expected, actual);
    }


    @Test
    void testPushThrowsErrorWhenStackIsFull() {
        Stack<Integer> integerStack = getIntegerStack();

        assertThrows(StackOverflowError.class, () -> {
            integerStack.push(10);
        });
    }


    @Test
    void testPopReturnProperItem() {
        Stack<Integer> integerStack = getIntegerStack();

        int expected = 9;
        int actual = integerStack.pop();

        assertEquals(expected, actual);
    }


    @Test
    void testPopProperlyRemovesItem() {
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

        assertThrows(StackOverflowError.class, () -> {
           integerStack.pop();
        });
    }


    @Test
    void testPeekReturnsProperItem() {
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
    void testGetAvailableSpaceReturnsProperFreeSpaceInFullStack() {
        Stack<Integer> integerStack = getIntegerStack();

        int expected = 0;
        int actual = integerStack.getAvailableSpace();

        assertEquals(expected, actual);
    }

}