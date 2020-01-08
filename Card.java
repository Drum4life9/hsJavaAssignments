/**
 * An object of class card represents one of the 52 cards in a standard
 * deck of playing cards.  Each card has a suit and a value.
 * @author M. Fleming
 * @version 4 May 2018, 14 August 2018
 * @see http://math.hws.edu/eck/cs124/javanotes4/source/Card.java
 */
public class Card
{
    private int pointValue;
    private String suit;
    
    /**
     * Construct a default card with no suit or point value.  Using this 
     * constructor sets the suit as ?? and the point value as 0.
     */
    public Card()
    {
        pointValue = 0;
        suit = "??";
    }
    
    /**
     * Construct a card with the specified value and suit.  Ace is 1, 
     * two is two, ten is 10, jack is 11, queen is 12, and king is 13.
     * @param s - the card suit
     * @param pv - the card point value
     */
    public Card(String s, int pv)
    {
        suit = s;
        pointValue = pv;
    }
    
    /**
     * Return the card's current suit - hearts, diamonds, spades, or clubs.
     * @return the current suit
     */
    public String getSuit()
    {
        return suit;
    }
    
    /**
     * Return the card's current point value - ace is 1, two is two, 
     * ten is 10, jack is 11, queen is 12, and king is 13.
     * @return the card's point value
     */
    public int getPointValue()
    {
        return pointValue;
    }
    
    /**
     * Return a String representation of the card in the form of 
     * "pv of suit".  For example, the 10 of Hearts or Queen of Spades.
     * @return a String representation of this card
     */
    public String toString()
    {
        String card;
        
        if (pointValue >= 2 && pointValue <=10) card = pointValue + " of " + suit; 
        else card = getPointValueAsString() + " of " + suit; 
       
        return card;
    }
    
    /**
     * Return a String version of the point value for non-numeric 
     * card values, such as the Ace, Jack, Queen, or King.
     * @return a String representing the card's value; if the 
     *         card's value i invalid, ?? is returned.
     */
    private String getPointValueAsString()
    {        
        if (pointValue == 1) return "Ace";
        if (pointValue == 11) return "Jack";
        if (pointValue == 12) return "Queen";
        if (pointValue == 13) return "King";
        return "??";
    }
}