package ru.surovtseva.hw4.lesson1;

public class Wall implements Hurdles {
    private float parameter;
    private String type;

    public Wall(float parameter) {
        this.parameter = parameter;
        type = "wall";
    }

    @Override
    public float getParameter() {
        return parameter;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean doIT(Action player) {
        return player.toJump(parameter);
    }
}
