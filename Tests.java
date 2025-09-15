import java.util.Arrays;
/**
 *  
 * @author  
 * @version 
 */
public class Tests
{
    public static void Main(){
        System.out.println(palindromeRearranging("aabb"));
    }
public static boolean palindromeRearranging(String s) {
    char tempArray[] = s.toCharArray();
          
        // sort tempArray
    Arrays.sort(tempArray);
          
        // return new sorted string
    s = new String(tempArray);
    
    int count = 0, numOdds = 0, start = 0;
    for (int i = 0; i < s.length(); i++)
    {
        i = start;
        count = 0;
        int j = i;
        while (j < s.length()){
            if (s.charAt(i) == s.charAt(j)) count++;
            else 
            {
                start = j;
                break;
            }
            j++;
        }
        
        if (count % 2 == 1) numOdds++;
        if (numOdds > 1) return false;
        count = 0;
        if (j >= s.length()) return true;
    }
    
    return true;
}

    
    public static boolean areSimilar(int[] a, int[] b) {
    for (int i = 0; i < a.length; i++)
    {
        for (int j = 0; j < a.length; j++)
        {
            int swap1 = a[i];
            int swap2 = b[j];
            a[i] = swap2;
            b[j] = swap1;
            
            if (Arrays.equals(a, b)) return true;
            a[i] = swap1;
            b[j] = swap2;
        
        }
    }
    
    return false;
}

public static String stringClean(String word) {
  if (word.length() <= 1) return word;
    if (word.charAt(0) == word.charAt(1)) return "" + word.charAt(0) + stringClean(word.substring(2));
    return "" + word.charAt(0) + stringClean(word.substring(1));
}


public int strDist(String str, String sub) {
  if (str.length() < sub.length()) return 0;
  if (str.substring(0, sub.length()).equals(sub) && str.substring(str.length()-sub.length()).equals(sub)) return str.length();
  if (str.substring(0, sub.length()).equals(sub)) return strDist(str.substring(0, str.length()-1), sub);
  
  return strDist(str.substring(1), sub);
}





public static String notReplace(String str) {
  
  String fin = "";
  boolean isLetter = true;
  int len = str.length();
  
  if (len == 0) return fin;
  for (int i = 0; i < len - 2; i++)
  {
      if (i > 0 && str.substring(i-1, i+3).equalsIgnoreCase(" is "))
      {
          isLetter = false;
      }
      if (i == 0 && str.substring(i, i+2).equals("is")) 
      {
          fin += "is not";
          i += 2;
        }
      
      else if (i == len - 2 && str.substring(i).equals("is") && !isLetter) 
      {
          fin += "is not"; 
          break;
      }
      else if (str.substring(i, i+2).equals("is") && !isLetter) 
      {
          fin += "is not ";
          i += 2;
        }
      else fin += str.charAt(i);
        
      isLetter = true;
  }
  if (str.substring(len-2).equals("is")) return fin + "is not";
  return fin + str.substring(len-2);
}










}
