import java.util.Scanner;


/**
 * The Escape Engine generates a "maze-like" house with rooms.  It then 
 * controls game play to allow players to find their way out of the house.
 * @author  B. Myers
 * @version 18 November 2019
 */
public class HH2
{
    // Create the blank room objects for the house.
    public static SRoom room1 = new SRoom();      public static SRoom room2 = new SRoom();
    public static SRoom room3 = new SRoom();      public static SRoom room4 = new SRoom();
    public static SRoom room5 = new SRoom();      public static SRoom room6 = new SRoom();
    public static SRoom room7 = new SRoom();      public static SRoom room8 = new SRoom();
    public static SRoom room9 = new SRoom();      public static SRoom room10 = new SRoom();
    public static SRoom room11 = new SRoom();     public static SRoom room12 = new SRoom();
    public static SRoom room13 = new SRoom();     public static SRoom room14 = new SRoom();
    public static SRoom room15 = new SRoom();     public static SRoom room16 = new SRoom();
    public static SRoom room17 = new SRoom();     public static SRoom room18 = new SRoom();
    public static SRoom room19 = new SRoom();     public static SRoom room20 = new SRoom();
    
    public static SRoom end = new SRoom();        public static SRoom currentSRoom;
   
    
    public static void runEngine()
    {
        Scanner input = new Scanner(System.in);
        String direction;
        
        // Build the rooms to the house and set the current room.
        buildRooms();
        currentSRoom = room1;
        
        displayTitle();
        
        // Loop until the player exits the house
        do
        {
            //Get the adjacent rooms
            SRoom northOf = currentSRoom.getNorth();
            SRoom eastOf = currentSRoom.getEast();
            SRoom southOf = currentSRoom.getSouth();
            SRoom westOf = currentSRoom.getWest();
            
            // Determine the direction of each room
            boolean canGoNorth = currentSRoom.canGoDir(northOf);
            boolean canGoEast = currentSRoom.canGoDir(eastOf);
            boolean canGoSouth = currentSRoom.canGoDir(southOf);
            boolean canGoWest = currentSRoom.canGoDir(westOf);
            
            //Get direction to travel
            System.out.println(currentSRoom.toString(currentSRoom));
            System.out.print("Enter the direction to go: ");
            direction = input.nextLine();
            
            
            // Set the current room to the new room
            if (canGoNorth && direction.equals("north")) currentSRoom = northOf;
            else if (canGoEast && direction.equals("east")) currentSRoom = eastOf;
            else if (canGoSouth && direction.equals("south")) currentSRoom = southOf;
            else if (canGoWest && direction.equals("west")) currentSRoom = westOf;
            else System.out.println("Your location did not change!");

        }while(currentSRoom.getInMaze());
        
        
        System.out.println("You have escaped the house!");
    }
    
    /**
     * Build each room of the house.
     */
    private static void buildRooms()
    {
        //Room 1 test
        room1.setNorth(room2);
        
        //Room 2 test
        room2.setSecret(true);

        
        end.setInMaze(false);
    }
    
    /**
     * Display the title using ASCII art and escape keys.
     * @see https://www.asciiart.eu/buildings-and-places/houses
     */
    private static void displayTitle()
    {
        System.out.println("Escape the Haunted House");
        System.out.println("              ':.");
        System.out.println("         []_____");
        System.out.println("        /\\      \\");
        System.out.println("    ___/  \\__/\\__\\__");
        System.out.println("---/\\___\\ |''''''|__\\-- ---");
        System.out.println("   ||'''| |''||''|''|");
        System.out.println("   ``\"\"\"`\"`\"\"))\"\"`\"\"`\"");
        System.out.println();
        System.out.println("Commands: ");
        System.out.println("Type in (direction) to move");
        System.out.println("Type in 'inv' to check inventory");
        System.out.println("Type in 'interact' to check if there is anything to interact with");
        System.out.println("If it is required, type in an answer to guess");
        
    }
    
}
