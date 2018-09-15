package com.codecool.map;

import java.util.LinkedList;

public class HashMap<K, V> {
    private int bucketSize = 16;

    @SuppressWarnings("unchecked")
    private LinkedList<KeyValue<K, V>>[] mapElements = new LinkedList[bucketSize];

    public void add(K key, V value) {
        int hashCode = Math.abs(key.hashCode() % 16);
        KeyValue keyValue = new KeyValue(key, value);
        LinkedList<KeyValue<K, V>> list = mapElements[hashCode];
        if (list == null) {
            list = new LinkedList<>();
            mapElements[hashCode] = list;
            list.add(keyValue);
            return;
        }
        checkIfContainsKey(list, key);
        list.add(keyValue);
    }


    private void checkIfContainsKey(LinkedList<KeyValue<K, V>> list, K key) {
        for (KeyValue keyValue: list) {
            if (keyValue.key.equals(key)) {
                throw new IllegalStateException("Key already in map!");
            }
        }
    }


    public Object getValue(K key) {
        int hashCode = Math.abs(key.hashCode() % 16);
        LinkedList<KeyValue<K, V>> list = mapElements[hashCode];

        for (KeyValue keyValue: list) {
            if (keyValue.key.equals(key)) {
                return keyValue.value;
            }
        }
        return null;
    }


    public void remove(String key) {
        int hashCode = Math.abs(key.hashCode() % 16);
        LinkedList<KeyValue<K, V>> list = mapElements[hashCode];
        if (list == null) {
            throw new IllegalStateException("Tried remove not exist element!");
        }
        for (KeyValue keyValue: list) {
            if (keyValue.key.equals(key)) {
                list.remove(keyValue);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void clearAll() {
        mapElements = new LinkedList[bucketSize];
    }


    public String toString() {
        StringBuilder sB = new StringBuilder("[");
        for (LinkedList<KeyValue<K, V>> list: mapElements) {
            if (list != null) {
                addElementsToStringBuilder(sB, list);
            }
        }
        clearString(sB);
        sB.append("]");
        return sB.toString();
    }


    private void addElementsToStringBuilder(StringBuilder sB, LinkedList<KeyValue<K, V>> list) {
        for (KeyValue keyValue: list) {
            sB.append(String.format(" %s,", keyValue.toString()));
        }
    }


    private void clearString(StringBuilder sB) {
        int commaIndex = sB.lastIndexOf(",");
        int spaceIndex = sB.indexOf(" ");
        if (commaIndex >= 0 && spaceIndex >= 0) {
            sB.deleteCharAt(commaIndex);
            sB.deleteCharAt(spaceIndex);
        }
    }


    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap();
        map.add("SusanAge", 31);
        map.add("JulietAge", 42);
        map.add("SimonAge", 53);
        map.add("JohnAge", 64);
        System.out.println(map);
        System.out.println("Juliet age = " + map.getValue("JulietAge"));
        System.out.println("John age = " + map.getValue("JohnAge"));
        map.remove("JohnAge");
        System.out.println(map);
        map.clearAll();
        System.out.println(map);
    }
}
