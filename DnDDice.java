import java.util.Random;

/**
 * A dice class that takes an input and returns a random number up to it
 * @author  Brian Myers
 * @version 11-19-2019
 */
public class DnDDice
{
    private Random roll = new Random();
    private int num;
    
    public int roll(int max)
    {
        return roll.nextInt(max)+1;
    }
}
