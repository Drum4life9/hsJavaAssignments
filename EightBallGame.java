import java.util.Scanner;

/**
 * A game that uses a magic 8 ball to predict the future. 
 * @author  M. Fleming
 * @version 28 September 2019
 */
public class EightBallGame
{
    public static Magic8Ball m8 = new Magic8Ball();
    public static Scanner input = new Scanner(System.in);
    
    /**
     * Play the Eight Ball game.
     */
    public static void play8()
    {
        int choice;
        System.out.println('\u000c');
        displayTitle();
        
        do
        {
            displayMenu();
            choice = input.nextInt();
            input.nextLine();
            System.out.println('\u000C');
            
            // Determine the menu choice
            if (choice == 1) ask8();
            else if (choice == 2) addReplies();
            else if (choice == 3) seeAllReplies();
        }while(choice != 4);
        
        displayReply("See you later!");
    }
    
    /**
     * Ask the magic eight ball a question.
     */
    private static void ask8()
    {
        String question, reply;
        
        // Ask the 8 ball a question
        System.out.println();
        System.out.print("Ask the 8 ball a question: ");
        question = input.nextLine();
        
        // Get the 8 ball's reply
        reply = m8.shake8Ball();
        displayReply(reply);
    }
    
    /**
     * Add replies to the magic eight ball.
     */
    private static void addReplies()
    {
        String reply;
        
        System.out.print("Enter a new reply: ");
        reply = input.nextLine();
        
        m8.addReply(reply);
        displayReply("I added: " + reply + ".");
    }
    
    /**
     * Show all of the replies currently in the magic eight ball.
     */
    private static void seeAllReplies()
    {
        String allReplies = m8.showAllReplies();
        displayReply("Here are all of my replies");
        System.out.println(allReplies);
    }        
    
    /**
     * Display the game menu.
     */
    private static void displayMenu()
    {
        System.out.println("");
        System.out.println("Pick from a menu option below:");
        System.out.println("\t1) Ask the 8 ball a question.");
        System.out.println("\t2) Add replies to the 8 ball.");
        System.out.println("\t3) See all 8 ball replies.");
        System.out.println("\t4) Quit the program.");
        System.out.print("Enter your choice: ");
    }
    
    /**
     * Display the 8 ball's reply.
     * @param reply - The 8 ball's reply
     */
    private static void displayReply(String reply)
    {
        System.out.println('\u000C');
        System.out.println("        .-\"\"\"-.");
        System.out.println("       /   _   \\");
        System.out.println("       |  (8)  |\t " + reply);
        System.out.println("       \\   ^   /");
        System.out.println("        '-...-'");
    } 
   
    /**
     * Display the game title at the start of the game.
     */
    private static void displayTitle()
    {
        System.out.println("     Magic 8 Ball");
        System.out.println("        .-\"\"\"-.");
        System.out.println("       /   _   \\");
        System.out.println("       |  (8)  |");
        System.out.println("       \\   ^   /");
        System.out.println("        '-...-'");
    }
}