package ControlLayer;
import java.util.ArrayList;
import ModelLayer.*;
//model layer package has to be imported
//Denne skal slettesss
/**
 * Controller class for the DVD collection
 * 
 * @author (kbh) 
 * @version (2005.03.31)
 * @revised version English (Ab)
 * (FEN): 2006.03.21: Some changes to the architecture in order to assure layering
 *                    and loose coupling
 */
public class DVDCtr
{
    //declare instance variables to reference containers
    private DVDContainer dvdCon;
    private DVD dvd;

    /**
     * Constructor for objects of class DVDCtr
     */
    public DVDCtr()
    {
        //set up references to containers
        dvdCon = DVDContainer.getInstance();
    }
    
    /**
     * 
     * @param title Title of the DVD
     * @param artist Artist of the DVD
     * @param publicationDate Date of the DVD publication
     */
    public void createDVD(String title, String artist, String publicationDate)
    {       
          //this method constructs a new dvd object 
          //and stores it in the container
          dvdCon.createDVD(title, artist, publicationDate);
    }
    
    /**
     * getDVDInfo - Returns a String of information, by person id.
     * @param ID the id of the DVD.
     * @return String of the dvd information. 
     */
    public String getDVDInfo(int dvdID){ 
        DVD d = dvdCon.getDVD(dvdID);
        
        String nLine = System.getProperty("line.separator");
        
        if(d != null){
            return nLine + "ID: " + d.getID() + "Title: " + d.getTitle() + "Artist: " + d.getArtist() + "Publication Date: " + d.getPublicationDate() ; 
        }
        else {
            throw new NullPointerException("DVD was not found");
        }
    }
    

    /**
     * Creates a copy of a DVD
     * 
     * @param dvd DVD object
     * @param purchaseDate Date of purchase
     * @param purchasePrice Price of purchase
     */
    public void createCopy(DVD dvd, String purchaseDate, double purchasePrice){
        dvd.createCopy(purchaseDate, purchasePrice);
    }
    
    /**
     * Gets all copies of the DVD and prepares them for print
     * 
     * @param dvdID ID of the DVD
     * @return String
     */
    public String getCopies(int dvdID){
        String returnCopies = null;
        
        dvd = dvdCon.getDVD(dvdID);
        if(dvd != null){
            dvd.getCopies();
        } else {
            throw new NullPointerException("DVD was not found");
        }
        
        return returnCopies;
    }
    
    public void addCopy(int dvdID, String purchaseDate, double purchasePrice){
        DVD d = dvdCon.getDVD(dvdID);
        d.createCopy(purchaseDate, purchasePrice);
    }
    
    /**
     * Changes the DVD info based on the parameters
     * 
     * @param id ID of the DVD
     * @param title Title of the DVD
     * @param artist Artist of the DVD
     * @param publicationDate Publication date of the DVD
     */
    public void updateDVD(int id, String title, String artist, String publicationDate){
        DVD dvd = dvdCon.getDVD(id);
        if(dvd != null){
            dvd.setTitle(title);
            dvd.setArtist(artist);
            dvd.setPublicationDate(publicationDate);
        } else {
            throw new NullPointerException("DVD not found");
        }
        
    }
    
    /**
     * @param dvdID ID of the DVD
     * @param serialNumber Serialnumber of the DVD
     */
    public void deleteCopy(int dvdID, int serialNumber){
        DVD dvd = dvdCon.getDVD(dvdID);
        if(dvd != null){
            dvd.deleteCopy(dvd.getCopy(serialNumber));
        } else {
            throw new NullPointerException("DVD not found");
        }
    }
    
    public String listAllDVDs(){
        String returnList = null;
        
        return returnList;
    }
      // number of copies - get copies i hashSet
    
    public void deleteDVD(long id)
    {
        
        //search for the dvd and delete the object from the container
       
    }
    
    public void createCopy(long id)
    {
        //create a copy of the specified dvd and add it to the dvd
    }
    
    

}
