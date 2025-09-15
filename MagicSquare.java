import java.util.ArrayList;

/**
 * The Magic Square class will generate n x n magic squares.
 * @author Urvish Patel, Brian Myers
 * @version 02/24/2021
 */
public class MagicSquare
{
  // Static Class Variable - Shared by all MagicSquare objects
  public static int attempts;

  
  public void runMethod ()
  {
    for (int i = 0; i < 3; i++)
    {
    attempts = 0;
    do
    {
      initializeSquare();
      if (attempts > 255000000) 
      {
          System.out.println("Not minimum yet" + "\n");
          
          break;
      }
    }while(!isMagicSquare());
    System.out.println(toString());
    System.out.println("Attempts to generate: " + String.format("%,d", getAttempts()));
}
  }
  // Static Method - May be used without a MagicSquare object
  public static int getAttempts()
  {
    return attempts;
  }

  // Class Variable - One copy for each MagicSquare object
  private int dimension;
  private int[][] square;

  /**
   * Construct a default 3 x 3 MagicSquare.
   */
  public MagicSquare()
  {
    this(9);
  }

  /**
   * Construct a MagicSquare with a given number of squares.
   * Pre-condition: The parameter must be a perfect square
   * @param numSquares - The number of squares in the MagicSquare
   */ 
  public MagicSquare(int n)
  {
    dimension = (int)(Math.sqrt(n));
    square = new int[dimension][dimension];
    attempts = 0;
  }

  /**
   * Create a table as a string to output the magic square.
   * @return a string used to output the magic square
   */
  public String toString()
  {
    String s = ""; 
    for (int[] list : square) 
    {
      for (int e : list)
      {
        s += e + "\t"; 
      }
      s += "\n";
    }
    return s;
  }

  /** 
   * Initialize the elements of the MagicSquare with randomly 
   * selected values from 1 through the maximum number.
   */
  public void initializeSquare()
  {
    
    ArrayList<Integer> lis = new ArrayList<Integer>();
    for (int i = 1; i <= (int)(Math.pow(dimension, 2)); i++)
    {
      lis.add(i);
    }
    
    /**
    for (int i = 0; i < lis.length; i++)
    {
      int ind =  i + (int)((Math.random() * (lis.length)));
      int temp = lis[ind];
      lis[ind] = lis[i];
      lis[i]= temp;
    }
    **/
    
    for (int r = 0; r < square.length; r++)
    {
      for (int c = 0; c < square[r].length; c++)
      {
        int ind = (int)(Math.random() * (lis.size()));
        square[r][c] = lis.remove(ind);
      }
    }
    attempts++;
  }

  /**
   * The Magic Constant is the number that all rows, columns, and 
   * diagonals must sum to the same value.
   * @return the magic constant of an n x n magic square
   */
  public int getMagicConstant()
  {
    if (dimension % 2 == 0)
    {
      return (int)(Math.pow(dimension, 2) + 1) * dimension / 2;
    }
    else
    {
      return (int)(Math.pow(dimension, 2) + 1)/2 * dimension;
    }
  }

  /**
   * A helper method that will sum the elements of a given row.
   * @param the row number from 0 <= row < row.length
   * @return the sum of the elements in the row
   */
  public int sumRow(int row)
  {
    int sum = 0;
    for (int e : square[row])
    {
      sum += e;
    }
    return sum;
  }


  /**
   * A helper method that will sum the elements of a given column.
   * @param the column number from 0 <= col < col.length
   * @return the sum of the elements in the col
   */
  public int sumColumn(int col)
  {
    int sum = 0;
    for (int[] list : square)
    {
      sum += list[col];
    }
    return sum;
  }

  /**
   * Determine whether or not the sum of each row adds up 
   * to the magic constant.
   * @return true if the sum of all rows is the magic constant; 
   *         false otherwise
   */
  public boolean checkRowSums()
  {
    int cons = getMagicConstant();

    for (int r = 0; r < square.length; r++)
    {
      if (sumRow(r) != cons) return false;
    }

    return true;
  }

  /**
   * Determine whether or not the sum of each column adds up 
   * to the magic constant.
   * @return true if the sum of all columns is the magic constant; 
   *         false otherwise
   */
  public boolean checkColumnSums()
  {
    int cons = getMagicConstant();

    for (int c = 0; c < square[0].length; c++)
    {
      if (sumColumn(c) != cons) return false;
    }

    return true;
  }

  /**
   * Determine whether or not the sum of each diagonal adds up 
   * to the magic constant.
   * @return true if the sum of each diagonal is the magic constant;
   *         false otherwise
   */
  // check the 0,0 - 1,1 - 2,2 - 3,3 - etc.
  // && the 0, len - 1 - 0, 1, len - 1 - 1, 2, len - 1 - 2, etc. <-- USE THIS 
  public boolean checkDiagonalSums()
  {
    int sum = 0;
    for (int r = 0; r < square.length; r++)
    {
      sum += square[r][r]; 
      if (sum > getMagicConstant()) return false;
    }
    if (sum != getMagicConstant()) return false;
    else
    {
      sum = 0; 
      for (int r = 0; r < square.length; r++)
      {
        int d = square.length - 1 - r;
        sum += square[r][d];
        if (sum > getMagicConstant()) return false;
      }
      if (sum != getMagicConstant())
      return false;
    }
     return true;
  }
  /**
   * Check to see whether or not the randomly generated 2D array is actually
   * a true magic square.
   * @return true if all rows, columns, and diagonals add up to the magic constant,
   *         false otherwise
   */
  public boolean isMagicSquare()
  {
    return checkColumnSums() && checkRowSums() && checkDiagonalSums();
  }
}