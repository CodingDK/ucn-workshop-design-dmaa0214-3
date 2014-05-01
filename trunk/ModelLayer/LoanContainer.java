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
    
    public ArrayList<Loan> getLoans(Person person){
        return loans.get(person);
    }
    
    public HashMap<Person, ArrayList<Loan>> getAllLoans(){
        return loans;
    }    
}
