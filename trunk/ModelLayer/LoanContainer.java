package ModelLayer;
import java.util.*;

/**
 * Write a description of class LoanContainer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoanContainer
{
    private static LoanContainer instance;
    private HashMap<Person, ArrayList<Loan>> loans;

    /**
     * Constructor for objects of class LoanContainer
     */
    private LoanContainer(){
        loans = new HashMap<Person, ArrayList<Loan>>();
    }
    
    public static LoanContainer getInstance() {
        if(instance == null){
            instance = new LoanContainer();
        }
        
        return instance;
    }
    
    public void createLoan(Person person){
    
    }
    
    private void addLoan(Person person, Loan loan){
       // loans.put(person, loan);
    }
    
    public Loan getLoan(Person person, int loanID){
        ArrayList<Loan> pLoan = getLoans(person);
        
        for(Loan l : pLoan){
            //if(l.getID() == loanID){
            
           // }
        }
        
        return null;
    }
    
    public ArrayList<Loan> getLoans(Person person){
        return loans.get(person);
    }
    
    public HashMap<Person, ArrayList<Loan>> getAllLoans(){
        return loans;
    }
    
}
