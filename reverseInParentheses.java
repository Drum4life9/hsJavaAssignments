
/**
 * Write a description of class reverseInParentheses here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class reverseInParentheses
{
    public static String reverseInParentheses(String in) {
        int count = 0;
        
        for (int i = 0; i < in.length(); i++)
        {
            if (in.charAt(i) == '(') count++;
        }    
        
        
        String tempRet = "";
        for (int t = 0; t < count; t++)
        {
            int tempCount = 0;
            
            for (int i = 0; i < in.length(); i++)
            {
                int lastParen = -1;
                if (in.charAt(i) == '(') tempCount++;
                if (tempCount == count)
                {
                    int j = in.length() - 1;
                    int rCount = 0;
                    while (j > 0 && in.charAt(j-1) != '(')
                    {
                        if (in.charAt(j) == ')') rCount++;
                        if (rCount == count) 
                        {
                            tempRet += "" + in.charAt(j-1);
                            lastParen = j;
                        }
                        j--;
                    }
                    
                    i = in.length() - lastParen + 1;
                    tempCount++;
                }
                else tempRet += "" + in.charAt(i);
            }
            
            count--;
        }
        
        return tempRet;
    }

}
