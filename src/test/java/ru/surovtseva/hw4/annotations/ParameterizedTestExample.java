package ru.surovtseva.hw4.annotations;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ParameterizedTestExample {

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void checkSum(int expectedValue, int sum) {
        Assertions.assertEquals(expectedValue, sum + 1);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3),
                Arguments.of(5, 4)
        );
    }
}
