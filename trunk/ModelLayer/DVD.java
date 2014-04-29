package ModelLayer;
import java.util.*;


/**
 * Write a description of class DVD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DVD{
    private ArrayList<Copy> copys;
    private static int idIterator;
    private int id;
    private String title;
    private String artist;
    private String publicationDate;

    /**
     * Constructor for objects of class DVD
     */
    public DVD(String title, String artist, String publicationDate) {
        copys = new ArrayList<Copy>();
        idIterator++;
        this.id = idIterator;
        this.title = title;
        this.artist = artist;
        this.publicationDate = publicationDate;
    }
    
    /**
     * addCopy - Adds an Copy object to the container
     */
    public void addCopy(Copy copy){
        copys.add(copy);
    }
    
    /**
     * removeCopy - Removes a Copy object from the container
     */
    public void removeCopy(Copy copy){
        copys.remove(copy);
    }
    
    /**
     * getCopy - Returns the Copy associated with the serialNumber
     * @param serialNumber The serialNumber of the Copy Object
     * @return c The Copy object / null if none is found
     */
    public Copy getCopy(int serialNumber){
        Copy c = null;
        
        for(Copy copy : copys){
            if(copy.getSerialNumber() == serialNumber){
                c = copy;
                break;
            }
        }
        
        return c;
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
