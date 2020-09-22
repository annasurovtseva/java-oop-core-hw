package ru.surovtseva.hw4.lesson3;

public class Task2 {
    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();

        phonebook.add("Ivanov", "88991234567");
        phonebook.add("Petrov", "89996349856");
        phonebook.add("Ivanov", "87991324846");
        phonebook.add("Antonov", "86991484846");
        phonebook.add("Ivanov", "85521484846");

        System.out.println(phonebook);

        System.out.println();
        searchPhone(phonebook,"Ivanov");

        System.out.println();
        searchPhone(phonebook,"Petrov");

        System.out.println();
        searchPhone(phonebook,"Pavlov");

    }

    public static void searchPhone(Phonebook book, String name) {
        if (book.get(name) == null){
            System.out.println("Фамилии " + name + " в справочнике нет");
        } else {
            System.out.println("На фамилию " + name+ " зарагистрированны следующие номера тефефонов:");
            System.out.println(book.get(name));
        }
    }
}
