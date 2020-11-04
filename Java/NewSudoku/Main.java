import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public int[][] grid;
    public int size;
    public int count = 0;
    String input;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Size: ");
        size = scanner.nextInt();
        grid = new int[size][size];

        for(int i = 0; i< size; i++){
            for(int j = 0; j<size; j++){
                grid[i][j] = scanner.nextInt();
        
            }
        }
        scanner.close();
    }

    public boolean possible(int x, int y, int number){
        for(int i = 0; i<size; i++){
            if(grid[y][i] == number)
                return false;
        }
        for(int i = 0; i<size; i++){
            if(grid[i][x]==number){
                return false;
            }
        }
        double gx = (x/Math.sqrt(size));
        double gy = (y/Math.sqrt(size));

        for(int i = 0; i<Math.sqrt(size); i++){
            for(int j = 0; j<Math.sqrt(size); j++){
                if(grid[(int) (i + (Math.floor(gy) * Math.sqrt(size)))][(int) (j + (Math.floor(gx) * Math.sqrt(size)))] == number) {
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
                    for(int n = 1; n<size+1; n++){
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
        
    }

    public void print(){
        System.out.println("NR. "+ ++count);
        System.out.println("________________");
        for(int i = 0; i<size; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
    }
    public static void main(String[]args){
        Main m = new Main();
        m.input();
        m.solve();
    }
}