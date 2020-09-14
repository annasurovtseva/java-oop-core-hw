package ru.surovtseva.hw1;

public class Track implements Hurdles {
    private float parameter;
    private String type;

    Track(float parameter) {
        this.parameter = parameter;
        type = "track";
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
        return player.toRun(parameter);
    }
}
