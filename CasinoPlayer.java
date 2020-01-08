/**
 * A Casino Player has money to use at the casino. 
 * @author  M. Fleming
 * @version 14 August 2018
 */
public class CasinoPlayer
{
    private String name;
    private int money;
    
    /**
     * Construct an default CasinoPlayer object with $10 of complimentary chips, 
     * and no name.
     */
    public CasinoPlayer()
    {
        name = "";
        money = 0;
    }
    
    /**
     * Add money to the Casino Player.  The method will not 
     * add any money of parameter is negative.
     * @param m - a positive amount of money to add
     */
    public void addMoney(int m)
    {
        if (m > 0) money = money + m;
    }
    
    /**
     * Remove money from the Casino Player.  The method will 
     * not remove any money of parameter is negative.
     * @param m - a positive amount of money to remove
     */
    public void removeMoney(int m)
    {
        if (m > 0) money = money - m;
    }
    
    /**
     * Return the current amount of money, as an integer,  
     * the Casino Player has.
     * @return the current amount of money
     */
    public int getMoney()
    {
        return money;
    }

    /**
     * Set or change the CasinoPlayer's name.
     * @param n - the CasinoPlayer's name
     */
    public void setName(String n)
    {
        name = n;
    }
    
    /**
     * Get the CasinoPlayer's name.
     * @return the CasinoPlayer's name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Return the current amount of money, as a String, 
     * the Casino Player has.
     * @return the amojnt of money, with a dollar sign
     */
    public String toString()
    {
        return name + " has $" + money;
    }
}