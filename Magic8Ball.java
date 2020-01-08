import java.util.ArrayList;
import java.util.Random;

/**
 * A magic eight ball object. 
 * @author M. Fleming
 * @version 28 September 2019
 */
public class Magic8Ball
{
    private ArrayList<String> allReplies;
    private int numberReplies;
    
    /**
     * Construct a default Magic8Ball object with four initial replies.
     */
    public Magic8Ball()
    {
        allReplies = new ArrayList<String>();
        numberReplies = 0;
        addInitialReplies();
    }
    
    /**
     * Simulate shaking of a magic eight ball by randomly selecting one reply
     * from a list of replies.
     * @return a reply
     */
    public String shake8Ball()
    {
        return allReplies.get(new Random().nextInt(allReplies.size()));
    }
    
    /**
     * Add a reply to the eight ball.
     * @param a reply in the form of a statement
     */
    public void addReply(String newReply)
    {
        allReplies.add(newReply);
        numberReplies = allReplies.size();
    }
    
    /**
     * Create a string that contains all of the Eight Ball's replies.
     * @return a string containing all of the replies
     */
    public String showAllReplies()
    {
        String replies = "";
        
        for (String r : allReplies)
            replies += r + "\n";
            
        return replies;            
    }    
        
    /**
     * Load the initialil replies into the eight ball at startup.
     */
    private void addInitialReplies()
    {
        allReplies.add("All signs point to yes!");
        allReplies.add("Not in your lifetime.");
        allReplies.add("Outlook not so good.");
        allReplies.add("Almost certainly so.");
    }
}