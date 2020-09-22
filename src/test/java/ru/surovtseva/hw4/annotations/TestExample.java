package ru.surovtseva.hw4.annotations;

import org.junit.jupiter.api.*;

public class TestExample extends BeforeConfigTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("TestExample.beforeAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("TestExample.beforeEach");
    }

    @Test
    public void checkSumCorrect() {
        System.out.println("TestExample.checkSumCorrect");
        Assertions.assertEquals(2, 1 + 1);
    }

    @Test
    public void checkSumException() {
        System.out.println("TestExample.checkSumException");
        Assertions.assertEquals(3, 1 + 1);
    }

    @AfterEach
    public void afterEach(){
        System.out.println("TestExample.afterEach");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("TestExample.afterAll");
    }
}
