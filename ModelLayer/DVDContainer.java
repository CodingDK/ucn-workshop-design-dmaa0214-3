package ModelLayer;
import java.util.*;

/**
 * Container for objects of DVD
 * 
 * @author Group 3 
 * @version 0.3
 */
public class DVDContainer
{
    // instance variables
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
     * Removes the DVD Object by ID
     */
    public void deleteDVD(int id){
        dvds.remove(getDVD(id));
    }

    /**
     * Returns the instance of the DVDContainer
     */
    public static DVDContainer getInstance(){
        if(instance == null){
            instance = new DVDContainer();
        }
        
        return instance;
    }
    
    /**
     * createDVD - Create a DVD and add it to the DVDcontainer.
     * @param title The title of the dvd.
     * @param artist The artist of the dvd.
     * @param publicationDate The publicationDate of the dvd.
     */
    public void createDVD(String title, String artist, String publicationDate){
        addDVD(new DVD(title, artist, publicationDate));
    }
    
    /**
     * addDVD - Add dvd to the DVD container.
     * @param dvd The dvd object to be added.
     */
    private void addDVD(DVD dvd){
        dvds.add(dvd);
    }
        
    /**
     * getDVD - Get DVD object by id.
     * @param id The id of the dvd.
     * @return DVD - The DVD object or null.
     */
    public DVD getDVD(int id){
        DVD returnDVD = null;
        
        for(DVD dvd : dvds){
            if(dvd.getID() == id){
                returnDVD = dvd;
            }
        }
        
        return returnDVD;
    }
    
    /**
     * getAllDVDs - Get the ArrayList of the dvd objects.
     * @return ArrayList<DVD> The list of the dvd objects.
     */
    public ArrayList<DVD> getAllDVDs(){
        return dvds;
    }
    
}
