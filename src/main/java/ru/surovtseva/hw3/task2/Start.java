package ru.surovtseva.hw3.task2;

public class Start {
    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();

        phonebook.add("Ivanov", "88991234567");
        phonebook.add("Petrov", "89996349856");
        phonebook.add("Ivanov", "87991324846");
        phonebook.add("Antonov", "86991484846");
        phonebook.add("Ivanov", "85521484846");

        System.out.println(phonebook);

        System.out.println();
        phonebook.get("Ivanov");

        System.out.println();
        phonebook.get("Petrov");

        System.out.println();
        phonebook.get("Pavlov");

    }
}
