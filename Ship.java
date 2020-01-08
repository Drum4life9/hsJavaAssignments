
/**
 * The Ship class represents a ship from the game of Asteroids.  
 * @author  B Myers
 * @version 11-11-19
 */
public class Ship
{
    public static int MAX_SPEED = 100;
    public static int MAX_AMMO = 50;
    
    private double theta;
    private double speed;
    private int ammo;
    
    /**
     * Construct a default Asteroid ship whose starting angle and speed is 0, 
     * with a maximum ammount of ammunition.
     */
    public Ship()
    {
        theta = 0;
        speed = 0;
        ammo = MAX_AMMO;
    }
    
    /**
     * Turn the ship left (counter-clockwise).
     * @param degrees - the number of degrees to turn
     */
    public void turnLeft(double degrees)
    {
        theta += degrees;
        while (theta>=360)
        {
            theta -= 360;
        }
    }
    
    /**
     * Turn the ship right (clockwise).
     * @param degrees - the number of degrees to turn
     */
    public void turnRight(double degrees)
    {
        theta -= degrees;
        while (theta<0)
        {
            theta += 360;
        }
    }
    
    /**
     * Increase the ship's speed.
     * @param amount - the amount to increse the speed
     */
    public void speedUp(double amount)
    {
        speed += amount;
        if (speed > MAX_SPEED) speed = MAX_SPEED;
    }
    
    /**
     * Decrease the ship's speed.
     * @param amount - the amount to decrease the speed
     */
    public void slowDown(double amount)
    {
        speed -= amount;
        if (speed < 0) speed = 0;
    }
    
    /**
     * Use the ship's weapon to fire.
     * @return true - if there was enough ammunition the ship will fire; false otherwise
     */
    public boolean fire()
    {
        if (ammo > 0)
        {
            ammo--;
            return true;
        }  
        return false;
    }
}
