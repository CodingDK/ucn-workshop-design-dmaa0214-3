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
    private LoanContainer loanCon;
    private AddressBook addressBook;
    
    /**
     * Constructor for objects of class LoanCtr
     */
    public LoanCtr()
    {
        loanCon = LoanContainer.getInstance();
    }

    /**
     * @
     * @
     */
    //public void createLoan(int personID, ArrayList<Copy>){

    //}

    /**
     * Ends the loan -- All DVDs are handed in.
     * 
     * @param int loanID : The ID of the loan
     * @param int personID : The ID of the person
     */
    public void endLoan(int personID, int loanID){
        Person p = addressBook.getPerson(personID);
        Loan loan = loanCon.getLoans(loanID);
        if(loan != null){
           
        } else{
            throw new NullPointerException("Loan not found");
        }
        
    }
        
    
    /**
     * Extends the specific loan by 7 days
     * Can only be extended once
     * 
     * @param int loanID : The ID of the loan
     * @return boolean true/false : The loan was/n't extended
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
     * getLoansByID - Return a String with the Loans from the person ID
     * @param personID : The ID of the person.
     * @return String : The persons loans.
     */
    
    public String getLoansByID(int personID){
        Person p = addressBook.getPerson(personID);
        
        if(p != null){
            ArrayList<Loan> loans = loanCon.getLoans(p);
            if(!loans.isEmpty()){
                String returnString = "(";
                for(Loan l : loans){
                    returnString += l.getLoan() + ", ";
                }
            
                returnString = returnString.substring(0, returnString.length()-2) + ")";
                
                return returnString;
            } else{
               throw new NullPointerException("There are no Loans"); 
            }
        } else{
            throw new NullPointerException("Person ID not found");
        }
    }

    /**
     * 
     */
    public String listAllLoans(){
        String nLine = System.getProperty("line.seperator");
    }

    }
