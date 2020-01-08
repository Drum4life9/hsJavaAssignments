import java.util.Scanner;

/**
 * Demonstrate how to create and implement multi-sided Dice objects. 
 * @author  M. Fleming
 * @version 2 October 2019
 */
public class DiceTester
{
    public static Dice d6 = new Dice();
    public static Dice d10 = new Dice(10);
    public static Dice d20 = new Dice(20);
    
    public static void rollSomeDice()
    {
        int choice, result;
        Scanner input = new Scanner(System.in);
        
        System.out.println();
        System.out.println("Dice Tester Program");
        
        do
        {
            displayGameMenu();
            choice = input.nextInt();
            System.out.println('\u000C');
            
            if (choice == 1)
            {
                result = rollForStats();
                System.out.println("You rolled a " + result + " for your stat.");
            }
            else if (choice == 2)
            {
                result = rollForPercentages();
                System.out.println("You rolled a " + result + "percent.");
            }
            else if (choice == 3)
            {
                System.out.print("Enter charisma threshold from 1 - 40: ");
                choice = input.nextInt();
                
                if (rollForCharismaCheck(choice) == true)
                    System.out.print("You passed");
                else
                    System.out.print("You failed");
                System.out.println(" the charisma check!");
            }
            else if (choice == 4)
            {
                System.out.print("Enter number of sides: ");
                int sides = input.nextInt();
                System.out.print("Enter number of times: ");
                int times = input.nextInt();
                
                result = rollGenericDice(sides, times);
                System.out.println(times + "d" + sides + " rolled a " + result + ".");
            }
            
        }while(choice != 5);
        
        System.out.println("Good bye!");
    }
    
    /**
     * Roll for a starting stats value for strength, intellegence, etc.
     * @return the sum of 3 6-sided dice rolls
     */
    private static int rollForStats()
    {
        int statTotal;
        statTotal = d6.roll(3);
        return statTotal;
    }
    
    /**
     * Generate a percentage roll out of 100.
     * @return a number in the range of 1 through 100 representing a percentage.
     */
    private static int rollForPercentages()
    {
        int ones, tens, percent;
        
        ones = d10.roll(1);
        tens = d10.roll(1) * 10;
        percent = tens + ones;
        
        return percent;
    }
    
    /**
     * Roll a 20-sided dice two times to check if the sum exceeds the threshold.
     * @param threshold - the amount that must be passed
     * @return true if the sum exceeds the threshold, false otherwise
     */
    private static boolean rollForCharismaCheck(int threshold)
    {
        int rollValue = d20.roll(2);
        
        if (rollValue > threshold)
            return true;
        else
            return false;
    }
    
    /**
     * Roll a generic dice.
     * @param numSides - the number of sides of the dice
     * @param numTimes - the number of times to roll the dice
     * @return the sum of the rolls
     */
    private static int rollGenericDice(int numSides, int numTimes)
    {
        Dice d = new Dice(numSides);
        int sum = 0;
        
        sum += d.roll(numTimes);
        return sum;
    }
    
    /**
     * Display the game menu.
     */
    private static void displayGameMenu()
    {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("  [1]  Roll for stats (outcome 1 - 18).");
        System.out.println("  [2]  Roll for percentages (outcome 1 - 100).");
        System.out.println("  [3]  Roll for charisma check (additional info required).");
        System.out.println("  [4]  Roll any generic dice (additional info required).");
        System.out.println("  [5]  Quit the program.");
        System.out.print("Enter your choice: ");
    }
}