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
     * 
     */
    public void returnDVD(int loanID){
    
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
        
    }
    
    /**
     * 
     */
    public String listAllLoans(){
        String nLine = System.getProperty("line.seperator");
    }

}
