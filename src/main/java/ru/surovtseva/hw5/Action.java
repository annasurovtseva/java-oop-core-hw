package ru.surovtseva.hw5;

public interface Action {

    String getInfo();
    String getName();
    boolean toRun(float length);
    boolean toJump(float height);
}
