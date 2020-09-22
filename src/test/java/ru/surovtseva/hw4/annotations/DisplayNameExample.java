package ru.surovtseva.hw4.annotations;

import org.junit.jupiter.api.*;

@DisplayName("Авторизация")
public class DisplayNameExample {

    @DisplayName("Корректный логин/пароль")
    @Test
    public void checkSumCorrect() {
        System.out.println("TestExample.checkSumCorrect");
        Assertions.assertEquals(2, 1 + 1);
    }

    @DisplayName("Логин заблокирован")
    @Test
    public void checkSumException() {
        System.out.println("TestExample.checkSumException");
        Assertions.assertEquals(4, 1 + 1);
    }
}
