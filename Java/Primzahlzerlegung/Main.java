import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    List<Integer> pz = new ArrayList<>();
    List<Integer> divider = new ArrayList<>();
    double range;
    double RANGE;

    public double input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        return scanner.nextDouble();
    }
    public void search(){
        int n = 1;
        while(n < range){
            if(check(++n)){
                pz.add(n);
            }
        }
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

    public void divide(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i<pz.size(); i++){
            while(range % pz.get(i) == 0){
                range = range / pz.get(i);
                divider.add(pz.get(i));
                System.out.print(divider.toString());
                System.out.print("--> "+(int) range);
                scanner.nextLine();
                if(pz.get(i) > Math.sqrt(RANGE)){
                    
                    return;
                }
            }
        }
        
    }

    public static void main(String[]args){
        Main m = new Main();
        m.range = m.input();
        m.RANGE = m.range;
        m.search();
        m.divide();
    }
}