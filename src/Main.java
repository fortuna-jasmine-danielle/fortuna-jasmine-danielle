import java.util.Scanner;

public class Main {

    public static boolean startGame(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Do you want to start the game? [yes/no]: ");
        boolean runGame = sc.nextLine().equalsIgnoreCase("yes");

        return runGame;
    }

    public static String getUserName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        return sc.nextLine();
    }


    public static void main(String[] args) {

    // See if user wants to start game
        boolean runGame = startGame();

        // If user opts to start game, get user's name
        if(runGame) {
            String userName = getUserName();
            System.out.println(userName);

        }



    }


}
