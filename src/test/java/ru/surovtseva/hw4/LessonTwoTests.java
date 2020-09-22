package ru.surovtseva.hw4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import ru.surovtseva.hw4.lesson2.*;

import java.util.stream.Stream;

import static ru.surovtseva.hw4.lesson2.Start.arrayAnalysis;

@DisplayName("Проверка метода arrayAnalysis")
public class LessonTwoTests {

    @DisplayName("Массив неверного размера, ожидается MyArraySizeException")
    @Test
    public void whenPassedWrongSizeArray() {
        String[][] wrongSizeArray = {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
        };

        Assertions.assertThrows(
                MyArraySizeException.class,
                () -> System.out.println("Сумма всех элементов массива: "+ arrayAnalysis(wrongSizeArray))
        );
    }

    @DisplayName("Массив с неверными значениями, ожидается MyArrayDataException")
    @Test
    public void whenPassedWrongValueArray() {
        String[][] wrongValueArray = {
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","v","4"}
        };

        Assertions.assertThrows(
                MyArrayDataException.class,
                () -> System.out.println("Сумма всех элементов массива: "+ arrayAnalysis(wrongValueArray))
        );
    }

    @DisplayName("Корректный массива, ожидается сумма всех элементов массива")
    @ParameterizedTest
    @MethodSource("correctArray")
    public void whenPassedCorrectArray1(int expectedValue, String[][] array) {
        Assertions.assertEquals(expectedValue,arrayAnalysis(array));

    }

    private static Stream<Arguments> correctArray() {
        return Stream.of(
                Arguments.of(40, new String[][]{
                        {"1","2","3","4"},
                        {"1","2","3","4"},
                        {"1","2","3","4"},
                        {"1","2","3","4"}
                }),
                Arguments.of(64, new String[][]{
                        {"1","3","5","7"},
                        {"1","3","5","7"},
                        {"1","3","5","7"},
                        {"1","3","5","7"}
                }),
                Arguments.of(30, new String[][]{
                        {"1","1","1","1"},
                        {"1","1","1","1"},
                        {"1","1","15","1"},
                        {"1","1","1","1"}
                })
        );
    }
}
