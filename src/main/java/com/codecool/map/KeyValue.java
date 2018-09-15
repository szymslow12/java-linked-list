package com.codecool.map;

public class KeyValue {

    public String key;
    public Integer value;

    public KeyValue(String key, Integer value) {
        this.key = key;
        this.value = value;
    }


    public String toString() {
        return key + ": " + value;
    }
}
