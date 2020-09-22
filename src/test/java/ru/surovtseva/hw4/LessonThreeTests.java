package ru.surovtseva.hw4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import ru.surovtseva.hw4.lesson3.Phonebook;
import static ru.surovtseva.hw4.lesson3.Task2.searchPhone;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

@DisplayName("Проверка методов класса Phonebook и Task2")
public class LessonThreeTests {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void SetUpStream(){
        System.setOut(new PrintStream(output));
    }

    @DisplayName("Метод searchPhone. Вывод в консоль. Некорректное имя")
    @ParameterizedTest
    @MethodSource("testData")
    public void checkConsoleInCorrectName(Phonebook phonebook){
        searchPhone(phonebook,"Pavlov");
        Assertions.assertEquals("Фамилии Pavlov в справочнике нет", output.toString().trim());
    }

    @DisplayName("Метод searchPhone класса Task2. Вывод в консоль. Kорректное имя")
    @ParameterizedTest
    @MethodSource("testData")
    public void checkConsoleCorrectName(Phonebook phonebook){
        searchPhone(phonebook,"Petrov");
        Assertions.assertEquals("На фамилию Petrov зарагистрированны следующие номера тефефонов:\r\n[89996349856]"
                , output.toString().trim());
    }

    @DisplayName("Методы add и size класса Phonebook")
    @ParameterizedTest
    @MethodSource("testData")
    public void checkMethodsAddAndSize(Phonebook phonebook){
        Assertions.assertEquals(2,phonebook.size());
    }

    @DisplayName("Метод get класса Phonebook")
    @ParameterizedTest
    @MethodSource("testData")
    public void checkMethodGet(Phonebook phonebook) {
        Set<String> expectedPhoneNumber = new HashSet<String>(){{
            add("88991234567");
            add("87991324846");
        }};
        Assertions.assertEquals(
                expectedPhoneNumber,
                phonebook.get("Ivanov")
        );
    }

    @AfterEach
    public void clearStream(){
        System.setOut(null);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new Phonebook(){{
                    add("Ivanov", "88991234567");
                    add("Petrov", "89996349856");
                    add("Ivanov", "87991324846");
                }})
        );
    }
}
