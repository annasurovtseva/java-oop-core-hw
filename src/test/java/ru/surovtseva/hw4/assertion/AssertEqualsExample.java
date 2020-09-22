package ru.surovtseva.hw4.assertion;

import org.junit.jupiter.api.*;

public class AssertEqualsExample {
    @Test
    public void checkSumCorrect() {
        Assertions.assertEquals(5, 4 + 1);
    }

    @Test
    public void checkSumException() {
        Assertions.assertEquals(5, 1 + 1);
    }
}
