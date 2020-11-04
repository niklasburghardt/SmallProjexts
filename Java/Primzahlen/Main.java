import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    List<Integer> pz = new ArrayList<>();
    public void search(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Limit: ");
        int limit = scanner.nextInt();
        int n = 1;
        while(n < limit){
            if(check(++n)){
                pz.add(n);
            }
        }
        scanner.close();
        System.out.println(pz.toString());
        System.out.println("Count: "+pz.size());
    }
    public boolean check(int n){
        for(int i = 0; i< pz.size(); i++) {
            if(pz.get(i) <= Math.sqrt(n)){
                if(n % pz.get(i) == 0)
                    return false;
            }else
                return true;
        }
        return true;
    }
    public static void main(String[]args) {
        Main m = new Main();
        m.search();
    }
}