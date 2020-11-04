import java.util.ArrayList;
import java.util.List;

public class Namelist {
    
    String name;
    String use;
    String host;
    List<Person> persons = new ArrayList<>();

    public Namelist(String name, String use, String host){
        this.name = name;
        this.use = use;
        this.host = host;
    }

    public void addName(String name, int birth){
        persons.add(new Person(name, birth));
    }




}
