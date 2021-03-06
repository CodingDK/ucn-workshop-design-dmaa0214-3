package ModelLayer;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * The Loan Class holds information about a loan.
 * 
 * @author Group 3 
 * @version 0.3
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
     * @param copies The ArrayList<Copy> of copies to lent.
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
     * extend - extend period.
     */
    public void extend(){
        if(!extended){
            this.period += this.period; 
            extended = true;
        }
    }
    
    /**
    * getReturned() - Returns the Returned
    * @return returned
    */
    public boolean getReturned(){
        return returned;
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
    
    /**
     * getDueDate - Get the DueDate.
     * @return String with dueDate.
     */
    public String getDueDate(){
        String dueDateD = "";
        try{
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");        
            Date dueDate = format.parse(borrowDate);
            dueDate = addDays(dueDate, period);
            dueDateD = new SimpleDateFormat("dd-MM-yyyy").format(dueDate);
        }catch(Exception e){
            dueDateD = "Error";
        }
        return dueDateD;
    }
    
    /**
     * addDays - Adds days to a date.
     * @param date Date to add too.
     * @return Date The day calulated date.
     */
    private Date addDays(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        
        return cal.getTime();
    }
    
    /**
    * endLoan - End a loan and set returned to true.
    */
    public void endLoan(){
        returned = true;
        for(Copy c : copies){
        c.setLent(false);
        }
    }
}
