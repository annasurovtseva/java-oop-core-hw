package ru.surovtseva.hw4.assertion;

import org.junit.jupiter.api.*;

public class AssertTrueFalseNullExample {
    @Test
    public void checkTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    public void checkTrueFail() {
        Assertions.assertTrue(false);
    }

    @Test
    public void checkFalse() {
        Assertions.assertFalse(false);
    }

    @Test
    public void checkFalseFail() {
        Assertions.assertFalse(true);
    }

    @Test
    public void checkNull() {
        String str = null;
        Assertions.assertNull(str);
    }

    @Test
    public void checkNullFail() {
        String str = "null";
        Assertions.assertNull(str);
    }

    @Test
    public void checkNotNull() {
        String str = "null";
        Assertions.assertNotNull(str);
    }

    @Test
    public void checkNotNullFail() {
        String str = null;
        Assertions.assertNotNull(str);
    }

    @Test
    public void fail() {
        Assertions.fail("Fail!");
    }
}
