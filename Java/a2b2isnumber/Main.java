import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class Main {

    int right;
    int a;
    int b;

    public void input(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("right: ");
        right = scanner.nextInt();
    }

    public void find(){
        a = right;
        b = 1;
        while (a>=b){
            if(Math.sqrt(a) + Math.sqrt(b) == Math.sqrt(right)){
                System.out.println("A: "+a);
                System.out.println("B: "+b);
                return;
            }else if(Math.sqrt(a) + Math.sqrt(b) > Math.sqrt(right)){
                a--;
            }else{
                b++;
            }
        }
        System.out.println("Impossible");
    }

    public static void main(String[]args){
        Main m = new Main();
        m.input();
        m.find();
    }
}