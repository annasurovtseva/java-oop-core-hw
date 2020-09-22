package ru.surovtseva.hw4.annotations;

import org.junit.jupiter.api.*;

public abstract class BeforeConfigTest {
    @BeforeAll
    public static void beforeAllBeforeConfigTest() {
        System.out.println("BeforeConfigTest.beforeAll");
    }

    @BeforeEach
    public void setUpBeforeConfigTest() {
        System.out.println("BeforeConfigTest.setUp");
    }

    @AfterEach
    public void tearDownBeforeConfigTest() {
        System.out.println("BeforeConfigTest.tearDown");
    }

    @AfterAll
    public static void afterAllBeforeConfigTest() {
        System.out.println("BeforeConfigTest.afterAll");
    }
}
