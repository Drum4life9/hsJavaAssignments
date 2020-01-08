import java.awt.Color;

/**
 * The Ghost class represents a Ghost object from the game of Pac-Man. 
 * @author  M. Fleming
 * @version 9 October 2019
 */
public class Ghost
{
    private Color normalColor;
    private Color currentColor;
    private boolean canEat;
    private double speed;
    
    /**
     * Construct an initialized Ghost object whose normal color and 
     * eatable state are set by parameter values.
     * @param nc - the normal ghost color
     * @param ce - the eatable state of the ghost
     */
    public Ghost(Color nc, boolean ce)
    {
        canEat = ce;
        
        setColor(nc);
    }
    
    /**
     * Set or change the current ghost color.
     * @param c - the new color to set to the ghost
     */
    public void setColor(Color c)
    {
        normalColor = c;
        
        if (canEat) currentColor = Color.BLUE.darker();
        else currentColor = normalColor;
    }
    
    /**
     * Return the current color of the ghost.
     * @return the ghost's current color
     */
    public Color getColor()
    {
        return currentColor;
    }
    
    /**
     * Return the current speed of the ghost.
     * @return the ghost's current speed
     */
    public double getSpeed()
    {
         return speed;
    }
    
    /**
     * Set the speed of the ghosts.  Ghosts will travel at a slower speed 
     * when they can be eaten and travel at normal speed when they cannot.
     */
    public void setSpeed()
    {
        if (canEat) speed = 10;
        else speed = 20;
    }
    
    /**
     * Change the ghost's eatable state due to the consumption of a 
     * power pellete.
     * @param atePellet - lets the ghost know that pac-man ate a pellet
     */
    public void changeEatable(boolean atePellet)
    {
        if (atePellet) canEat = true;
        else canEat = false;
        
        setColor(normalColor);
        setSpeed();
    }
}
