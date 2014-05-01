package ModelLayer;
import java.util.*;

/**
 * Container for objects of Loan.
 * 
 * @author Group 3 
 * @version 0.3
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
    
    /**
     * Returns the instance of the LoanContainer.
     * @return LoanContainer - The instance of the LoanContainer.
     */
    public static LoanContainer getInstance() {
        if(instance == null){
            instance = new LoanContainer();
        }
        
        return instance;
    }
    
    /**
     * addLoan - Adds the loan to the container.
     * @param person The Person object who borrows the copies.
     * @param loan The new Loan object.
     */
    public void addLoan(Person person, Loan loan){
        ArrayList<Loan> pLoans = getLoans(person);
        if(pLoans == null){
            pLoans = new ArrayList<Loan>();
        }
        pLoans.add(loan);
        loans.put(person, pLoans);
    }
    
    /**
     * getLoan - Get a loan by a loan id.
     * @param loanID The id of a loan.
     * @return Loan - A Loan object or null.
     */
    public Loan getLoan(int loanID){
        Loan retLoan = null;
        
        if(!loans.isEmpty()){
            for(ArrayList<Loan> list : loans.values()) {
                for(Loan loan : list){
                    if(loan.getId() == loanID) {
                        retLoan = loan;
                        break;
                    }
                }
            }
        }
        return retLoan;
    }
    
    /**
     * getLoans - Get a ArrayList with Loan by a Person object.
     * @param person The person object to look for.
     * @return ArrayList<Loan> - A arraylist with Loan objects.
     */
    public ArrayList<Loan> getLoans(Person person){
        return loans.get(person);
    }
    
    /**
     * getAllLoans - Get a HashMap with all loans in the system.
     * @return HashMap<Person, ArrayList<Loan>> - A HashMap with all loans.
     */
    public HashMap<Person, ArrayList<Loan>> getAllLoans(){
        return loans;
    }    
}
