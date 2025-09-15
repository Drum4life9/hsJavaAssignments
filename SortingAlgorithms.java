import java.util.ArrayList;
/**
 * Write a description of class SortingAlgorithms here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SortingAlgorithms
{
    public static ArrayList<Integer> iList = new ArrayList<Integer>();
    
    public static void bounceSort()
    {
        initializeList(10);
        System.out.println("Before Bounce sort: " + iList);
        
        
        
        System.out.println("After Bunce sort: " + iList);
    }
    
    public static void insertionSort()
    {
        initializeList(10);
        System.out.println("Before Insertion sort: " + iList);
        
        for (int i = 1; i < iList.size(); i++)
        {
            int num = iList.get(i);
            for (int j = i; j >= 0; j--)
            {
                if (num < iList.get(j))
                {
                    int temp = iList.get(j);
                    iList.set(j, num);
                    iList.set(j + 1, temp);
                    
                }
                else if (j == 0) iList.set(0, iList.get(j));
                else
                {
                    iList.set(j, iList.get(j));
                }
            }
        }
        
        System.out.println("After Insertion sort: " + iList);
    }
    
    public static void bubbleSort()
    {
        initializeList(10);
        System.out.println("Before Bubble sort: " + iList);
        
        int size = iList.size();
        for (int i = 0; i <= size - 1; i++)
        {
            int min = iList.get(0);
            for (int j = 1; j < 10 - i; j++)
            {
                if (min < iList.get(j))
                {
                    iList.set(j - 1, iList.get(j));
                }
                else
                {
                    iList.set(j - 1, min);
                    min = iList.get(j);
                }
                
                if (j == 10 - i - 1) iList.set(j, min);
            }
        }
        
        System.out.println("After bubble sort: " + iList);
    }
    
    
    public static void selectionSort()
    {
        initializeList(10);
        System.out.println("Before Selection sort: " + iList);
         // Begin selection sort algorithm
        int size = iList.size();
    
        // Outer loop controls boundary between sorted and unsorted partition
        for (int i = 0; i < size - 1; i++)
        {
              // Search for elements smaller than element at i
              int minIndex = i;
              for (int j = i + 1; j < size; j++)
              {
                // Compare elements. Identify location of smallest element in unsorted partition
                if (iList.get(j) < iList.get(minIndex))
                {
                  minIndex = j;     
                }
              }
                
              // Swap the elements - if check prevents swapping same element at i
              if (minIndex != i)
              {
                int temp = iList.get(i);
                iList.set(i, iList.get(minIndex));
                iList.set(minIndex, temp);
              }
        
       }
        
        System.out.println("After Selection sort: " + iList);
    }
  
    private static void initializeList(int size)
    { 
        iList.clear();
        
        for (int i = 0; i < size; i++)
          iList.add((int)(Math.random() * 90) + 10);
    }
}
