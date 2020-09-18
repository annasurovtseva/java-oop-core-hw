package ru.surovtseva.hw3.task2;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    private HashMap<String,String> phonebook;

    Phonebook(){
        this.phonebook = new HashMap<>();

    }

    void add (String name, String phoneNumber){
        phonebook.put(phoneNumber, name);
    }

    void get (String name){
        if(!phonebook.containsValue(name)){
            System.out.println("Фамилии " + name + " в справочнике нет");
        }else {
            System.out.println("На фамилию " + name+ " зарагистрированны следующие номера тефефонов:");
            for (Map.Entry<String, String> record: phonebook.entrySet()){
                if(record.getValue().equals(name)) {
                    System.out.println(record.getKey());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Phonebook [" +
                phonebook +
                ']';
    }
}