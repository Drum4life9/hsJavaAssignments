import java.util.Scanner;

/**
 * An engine to run the flash card game
 * @author  Brian Myers
 * @version 12-5-2019
 */
public class FlashCardGame
{
    private static FlashCard fc = new FlashCard();   
    private static Scanner input = new Scanner(System.in);
    
    /**
     * Display the tiles for the game
     */
    public static void playGame()
    {
        int numQuestions, maxNum, ans;
        int correctAnswers = 0;
        int totalGuesses = 0;
        
        //Display title
        displayTitle();
        
        numQuestions = getPositiveNumber("Enter a number of cards to try");
        maxNum = getPositiveNumber("Enter a number for a max integer to use");
        
        fc.setMaxNumber(maxNum);
        
        while (totalGuesses < numQuestions)
        {
            String question = fc.toString();
            System.out.print(question + " is: ");
            
            int pAns = input.nextInt();
            
            if (fc.checkAnswer(pAns))
            {
                correctAnswers +=1;
                System.out.println("That is correct!");
            }
            else System.out.println("That is not correct.");
            
            totalGuesses += 1;
        }
        
        if (numQuestions == correctAnswers) System.out.println("You got all the questions right!");
        else System.out.println("You got " + correctAnswers + " question(s) right out of " + numQuestions + "!");
        
    }
    
    /**
     * Define program to loop until a positive number is entered
     * @param prompt - a prompt to be displayed, along with a colon
     */
    private static int getPositiveNumber(String prompt)
    {
        int number;
        do
        {
            System.out.print(prompt + ": ");
            number = input.nextInt();
        } while (number <= 0);
        
        return number;
    }
    
    /**
     * Display the title, involving ascii art from Mr. F website.
     */
    private static void displayTitle()
    {
        System.out.println();
        System.out.println("   _____");
        System.out.println("  |2    | _____");
        System.out.println("  |  v  ||3    |");
        System.out.println("  |     || v v |");
        System.out.println("  |  v  ||     |");
        System.out.println("  |____Z||  v  |");
        System.out.println("         |____E|");
        System.out.println("The Flash Card Game");
        System.out.println();
    }
}
