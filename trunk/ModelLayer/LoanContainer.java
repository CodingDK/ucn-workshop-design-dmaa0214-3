package ModelLayer;
import java.util.*;

/**
 * Write a description of class LoanContainer here.
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
    
    public static LoanContainer getInstance() {
        if(instance == null){
            instance = new LoanContainer();
        }
        
        return instance;
    }
    
    public void createLoan(Person person, ArrayList<Copy> copies){
        addLoan(person, new Loan(copies));
    }
    
    private void addLoan(Person person, Loan loan){
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
        
//         ArrayList<Loan> pLoan = getLoans(person);
//         Loan retLoan = null;
//         if(pLoan != null){
//             for(Loan l : pLoan){
//                 if(l.getId() == loanID){
//                     retLoan = l;
//                     break;
//                 }
//             }
//         }
        
        return retLoan;
    }
    
    public ArrayList<Loan> getLoans(Person person){
        return loans.get(person);
    }
    
    public HashMap<Person, ArrayList<Loan>> getAllLoans(){
        return loans;
    }
    
//     public Person getPersonByLoanID(int loanID){
//         Person returnPerson = null;
//         
//         if(!loans.isEmpty()){
//             for(ArrayList<Loan> list : loans.values()) {
//                 for(Loan loan : list){
//                     if(loan.getId() == loanID) {
//                         for (Person key : loans.keySet()) {
//                             if (loans.get(key).equals(list)) {
//                                 returnPerson = key;
//                                 break;
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return returnPerson;
//     }
    
}
