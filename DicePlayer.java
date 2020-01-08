/**
 * The DicePlayer object can be inserted into any Dice game that 
 * utilizes a score and a single dice object.
 * @author  M. Fleming
 * @version 13 August 2018, 2 October 2019
 */
public class DicePlayer
{
    // Instance variables
    private String name;
    private Dice dice;
    private int score;
    
    /**
     * Construct a default DicePlayer object that includes a six-sided   
     * Dice object and a score of 0.
     */
    public DicePlayer()
    {
        name = "Player 1";
        dice = new Dice();
        score = 0;
    }
    
    /**
     * Construct an initialized DicePlayer object that includes a multi-sided 
     * Dice object and any score.
     * @param ns - the number of sides of the dice
     * @param sc - the starting score of the DicePlayer
     * @param n  - the name of the DicePlayer
     */
    public DicePlayer(String n, int ns, int sc)
    {
        name = n;
        score = sc;
        dice = new Dice(ns);
    }

    /**
     * Get the name of the DicePlayer
     * @return the name of the DicePlayer
     */
    public String getMyName() { return name;}
    
    /**
     * Set or change the name of the DicePlayer
     * @param n - the new name of the DicePlayer
     */
    public void setMyName(String n) { name = n; }
    
    /**
     * Return the number of sides of the Dice.
     * @return the number of sides of the Dice
     */
    public int getMyDiceSides() { return dice.getSides(); }
    
    /**
     * Set or change the number of sides of the dice.
     * @param ns - the value of this DicePlayer's n-sided Dice object
     */
    public void setMyDiceSides(int ns) { dice.setSides(ns); }
    
    /**
     * Set or change the player's score back to a new value.
     * @param sc - the new value of this DicePlayer's score
     */
    public void setMyScore(int sc) { score = sc; }
    
    /**
     * Return the player's current score.
     * @return the player's score
     */
    public int getMyScore() { return score; }
    
    /**
     * Add an amount to the player's score.
     * Any negative parameter value will not add to the score.
     * @param s - the score to add
     */
    public void addMyScore(int s) { if (s>=0) {score += s; }}
    
    /**
     * Deduct an amount from the player's score.
     * Any negative parameter value will not deduct from the score.
     * @param s - the amount to deduct
     */
    public void deductMyScore(int s) {if(s>=0) {score -= s;}}
    
    /**
     * Roll the dice one time.
     * @return the result of rolling the Dice
     */
    public int rollMyDie()
    {
        return dice.roll(1);
    }
    
    /**
     * Roll the dice to generate a sum of random numbers.
     * @param times - the number of times to roll the dice
     * @return the sum of the dice rolls
     */
    public int rollMyDiceSum(int times)
    {
        return dice.roll(times);
    }
    
    /**
     * Return a String representation of the DicePlayer object.
     * @return a String in the format of "??? has ??? points."
     */
    public String toString()
    {
        return name + " has " + score + " points.";
    }
}