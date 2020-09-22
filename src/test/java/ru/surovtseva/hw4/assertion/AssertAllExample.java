package ru.surovtseva.hw4.assertion;

import org.junit.jupiter.api.*;

public class AssertAllExample {

    @Test
    public void checkAllFill() {
        //Получи с веба
        String expectedLogin = "Admin";
        String expectedFio = "Иванов Иван Иванович";
        String expectedProff = "Токарь";

        Assertions.assertAll("Данные пользователя",
                () -> Assertions.assertEquals(expectedLogin, "admin"),
                () -> Assertions.assertEquals(expectedFio, "Зубенко Николай Иванович"),
                () -> Assertions.assertEquals(expectedProff, "Доктор")
        );
    }

    @Test
    public void checkAllCorrect() {
        //Получи с веба
        String expectedLogin = "Admin";
        String expectedFio = "Иванов Иван Иванович";
        String expectedProff = "Токарь";

        Assertions.assertAll("Данные пользователя",
                () -> Assertions.assertEquals(expectedLogin, "Admin"),
                () -> Assertions.assertEquals(expectedFio, "Иванов Иван Иванович"),
                () -> Assertions.assertEquals(expectedProff, "Токарь")
        );
    }
}
