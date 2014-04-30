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
    private DVDContainer dvdCont;
    
    /**
     * Constructor for objects of class LoanCtr
     */
    public LoanCtr()
    {
        loanCon = LoanContainer.getInstance();
        dvdCont = DVDContainer.getInstance();
    }

    /**
     * @
     * @
     */
    public void createLoan(int personID, ArrayList<Integer> dvdIds){
        Person p = addressBook.getPerson(personID);
        ArrayList<DVD> dvds = dvdCont.getAllDVDs();
        ArrayList<Copy> copies = new ArrayList<Copy>();
        if(p != null && !dvdIds.isEmpty()){
            for(Integer i : dvdIds){
                for(DVD dvd : dvds){
                    if(dvd.getID() == i){
                        HashSet<Copy> dvdCopies = dvd.getCopies();
                        for(Copy c : dvdCopies){
                            if(!c.getLent()){
                                copies.add(c);
                                c.setLent(true);
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            throw new NullPointerException("Person does not exist, or there are no dvds added to the list");
        }
        
        loanCon.createLoan(p, copies);
    }
    
    public boolean personExist(int personID){
        Person p = addressBook.getPerson(personID);
        boolean retBool = false;
        
        if(p != null){
            retBool = true;
        }
        
        return retBool;
    }
    
    public boolean hasCopies(int dvdID){
        DVD dvd = dvdCont.getDVD(dvdID);
        return dvd.hasCopies();
    }

    /**
     * Ends the loan -- All DVDs are handed in.
     * 
     * @param int loanID : The ID of the loan
     * @param int personID : The ID of the person
     */
    public void endLoan(int personID, int loanID){
        Person p = addressBook.getPerson(personID);
        Loan loan = loanCon.getLoan(p, loanID);
        if(loan != null){
            loan.setReturned(true);
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
    public boolean extendLoan(int personID, int loanID){
        boolean returnBoolean;
        Person p = addressBook.getPerson(personID);
        Loan loan = loanCon.getLoan(p, loanID);
        if(loan != null && !loan.getExtended()){
            int period = loan.getPeriod();
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
        String nL = System.getProperty("line.separater");
        
        if(p != null){
            ArrayList<Loan> loans = loanCon.getLoans(p);
            if(!loans.isEmpty()){
                String returnString = "";
                for(Loan l : loans){
                    String loanString = " ### Loan ID: " + l.getId() + " ### " + nL + "Copies:" + nL;
                    ArrayList<Copy> copies = l.getCopies();
                    for(Copy c : copies){
                        ArrayList<DVD> dvds = dvdCont.getAllDVDs();
                        for(DVD dvd : dvds){
                            boolean thisIsIt = false;
                            HashSet<Copy> dvdCopies = dvd.getCopies();
                            for(Copy dvdC : dvdCopies){
                                if(dvdC.getSerialNumber() == c.getSerialNumber()){
                                    thisIsIt = true;
                                }
                            }
                            if(thisIsIt){
                                loanString += "  - " + dvd.getTitle() + nL;
                            }
                        }
                    }
                    loanString += "Returned: " + l.getReturned() + nL;
                    returnString += loanString;
                }
            
                //returnString = returnString.substring(0, returnString.length()-2) + ")";
                
                return returnString;
            } else{
               throw new NullPointerException("There are no Loans"); 
            }
        } else{
            throw new NullPointerException("Person ID not found");
        }
    }

    /**
     * listAllLoans - Lists all loans from all persons
     * @return String : Returns a string with all persons loans.
     */
    public String listAllLoans(){
        HashMap<Person, ArrayList<Loan>> loans = loanCon.getAllLoans();
        String returnString = null;
        String nLine = System.getProperty("line.seperator");
        
        Iterator it = loans.keySet().iterator();
        
        if(!loans.isEmpty()){
            for(Person p : loans.keySet()) {
                returnString += getLoansByID(p.getID());
            }
        } else{
            throw new NullPointerException("Loans could not be found");
        }
        
        return returnString;
    }

}
