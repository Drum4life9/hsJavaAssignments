import java.awt.Color;

/**
 * The Tetromino class represents a Tetris Tetromino.
 * @author  B Myers
 * @version 12 November 2019
 */
public class Tetromino
{
    private int rotation;
    private String shape;
    private Color color;
    private boolean isFalling;
    
    /**
     * Construct a default Tetromino object.
     */
    public Tetromino()
    {
        rotation = 0;
        shape = "cube";
        color = Color.BLUE;
        isFalling = false;
    }
    
    /**
     * Construct an initialized Tetromino object whose fields are initialized
     * through parameter values.
     * @param s - the Tet. shape
     * @param c - the Tet. color
     * @param r - the Tet. rotation
     */
    public Tetromino(String s, Color c, int r, boolean f)
    {
        shape = s;
        color = c;
        setRotation(r);
        isFalling = f;
    }
    
    /**
     * Return the rotation of the Tetromino, in degrees.
     * @return the rotation of the Tetromino
     */
    public int getRotation()
    {
        return rotation;
    }
    
    /**
     * Return the Color of the Tetromino piece
     * @return the color of the Tetromnio
     */
    public Color getColor()
    {
        return color;
    }
    
    /**
     * Return the shape of the Tetromino piece
     * @return the shape of the Tetromino
     */
    public String getShape()
    {
        return shape;
    }

    /**
     * Set the Color of the Tetromino object
     * @param c - the color at which to set the object
     */
    public void setColor(Color c)
    {
        color = c;
    }
    
    /**
     * Set the shape of the Tetromino object
     * @param s - the shape to set the Tetromino object
     */
    public void setShape(String s)
    {
        shape = s;
    }
    
    /**
     * Set the current rotation, either 0, 90, 180, or 270 degrees, of the Tetromino
     * @param r - the rotation amount, in degrees
     */
    public void setRotation(int r)
    {
        if (r >= 0 && r < 90) rotation = 0;
        else if (r >= 90 && r < 180) rotation = 90;
        else if (r >= 180 && r < 270) rotation = 180;
        else rotation = 270;
    }
    
    /**
     * Rotate the Tetromino counter-clockwise
     * @param times - the number of times to rotate
     */
    public void rotate(int times)
    {
        int degreesToRotate = times * 90;
        rotation += degreesToRotate;
        while (rotation >= 360)
        {
            rotation -= 360;
        }
    }
    
    /**
     * Change the value of isFalling to true or false, depending on what it is
     */
    public void changeIsFalling()
    {
        isFalling = !isFalling;
    }
}
