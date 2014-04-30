package ControlLayer;
import java.util.*;
import ModelLayer.*;

/**
 * Controller of Loans
 * 
 * @author Group 3
 * @version 0.1
 */
public class LoanCtr{
    private LoanContainer loanCtr;
    private AddressBook addressBook;
    
    /**
     * Constructor for objects of class LoanCtr
     */
    public LoanCtr()
    {
        loanCtr = LoanContainer.getInstance();
    }

    /**
     * @
     * @
     */
    //public void createLoan(int personID, ArrayList<Copy>){

    //}

    /**
     * @param int loanID : The ID of the loan
     * 
     */
    public void endLoan(int personID, int loanID){
        loan = loanCon.getLoans(loanID);
        if(loan != null){
           
        } else{
            throw new NullPointerException("Loan not found");
        }
        
    }
        
    
    /**
     * 
     */
    public boolean extendLoan(int loanID){
        boolean returnBoolean;
        loan = loanCon.getLoan(loanID);

        if(loan != 0 && !loan.getExtended()){
            period = loan.getPeriod();
            loan.setPeriod(period+7);
            returnBoolean = true;
        } else{
            returnBoolean = false;
        }

        return returnBoolean;
    }

    /**
     * 
     */
    public String getLoansByID(int personID){
        Person p = addressBook.getPerson(personID);
        
        if(p != null){
            
        }
    }

    /**
     * 
     */
    public String listAllLoans(){
        String nLine = System.getProperty("line.seperator");
    }

    }
