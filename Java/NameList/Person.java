public class Person {

    String name;
    int birth;
    Adresse adresse;

    public Person(String name, int birth){
        this.name = name;
        this.birth = birth;
    }

    public void addInformation(Adresse adresse){
        this.adresse = adresse;
    }
    
}
