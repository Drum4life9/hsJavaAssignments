/**
 * A SRoom object within the maze. 
 * @author  Brian Myers
 * @version 15 November 2019
 */
public class SRoom extends HH2
{
    private SRoom north, south, east, west;
    private boolean inMaze, isSecret;
    private String color, description;
    
    /**
     * Construct a default SRoom object with all directions set to null,  
     * color set to white, descrption set to empty, and inMaze set to true.  
     * Use the setter methods to set these variables.
     */
    public SRoom()
    {
        north = null;
        south = null;
        east = null;
        west = null;
        inMaze = true;
        isSecret = false;
    }
    
    // The "SETTER" methods
    /**
     * Set the state of the current room as in the maze or out of the maze.
     * @param im pass as true if the current room is in the maze; false otherwise
     */
    public void setInMaze(boolean im)
    {
        inMaze = im;
    }
    
    /**
     * Set the description of an item in the corner of the room.  This will help to 
     * distinguish one room from another, especially if they have equal colors.
     * @param d the description of an item in the corner of the room
     */
    public void setCornerDesc(String d)
    {
        description = d;
    }
    
    /**
     * Set the color of the room.
     * @param c the color of the room, as a string
     */
    public void setColor(String c)
    {
        color = c;
    }
    
    /**
     * Set the room to the north of the current room.
     * @param n the room to the north of the current room
     */
    public void setNorth(SRoom n)
    {
        north = n;
    }
    
    /**
     * Set the room to the east of the current room.
     * @param e the room to the east of the current room
     */
    public void setEast(SRoom e)
    {
        east = e;
    }
    
    /**
     * Set the room to the south of the current room.
     * @param s the room to the south of the current room
     */
    public void setSouth(SRoom s)
    {
        south = s;
    }
    
    /**
     * Set the room to the west of the current room.
     * @param w the room to the west of the current room
     */
    public void setWest(SRoom w)
    {
        west = w;
    }
    
    public void setSecret(boolean is) {isSecret = is;}
    
    
    // The "GETTER" methods
    /**
     * Return the state of the current room as in or out of the maze.
     * @return true if the current room is in the maze; false otherwise
     */
    public boolean getInMaze()
    {
        return inMaze;
    }
    
    /**
     * Return a description of items in the corner of the room.
     * @return a room description
     */
    public String getCornerDesc()
    {
        return description;
    }
    
    /**
     * Return the color of the current room.
     * @return the room's color
     */
    public String getColor()
    {
        return color;
    }
    
    /**
     * Return the room to the north of the current room.
     * @return  the room to the north of the current room,
     *          or null if there is no room north.
     */
    public SRoom getNorth() { return north; }
    
    /**
     * Return the room to the east of the current room.
     * @return  the room to the east of the current room,
     *          or null if there is no room east.
     */    
    public SRoom getEast() { return east; }
    
    /**
     * Return the room to the south of the current room.
     * @return  the room to the south of the current room,
     *          or null if there is no room south.
     */
    public SRoom getSouth() { return south; }
    
    /**
     * Return the room to the west of the current room.
     * @return  the room to the west of the current room,
     *          or null if there is no room west.
     */    
    public SRoom getWest() { return west; }
    
    /**
     * Make secret room
     */
    public boolean getIsSecret() {return isSecret;}
    
    
    // The "OTHER" methods
    /**
     * Determine whether or not the player can go in the direction to 
     * get the an adjacent room
     * @param aRoom - the adjacent room to move to
     * @return true if the player can move to the room; false otherwise
     */
    public boolean canGoDir(SRoom aRoom)
    {
        return aRoom != null && aRoom.getIsSecret();
    }
    
    /**
     * Return a String representation of the SRoom object.
     * @param aRoom the room to move to, check to see is secret
     * @return a String representation of the SRoom object.
     */
    public String toString(SRoom aRoom)
    {   
        String s = "\n";
        
        s += "You are in a " + getColor() + " room. ";
        s += "In the corner is a " + getCornerDesc() + ".\n";
        s += "Open doors are to the: ";
        
        if (canGoDir(north) && aRoom.isSecret) s += "north  ";
        if (canGoDir(south) && aRoom.isSecret) s += "south  ";
        if (canGoDir(east) && aRoom.isSecret) s += "east  ";
        if (canGoDir(west) && aRoom.isSecret) s += "west  ";

        return s;
    }
}
