import java.util.Scanner;


/**
 * The Escape Engine generates a "maze-like" house with rooms.  It then 
 * controls game play to allow players to find their way out of the house.
 * @author  B. Myers
 * @version 18 November 2019
 */
public class HauntedHouseEngine
{
    // Create the blank room objects for the house.
    public static Room room1 = new Room();      public static Room room2 = new Room();
    public static Room room3 = new Room();      public static Room room4 = new Room();
    public static Room room5 = new Room();      public static Room room6 = new Room();
    public static Room room7 = new Room();      public static Room room8 = new Room();
    public static Room room9 = new Room();      public static Room room10 = new Room();
    public static Room room11 = new Room();     public static Room room12 = new Room();
    public static Room room13 = new Room();      public static Room room14 = new Room();
    public static Room room15 = new Room();      public static Room room16 = new Room();
    public static Room room17 = new Room();      public static Room room18 = new Room();
    public static Room room19 = new Room();      public static Room room20 = new Room();
    
    public static Room end = new Room();        public static Room currentRoom;
    //special booleans.....
    public static boolean hasKey = false;       public static boolean hasBatteries = false;
    public static boolean isDead = false;    
    public static boolean hasSword = false;     public static boolean hasFlashlight = false;
    
    public static void runEngine()
    {
        //reset the variables
        hasKey = false;
        isDead = false;
        hasSword = false;
        hasBatteries = false;
        hasFlashlight = false;
        
        Scanner input = new Scanner(System.in);
        String direction;
        
        // Build the rooms to the house and set the current room.
        buildRooms();
        currentRoom = room18;
        
        displayTitle();
        
        // Loop until the player exits the house
        do
        {
            //Get the adjacent rooms
            Room northOf = currentRoom.getNorth();
            Room eastOf = currentRoom.getEast();
            Room southOf = currentRoom.getSouth();
            Room westOf = currentRoom.getWest();
            
            // Determine the direction of each room
            boolean canGoNorth = currentRoom.canGoDir(northOf);
            boolean canGoEast = currentRoom.canGoDir(eastOf);
            boolean canGoSouth = currentRoom.canGoDir(southOf);
            boolean canGoWest = currentRoom.canGoDir(westOf);
            
            //Get direction to travel
            System.out.println(currentRoom);
            System.out.print("Enter the direction to go: ");
            direction = input.nextLine();
            
            
            // Set the current room to the new room
            if (canGoNorth && direction.equals("north")) currentRoom = northOf;
            else if (canGoEast && direction.equals("east")) currentRoom = eastOf;
            else if (canGoSouth && direction.equals("south")) currentRoom = southOf;
            else if (canGoWest && direction.equals("west")) currentRoom = westOf;
            else System.out.println("Your location did not change!");
            
            if (currentRoom == room5)
            {
                if (!hasFlashlight)
                {
                    room5.setCornerDesc("flashlight, with no batteries (you pick it up)");
                    hasFlashlight = true;
                }
                else
                {
                    room5.setCornerDesc("space where the flashlight was");
                }
            }
            
            if (currentRoom == room1)
            {
                if (hasFlashlight && hasBatteries)
                {
                    DnDEnc();
                    room1.setCornerDesc("empty space where the goblin sat");
                }
                else room1.setCornerDesc("random object, but there is no light");
            }
            
            if ((currentRoom == room14 && !hasKey) || currentRoom == room19)
            {
                hasKey = false;
                hasSword = false;
                hasBatteries = false;
                hasFlashlight = false;
                }
            
            if (hasKey)
            {
                room20.setEast(end);
                room14.setNorth(room20);
                room14.setCornerDesc("sign, saying \"The exit is now north\"");
            }
            else 
            {
                room14.setCornerDesc("sign, saying \"You will be reset in 3, 2, 1...\"");
                room14.setNorth(null);
            }
            
            if (currentRoom == room8)
            {
                if (!hasBatteries)
                {
                    room8.setCornerDesc("set of AA batteries (you pick them up)");
                    hasBatteries = true;
                }
                else
                {
                    room8.setCornerDesc("space where the AA batteries were");
                }
            }
            
            if (currentRoom == room12)
            {
                if (!hasSword)
                {
                    room12.setCornerDesc("shiny sword, which you can barely handle (you pick it up)");
                    hasSword = true;
                }
                else room12.setCornerDesc("space where the shiny sword sat");
            }
            
            if (currentRoom==room2 || currentRoom==room16)
            {
                System.out.println();
                System.out.println("As you walk into the room, all the doors close. Spikes fall from the ceiling. You are dead.");
                isDead = true;
                break;
            }
            
        }while(currentRoom.getInMaze() && !isDead);
        
        
        if (!isDead) System.out.println("You have escaped the house!");
    }
    
    /**
     * Build each room of the house.
     */
    private static void buildRooms()
    {
        // Room 18 - Red w/ exist north
        room18.setColor("red");
        room18.setNorth(room1);
        room18.setCornerDesc("sign, saying \"Start here\"");
        
        // Room 1 - Yellow w/ exits west, east, south, and north
        room1.setColor("yellow");
        room1.setEast(room2);
        room1.setWest(room3);
        room1.setSouth(room18);
        room1.setNorth(room10);
        
        // Room 3 - Blue w/ exits north and east
        room3.setColor("blue");
        room3.setEast(room1);
        room3.setNorth(room4);
        room3.setCornerDesc("staircase, leading to the next floor");
        
        
        // Room 4 - Orange w/ exits north, south, east, and west
        room4.setColor("orange");
        room4.setEast(room6);
        room4.setNorth(room5);
        room4.setWest(room3);
        room4.setSouth(room2);
        room4.setCornerDesc("staircase leading downstairs");
        
        // Room 5 - Yellow w/ flashlight, and exits east, south, and west
        room5.setColor("yellow");
        room5.setEast(room11);
        room5.setSouth(room4);
        room5.setWest(room16);
        
        
        // Room 6 - Green w/ exits north, east, west, and south
        room6.setColor("green");
        room6.setNorth(room16);
        room6.setEast(room10);
        room6.setSouth(room7);
        room6.setWest(room4);
        room6.setCornerDesc("unsolved Rubik's cube, driving you crazy");
        
        //Room 7 - Chartruce w/ exits in all directions
        room7.setColor("Chartruce");
        room7.setNorth(room6);
        room7.setWest(room8);
        room7.setEast(room6);
        room7.setSouth(room6);
        room7.setCornerDesc("scary looking Fleming");
        
        // Room 8 - purple w/ the batteries, and exits all directions
        room8.setColor("purple");
        room8.setNorth(room11);
        room8.setEast(room7);
        room8.setSouth(room2);
        room8.setWest(room9);
        
        // Room 9 - white w/ exit east
        room9.setColor("white");
        room9.setEast(room7);
        room9.setCornerDesc("sign saying \"Ha! Tricked you\"");
        
        // Room 10 - grey w/ exits south and north
        room10.setColor("grey");
        room10.setNorth(room15);
        room10.setSouth(room1);
        room10.setCornerDesc("spider");
        
        // Room 11- Black w/ west
        room11.setColor("black");
        room11.setWest(room13);
        room11.setCornerDesc("sign, saying \"You have made a 'grave' mistake coming here....\"");
        
        //Room 12 - shiny blue w/ sword and exit north and east
        room12.setColor("shiny blue");
        room12.setNorth(room15);
        room12.setEast(room16);
        
        //Room 13 - dark grey w/ exit west
        room13.setColor("dark grey");
        room13.setWest(room14);
        room13.setCornerDesc("sign, saying \"I think its fun to reset your progress, even your objects. Unless you have the key....\"");
        
        //Room 14 - brown w/ exits west and south
        room14.setColor("brown");
        room14.setWest(room2);
        room14.setSouth(room18);
        
        //Room 15 - magenta w/ exits north, west, and south
        room15.setColor("magenta");
        room15.setNorth(room13);
        room15.setWest(room10);
        room15.setSouth(room12);
        room15.setCornerDesc("map, ripped to shreds");
        
        //room 17 - white, with exits east
        room17.setColor("white");
        room17.setEast(room19);
        room17.setCornerDesc("sign, saying \"You were so close. Try east next time. Now you are being reset (including objects). Great job...\"");
        
        //Room 19 - dull green with exit south
        room19.setColor("dull green");
        room19.setSouth(room18);
        room19.setCornerDesc("sign, saying \"Good luck getting through this again.\"");
        
        // Room 20 - bright pink w/ exits all directions, east being the real exit
        room20.setColor("bright pink");
        room20.setNorth(room17);
        room20.setSouth(room17);
        room20.setWest(room11);
        room20.setCornerDesc("sign, saying \"Which way is it??\"");
        room20.setEast(end);

        
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
    }
    
    private static void DnDEnc()
    {   
        //add scanner and clear screen
        Scanner input = new Scanner(System.in);
        System.out.println('\u000C');
        //create a new dice object
        DnDDice dice = new DnDDice();
        int playerIni;
        int goblinIni;
        
        //other stats
        int gobHP = 20;
        int playerHP = 20;
        int damage;
        //set player and goblin initiatives
        do
        {
            playerIni = dice.roll(20);
            goblinIni = dice.roll(20);
        }while(playerIni==goblinIni);
        
        //Provide backstory
        System.out.println();
        System.out.print("As you shine a light in the room, ");
        System.out.print("you see a goblin hiding in the corner. \nIt seems to ");
        System.out.print("be holding a key. It advances toward you, in a D&D style ");
        System.out.print("fashion. \n");
        System.out.println("You roll for initiative, and roll a " + playerIni + ".");
        System.out.println("The goblin rolls a " + goblinIni + ".");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Fight starts: -----------------");
        System.out.println();
        System.out.println();
        System.out.println();
        
        do
        {
            if (playerIni > goblinIni)
            {
                //set goblin and player Armor class points (player turn)
                int goblinAc = 10;
                int playerAttack = dice.roll(20);
                
                //player hits
                if (playerAttack > goblinAc)
                {
                    System.out.println("You rolled a " + playerAttack + ", which breaks the goblin AC");
                    if (hasSword)
                    {
                        System.out.print("You have a sword, it does 1d8 piercing damage.");
                        damage = dice.roll(8);
                        System.out.println("\nYou deal " + damage + " damage.");
                        gobHP -= damage;
                        if (gobHP <=0)
                        {
                            break;
                        }
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println("Next turn: ----------------------");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    }
                    else 
                    {
                        System.out.println("You don't have a sword! You have to punch, 1d4 damage.");
                        damage = dice.roll(4);
                        System.out.println("\nYou deal " + damage + " damage.");
                        gobHP -= damage;
                        if (gobHP <=0)
                        {
                            break;
                        }
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println("Next turn: ----------------------");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    }
                }
                //player misses
                else
                {
                    System.out.println("You rolled a " + playerAttack + ", which was less than the goblin AC");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("Next turn: ----------------------");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                }
                
                //goblin turn
                //set goblin and player Armor class points
                int playerAc = 14;
                int goblinAttack = dice.roll(20);
                
                //goblin hits
                if (goblinAttack > playerAc)
                {
                    System.out.println();
                    System.out.println();
                    System.out.println("The goblin rolled a " + goblinAttack + ", which breaks your AC");
                    System.out.print("It has a dagger, which does 1d12 piercing damage.");
                    damage = dice.roll(12);
                    System.out.println("\nThe goblin deals " + damage + " damage.");
                    playerHP -= damage;
                    System.out.println("You now have " + playerHP + " hit point(s)");
                    if (playerHP <= 0) 
                    {
                        isDead = true; 
                        break;
                    }
        
                }
                else
                {
                    System.out.println("The goblin rolled a " + goblinAttack + ", which was less than your AC");
                    
                }
                if (playerHP <= 0) 
                    {
                        isDead = true; 
                        break;
                    }
            }
            else
            {
                //goblin turn
                //set goblin and player Armor class points
                int playerAc = 14;
                int goblinAttack = dice.roll(20);
                
                //goblin hits
                if (goblinAttack > playerAc)
                {
                    System.out.println("The goblin rolled a " + goblinAttack + ", which breaks your AC");
                    System.out.print("It has a dagger, which does 1d12 piercing damage.");
                    damage = dice.roll(12);
                    System.out.println("\nThe goblin deals " + damage + " damage.");
                    playerHP -= damage;
                    System.out.println("You now have " + playerHP + " hit point(s)");
                    if (playerHP <= 0) 
                    {
                        isDead = true; 
                        break;
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("Next turn: ----------------------");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();    
        
                }
                else
                {
                    System.out.println("The goblin rolled a " + goblinAttack + ", which was less than your AC");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("Next turn: ----------------------");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                }
                if (playerHP <= 0) 
                    {
                        isDead = true; 
                        break;
                    }
                //set goblin and player Armor class points (player turn)
                int goblinAc = 10;
                int playerAttack = dice.roll(20);
                
                //player hits
                if (playerAttack > goblinAc)
                {
                    System.out.println("You rolled a " + playerAttack + ", which breaks the goblin AC");
                    if (hasSword)
                    {
                        System.out.print("You have a sword, it does 1d8 piercing damage.");
                        damage = dice.roll(8);
                        System.out.println("\nYou deal " + damage + " damage.");
                        gobHP -= damage;

                    }
                    else 
                    {
                        System.out.println("You don't have a sword! You have to punch, 1d4 damage.");
                        damage = dice.roll(4);
                        System.out.println("\nYou deal " + damage + " damage.");
                        gobHP -= damage;
                        if (gobHP <=0)
                        {
                            break;
                        }

                    }
                }
                //player misses
                else
                {
                    System.out.println("You rolled a " + playerAttack + ", which was less than the goblin AC");

                }
            }
            
            //check if the player is dead
            if (playerHP <= 0) isDead = true;
            
            //space
            System.out.println();
            System.out.println();
            System.out.println();
            //let player read, and enter 1 to continue
            String choice = "";
            do
            {
                System.out.print("Enter 1 to continue: ");
                choice = input.nextLine();
            }while(!(choice.equals("1")));
            
            //clear screen after turn
            System.out.println('\u000C');
            
        }while(!isDead && gobHP > 0);
        if (playerHP <= 0) 
        {
            System.out.println("You died! The goblin killed you");
            isDead = true;
        }
        else
        {
            System.out.println("You killed the goblin and received the key!");
            hasKey = true;
        }
                    
        
    }
}