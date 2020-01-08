import java.util.Random;

/**
 * This class simulates a roulette wheel. 
 * @author  M. Fleming
 * @version 23 April 2018; 14 August 2018
 */
public class Wheel
{
    private int[] numbers;
    private char[] colors;
    private int ball;
    
    /**
     * Construct a Wheel object that simulates a roulette wheel.
     */
    public Wheel()
    {
        initializeNumbers();
        initializeColors();
    }
    
    /**
     * Spin the wheel.
     * @param bc - the bet choice (to display the bet when the wheel spins)
     * @return the color and number which the ball lands on
     */
    public String spin(int bc)
    {
        Random generate = new Random();
        int milliseconds = 25;
        String wager = "??";
        
        if (bc == 1) wager = "red.";
        else if (bc == 2) wager = "black.";
        else if (bc == 3) wager = "odds.";
        else if (bc == 4) wager = "evens.";
        else if (bc == 5) wager = "1 through 12.";
        else if (bc == 6) wager = "13 through 24.";
        else if (bc == 7) wager = "25 through 36.";
        else if (bc == 8) wager = "two exact numbers.";
        
        for (int i = 0; i <= generate.nextInt(10) + 20; i++)
        {
            printWheel(ball, wager);
            
            milliseconds = milliseconds + 25;
            delay(milliseconds);
            
            ball++;
            if (ball == 37) ball = 0;
        }
        
        return "" + getNumber() + getColor();
    }
    
    /**
     * Return the number on which the ball lands.
     * @return the number on which the ball lands
     */
    public int getNumber()
    {
        int number = numbers[ball];
        return numbers[ball];
    }
    
    /**
     * Return the color on which the ball lands.
     * @return the color on which the ball lands
     */
    public char getColor()
    {
        char color = colors[ball];
        return colors[ball];
    }
    
    /**
     * Initialize the numbers array, from 0 to 36.
     */
    private void initializeNumbers()
    {
        numbers = new int[37];
        
        numbers[0] = 0;     numbers[12] = 13;   numbers[24] = 20;
        numbers[1] = 32;    numbers[13] = 36;   numbers[25] = 14;
        numbers[2] = 15;    numbers[14] = 11;   numbers[26] = 31;
        numbers[3] = 19;    numbers[15] = 30;   numbers[27] = 9;
        numbers[4] = 4;     numbers[16] = 8;    numbers[28] = 22;
        numbers[5] = 21;    numbers[17] = 23;   numbers[29] = 18;
        numbers[6] = 2;     numbers[18] = 10;   numbers[30] = 29;
        numbers[7] = 25;    numbers[19] = 5;    numbers[31] = 7;
        numbers[8] = 17;    numbers[20] = 24;   numbers[32] = 28;
        numbers[9] = 34;    numbers[21] = 16;   numbers[33] = 12;
        numbers[10] = 6;    numbers[22] = 33;   numbers[34] = 35;
        numbers[11] = 27;   numbers[23] = 1;    numbers[35] = 3;
        numbers[36] = 26;
    }
    
    /**
     * Initialize the colors array.
     */
    private void initializeColors()
    {
        colors = new char[37];
        
        colors[0] = '0';    colors[13] = 'R';    colors[26] = 'B';
        colors[1] = 'R';    colors[14] = 'B';    colors[27] = 'R';
        colors[2] = 'B';    colors[15] = 'R';    colors[28] = 'B';
        colors[3] = 'R';    colors[16] = 'B';    colors[29] = 'R';
        colors[4] = 'B';    colors[17] = 'R';    colors[30] = 'B';
        colors[5] = 'R';    colors[18] = 'B';    colors[31] = 'R';
        colors[6] = 'B';    colors[19] = 'R';    colors[32] = 'B';
        colors[7] = 'R';    colors[20] = 'B';    colors[33] = 'R';
        colors[8] = 'B';    colors[21] = 'R';    colors[34] = 'B';
        colors[9] = 'R';    colors[22] = 'B';    colors[35] = 'R';
        colors[10] = 'B';   colors[23] = 'R';    colors[36] = 'B';
        colors[11] = 'R';   colors[24] = 'B';
        colors[12] = 'B';   colors[25] = 'R';
    }
    
    /**
     * Print ten numbers from the roulette wheel.
     * @param b - the starting location of the ball
     * @param w - the wager
     */
    private void printWheel(int b, String w)
    {
        // Clear the console window
        System.out.print('\u000C');
        System.out.println("You bet on " + w);
        
        // Print the top line of the wheel
        System.out.print("|   ---    *    ---   ---");
        System.out.print("   ---   ---   ---   ---");
        System.out.println("   ---   ---   ---  |");
        
        // Print the middle line with numbers of the wheel
        for (int j = 0; j <= 10; j++)
        {
            System.out.printf("%5d", numbers[b]);
            System.out.print(colors[b]);
                
            b++;
            if (b == 37) b = 0;
        }
        
        // Print the bottom line of the wheel.
        System.out.print("\n|   ---    *    ---   ---");
        System.out.print("   ---   ---   ---   ---");
        System.out.println("   ---   ---   ---  |");
    }
    
    /**
     * Delay the program by m miliseconds.
     * @param ms - the number of miliseconds to delay
     */
    private void delay(int ms)
    {
        try{Thread.sleep(ms);}
        catch (InterruptedException e){};
    }
}