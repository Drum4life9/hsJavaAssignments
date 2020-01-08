import java.util.Scanner;

/**
 * This game demonstrates how to create and implement a DicePlayer object. 
 * @author  M. Fleming
 * @version 10 April 2018, 3 October 2019
 */
public class DicePlayerTester
{
    // Create a new DicePlayer and Scanner object
    public static DicePlayer player = new DicePlayer();
    public static Scanner input = new Scanner(System.in);
    
    public static void testDicePlayer()
    {
        int choice; // Main menu choice
        
        // Display the game title.
        System.out.println();
        System.out.println("***** Dice Player Tester *****");
        
        do
        {
            displayMainMenu();
            choice = input.nextInt();
            input.nextLine();
            System.out.println('\u000C');
            
            if (choice == 1)
            {
                controlPlayerMenu();
            }
            else if (choice == 2)
            {
                controlRollMenu();
            }
            
        }while(choice != 3);        // Quit game
        
        System.out.println("Good bye!");
    }

    /**
     * Control the Player Utility submenu and its options.
     */
    private static void controlPlayerMenu()
    {
        int choice;     // Submenu choice
        
        do
        {
            displayPlayerMenu();
            choice = input.nextInt();
            input.nextLine();
            System.out.println('\u000C');
            
            if (choice == 1)        // Change player's name
            {
                System.out.print("Enter the new player's name: ");
                String name = input.nextLine();
                player.setMyName(name);
            }
            else if (choice == 2)   // Change dice sides
            {
                System.out.print("Enter the number of dice sides: ");
                int sides = input.nextInt();
                input.nextLine();
                player.setMyDiceSides(sides);
            }
            else if (choice == 3)   // Set player's score
            {
                System.out.print("Enter the new player score: ");
                int score = input.nextInt();
                input.nextLine();
                player.setMyScore(score);
            }
            
        }while(choice != 4);
    }
    
    /**
     * Control the Roll submenu and its options.
     */
    private static void controlRollMenu()
    {
        int choice;     // Submenu choice
        int roll1, roll2;
        
        do
        {
            displayRollMenu();
            choice = input.nextInt();
            input.nextLine();
            System.out.println('\u000C');
            
            if (choice == 1)        // Roll a single cube
            {
                roll1 = player.rollMyDie();
                player.addMyScore(roll1);
                System.out.println(player.getMyName() + " rolled a " + roll1);
            }
            else if (choice == 2)   // Roll two cubes
            {
                roll1 = player.rollMyDie();
                roll2 = player.rollMyDie();
                player.addMyScore(roll1);
                player.addMyScore(roll2);
                System.out.print(player.getMyName() + " rolled a " + roll1);
                System.out.println(" and a " + roll2);
            }
            else if (choice == 3)   // Disply total of all rolls
            {
                System.out.println(player.toString());
            }
            else if (choice == 4)   // Reset roll totals
            {
                player.setMyScore(0);
                System.out.println("Total reset to 0.");
            }
            
        }while(choice != 5);            
    }
    
    
    /**
     * Display the game menu.
     */
    private static void displayMainMenu()
    {
        System.out.println();
        System.out.println("MAIN MENU: Enter a menu option.");
        System.out.println("\t1) Enter player utility menu.");
        System.out.println("\t2) Enter roll menu.");
        System.out.println("\t3) Quit game.");
        System.out.print("Enter your choice: ");
    }
    
    /**
     * Display the Roll submenu.
     */
    private static void displayRollMenu()
    {
        System.out.println();

        System.out.println("ROLL MENU: Enter a menu option.");
        System.out.println("\t1) Roll a single dice.");
        System.out.println("\t2) Roll two dice.");
        System.out.println("\t3) See total of all rolls.");
        System.out.println("\t4) Reset total rolls.");
        System.out.println("\t5) Return to main menu.");
        System.out.print("Enter your choice: ");      
    }
    
    /**
     * Display the Player Utility submeny.
     */
    private static void displayPlayerMenu()
    {
        System.out.println('\u000C');
        System.out.println("PLAYER UTILITY MENU");
        System.out.println("   Player name:\t" + player.getMyName());
        System.out.println("   Dice sides:\t" + player.getMyDiceSides());
        System.out.println("   Player score:\t" + player.getMyScore());
        
        System.out.println();
        System.out.println("Choose from a menu option.");
        System.out.println("\t1 Change player name.");
        System.out.println("\t2 Set number of sides of dice.");
        System.out.println("\t3 Set starting player score.");
        System.out.println("\t4 Return to main menu.");
        System.out.print("Enter your choice: ");
    }
}