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
    private LoanContainer loanCont;
    private AddressBook addressBook;
    private DVDContainer dvdCont;
    
    /**
     * Constructor for objects of class LoanCtr
     */
    public LoanCtr()
    {
        loanCont = LoanContainer.getInstance();
        dvdCont = DVDContainer.getInstance();
        addressBook = AddressBook.getInstance();
    }

    /**
     * @addLoan(person, new Loan(copies));
     * @
     */
    public void createLoan(int personID, ArrayList<Integer> dvdIds){
        DVDCtr dvdCtr = new DVDCtr();
        AddressCtr addrCtr = new AddressCtr();
        Person p = addrCtr.getPerson(personID);
        ArrayList<Copy> copies = new ArrayList<Copy>();
        if(p != null && !dvdIds.isEmpty()){
            for(Integer i : dvdIds){
                Copy c = dvdCtr.getDVD(i).getAvailableCopy();
                copies.add(c);
                c.setLent(true);
            }
        } else {
            throw new NullPointerException("Person does not exist, or there are no dvds added to the list");
        }
        
        loanCont.addLoan(p, new Loan(copies));
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
        if(dvd != null){
            return dvd.hasCopies();
        } else{
            throw new NullPointerException("DVD id dont exits");
        }
    }

    /**
     * Ends the loan -- All DVDs are handed in.
     * @param int loanID : The ID of the loan
     */
    public void endLoan(int loanID){
        Loan loan = loanCont.getLoan(loanID);
        if(loan != null){
            if(loan.getReturned()){
                throw new NullPointerException("Loan already returned.");
            } else {
                loan.endLoan();
            }
        } else{
            throw new NullPointerException("Loan not found");
        }
        
    }
        
    
    /**
     * Extends the specific loan.
     * Can only be extended once
     * @param int loanID : The ID of the loan
     * @return boolean true/false : The loan was/n't extended
     */
    public boolean extendLoan(int loanID){
        boolean returnBoolean = false;
        Loan loan = loanCont.getLoan(loanID);
        if(loan != null){
            if(!loan.getExtended()){
                loan.extend();
                returnBoolean = true;
            }
        } else{
                throw new NullPointerException("Loan ID was not found");
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
        String nL = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        
        if(p != null){
            ArrayList<Loan> loans = loanCont.getLoans(p);
            if(!loans.isEmpty()){
                //String returnString = "### Name: " + p.getName() + " - ID: " + p.getID() + " ### " + nL;
                sb.append("### Name: " + p.getName() + " - ID: " + p.getID() + " ### " + nL);
                for(Loan l : loans){
                    //String loanString = "*** Loan ID: " + l.getId() + " *** " + nL + "Copies:" + nL;
                    sb.append("*** Loan ID: " + l.getId() + " *** " + nL + "Copies:" + nL);
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
                                //loanString += "  - " + dvd.getTitle() + nL;
                                sb.append("  - " + dvd.getTitle() + nL);
                            }
                        }
                    }
                    //loanString += "Returned: " + l.getReturned() + nL + "Borrow Date: " + l.getBorrowDate() + nL + "Due Date: " + l.getDueDate() + nL;
                    sb.append("Returned: " + l.getReturned() + nL + "Borrow Date: " + l.getBorrowDate() + nL + "Due Date: " + l.getDueDate() + nL + nL);
                    //returnString += loanString;
                }
                //return returnString;
                return sb.toString();
            } else{
               throw new NullPointerException("There are no Loans"); 
            }
        } else{
            throw new NullPointerException("Person ID not found");
        }
    }

    /**
     * listAllLoans - Lists all loans from all persons
     * @return String : Returns a string with all Loans.
     */
    public String listAllLoans(){
        HashMap<Person, ArrayList<Loan>> loans = loanCont.getAllLoans();
        String nLine = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        //String returnString = nLine + "\f  *** All Loans *** " + nLine;
        sb.append(nLine + "\f  *** All Loans *** " + nLine);
        
        if(!loans.isEmpty()){
            for(Person p : loans.keySet()) {
                //returnString += nLine + getLoansByID(p.getID()) + nLine;
                sb.append(nLine + getLoansByID(p.getID()));
            }
        } else{
            throw new NullPointerException("Loans could not be found");
        }
        
        //return returnString;
        return sb.toString();
    }

}
