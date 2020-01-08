
import java.util.Scanner;

/**
 * This program simulates a one-player version of the dice game of Pig. 
 * @author  M. Fleming
 * @version 11 April 2018, 10 May 2018
 */
public class Pig
{
    private static final int END_GAME = 100;
    private static int gameTotal = 0;
    private static int choice;
    private static Scanner input = new Scanner(System.in);
    
    public static void playPig()
    {
        DicePlayer player1 = new DicePlayer();
        DicePlayer player2 = new DicePlayer();
        
        // Control the main game
        do
        {
            displayTitle();
            displayDirections();
            displayGameMenu();
            choice = input.nextInt();
            input.nextLine();
            
            if (choice == 1)
            {
                playNewGame(player1, player2);
            }
            else if (choice == 2)
            {
                setPlayerName(player1);
                setPlayerName(player2);
            }
            
        } while (choice != 3);
        
        
        
        System.out.println();
        System.out.println("Thanks for playing!");
    }
    
    /**
     * Begin a new game, which is composed of several rounds.
     */
    private static void playNewGame(DicePlayer p1, DicePlayer p2)
    {
        do 
        {
            playNewRound(p1);
            playNewRound(p2);
            
            System.out.println();
            
            if (p1.getMyScore() >= END_GAME || p2.getMyScore() >= END_GAME)
            {
                //System.out.print("You won the game! ");
                break;
            }
            else
            {
                System.out.println(p1.getMyName() + "'s score: " + p1.getMyScore());
                System.out.println(p2.getMyName() + "'s score: " + p2.getMyScore());
                System.out.println("Play another round (0 - No, 1 - Yes) ?");
                choice = input.nextInt();
            }
        } while (choice != 0);
        
        //System.out.println("Your game total: ");
        
        if (p1.getMyScore() > p2.getMyScore())
        {
            System.out.print(p1.getMyName() + " wins!");
        }
        else 
        {
            System.out.print(p2.getMyName() + " wins!");
        }
    }
    
    /**
     * Control each new round inside of a single game.
     */
    private static void playNewRound(DicePlayer player)
    {
        int roll1 = 0, roll2 = 0, rollTotal, roundTotal = 0;
                
        System.out.println('\u000C');
        do
        {
            displayRoundMenu(player, roundTotal);
            choice = input.nextInt();
            input.nextLine();
            
            if (choice != 1) {break;}
            
            // Roll the dice
            roll1 = player.rollMyDie();
            roll2 = player.rollMyDie();
            System.out.println("Your rolls - " + roll1 + " & " + roll2);    
            
            
            // Process the roll results
            if (roll1 == 1 && roll2 == 1)       // Double 1 was rolled
            {
                roundTotal = 0;
                player.setMyScore(0);
                System.out.println("Busted! Your round is over!");
                System.out.println("Your game and round total is reset!");
                choice = 2;
            }
            else if (roll1 == 1 || roll2 == 1)  // Single 1 was rolled
            {
                roundTotal = 0;
                System.out.println("Busted! Your round is over!");
                choice = 2;
            }
            else    // Avoided 1 or double 1
            {
                rollTotal = roll1 + roll2;
                roundTotal += rollTotal;
            }
            
        }while(choice == 1);
        
        // Display the round results
        System.out.println();
        System.out.println("Previous Game Total: " + player.getMyScore());
        System.out.println("Round Total: " + roundTotal);
        player.addMyScore(roundTotal);
        System.out.println("New Game Total: " + player.getMyScore());
        System.out.print("Hit enter for the next player's round.");
        input.nextLine();
    }
    
    private static void setPlayerName(DicePlayer p)
    {
        System.out.println('\u000C');
        System.out.println("Your name is " + p.getMyName());
        System.out.print("Enter your new name: ");
        p.setMyName(input.nextLine());
    }
    
    /**
     * Display the game menu.
     */
    private static void displayGameMenu()
    {
        System.out.println("GAME MENU: Choose from a menu item below: ");
        System.out.println("\t1) Play a new game");
        System.out.println("\t2) Set player names");
        System.out.println("\t3) Quit game");
        System.out.print("Enter your selection: ");
    }
    
    /**
     * Display the round menu.
     * @param the round total
     */
    private static void displayRoundMenu(DicePlayer player, int rt)
    {
        String name = player.getMyName().toUpperCase();
        int gameTotal = player.getMyScore();
        
        System.out.println();
        System.out.print(name + " ROUND TOTAL:  " + rt + "     ");
        System.out.println("GAME TOTAL: " + gameTotal);
        System.out.println("\t1) Roll the dice");
        System.out.println("\t2) End round and bank round score");
        System.out.print("Enter your selection: ");
    }
    
    /**
     * Display the game rules.
     */
    public static void displayDirections()
    {
        System.out.println();
        System.out.print("Two standard dice are rolled.  ");
        System.out.println("A player scores by adding the total of each throw");
        System.out.print("to the turn total.  A player may ");
        System.out.println("voluntarily end the turn at any time and bank the");
        System.out.print("turn total into the game total.  ");
        System.out.println("The game ends when the player reaches 100 points.");
        
        System.out.println();
        System.out.println("Special Rules:");
        System.out.println("If a single 1 is rolled, the player scores nothing and the turn ends.");
        System.out.println("If two 1s are rolled, both the turn and game total is lost, and the turn ends.");
        System.out.println();
    }
    
    /**
     * Display the game title.
     */
    private static void displayTitle()
    {
        System.out.println('\u000C');
        System.out.println("  <(ﾟ´(｡ ｡)`ﾟ)>  ");
        System.out.println("     P I G   ");
    }
}