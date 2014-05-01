package ControlLayer;
import java.util.*;
import ModelLayer.*;
/**
 * Controller class for the DVD collection
 * 
 * @author Group 3
 * @version 0.1
 */
public class DVDCtr{
    private DVDContainer dvdCon;
    /**
     * Constructor for objects of class DVDCtr
     */
    public DVDCtr(){
        dvdCon = DVDContainer.getInstance();
    }

    /**
     * 
     * @param title Title of the DVD
     * @param artist Artist of the DVD
     * @param publicationDate Date of the DVD publication
     */
    public void createDVD(String title, String artist, int publicationYear){       
          dvdCon.createDVD(title, artist, publicationYear);
    }
    
    /**
     * getDVDInfo - Returns a String of information, by person id.
     * @param dvdID The id of the DVD.
     * @return String of the dvd information. 
     */
    public String getDVDInfo(int dvdID){ 
        DVD d = dvdCon.getDVD(dvdID);
        
        String nLine = System.getProperty("line.separator");
        
        if(d != null){
            return nLine + "ID: " + d.getID() + " Title: " + d.getTitle() + " Artist: " + d.getArtist() + " Publication Year: " + d.getPublicationYear() + " Copies: " + d.getCopies().size() ; 
        } else {
            throw new NullPointerException("DVD was not found");
        }
    }
    
    /**
     * getCopies - Returns a string of information, by DVD ID.
     * @param dvdID The ID of the DVD.
     * @return String of the copy information.
     */
    public String getCopies(int dvdID){
        DVD d = dvdCon.getDVD(dvdID);
        StringBuilder sb = new StringBuilder();
        if(d != null){
            HashSet<Copy> copies = d.getCopies();
            if(!copies.isEmpty()){
                //String returnString = "(";
                sb.append("(");
                for(Copy c : copies){
                    //returnString += c.getSerialNumber() + ", ";
                    sb.append(c.getSerialNumber() + ", ");
                }
                
                //returnString = returnString.substring(0, returnString.length()-2) + ")";
                sb.setLength(sb.length() -2);
                sb.append(")");
                
                //return returnString;
                return sb.toString();
            } else {
                throw new NullPointerException("There are no Copies of that DVD");
            }
        } else {
            throw new NullPointerException("DVD was not found");
        }
    }
  
    /**
     * addCopy - Adding a copy of a DVD
     * @Param dvdID The ID of the DVD.
     * @param purchaseDate When the DVD is purchased.
     * @param purchasePrice The purchase price of the dvd.
     */
    public void addCopy(int dvdID, String purchaseDate, double purchasePrice){
        DVD d = dvdCon.getDVD(dvdID);
        if(d != null){
            d.createCopy(purchaseDate, purchasePrice);
        } else {
            throw new NullPointerException("DVD ID was not found");
        }
        
    }
    
    /**
     * Changes the DVD info based on the parameters
     * 
     * @param id ID of the DVD
     * @param title Title of the DVD
     * @param artist Artist of the DVD
     * @param publicationDate Publication year of the DVD
     */
    public void updateDVD(int id, String title, String artist, int publicationYear){
        DVD dvd = dvdCon.getDVD(id);
        if(dvd != null){
            dvd.setTitle(title);
            dvd.setArtist(artist);
            dvd.setPublicationDate(publicationYear);
        } else {
            throw new NullPointerException("DVD not found");
        }
        
    }
    
    /**
     * updateCopy - Updating the copy information
     * @param serialNumber The serialnumber of the DVD.
     * @param purchaseDate The date the DVD is purchased.
     * @param purchasePrise The DVD purchase price.
     */
    public void updateCopy(int dvdID, int serialNumber, String purchaseDate, double purchasePrice){
        DVD dvd = dvdCon.getDVD(dvdID);
        if(dvd != null){
            Copy copy = dvd.getCopy(serialNumber);
            if(copy != null){
                copy.setPurchaseDate(purchaseDate);
                copy.setPurchasePrice(purchasePrice);
            } else {
                throw new NullPointerException("Copy was not found");            
            }
        } else {
            throw new NullPointerException("DVD was not found");
        }
    } 
    
    /**
     * deleteCopy - Delete a Copy object
     * @param dvdID ID of the DVD.
     * @param serialNumber Serialnumber of the DVD.
     */
    public void deleteCopy(int dvdID, int serialNumber){
        DVD dvd = dvdCon.getDVD(dvdID);
        if(dvd != null){
            dvd.deleteCopy(dvd.getCopy(serialNumber));
        } else {
            throw new NullPointerException("DVD was not found");
        }
    }
    
    /**
     * getTitleByID - Return the DVD title
     * @param dvdID The ID of the DVD.
     * @return String with the DVD title.
     */
    public String getTitleByID(int dvdID){
        DVD dvd = dvdCon.getDVD(dvdID);
        if(dvd != null){
            return dvd.getTitle();
        } else {
            throw new NullPointerException("DVD not found");
        }
    }
    
    /**
     * deleteDVD - Delete a DVD object, by the DVD id.
     * @param dvdID The ID of the DVD.
     */
    public void deleteDVD(int dvdID) {
        DVD dvd = dvdCon.getDVD(dvdID);
        if(dvd != null){
            dvdCon.deleteDVD(dvdID);
        } else {
            throw new NullPointerException("DVD was not found");
        }
    }
    
    /**
     * listAllDVDs - List all DVD in the collection
     * @return String with the list of all dvds.
     */
    public String listAllDVDs(){
        ArrayList<DVD> dvd = dvdCon.getAllDVDs();
      
        String nLine = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        //String returnString = "### All DVD ###" + nLine;
        sb.append("### All DVD ###" + nLine);
        if(!dvd.isEmpty()) {
            for(DVD d : dvd) {
                //returnString += "#" + d.getID() + ", Title: " + d.getTitle() + ", Artist: " + d.getArtist() 
                //+ ", Publication Year: " + d.getPublicationYear() + ", Copies: " + d.getCopies().size() + nLine;
                sb.append("#" + d.getID() + ", Title: " + d.getTitle() + ", Artist: " + d.getArtist() + ", Publication Year: " + d.getPublicationYear() + ", Copies: " + d.getCopies().size() + nLine);
            }
        } else {
            throw new NullPointerException("DVD list was not found");
        }
        //return returnString; 
        return sb.toString();
    }
    
    
    public DVD getDVD(int dvdID){
        return dvdCon.getDVD(dvdID);
    }
}
