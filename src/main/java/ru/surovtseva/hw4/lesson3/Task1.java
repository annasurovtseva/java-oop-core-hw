package ru.surovtseva.hw4.lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("pear");
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("watermelon");
        fruits.add("pear");
        fruits.add("grape");
        fruits.add("melon");
        fruits.add("banana");
        fruits.add("peach");
        fruits.add("apple");
        fruits.add("kiwi");
        fruits.add("grape");
        fruits.add("orange");
        fruits.add("pear");

        Set<String> uniqueFruit = new HashSet<>(fruits);

        System.out.println("Первоначальный массив");
        System.out.println(fruits);
        System.out.println();
        System.out.println("Массив уникальных слов");
        System.out.println(uniqueFruit);
        System.out.println();
        System.out.println("Частота слов");
        for(String word: uniqueFruit){
            System.out.println(word + " - " + Collections.frequency(fruits,word));
        }
    }
}
