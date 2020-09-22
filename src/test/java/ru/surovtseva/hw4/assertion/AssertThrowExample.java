package ru.surovtseva.hw4.assertion;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.Scanner;

public class AssertThrowExample {
    @Test
    public void checkAssertThrows() {
        Assertions.assertThrows(
                FileNotFoundException.class,
                () -> new Scanner(new File("src/main/resources/txt1.txt"))
        );
    }
    @Test
    public void checkAssertThrowsFail() {
        Assertions.assertThrows(
                FileNotFoundException.class,
                () -> new Scanner(new File("src/main/resources/txt2.txt"))
        );
    }
}
