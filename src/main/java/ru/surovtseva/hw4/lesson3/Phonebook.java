package ru.surovtseva.hw4.lesson3;

import java.util.*;

public class Phonebook {
    private HashMap<String,Set<String>> phonebook;

    public Phonebook(){
        this.phonebook = new HashMap<>();
    }

    public void add(String name, String phoneNumber){
        if(!phonebook.containsKey(name)){
            phonebook.put(name, new HashSet<>());
        }
        Set<String> value = phonebook.get(name);
        value.add(phoneNumber);
    }

    public Set<String> get(String name) {
        return phonebook.get(name);
    }

    public int size(){
        return phonebook.size();
    }

    @Override
    public String toString() {
        return "Phonebook [" +
                phonebook +
                ']';
    }
}
