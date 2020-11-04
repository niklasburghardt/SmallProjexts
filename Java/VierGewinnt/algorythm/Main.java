package algorythm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int[][] grid = new int[6][7];

    public void play(){
        int count = 0;
        while(++count<=21){
            human(1);
            print();
            human(2);
            print();
        }
        
    }

    public void human(int player){
        Scanner scanner = new Scanner(System.in);
        
        
        while(true){
            System.out.print("Column: ");
            int x = scanner.nextInt();
            if(put(x-1, player)){
                if(won(player))
                    System.out.println("Player "+player+" won!!");
                break;
            }
        }
    }

    public boolean put(int x, int player){
        for(int i = 0; i<grid.length; i++){
            if(grid[i][x] != 0){
                try{
                    grid[i-1][x] = player;
                    return true;
                }catch(IndexOutOfBoundsException in){
                    return false;
                }
            }else if(i == grid.length-1){
                grid[i][x] = player;
                return true;
            }
        }
        return false;
    }

    public void print(){
        System.out.println("____________");
        for(int i = 0; i<grid.length; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    public boolean won(int player){
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j] == player){
                    player++;
                    if(player == 4)
                        return true;
                }else
                    player = 0;
            }
        }
        
        return false;
    }

    public static void main(String[] args){
        Main m = new Main();
        m.play();
    }
}