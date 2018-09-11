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
    void testListLength() {
        SingleLinkedList<Integer> integerList = getIntegerList();

        Integer expected = 10;
        Integer actual = integerList.length();

        assertEquals(expected, actual);
    }


    @Test
    void testHead() {
        SingleLinkedList<Integer> integerList = getIntegerList();

        Integer expected = 0;
        Integer actual = integerList.get(0);

        assertEquals(expected, actual);
    }


    @Test
    void testGetItemWithIndex5() {
        SingleLinkedList<Integer> integerList = getIntegerList();

        Integer expected = 5;
        Integer actual = integerList.get(5);

        assertEquals(expected, actual);
    }


    @Test
    void testGetLastItem() {
        SingleLinkedList<Integer> integerList = getIntegerList();

        Integer expected = 9;
        Integer actual = integerList.get(integerList.length() - 1);

        assertEquals(expected, actual);
    }


    @Test
    void testRemoveFirstItem() {
        SingleLinkedList<Integer> integerList = getIntegerList();

        integerList.remove(0);

        String expected = "1 2 3 4 5 6 7 8 9";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }


    @Test
    void testRemoveLastItem() {
        SingleLinkedList<Integer> integerList = getIntegerList();

        integerList.remove(9);

        String expected = "0 1 2 3 4 5 6 7 8";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }


    @Test
    void testRemoveMultipleItemsFromMiddle() {
        SingleLinkedList<Integer> integerList = getIntegerList();

        integerList.remove(3);
        integerList.remove(8);

        String expected = "0 1 2 4 5 6 7 9";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testInsertOnBeginningOfList() {
        SingleLinkedList<Integer> integerList = getIntegerList();

        integerList.insert(0, 123);

        String expected = "123 0 1 2 3 4 5 6 7 8 9";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }
}