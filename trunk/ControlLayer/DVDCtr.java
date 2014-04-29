package ControlLayer;
import java.util.ArrayList;
import ModelLayer.*;
//model layer package has to be imported
// Skal beholdes
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
    
    //Dummy implementation: after implementing the model layer 
    //objects of class DVD are to be returned, not String
    public String findDVD( int no)
    {
        //this method is to search the container for a DVD
        //with an id-number equal to the parameter no
        //when the dvd is found, the method is to call print-methods in the TUI layer
       
       return "dvd"; 
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
    

    // Lau
    public void createCopy(DVD dvd, String purchaseDate, double purchasePrice){
        
    }

    
    
    // getCopy -- Lau
    
    /**
     * addCopy - Adding a copy of a DVD
     * @Param dvdID of the DVD.
     * @param purchaseDate when it is purchased.
     * @param purchasePrice is the price of the dvd.
     */
    public void addCopy(int dvdID, String purchaseDate, double purchasePrice){
        DVD d = dvdCon.getDVD(dvdID);
        if(d != null){
        d.createCopy(purchaseDate, purchasePrice);
        } else{
            throw new NullPointerException("DVD ID was not found");
        }
        
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
    
     public void updateCopy(int dvdID, int serialNumber, String purchaseDate, double purchasePrice){
        DVD dvd = dvdCon.getDVD(dvdID);
        if(dvd != null){
            Copy copy = dvd.getCopy(serialNumber);
            if(copy != null){
                copy.setPurchaseDate(purchaseDate);
                copy.setPurchasePrice(purchasePrice);
            } else{
                throw new NullPointerException("Copy was not found");            
            }
        throw new NullPointerException("DVD was not found");
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
    
    // listAllDVD -- Lasse
      // number of copies - get copies i hashSet
    
    public void deleteDVD(long id)
    {
        
        //search for the dvd and delete the object from the container
       
    }
    
    public void createCopy(long id)
    {
        //create a copy of the specified dvd and add it to the dvd
    }
    
    
    public String listAllDvds()
    {
          //returns a list of all dvds and their associated copies
          return null;
    }
}
