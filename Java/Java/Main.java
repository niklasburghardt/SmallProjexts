import java.util.Arrays;
import java.util.Scanner;

public class Main {

    int[][] grid;
    int size;
    int count;
    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Size: ");
        size = scanner.nextInt();
        grid = new int[size][size];
        for(int i = 0; i<size ; i++){
            for(int j = 0; j< size; j++){
                grid[i][j] = scanner.nextInt();
            }
        }
        System.out.println();
    }

    public boolean possible(int x, int y, int n){
        for(int i = 0; i<size; i++){
            if(grid[i][x] == n || grid[y][i] == n){
                return false;
            }
        }

        double gx = (Math.floor(x/Math.sqrt(size)))*Math.sqrt(size);
        double gy = (Math.floor(y/Math.sqrt(size)))*Math.sqrt(size);

        for(int i = 0; i<Math.sqrt(size); i++){
            for(int j = 0; j<Math.sqrt(size); j++){
                if(grid[(int)(i+gx)][(int) (j+gy)] == n)
                    return false;
            }
        }
        return true;
    }

    public void solve(){
        for(int y = 0; y<size; y++){
            for(int x = 0; x<size; x++){
                if(grid[y][x] == 0){
                    for(int n = 1; n<size+1; n++){
                        if(possible(y, x, n)){
                            grid[y][x] = n;
                            solve();
                            grid[y][x] = 0;
                        }
                    }
                    return;
                }
            }
        }
        print();
    }

    public void print(){
        System.out.println("Nr: "+(++count));
        System.out.println("___________________");
        for(int i = 0; i<size; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
    }


    public static void main(String[]args){
        Main m = new Main();
        m.input();
        System.out.print(m.possible(2, 2, 3));
    }
}