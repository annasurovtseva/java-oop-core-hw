package ru.surovtseva.hw4.assertion;

import org.junit.jupiter.api.*;

public class AssertArrayEqualsExample {

    @Test
    public void checkArrayCorrect() {
        String[] cats1 = {"Barsik", "Muuurziik"};
        String[] cats2 = {"Barsik", "Muuurziik"};
        Assertions.assertArrayEquals(cats1, cats2);
    }

    @Test
    public void checkArrayFail() {
        String[] cats1 = {"Barsik", "Muuurziik"};
        String[] cats2 = {"Barsik", "Pushok"};
        Assertions.assertArrayEquals(cats1, cats2);
    }
}
