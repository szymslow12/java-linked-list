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

}