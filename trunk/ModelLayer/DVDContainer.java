package ModelLayer;
import java.util.ArrayList;


/**
 * Write a description of class DVDContainer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DVDContainer
{
    private DVDContainer instance;
    private ArrayList<DVD> dvds;

    /**
     * Constructor for objects of class DVDContainer
     */
    private DVDContainer(){
        dvds = new ArrayList<DVD>();
    }


    public DVDContainer getInstance(){
        if(instance == null){
            instance = new DVDContainer();
        }
        
        return instance;
    }
}
