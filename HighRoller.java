import java.util.Scanner;
import java.util.Random;
/**
 * Play a game where players take turns in order to surpass a specific number.
 * @author  Brian Myers
 * @version 12-17-19
 */
public class HighRoller
{
    private static Scanner in = new Scanner(System.in);
    private static DicePlayer player1 = new DicePlayer();
    private static DicePlayer player2 = new DicePlayer();
    private static Random gen = new Random();
    
    /**
     * Play the game
     */
    public static void playHighRoller()
    {
        int sides, endTotal, p1Score = 0, p2Score = 0;
        
        //Display title and directions
        displayTitle();
        displayDirections();
        
        //enter sides and target number
        System.out.print("Enter a number of sides for the die: ");
        sides = in.nextInt();
        
        System.out.print("Enter a target value: ");
        endTotal = in.nextInt();
        in.nextLine();
        System.out.println();
        
        //set the two players info
        setDicePlayer(player1, sides);
        setDicePlayer(player2, sides);
        
        setPlayerOrder();
        
        System.out.println();
        do 
        {
            //player 1 turn
            int p1roll = playerRoll(player1);
            p1Score = player1.getMyScore();
            System.out.println(player1.getMyName() + " rolled a " + p1roll + ", and now has " + p1Score + ". Hit enter to continue");
            in.nextLine();
            System.out.println();
            
            //player 2 turn
            int p2roll = playerRoll(player2);
            p2Score = player2.getMyScore();
            System.out.println(player2.getMyName() + " rolled a " + p2roll + ", and now has " + p2Score + ". Hit enter to continue");
            in.nextLine();
            System.out.println('\u000c');
        } while (p1Score < endTotal && p2Score < endTotal);
        
        getWinningResults();
    }
    
    /**
     * Find out who has more points
     */
    private static void getWinningResults()
    {
        System.out.println("The game is over!");
        System.out.println(player1);
        System.out.println(player2);
        
        if (player1.getMyScore() > player2.getMyScore()) {System.out.println(player1.getMyName()+ " wins!");}
        else if (player2.getMyScore() > player1.getMyScore()) {System.out.println(player2.getMyName()+ " wins!");}
        else {System.out.println("Both players tie!");}
    }
    
    /**
     * Take a player, roll their die, and add it to total score for said player
     * @param p - the dice player to roll die and add score
     */
    private static int playerRoll(DicePlayer p)
    {
        int num = gen.nextInt(p.getMyDiceSides())+1;
        
        if (num == p.getMyDiceSides())
        {
            p.addMyScore(p.getMyDiceSides());
            System.out.println(p.getMyName() + " rolled a maxium! They roll again...");
            num = gen.nextInt(p.getMyDiceSides())+1;
        }
        p.addMyScore(num);
        
        return num;
    }
    
    /**
     * Determine which player is p1 and p2
     */
    private static void setPlayerOrder()
    {
        if (gen.nextInt(2)+1 == 1) 
        { 
            DicePlayer temp = player1;
            player1 = player2;
            player2 = temp;
        }
    }
    
    /**
     * Set a specific player's name and dice sides
     * @param p - the dice player to modify
     * @param s - the number of sides on the die
     */
    private static void setDicePlayer(DicePlayer p, int s)
    {
        System.out.print("What is your name: ");
        
        p.setMyName(in.nextLine());
        p.setMyDiceSides(s);
    }
    
    /**
     * Display the game title, with ascii art.
     */
    private static void displayTitle()
    {
        System.out.println();        
        System.out.println("  ____     HIGH");
        System.out.println(" /\\' .\\    _____");
        System.out.println("/: \\___\\  / .  /\\");
        System.out.println("\\' / . / /____/..\\");
        System.out.println(" \\/___/  \\'  '\\  /");
        System.out.println(" ROLLER   \\'__'\\/");
        System.out.println("");
    }
    
    /**
     * Display the game directions
     */
    private static void displayDirections()
    {
        System.out.println("Players take turns rolling a single dice.  The winner");
        System.out.println("is the first player whos combined roll value reaches");
        System.out.println("an agreed upon score.");
        System.out.println();
    }
}
