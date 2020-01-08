
import java.util.Scanner;
/**
 * Plays a game where players roll until they hit a target number, in which the
 * round ends, and points are added
 * @author  Brian Myers
 * @version 1-7-20
 */
public class KnockOut
{
    private static Scanner input = new Scanner(System.in);
    
    /**
     * play the game of knock out
     */
    public static void playKnockOut()
    {
        int choice = -1;
        DicePlayer p1 = new DicePlayer();
        DicePlayer p2 = new DicePlayer();
        
        displayTitle();
        System.out.println();
        displayDirections();
        System.out.println();
        do 
        {
            displayMenu();
            choice = input.nextInt();
            input.nextLine();
            
            if (choice == 1)
            {
                rollDice(p1);
                System.out.println();
                System.out.println(p1.getMyName() + " has a total of: " + p1.getMyScore());
                System.out.println();
                System.out.println("Hit enter to continue to next player: ");
                input.nextLine();
                
                rollDice(p2);
                System.out.println();
                System.out.println(p2.getMyName() + " has a total of: " + p2.getMyScore());
                System.out.println();
                System.out.println("Hit enter to continue to next player: ");
                input.nextLine();
            }
            else if (choice == 2)
            {
                setPlayerName(p1);
                setPlayerName(p2);
            }
            
            System.out.println(p1.getMyName() + " has " + p1.getMyScore() + " points.");
            System.out.println(p2.getMyName() + " has " + p2.getMyScore() + " points.");
            System.out.println('\u000C');
        } while (choice != 3);
        
        System.out.println(p1.getMyName() + " had " + p1.getMyScore() + " points.");
        System.out.println(p2.getMyName() + " had " + p2.getMyScore() + " points.");
        System.out.println();
        System.out.println("Thanks for playing!");
    }
    
    /**
     * complete one player turn
     * @param p - the dice player to roll and modify
     */
    private static void rollDice(DicePlayer p)
    {
        System.out.println('\u000C');
        int roll1 = 0, roll2 = 0, rScore = 0;
        int koNum = getKnockOutNumber(p);
        System.out.println('\u000C');
        do
        {
            roll1 = p.rollMyDie();
            roll2 = p.rollMyDie();
            
            System.out.println(p.getMyName() + " rolled " + roll1 + " & " + roll2 + ".");
            
            if (roll1 + roll2 == koNum) 
            {
                System.out.println("You have been knocked out!!");
                System.out.println("Round total: " + rScore);
            }
            else
            {
                System.out.println("You are safe and can keep rolling (ko number is: "+koNum+")");
                rScore += roll1 + roll2;
                System.out.println("You now have " + rScore + " points.");
                
                System.out.println("Hit enter to continue:");
                input.nextLine();
            }
            
        } while (roll1 + roll2 != koNum);
        
        
        p.addMyScore(rScore);
    }
    
    /**
     * get the players ko number, 6-9
     * @return the number of the player's choice
     */
    private static int getKnockOutNumber(DicePlayer p)
    {
        int koNumber;
        
        do
        {
            System.out.print(p.getMyName());
            System.out.println(", enter a knockout number (6, 7, 8, 9): ");
            
            koNumber = input.nextInt();
            input.nextLine();
        } while (koNumber < 6 || koNumber > 9);
        
        return koNumber;
    }
    
    /**
     * sets the player name of a given dice player object
     */
    private static void setPlayerName(DicePlayer p)
    {
        System.out.println('\u000C');
        System.out.print("Enter a new name for the player: ");
        p.setMyName(input.nextLine());
    }
    
    /**
     * display the menu for players to pick from
     */
    private static void displayMenu()
    {
        System.out.println("Enter 1) to play the game or 2) change player names or 3) to quit");
        System.out.print("Your selection: ");
    }
    
    /**
     * display the title of the game
     */
    private static void displayTitle()
    {
        System.out.println('\u000C');
        System.out.println("KKKKKKKKKKKOOOOOOOOOOOO");
        System.out.println("KKK    Knock Out    OOO");
        System.out.println("KKKKKKKKKKKOOOOOOOOOOOO");
    }
    
    /**
     * display the directions of the game
     */
    private static void displayDirections()
    {
        System.out.println("A player picks a knock out number, 6, 7, 8, or 9.  This is");
        System.out.println("the number to avoid when rolling a pair of dice.  The player");
        System.out.println("rolls the dice and adds up the result.  If the result is the");
        System.out.println("knock out number, the game is over.  Otherwise, the result is");
        System.out.println("added to the total.  The player continues to roll and add to");
        System.out.println("total as long as the knock out number is avoided.");
    }
}
