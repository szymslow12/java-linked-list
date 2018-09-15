package com.codecool.map;

import java.security.Key;
import java.util.LinkedList;
import java.util.List;

public class HashMap {
    private int bucketSize = 16;

    @SuppressWarnings("unchecked")
    private LinkedList<KeyValue>[] mapElements = new LinkedList[bucketSize];

    public void add(String key, Integer value) {
        KeyValue keyValue = new KeyValue(key, value);
        int hashCode = Math.abs(key.hashCode() % 16);
        LinkedList list = mapElements[hashCode];
        if (list == null) {
            list = new LinkedList<KeyValue>();
            mapElements[hashCode] = list;
            list.add(keyValue);
            return;
        }
        for (Object object: list) {
            KeyValue kV = (KeyValue) object;
            if (kV.key.equals(key)) {
                throw new IllegalStateException("Key already in map!");
            }
        }
        list.add(keyValue);
    }


    public String toString() {
        StringBuilder sB = new StringBuilder("[");
        for (LinkedList list: mapElements) {
            if (list != null) {
                addElementsToStringBuilder(sB, list);
            }
        }
        clearString(sB);
        sB.append("]");
        return sB.toString();
    }


    private void addElementsToStringBuilder(StringBuilder sB, LinkedList list) {
        for (Object object: list) {
            KeyValue keyValue = (KeyValue) object;
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
        map.add("Klucz", 0);
        map.add("klucz", 1);
        map.add("Klucz1", 2);
        map.add("Susan", 3);
        map.add("Juliet", 4);
        map.add("Simon", 5);
        map.add("John", 6);
        System.out.println(map);
    }
}
