package com.codecool.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    private SingleLinkedList<Integer> getIntegerList() {
        SingleLinkedList<Integer> integerList = new SingleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }
        return integerList;
    }

    @Test
    void addTest() {
        SingleLinkedList<Integer> integerList = getIntegerList();

        String expected = "0 1 2 3 4 5 6 7 8 9";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }


    @Test
    void testRemoveFirstItem() {
        SingleLinkedList<Integer> integerList = getIntegerList();

        String expected = "1 2 3 4 5 6 7 8 9";

        integerList.remove(0);

        String actual = integerList.toString();

        assertEquals(expected, actual);
    }


    @Test
    void testRemoveLastItem() {
        SingleLinkedList<Integer> integerList = getIntegerList();

        String expected = "0 1 2 3 4 5 6 7 8";

        integerList.remove(9);

        String actual = integerList.toString();

        assertEquals(expected, actual);
    }


    @Test

}