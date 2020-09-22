package ru.surovtseva.hw4.lesson1;

public class Cat implements Action {
    private String name;
    private float maxRun;
    private float maxJump;

    public Cat(String name, float maxRun, float maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
//        maxRun = (float)(Math.random()*101+200);
//        maxJump = (float)(Math.random()*2+0.5);
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
