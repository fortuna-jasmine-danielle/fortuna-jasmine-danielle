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

    public static int heroAttack() {
        return (int) Math.floor(Math.random() * (20 - 10)) + 10;
    }

    public static int enemyAttack() {
        return (int) Math.floor(Math.random() * (10 - 5)) + 5;
    }

    public static int drinkPotion(int heroHealth) {
        numPotions--;
        if (heroHealth <= 80) {
            heroHealth += 20;
            System.out.printf("You drank a potion, your health is now %d.  There are %d potions remaining.\n", heroHealth, numPotions);

        } else if (heroHealth > 80) {
            heroHealth = 100;
            System.out.printf("You drank a potion, your health is now %d. There are %d potions remaining.\n", heroHealth, numPotions);
        }

        return heroHealth;
    }

    public static int battleSequence(int heroHealth, int enemyHealth) {
        boolean continueBattle = true;
        while (continueBattle) {
            if (heroHealth <= 0) {
               continueBattle = false;
                System.out.println("GAME OVER!");

            } else if (enemyHealth <= 0) {
                continueBattle = false;
                System.out.println("ENEMY DEFEATED!");

            } else {
                int heroDealtDamage = heroAttack();
                int enemyDealtDamage = enemyAttack();
                heroHealth -= enemyDealtDamage;
                enemyHealth -= heroDealtDamage;
                if (heroHealth > 0) {
                    if (enemyHealth <= 0) {
                        enemyHealth = 0;
                    }
                    System.out.printf("You dealt %d damage to the enemy.  The enemy's health is now %d.\n", heroDealtDamage, enemyHealth);
                }
                if (enemyHealth > 0 ) {
                    if (heroHealth <= 0) {
                        heroHealth = 0;
                    }
                    System.out.printf("The enemy dealt %d damage to you.  Your health is now %d.\n",enemyDealtDamage, heroHealth);
                }

            }

        }
        return heroHealth;
    }
    public static int numPotions = 5;

    public static void main(String[] args) {

    // See if user wants to start game
        boolean runGame = startGame();

        // If user opts to start game, get user's name
        if(runGame) {
            String userName = getUserName();
            System.out.printf("Hello, %s!  Welcome to game.  Defeat the enemy!\n", userName);
            int heroHealth = 50;
            int enemyHealth = 100;

//            battleSequence(heroHealth, enemyHealth);
            drinkPotion(heroHealth);

        }



    }


}
