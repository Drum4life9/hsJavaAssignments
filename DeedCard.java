
/**
 * The DeedCard represents a Monopoly deed card.  
 * @author  Brian Myers
 * @version 6 November 2019
 */
public class DeedCard
{
    private String name;
    private int purchasePrice;
    
    private int rent;
    private int accumulatedRent;
    private boolean isPartOfSet;
    /**
     * Construct a default DeedCard.
     */
    public DeedCard()
    {
        name = "default";
        purchasePrice = 0;
        isPartOfSet = false;
        
        rent = 0;
        accumulatedRent = 0;
    }

    /**
     * Construct a DeedCard whose fields are initialized through parameter values.
     * @param n - the property's name
     * @param pp - the property's purchase price
     * @param ipos - the property's set collection state
     * @param r - the property's rent price
     */
    public DeedCard(String n, int pp, boolean ipos, int r)
    {
        name = n;
        purchasePrice = pp;
        isPartOfSet = ipos;
        
        rent = r;
        accumulatedRent = 0;
        
    }

    /**
     * Return the name of the property on the Deed card.
     * @return the property's name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Return the purchase price of the property on the Deed card.
     * @return the property's purchase price
     */
    public int getPurchasePrice()
    {
        return purchasePrice;
    }

    /**
     * Return the property's status as part of a purchased color set.
     * @return true - if the property is part of a color set; false otherwise
     */
    public boolean getIsPartOfSet()
    {
        return isPartOfSet;
    }

    /**
     * Return the rent price of the property on the Deed card.
     * @return the property's rent price
     */
    public int getRent()
    {
        return rent;
    }

    /**
     * Return the accumulated rent the property has aquired.
     * @return the property's accumulated rent.
     */
    public int getAccumulatedRent()
    {
        return accumulatedRent;
    }


    
    
    /**
     * Set or change the name of the property on the Deed card.
     * @paran n - the name of the property
     */
    public void setName(String n)
    {
        name = n;
    }
    
    /**
     * Set or change the purchase price of the property on the Deed card.
     * @paran pp - the purchase price of the property
     */
    public void setPurchasePrice(int pp)
    {
        purchasePrice = pp;
    }
    
    /**
     * Set or change the collection state of the property.
     * @paran ipos - the collection state of the property
     */
    public void setIsPartOfSet(boolean ipos)
    {
        isPartOfSet = ipos;
    }

    /**
     * Set or change the rental price of the property on the Deed Card.
     * @param r - the rental price of the property
     */
    public void setRent(int r)
    {
        rent = r;
    }
        
    

    /**
     * Return the current rental price for the property.  This amount will be  
     * twice the normal rental price of the player has all properties of the 
     * same color set.
     * @return the rental price for the property
     */
    public int chargeRent()
    {
        int adjRent = rent;
        
        if (isPartOfSet) adjRent = rent*2;
        accumulatedRent += adjRent;
        
        return adjRent;
    }
    
    /**
     * Return the mortgage value of the property.  The mortgage is valued at  
     * 15% of the property's purchase price.
     * @return - the property's mortgage value
     */
    public double getMortgageValue()
    {
        return purchasePrice * 1.15;
    }
    
}