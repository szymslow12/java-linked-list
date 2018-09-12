package com.codecool.exceptions;

public class QueueIsEmpty extends Exception {

    public QueueIsEmpty() {}

    public QueueIsEmpty(String message) {
        super(message);
    }
}
