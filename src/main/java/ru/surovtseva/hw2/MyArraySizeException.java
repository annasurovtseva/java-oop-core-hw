package ru.surovtseva.hw2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
    }

    public MyArraySizeException(String message) {
        super(message);
    }
}
