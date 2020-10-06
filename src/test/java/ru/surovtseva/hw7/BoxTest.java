package ru.surovtseva.hw7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxTest {

    @Test
    public void firstAddItemMethodTest() {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Box<Apple> appleBox = new Box<>();
        appleBox.addItem(apple1,apple2,apple3);

        Assertions.assertEquals(3,appleBox.size());
    }

    @Test
    public void secondConstructorTest() {
        Box<Apple> appleBox = new Box<>(6,new Apple());
        Assertions.assertEquals(6,appleBox.size());
    }

    @Test
    public void secondAddItemMethodTest() {
        Box<Orange> orangeBox = new Box<>(4,new Orange());
        orangeBox.addItem(6);
        Assertions.assertEquals(10,orangeBox.size());
    }

    @Test
    public void getWeightMethodTest(){
        Box<Orange> orangeBox = new Box<>(10,new Orange());
        Box<Apple> appleBox = new Box<>(6,new Apple());
        Assertions.assertAll(
                () -> Assertions.assertEquals(15,orangeBox.getWeight()),
                () -> Assertions.assertEquals(6,appleBox.getWeight())
        );
    }

    @Test
    public void compareMethodTestTrue() {
        Box<Orange> orangeBox = new Box<>(4,new Orange());
        Box<Apple> appleBox = new Box<>(6,new Apple());

        Assertions.assertTrue(orangeBox.compare(appleBox));
    }

    @Test
    public void compareMethodTestFalse() {
        Box<Orange> orangeBox = new Box<>(4,new Orange());
        Box<Apple> appleBox = new Box<>(5,new Apple());

        Assertions.assertFalse(appleBox.compare(orangeBox));
    }

    @Test
    public void moveMethodTest() {
        Box<Apple> appleBox1 = new Box<>(5,new Apple());
        Box<Apple> appleBox2 = new Box<>(8,new Apple());
        appleBox1.move(appleBox2);

        Assertions.assertAll(
                () -> Assertions.assertEquals(0,appleBox1.size()),
                () -> Assertions.assertEquals(13,appleBox2.size())
        );
    }
}
