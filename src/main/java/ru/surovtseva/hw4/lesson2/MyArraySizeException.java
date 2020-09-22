package ru.surovtseva.hw4.lesson2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
    }

    public MyArraySizeException(String message) {
        super(message);
    }
}
