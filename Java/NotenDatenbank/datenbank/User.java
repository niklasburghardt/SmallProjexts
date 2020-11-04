package datenbank;

import java.util.HashMap;

public class User {
    String username;
    String password;
    HashMap<String, String> notes;

    public User(String name, String password){
        this.username = name;
        this.password = password;
        this.notes = new HashMap<String, String>();
    }

    public void add(String name, String text){
        notes.put(name, text);
    }

    public void view(String name){
        System.out.println(notes.get(name));
    }

    public void remove(String name){
        notes.remove(name);
    }

    public void projects(){
        System.out.println(notes.keySet());
    }
}