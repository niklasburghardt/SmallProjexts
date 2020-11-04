package datenbank;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Main{

    List<User> users = new ArrayList<User>();
    int currentUser = -1;

    public void login(String name, String password){
        int number = 0;

        System.out.println("LOGGING IN...");
        for(int i = 0; i<users.size(); i++){
            if(users.get(i).username.equals(name) && users.get(i).password.equals(password)){
                currentUser = i;
                number = i;
                System.out.println("LOGGED IN AS "+users.get(i).username.toUpperCase()+"...");
                return;
            }
        }
        System.out.println("WRONG USER INFORMATION...\nCREATE NEW ACCOUT???");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().toLowerCase().equals("yes")){

            users.add(new User(name, password));
            System.out.println("CREATED NEW USER "+users.get(number).username.toUpperCase()+"...");
            currentUser = number;
        }
    }

    public void logout(){
        currentUser = -1;
        System.out.println("LOGGEN OUT...");
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(">>> ");
        String name = scanner.nextLine();
        if(name.toLowerCase().equals("add") && currentUser>=0){
            users.get(currentUser).add(ins(1), ins(2));
        }else if(name.toLowerCase().equals("view") && currentUser>=0){
            users.get(currentUser).view(ins(1));
        }else if(name.toLowerCase().equals("login") && currentUser == -1){
            login(ins(1), ins(3));
        }else if(name.toLowerCase().equals("logout") && currentUser>=0){
            logout();
        }else if(name.toLowerCase().equals("delete") && currentUser>=0){
            users.get(currentUser).remove(ins(1));
        }
    }

    public String ins(int n){
        Scanner scanner = new Scanner(System.in);
        if(n==1){
            System.out.print("Name: ");
            
        }else if(n==2){
            System.out.println("Text: ");
        }else if(n==3){
            System.out.print("Password: ");
        }
        String name = scanner.nextLine();
        return name;

    }



    public static void main(String[] args){
        Main m = new Main();
        while(true){
            m.input();
        }
    }
}