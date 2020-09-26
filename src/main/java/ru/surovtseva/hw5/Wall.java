package ru.surovtseva.hw5;

public class Wall implements Hurdles {
    private float parameter;
    private String type;

    Wall(float parameter) {
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
