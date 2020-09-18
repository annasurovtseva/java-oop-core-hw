package ru.surovtseva.hw3.task1;

import java.util.*;

public class Start {
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
