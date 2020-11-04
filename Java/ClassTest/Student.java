import java.util.ArrayList;
import java.util.List;

public class Student extends Person{

    Student(String name, int birth, String phone, Adresse adresse) {
        super(name, birth, phone, adresse);
    }

    List<Grade> grades = new ArrayList<>();

    
    
}