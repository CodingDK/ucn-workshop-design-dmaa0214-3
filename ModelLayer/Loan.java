package ModelLayer;

import java.util.*;
import java.text.SimpleDateFormat;

/**
 * The Loan Class holds information about a loan.
 * 
 * @author Group 3 
 * @version 0.1
 */
public class Loan{
    
    private static int idIterator;
    private int id;
    private String borrowDate;
    private int period;
    private boolean returned;
    private boolean extended;
    private ArrayList<Copy> copies;

    /**
     * Constructor for objects of class Loan
     */
    public Loan(ArrayList<Copy> copies){
        this.idIterator++;
        this.id = idIterator;
        this.borrowDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        this.period = 30;
        this.returned = false;
        this.extended = false;
        this.copies = copies;
    }
    
    /**
    * getId() - Returns the Id
    * @return id
    */
    public int getId(){
    	return id;
    }
    
    /**
    * setId() - sets the Id
    * @param id - value as int
    */
    public void setId(int id){
    	this.id = id;
    }
    
    /**
    * getBorrowDate() - Returns the BorrowDate
    * @return borrowDate
    */
    public String getBorrowDate(){
    	return borrowDate;
    }
    
    /**
    * setBorrowDate() - sets the BorrowDate
    * @param borrowDate - value as String
    */
    public void setBorrowDate(String borrowDate){
    	this.borrowDate = borrowDate;
    }
    
    /**
    * getPeriod() - Returns the Period
    * @return period
    */
    public int getPeriod(){
    	return period;
    }
    
    /**
    * setPeriod() - sets the Period
    * @param period - value as int
    */
    public void setPeriod(int period){
    	this.period = period;
    }
    
    /**
    * getReturned() - Returns the Returned
    * @return returned
    */
    public boolean getReturned(){
    	return returned;
    }
    
    /**
    * setReturned() - sets the Returned
    * @param returned - value as boolean
    */
    public void setReturned(boolean returned){
    	this.returned = returned;
    }
    
    /**
    * getExtended() - Returns the Extended
    * @return extended
    */
    public boolean getExtended(){
    	return extended;
    }
    
    /**
    * setExtended() - sets the Extended
    * @param extended - value as boolean
    */
    public void setExtended(boolean extended){
    	this.extended = extended;
    }
    
    /**
    * getCopies() - Returns the Copies
    * @return copies
    */
    public ArrayList<Copy> getCopies(){
    	return copies;
    }
    
    /**
    * setCopies() - sets the Copies
    * @param copies - value as ArrayList<Copy>
    */
    public void setCopies(ArrayList<Copy> copies){
    	this.copies = copies;
    }
}
