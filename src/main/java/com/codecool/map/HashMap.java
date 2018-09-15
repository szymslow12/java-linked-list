package com.codecool.map;

import java.util.LinkedList;

public class HashMap {
    private int bucketSize = 16;

    @SuppressWarnings("unchecked")
    private LinkedList<KeyValue>[] mapElements = new LinkedList[bucketSize];

    public void add(String key, Integer value) {
        int hashCode = Math.abs(key.hashCode() % 16);
        KeyValue keyValue = new KeyValue(key, value);
        LinkedList<KeyValue> list = mapElements[hashCode];
        if (list == null) {
            list = new LinkedList<>();
            mapElements[hashCode] = list;
            list.add(keyValue);
            return;
        }
        checkIfContainsKey(list, key);
        list.add(keyValue);
    }


    private void checkIfContainsKey(LinkedList<KeyValue> list, String key) {
        for (KeyValue keyValue: list) {
            if (keyValue.key.equals(key)) {
                throw new IllegalStateException("Key already in map!");
            }
        }
    }


    public Integer getValue(String key) {
        int hashCode = Math.abs(key.hashCode() % 16);
        LinkedList<KeyValue> list = mapElements[hashCode];

        for (KeyValue keyValue: list) {
            if (keyValue.key.equals(key)) {
                return keyValue.value;
            }
        }
        return null;
    }


    public void remove(String key) {
        int hashCode = Math.abs(key.hashCode() % 16);
        LinkedList<KeyValue> list = mapElements[hashCode];
        for (KeyValue keyValue: list) {
            if (keyValue.key.equals(key)) {
                list.remove(keyValue);
            }
        }
    }


    public String toString() {
        StringBuilder sB = new StringBuilder("[");
        for (LinkedList<KeyValue> list: mapElements) {
            if (list != null) {
                addElementsToStringBuilder(sB, list);
            }
        }
        clearString(sB);
        sB.append("]");
        return sB.toString();
    }


    private void addElementsToStringBuilder(StringBuilder sB, LinkedList<KeyValue> list) {
        for (KeyValue keyValue: list) {
            sB.append(String.format(" %s,", keyValue.toString()));
        }
    }


    private void clearString(StringBuilder sB) {
        int commaIndex = sB.lastIndexOf(",");
        int spaceIndex = sB.indexOf(" ");
        sB.deleteCharAt(commaIndex);
        sB.deleteCharAt(spaceIndex);
    }


    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.add("Susan", 3);
        map.add("Juliet", 4);
        map.add("Simon", 5);
        map.add("John", 6);
        System.out.println(map.getValue("Juliet"));
        System.out.println(map.getValue("John"));
        map.remove("John");
        System.out.println(map);
    }
}
