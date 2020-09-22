package ru.surovtseva.hw4.annotations;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class TimeoutExample {
    @Test
    public void checkSumCorrect() {
        Assertions.assertEquals(2, 1 + 1);
    }

    @Timeout(value = 1500, unit = TimeUnit.MILLISECONDS)
    @Test
    public void checkSumException() throws InterruptedException {
        sleep(1600);
        Assertions.assertEquals(3, 2 + 1);
    }
}
