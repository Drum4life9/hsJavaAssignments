import java.util.Random;

/**
 * The FlashCard class represents a flash card that can check integer addition,  
 * subtraction, multiplication, and division.
 * @author  M. Fleming
 * @version 9 October 2019
 */
public class FlashCard
{
    private int num1, num2, maxNum;
    private char operator;
    
    /**
     * Construct a default FlashCard object with no numbers
     * and the operator set to addition.
     */
    public FlashCard()
    {
        num1 = 0;
        num2 = 0;
        maxNum = 0;
        operator = 'a';
    }
    
    /**
     * Set the maximum number to appear on the card.
     * @param the maximum number
     */
    public void setMaxNumber(int max)
    {
        maxNum = max;
    }
    
    /**
     * Create random whole numbers to appear on the card.  The 
     * method sets the first number to be the largest.
     */
    private void setCardNumbers()
    {
        Random gen = new Random();
        num1 = gen.nextInt(maxNum)+1;
        num2 = gen.nextInt(maxNum)+1;
        
        //swap #s if needed
        if (num1<num2)
        {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
    }
    
    /**
     * Determine and set the operator for the card.  The operator
     * is randomly determined.
     */
    private void setOperator()
    {
        Random gen = new Random();
        int o = gen.nextInt(5)+1;
        
        if (o==1) operator = '+';
        else if (o==2) operator = '-';
        else if (o==3) operator = '*';
        else if (o==4) operator = '%';
        else operator = '/';
        
    }
    
    /**
     * Compares the player's answer to the actual answer of the card.
     * @param playerAnswer - the player's answer to the equation
     * @return true if the player is correct; false otherwise
     */
    public boolean checkAnswer(int playerAnswer)
    {
        int correctAnswer;
        
        if (operator == '+') correctAnswer = num1 + num2;
        else if (operator == '-') correctAnswer = num1 - num2;
        else if (operator == '*') correctAnswer = num1 * num2;
        else if (operator == '%') correctAnswer = num1 % num2;
        else correctAnswer = num1 / num2;
        return correctAnswer == playerAnswer;
    }
    
    /**
     * Generate the String representation of the playing card with a 
     * new question on the card.
     * @return a Sting representation of a new flash card
     */
    public String toString()
    {
        return getNextQuestion();
    }
    
    
    /**
     * Generate a new flash card question.
     * @return a new flash card question as a String
     */
    private String getNextQuestion()
    {
        setCardNumbers();
        setOperator();
        
        String problem = num1 + " " + operator + " " + num2;
        return problem;
    }
    
}
