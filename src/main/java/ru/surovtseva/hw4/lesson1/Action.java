package ru.surovtseva.hw4.lesson1;

public interface Action {
    String getInfo();
    String getName();
    boolean toRun(float length);
    boolean toJump(float height);
}
