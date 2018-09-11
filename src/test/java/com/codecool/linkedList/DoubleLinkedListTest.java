package com.codecool.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    private DoubleLinkedList<Integer> getIntegerList() {
        DoubleLinkedList<Integer> integerList = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }
        return integerList;
    }

    @Test
    void addTest() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        String expected = "0 1 2 3 4 5 6 7 8 9";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testListLength() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        Integer expected = 10;
        Integer actual = integerList.length();

        assertEquals(expected, actual);
    }


    @Test
    void testHead() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        Integer expected = 0;
        Integer actual = integerList.get(0);

        assertEquals(expected, actual);
    }


    @Test
    void testGetItemWithIndex5() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        Integer expected = 5;
        Integer actual = integerList.get(5);

        assertEquals(expected, actual);
    }


    @Test
    void testGetLastItem() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        Integer expected = 9;
        Integer actual = integerList.get(integerList.length() - 1);

        assertEquals(expected, actual);
    }


    @Test
    void testRemoveFirstItem() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        integerList.remove(0);

        String expected = "1 2 3 4 5 6 7 8 9";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }


    @Test
    void testRemoveLastItem() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        integerList.remove(9);

        String expected = "0 1 2 3 4 5 6 7 8";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }


    @Test
    void testRemoveMultipleItemsFromMiddle() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        integerList.remove(3);
        integerList.remove(8);

        String expected = "0 1 2 4 5 6 7 9";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testRemoveNotExistItem() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        integerList.remove(142);

        String expected = "0 1 2 3 4 5 6 7 8 9";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testInsertOnBeginningOfList() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        integerList.insert(0, 123);

        String expected = "123 0 1 2 3 4 5 6 7 8 9";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testInsertOnEndOfList() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        integerList.insert(integerList.length(), 123);

        String expected = "0 1 2 3 4 5 6 7 8 9 123";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testInsertMultipleItemsInMiddleOfList() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        integerList.insert(3, 123);
        integerList.insert(7, 321);

        String expected = "0 1 2 123 3 4 5 321 6 7 8 9";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testInsertItemOnIndexBiggerThanListSize() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        integerList.insert(15, 123);

        String expected = "0 1 2 3 4 5 6 7 8 9 123";
        String actual = integerList.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testIterateThroughList() {
        DoubleLinkedList<Integer> integerList = getIntegerList();

        String actual = iterateThroughList(integerList);
        String expected = " 0 1 2 3 4 5 6 7 8 9";

        assertEquals(expected, actual);
    }

    private String iterateThroughList(DoubleLinkedList<Integer> integerList) {
        String result = "";
        for (int i = 0; i < integerList.length(); i++) {
            result += String.format(" %s", integerList.get(i));
        }
        return result;
    }

}