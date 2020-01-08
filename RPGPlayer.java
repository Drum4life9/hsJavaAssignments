/**
 * The RPGPlayer class repesents a player for a roll-playing game.
 * @author Brian Myers 
 * @version Oct. 31 2019
 */
public class RPGPlayer
{
    private String playerClass;
    private int hitPoints;
    /**
     * Construct a default RPG Player object whose
     * playerClass is blank and HP is 0.
     */
    public RPGPlayer()
    {
        playerClass = "";
        hitPoints = 0;
    }
    
    /**
     * Construct an initialized RPG player object.
     * @param pc the player class
     * @param hp the hit points
     */
    public RPGPlayer(String pc, int hp)
    {
        playerClass = pc;
        hitPoints = hp;
    }
    
    /**
     * Return the RPG Player's hit points.
     * @return the RPG Player's hit points
     */
    public int getHp()
    {
        return hitPoints;
    }
    
    /**
     * Return the RPG Player's class
     * @return the RPG Player's class
     */
    public String getPlayerClass()
    {
        return playerClass;
    }
    
    /**
     * Set the RPG Player's class .
     * @param pc - the class to set
     */
    public void setPlayerClass(String pc)
    {
        playerClass = pc;
    }
    
    /**
     * Set the RPG Player's hit points.
     * @param hp - the hit points
     */
    public void setHp(int hp)
    {
        hitPoints = hp;
    }
    
    /**
     * Return a String representation of the RPGPlayer object in the form 
     * playerClass: hitPoints hp.
     * @return a String representation
     */
    public String toString()
    {
        return playerClass + ": " + hitPoints + " hp";
    }
    
}