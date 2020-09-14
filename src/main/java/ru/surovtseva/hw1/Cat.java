package ru.surovtseva.hw1;

public class Cat implements Action {
    private String name;
    private float maxRun;
    private float maxJump;

    Cat(String name) {
        this.name = name;
        maxRun = (float)(Math.random()*101+200);
        maxJump = (float)(Math.random()*2+0.5);
    }
    @Override
    public String getName(){
        return name;
    }

    float getMaxRun () {
        return maxRun;
    }

    float getMaxJump() {
        return maxJump;
    }

    @Override
    public String getInfo() {
        return String.format("name: %s, maxRun: %.1f, maxJump: %.1f",
                getName(), getMaxRun(), getMaxJump());
    }

    @Override
    public boolean toJump(float height) {
        return height <= maxJump;
    }

    @Override
    public boolean toRun(float length) {
        return length <= maxRun;
    }
}
