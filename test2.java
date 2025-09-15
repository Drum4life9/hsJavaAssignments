import java.util.ArrayList;
/**
 * Write a description of class test2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test2
{
    public static int[][] magicSqr = new int[3][3];
    public static int dimension = 3;
    
  public void initializeSquare()
  {
    int[] lis = new int[dimension * dimension];
    for (int i = 1; i <= lis.length; i++)
    {
      lis[i-1] = i;
    }

    for (int i = 0; i < lis.length; i++)
    {
      int ind = (int)((Math.random() * (lis.length - i)));
      int temp = lis[ind];
      lis[ind] = lis[i];
      lis[i]= temp;
    }

    int ind = 0;
    for (int r = 0; r < magicSqr.length; r++)
    {
      for (int c = 0; c < magicSqr[r].length; c++)
      {
        if (ind == lis.length) break;
        magicSqr[r][c] = lis[ind];
        ind++;
      }
    }

    
  }
    
  
}
