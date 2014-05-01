package ModelLayer;
import java.util.*;

/**
 * Container for objects of DVD
 * 
 * @author Group 3 
 * @version 0.3
 */
public class DVDContainer{
    private static DVDContainer instance;
    private ArrayList<DVD> dvds;

    /**
     * Constructor for objects of class DVDContainer
     */
    private DVDContainer(){
        dvds = new ArrayList<DVD>();
    }

    /**
     * Returns the instance of the DVDContainer
     * @return DVDContainer - The instance of the DVDContainer.
     */
    public static DVDContainer getInstance(){
        if(instance == null){
            instance = new DVDContainer();
        }
        
        return instance;
    }
    
    /**
     * Removes the DVD Object by ID
     * @param dvdID The id of the dvd object.
     */
    public void deleteDVD(int dvdID){
        dvds.remove(getDVD(dvdID));
    }
    
    /**
     * createDVD - Create a DVD and add it to the DVDcontainer.
     * @param title The title of the dvd.
     * @param artist The artist of the dvd.
     * @param publicationDate The publicationYear of the dvd.
     */
    public void createDVD(String title, String artist, int publicationYear){
        addDVD(new DVD(title, artist, publicationYear));
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
     * @param dvdID The id of the dvd.
     * @return DVD - The DVD object or null.
     */
    public DVD getDVD(int dvdID){
        DVD returnDVD = null;
        
        for(DVD dvd : dvds){
            if(dvd.getID() == dvdID){
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
