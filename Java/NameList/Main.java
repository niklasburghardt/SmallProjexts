import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    public List<Namelist> lists = new ArrayList<>();
    public int currentList = -1;

    public String ins(int n){
        Scanner scanner = new Scanner(System.in);
        String name;
        if(n==1){
            System.out.print("Name");
        }else if(n==2){
            System.out.print("Use");
        }else if(n==3){
            System.out.print("host");
        }else if(n == 4){
            System.out.print("Birth");
        }
        name = scanner.nextLine();
        return name;
    }

    public void createList(){
        lists.add(new Namelist(ins(1), ins(2), ins(3)));
        currentList = lists.size()-1;
    }

    

    public static void main(String[] args){

    }
}