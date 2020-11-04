import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Person{

    String name;
    int birth;
    List<Adresse> adresses = new ArrayList<>();
    String phone;

    Person(String name, int birth, String phone, Adresse adresse){
        this.name = name;
        this.birth = birth;
        this.phone = phone;
        this.adresses.add(adresse);
    }

    void show(){
        System.out.println("Hello my name is "+ this.name+" and I am born in "+this.birth+".\nI live here: "+this.adresses.get(0).show()+"\nYou can call me here: "+this.phone);
    }
}