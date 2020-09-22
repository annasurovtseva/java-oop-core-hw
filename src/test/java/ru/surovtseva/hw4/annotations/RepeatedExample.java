package ru.surovtseva.hw4.annotations;

import org.junit.jupiter.api.*;

public class RepeatedExample {
    @RepeatedTest(value = 5)
    public void checkSumCorrect() {
        System.out.println("TestExample.checkSumCorrect");
        Assertions.assertEquals(2, 1 + 1);
    }

    @RepeatedTest(value = 2)
    public void checkSumException() {
        System.out.println("TestExample.checkSumException");
        Assertions.assertEquals(3, 2 + 1);
    }
}
