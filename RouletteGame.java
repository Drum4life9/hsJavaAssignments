import java.util.Scanner;
/**
 * Play a simple multi-player game of roulette. 
 * @author  M. Fleming
 * @version 23 April 2018, 14 August 2019, 3 October 2019
 */
public class RouletteGame
{
    public static Scanner input = new Scanner(System.in);
    
    // Play the game of roulette
    public static void playGame()
    {
        int moneyWon, wager, spinAgain;
        int startingMoney1, startingMoney2, startingMoney3 = 0;
        boolean thirdTurn = false, cont = false;
        
        CasinoPlayer p1 = new CasinoPlayer();
        CasinoPlayer p2 = new CasinoPlayer();
        CasinoPlayer p3 = new CasinoPlayer();
        
        displayTitle();
        
        getPlayerDetails(p1);
        getPlayerDetails(p2);
        startingMoney1 = p1.getMoney();
        startingMoney2 = p2.getMoney();
        
        System.out.print("Would you like to add a third player? (0-No, 1-Yes): ");
        int third = -1;
        third = input.nextInt();
        System.out.println('\u000C');
        if (third == 1)
        {
            input.nextLine();
            thirdTurn = true;
            getPlayerDetails(p3);
            startingMoney3 = p3.getMoney();
        }
        
        do
        {
            // Play each player's turn
            singlePlayerTurn(p1);
            singlePlayerTurn(p2);
            if (thirdTurn) singlePlayerTurn(p3);
            
            System.out.print("Spin again? (0 - No, 1 - Yes): ");
            if (input.nextInt() == 0) break;
            
            System.out.println('\u000C');
        }while(p1.getMoney() > 0 && p2.getMoney() > 0 && p3.getMoney() > 1);

        // Exit the program
        System.out.println('\u000C');
        System.out.println(p1.getName() + " entered the casino with $" + startingMoney1);
        System.out.println("and left the casino with $" + p1.getMoney());
        
        System.out.println();
        
        System.out.println(p2.getName() + " entered the casino with $" + startingMoney2);
        System.out.println("and left the casino with $" + p2.getMoney());
        if (thirdTurn)
        {
            System.out.println();
            
            System.out.println(p3.getName() + " entered the casino with $" + startingMoney3);
            System.out.println("and left the casino with $" + p3.getMoney());
        }
        System.out.println();
        System.out.println("Come back soon!");
        input.close();
    }

    /**
     * Allow a single CasinoPlayer to bet and spin the roulette wheel.
     * @param player - a CasinoPlayer object
     */
    private static void singlePlayerTurn(CasinoPlayer player)
    {
        int betChoice, bn1 = -1, bn2 = -1;
        int moneyWon, wager;
        int number, color;
        
        Wheel wheel = new Wheel();
        
        // Get the player's wager and deduct the money
        wager = enterWagerAmount(player);
        player.removeMoney(wager);
        
        // Enter the type of bet
        displayMenu(wager);
        betChoice = input.nextInt();
        
        // Enter a single number bet
        if (betChoice == 8)
        {
            System.out.println('\u000C');
            System.out.print("Enter a number (0 - 36): ");
            bn1 = input.nextInt();
            System.out.print("Enter another number (0 - 36): ");
            bn2 = input.nextInt();
        }
                
        // Spin the wheel
        wheel.spin(betChoice);
        color = wheel.getColor();
        number = wheel.getNumber();
        
        // Process the wheel results
        boolean isEven = (number%2) == 0;
        boolean is1To12 = number >= 1 && number <= 12;
        boolean is13To24 = number >= 13 && number <= 24;
        boolean is25To36 = number >= 25 && number <= 36;
        // Determine player win
        if (color == 'R' && betChoice == 1) //Bet on red
        {
            moneyWon = wager*2;
            System.out.println(player.getName() + ", you won!");
        }
        else if (color == 'B' && betChoice == 2) //Bet on black
        {
            moneyWon = wager*2;
            System.out.println(player.getName() + ", you won!");
        }
        else if (!isEven && betChoice == 3) //Bet on odd
        {
            moneyWon = wager*2;
            System.out.println(player.getName() + ", you won!");
        }
        else if (isEven && betChoice == 4) //Bet on even
        {
            moneyWon = wager*2;
            System.out.println(player.getName() + ", you won!");
        }
        else if (is1To12 && betChoice == 5) //Bet on 1-12
        {
            moneyWon = wager*3;
            System.out.println(player.getName() + ", you won!");
        }
        else if (is13To24 && betChoice == 6) //Bet on 13-24
        {
            moneyWon = wager*3;
            System.out.println(player.getName() + ", you won!");
        }
        else if (is25To36 && betChoice == 7) //Bet on 25-36
        {
            moneyWon = wager*3;
            System.out.println(player.getName() + ", you won!");
        }
        else if ((bn1 == number || bn2 == number) && betChoice == 8)
        {
            moneyWon = wager*18;
            System.out.println(player.getName() + ", you won the big bucks!");
        }
        else
        {
            moneyWon = 0;
            System.out.println("So sad, "+player.getName() + ", you lost!");
        }
        // Add money to the player's account
        player.addMoney(moneyWon);
    }
    
    /**
     * Enter the amount to be wagered.
     * @param cp - a CasinoPlayer object
     * @return the amount of money the player will wager
     */
    private static int enterWagerAmount(CasinoPlayer player)
    {
        int wager = 0;
        int playerMoney = player.getMoney();
        
        do
        {
            System.out.println(player.toString() + ".");
            System.out.print("Enter a wager amount: ");
            wager = input.nextInt();
        }while(wager > playerMoney || wager < 0);
        
        return wager;
    }

    /**
     * Enter a CasionPlayer's name and starting cash amount.
     * @param player - a CasinoPlayer
     */
    private static void getPlayerDetails(CasinoPlayer player)
    {
        String name;
        int money;
        
        // Enter players name
        System.out.print("Welcome to the Sketchy Casino! Please enter your name: ");
        name = input.nextLine();
        player.setName(name);
        
        // Enter player money
        System.out.print("Welcome, " + player.getName() + ". Enter money to wager: ");
        money = input.nextInt();
        player.addMoney(money);
        input.nextLine();
        
        System.out.println('\u000C');
        // Confirm the player's name and money
        System.out.println(player.toString() + "! Good luck!");
        System.out.println();
    }
    
    /**
     * Display the betting menu.
     * @param w - the amount to wager
     */
    private static void displayMenu(int w)
    {
        System.out.println("You have wagered $" + w + ".  Choose how to play!");
        System.out.println("    1 - Bet on red               2:1");
        System.out.println("    2 - Bet on black             2:1");
        System.out.println("    3 - Bet on odd               2:1");
        System.out.println("    4 - Bet on even              2:1");
        System.out.println("    5 - Bet on 1 - 12            3:1");
        System.out.println("    6 - Bet on 13 - 24           3:1");
        System.out.println("    7 - Bet on 25 - 36           3:1");
        System.out.println("    8 - Bet on a single number  36:1");
        System.out.print("Enter your selection: ");
    }
    
    /**
     * Display the game title.
     */
    private static void displayTitle()
    {
        System.out.println();
        System.out.println("********************************************");
        System.out.println("*****   S K E T C H Y    C A S I N O   *****");
        System.out.println("*****          R O U L E T T E         *****");
        System.out.println("********************************************");
        System.out.println();
    }
}