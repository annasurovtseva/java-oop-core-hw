package ru.surovtseva.hw4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import ru.surovtseva.hw4.lesson1.*;

import java.util.stream.Stream;

@DisplayName("Проверка метода DoIT")
public class LessonOneTests {

    @DisplayName("Метод DoIT класса Wall, ожидается True")
    @ParameterizedTest
    @MethodSource("testData")
    public void checkDoItWallTrue(Action player) {
        Wall wall = new Wall(1.2f);
        Assertions.assertTrue(wall.doIT(player));
    }

    @DisplayName("Метод DoIT класса Wall, ожидается False")
    @ParameterizedTest
    @MethodSource("testData")
    public void checkDoItWallFalse(Action player) {
        Wall wall = new Wall(2.2f);
        Assertions.assertFalse(wall.doIT(player));
    }

    @DisplayName("Метод DoIT класса Track, ожидается True")
    @ParameterizedTest
    @MethodSource("testData")
    public void checkDoItTrackTrue(Action player) {
        Track track = new Track(190);
        Assertions.assertTrue(track.doIT(player));
    }

    @DisplayName("Метод DoIT класса Track, ожидается False")
    @ParameterizedTest
    @MethodSource("testData")
    public void checkDoItTrackFalse(Action player) {
        Track track = new Track(260);
        Assertions.assertFalse(track.doIT(player));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new Human("Tim",200,1.4f)),
                Arguments.of(new Cat("Barsik",250,1.3f)),
                Arguments.of(new Robot("C3PO",210,2.0f))
        );
    }
}
