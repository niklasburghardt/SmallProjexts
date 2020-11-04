package main;
import java.util.Scanner;


public class Main{

    public int[][] grid;
    public int size;
    public boolean limit = true;
    public int count;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("limit: ");;
        if(scanner.nextLine() == "no"){
            limit = false;
        }
        System.out.print("Size: ");
        size = scanner.nextInt();
        grid = new int[size][size];

        for(int i = 0; i< size; i++){
            for(int j = 0; j<size; j++){
                grid[i][j] = scanner.nextInt();
            }
        }

    }

    public boolean possible(int x, int y, int number){
        for(int i = 0; i<size; i++){
            if(grid[y][i] == number || grid[i][x] == number){
                return false;
            }
        }

        double gx = Math.floor(x / Math.sqrt(size)) * Math.sqrt(size);
        double gy = Math.floor(y / Math.sqrt(size)) * Math.sqrt(size);

        for(int i = 0; i<Math.sqrt(size)+gy; i++){
            for(int j = 0; j<Math.sqrt(size)+gx; j++){
                if(grid[i][j] == number){
                    return false;
                }
            }
        }

        return true;
    }

    public void solve(){
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                if(grid[i][j] == 0){
                    for(int n = 0; n < size; n++){
                        if(possible(j, i, n)){
                            grid[i][j] = n;
                            solve();
                            grid[i][j] = 0;
                        }
                    }
                    return;
                }
            }
        }
        print();
        Scanner scanner = new Scanner(System.in);
        System.out.print("MORE?");
        scanner.nextLine();

    }

    public void print(){
        System.out.println("NR: "+ (++count));
        System.out.println("______________");
        for(int i = 0; i<size; i++){
            System.out.println(grid[i]);
        }
    }

    public static void main(String[] args){
        Main m = new Main();
        m.input();
        

    }
}