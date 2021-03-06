package ModelLayer;
import java.util.*;

/**
 * DVD Class holds information of a dvd, and a list of copies of it.
 * 
 * @author Group 3
 * @version 0.3
 */
public class DVD{
    private HashSet<Copy> copies;
    private static int idIterator;
    private int id;
    private String title;
    private String artist;
    private int publicationYear;

    /**
     * Constructor for objects of class DVD
     * @param title The title of the dvd.
     * @param artist The artist of the dvd.
     * @param publicationYear The publicationDate of the dvd.
     */
    public DVD(String title, String artist, int publicationYear){
        copies = new HashSet<Copy>();
        idIterator++;
        this.id = idIterator;
        this.title = title;
        this.artist = artist;
        this.publicationYear = publicationYear;
    }
    
    /**
     * createCopy - Create a Copy object of a the dvd object.
     * @param year The year of the purchase
     * @param price The price of the purchase
     */
    public void createCopy(String purchaseDate, double purchasePrice){
        addCopy(new Copy(purchaseDate, purchasePrice));
    }
    
    /**
     * addCopy - Add a Copy object to the copy container.
     * @param copy The Copy object to add to the copy container.
     */
    private void addCopy(Copy copy){
        copies.add(copy);
    }
    
    /**
     * deleteCopy - Delete the Copy object from the copy container.
     * @param copy The Copy object to delete from the copy container.
     */
    public void deleteCopy(Copy copy){
        copies.remove(copy);
    }
    
    /**
     * getCopy - Returns the Copy associated with the serialNumber.
     * @param serialNumber The serialNumber of the Copy Object.
     * @return c The Copy object / null if none is found.
     */
    public Copy getCopy(int serialNumber){
        Copy c = null;
        
        for(Copy copy : copies){
            if(copy.getSerialNumber() == serialNumber){
                c = copy;
                break;
            }
        }
        
        return c;
    }
    
    /**
     * getAvailableCopy - Returns the first available copy found
     * @return c The Copy object / null if none is found
     */
    public Copy getAvailableCopy(){
        Copy c = null;
        
        for(Copy copy : copies){
            if(!copy.getLent()){
                c = copy;
                break;
            }
        }
        
        return c;
    }
    
    /**
     * getCopies - Get the HashSet list of Copy objects.
     * @return HashSet<Copy> - The list of copies objects.
     */
    public HashSet<Copy> getCopies(){
        return copies;
    }

    /**
    * getId() - Returns the Id
    * @return id
    */
    public int getID(){
        return id;
    }
    
    /**
    * setId() - sets the Id
    * @param id - value as int
    */
    public void setID(int id){
        this.id = id;
    }
    
    /**
    * getTitle() - Returns the Title
    * @return title
    */
    public String getTitle(){
        return title;
    }
    
    /**
    * setTitle() - sets the Title
    * @param title - value as String
    */
    public void setTitle(String title){
        this.title = title;
    }
    
    /**
    * getArtist() - Returns the Artist
    * @return artist
    */
    public String getArtist(){
        return artist;
    }
    
    /**
    * setArtist() - sets the Artist
    * @param artist - value as String
    */
    public void setArtist(String artist){
        this.artist = artist;
    }
    
    /**
    * getPublicationYear() - Returns the PublicationYear
    * @return publicationDate
    */
    public int getPublicationYear(){
        return publicationYear;
    }
    
    /**
    * setPublicationYear() - sets the PublicationYear
    * @param publicationYear - value as String
    */
    public void setPublicationDate(int publicationYear){
        this.publicationYear = publicationYear;
    }
    
    /**
     * hasCopies - Check the DVD for copies.
     * @return boolean - false if no copies available and true if any cpies available.
     */
    public boolean hasCopies(){
        boolean has = false;
        if(copies != null){
            for(Copy c : copies){
                if(!c.getLent()){
                    has = true;
                    break;
                }
            }
        }
        
        return has;
    }
}
