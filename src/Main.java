import java.util.Scanner;

public class Main {

    public static int enemyHealth = 100;
    public static int numPotions = 5;

    public static boolean startGame(){
        Scanner sc = new Scanner(System.in);


        System.out.println("          /\\\n" +
                "         /**\\\n" +
                "        /****\\   /\\\n" +
                "       /      \\ /**\\\n" +
                "      /  /\\    /    \\        /\\    /\\  /\\      /\\            /\\/\\/\\  /\\\n" +
                "     /  /  \\  /      \\      /  \\/\\/  \\/  \\  /\\/  \\/\\  /\\  /\\/ / /  \\/  \\\n" +
                "    /  /    \\/ /\\     \\    /    \\ \\  /    \\/ /   /  \\/  \\/  \\  /    \\   \\\n" +
                "   /  /      \\/  \\/\\   \\  /      \\    /   /    \\\n" +
                "__/__/_______/___/__\\___\\__________________________________________________");
        System.out.print("\n-- In a post-COVID-19 world, you find yourself walking through the mountains, foraging for toilet paper. Out of nowhere, you hear faint screaming echoing in the distance. Will you investigate? -- \n  [yes/no]  ");
        boolean runGame = sc.nextLine().equalsIgnoreCase("yes");

        return runGame;
    }

    public static String getUserName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nMy, my. You are a foolish one, aren't you? What is your name, adventurer?: ");
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
            System.out.printf("\nYou took an Ibuprofen, your health is now %d.  There are %d pills remaining.\n", heroHealth, numPotions);

        } else if (heroHealth > 80) {
            heroHealth = 100;
            System.out.printf("\nYou took an Ibuprofen, your health is now %d. There are %d pills remaining.\n", heroHealth, numPotions);
        }

        return heroHealth;
    }

    public static int battleSequence(int heroHealth) {
            if (heroHealth <= 0) {
                System.out.println("\n" +
                        "  _____          __  __ ______    ______      ________ _____  \n" +
                        " / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ \n" +
                        "| |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |\n" +
                        "| | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / \n" +
                        "| |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ \n" +
                        " \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\");

            } else if (enemyHealth <= 0) {
                System.out.println("\nENEMY DEFEATED!");

            } else {
                int heroDealtDamage = heroAttack();
                int enemyDealtDamage = enemyAttack();
                heroHealth -= enemyDealtDamage;
                enemyHealth -= heroDealtDamage;

                if (heroHealth > 0) {
                    if (enemyHealth <= 0) {
                        enemyHealth = 0;
                    }
                    System.out.printf("\nYou dealt %d damage to the enemy.  The enemy's health is now %d.\n", heroDealtDamage, enemyHealth);
                }

                if (enemyHealth > 0 ) {
                    if (heroHealth <= 0) {
                        heroHealth = 0;
                    }
                    System.out.printf("The enemy dealt %d damage to you.  Your health is now %d.\n",enemyDealtDamage, heroHealth);
                }

            }

        return heroHealth;
    }


    public static void main(String[] args) {

    // See if user wants to start game
        boolean runGame = startGame();

        // If user opts to start game, get user's name
        if(runGame) {
            String userName = getUserName();
            int heroHealth = 100;

            System.out.printf("\n-- As you near the source of the sound, you find an elderly woman flailing her arms and coughing uncontrollably." +
                "\n  She spots you and turns towards you. Before she can utter a warning a SUPER COVID-19 appears before you:" +
                    "\n  \"%s... I have been waiting for you.\" he utters, menacingly." +
                    "\n  What ever will you do? --\n", userName.toUpperCase());
            System.out.println("       _                      _______                      _\n" +
                    "   _dMMMb._              .adOOOOOOOOOba.              _,dMMMb_\n" +
                    "  dP'  ~YMMb            dOOOOOOOOOOOOOOOb            aMMP~  `Yb\n" +
                    "  V      ~\"Mb          dOOOOOOOOOOOOOOOOOb          dM\"~      V\n" +
                    "           `Mb.       dOOOOOOOOOOOOOOOOOOOb       ,dM'\n" +
                    "            `YMb._   |OOOOOOOOOOOOOOOOOOOOO|   _,dMP'\n" +
                    "       __     `YMMM| OP'~\"YOOOOOOOOOOOP\"~`YO |MMMP'     __\n" +
                    "     ,dMMMb.     ~~' OO     `YOOOOOP'     OO `~~     ,dMMMb.\n" +
                    "  _,dP~  `YMba_      OOb      `OOO'      dOO      _aMMP'  ~Yb._\n" +
                    " <MMP'     `~YMMa_   YOOo   @  OOO  @   oOOP   _adMP~'      `YMM>\n" +
                    "              `YMMMM\\`OOOo     OOO     oOOO'/MMMMP'\n" +
                    "      ,aa.     `~YMMb `OOOb._,dOOOb._,dOOO'dMMP~'       ,aa.\n" +
                    "    ,dMYYMba._         `OOOOOOOOOOOOOOOOO'          _,adMYYMb.\n" +
                    "   ,MP'   `YMMba._      OOOOOOOOOOOOOOOOO       _,adMMP'   `YM.\n" +
                    "   MP'        ~YMMMba._ YOOOOPVVVVVYOOOOP  _,adMMMMP~       `YM\n" +
                    "   YMb           ~YMMMM\\`OOOOI`````IOOOOO'/MMMMP~           dMP\n" +
                    "    `Mb.           `YMMMb`OOOI,,,,,IOOOO'dMMMP'           ,dM'\n" +
                    "      `'                  `OObNNNNNdOO'                   `'\n" +
                    "                            `~OOOOO~'" +
                    "\n");

            Scanner sc = new Scanner(System.in);


            while(heroHealth > 0 && enemyHealth > 0) {
                System.out.println("Choose an action:\nA. Use hand sanitizer\nB. Take ibuprofen\nC. Practice social distancing");
                String userAction = sc.next();

                if(userAction.equalsIgnoreCase("a")) {

                    heroHealth = battleSequence(heroHealth);

                } else if (userAction.equalsIgnoreCase("b")) {

                    heroHealth = drinkPotion(heroHealth);

                } else if (userAction.equalsIgnoreCase("c")) {
                    runGame = false;
                    heroHealth = 0;
                    System.out.println("\nWow, you're really just going to let her die like that?! What a wimp!\n");
                    System.out.println(
                            "  _____          __  __ ______    ______      ________ _____  \n" +
                            " / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ \n" +
                            "| |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |\n" +
                            "| | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / \n" +
                            "| |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ \n" +
                            " \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\");
                }



//            battleSequence(heroHealth, enemyHealth);
//            drinkPotion(heroHealth);

        }



    }


}}
