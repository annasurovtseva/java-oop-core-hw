package ru.surovtseva.hw7;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    private ArrayList<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public Box(int numbers,T... items){
        this.box = new ArrayList<>(Arrays.asList(items));
        for (int i = 1; i < numbers; i++) {
            this.box.addAll(Arrays.asList(items));
        }
    }

    public void addItem(T... items) {
        this.box.addAll(Arrays.asList(items));
    }

    public void addItem(int numbers) {
        T items = this.box.get(0);
        for (int i = 0; i < numbers; i++) {
            this.box.add(items);
        }
    }

    public void clear(){
        box.clear();
    }

    public int size() {
        return box.size();
    }

    public double getWeight() {
        double weight = 0;
        for (T item : box)
            weight += item.getWeight();
        return weight;
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }

    public void move(Box<T> box) {
        box.box.addAll(this.box);
        clear();
    }
}
