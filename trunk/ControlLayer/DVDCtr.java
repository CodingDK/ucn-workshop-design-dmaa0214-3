package ControlLayer;
import java.util.ArrayList;
import ModelLayer.*;
//model layer package has to be imported
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
    
    //Dummy implementation: more parameters are probaly to added
    public void createDVD(String dvd)
    {       
          //this method constructs a new dvd object 
          //and stores it in the container
    }
    
    /**
     * getDVDInfo - Returns a String of information, by person id.
     * @param ID the id of the DVD.
     * @return String of the dvd information. 
     */
    public String getDVDInfo(int id){
        DVDContainer d = dvdcon.
        String nLine = System.getProperty("line.separator");
        
        if(d != null){
            return nLine + "ID: " ; 
        }
        else {
            throw new NullPointerException("DVD was not found");
        }
    }
    

    // Lau
    public void createCopy(DVD dvd, String purchaseDate, double purchasePrice){
        
    }

    
    
    // getCopy -- Lau
    
    // addCopy -- Lasse 
    
    // updateDVD -- Lau
    
    // updateCopy -- Lasse 
    
    // deleteCopy -- Lau
    
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
