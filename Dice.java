import java.util.Random;

/**
 * The Dice class generates random integers from 1 to 6. 
 * @author  M. Fleming
 * @version 10 April 2018, 2 October 2019
 */
public class Dice
{
    private Random generate;
    private int sides;
    
    /**
     * Create a new Dice object with the ability to randomly
     * generate whole numbers from 1 - 6.
     */
    public Dice()
    {
        generate = new Random();
        sides = 6;
    }
    
    /**
     * Construct an initialized Dice object with the sides set by 
     * a parameter value.
     * @param ns - the number of sides on the Dice object
     */
    public Dice (int ns)
    {
        generate = new Random();
        sides = ns;
    }
    
    /**
     * Return the number of sides of the Dice object
     * @return the number of sides
     */
    public int getSides()
    {
        return sides;
    }
    
    /**
     * Set or change the number of sides on the Dice object
     * @param ns - the number of sides
     */
    public void setSides(int ns)
    {
        sides = ns;
    }
    
    /**
     * Roll the dice to generate a random number.
     * @return a random integer from 1 through 6, inclusive
     */
    public int roll(int times)
    {     
        int sum = 0;
        for (int i = 0; i < times; i++) sum += generate.nextInt(sides)+1;
        
        return sum;
    }
}