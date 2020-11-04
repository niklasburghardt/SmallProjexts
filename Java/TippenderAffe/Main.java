import java.util.Random;
import java.util.Scanner;


public class Main{

    String[] word;
    String[] currentSent;
    String[] letters = {"a", "b", "c", "d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s"
                        ,"t","u","v","w", "x", "y", "z"};

    int buildSentence(){
        word = input();
        Random random = new Random();
        int count = 0;
        currentSent = new String[word.length];
        for(int i = 0; i<word.length; i++){
            currentSent[i] = letters[random.nextInt(letters.length)];
        }
        while(true){
            count++;
            String letter = letters[random.nextInt(letters.length)];
            currentSent = offset(currentSent, letter);
            if(checkSame(currentSent)){
                return count;
            }
        }
        
    }
    String[] offset(String[] sent, String let){
        for(int i = 1; i<sent.length; i++){
            sent[i-1] = sent[i];
        }
        sent[sent.length-1] = let;
        //System.out.println(Arrays.toString(sent));
        return sent;
    }

    boolean checkSame(String[] sent){
        for(int i = 0; i<sent.length; i++){
            if(sent[i].equals(word[i]) == false){
                return false;
            }
        }
        return true;
    }

    public String[] input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("word: ");
        String word = scanner.next();

        String[] wordList = new String[word.length()];
        wordList = word.split("");
        scanner.close();

        return wordList;
    }


    public static void main(String[] args){
        Main m = new Main();
        System.out.println(m.buildSentence());
    
    }
}