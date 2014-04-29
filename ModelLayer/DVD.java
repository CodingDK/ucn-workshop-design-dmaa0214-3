package ModelLayer;
import java.util.*;

/**
 * DVD Class holds information of a dvd, and a list of copies of it.
 * 
 * @author group 3
 * @version 0.2
 */
public class DVD{
    private HashSet<Copy> copies;
    private static int idIterator;
    private int id;
    private String title;
    private String artist;
    private String publicationDate;

    /**
     * Constructor for objects of class DVD
     * @param title The title of the dvd.
     * @param artist The artist of the dvd.
     * @param publicationDate The publicationDate of the dvd.
     */
    public DVD(String title, String artist, String publicationDate) {
        copies = new HashSet<Copy>();
        idIterator++;
        this.id = idIterator;
        this.title = title;
        this.artist = artist;
        this.publicationDate = publicationDate;
    }
    
    /**
     * createCopy - Create a Copy object of a the dvd object.
     * @param date The date of the purchase
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
    * getPublicationDate() - Returns the PublicationDate
    * @return publicationDate
    */
    public String getPublicationDate(){
        return publicationDate;
    }
    
    /**
    * setPublicationDate() - sets the PublicationDate
    * @param publicationDate - value as String
    */
    public void setPublicationDate(String publicationDate){
        this.publicationDate = publicationDate;
    }
}
