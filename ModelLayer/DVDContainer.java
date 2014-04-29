package ModelLayer;
import java.util.*;


/**
 * Container for objects of DVD
 * 
 * @author Group 3 
 * @version 0.2
 */
public class DVDContainer
{
    // instance variables - replace the example below with your own
    private static DVDContainer instance;
    private ArrayList<DVD> dvds;

    /**
     * Constructor for objects of class DVDContainer
     */
    private DVDContainer()
    {
        dvds = new ArrayList<DVD>();
    }

    /**
     * Returns the instance of the DVDContainer
     */
    public DVDContainer getInstance(){
        if(instance == null){
            instance = new DVDContainer();
        }
        
        return instance;
    }
}
