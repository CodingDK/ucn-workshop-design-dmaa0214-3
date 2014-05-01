package ControlLayer;
import java.util.*;
import ModelLayer.*;

/**
 * Controller for Loans.
 * 
 * @author Group 3
 * @version 0.4 
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
     * createLoan - Create a loan.
     * @param personID The id of the person object.
     * @param dvdIDs a ArrayList<Integer> of integers with dvdID to lent.
     */
    public void createLoan(int personID, ArrayList<Integer> dvdIDs){
        DVDCtr dvdCtr = new DVDCtr();
        AddressCtr addrCtr = new AddressCtr();
        Person p = addrCtr.getPerson(personID);
        ArrayList<Copy> copies = new ArrayList<Copy>();
        if(!dvdIDs.isEmpty()){
            for(Integer i : dvdIDs){
                Copy c = dvdCtr.getDVD(i).getAvailableCopy();
                copies.add(c);
                c.setLent(true);
            }
        } else {
            throw new NullPointerException("There are no dvds added to the list");
        }
        
        loanCont.addLoan(p, new Loan(copies));
    }
    
    /**
     * personExist - Check about a person exists.
     * @param personID The id of the person object to check.
     * @return boolean - true if the person exist and false if the person not exist.
     */
    public boolean personExist(int personID){
        Person p = addressBook.getPerson(personID);
        boolean retBool = false;
        
        if(p != null){
            retBool = true;
        }
        
        return retBool;
    }
    
    /**
     * hasCopies - Check about a dvd has copies.
     * @param dvdID The id of the dvd object to check.
     * @return boolean - true if the dvd has available copies and false if not.
     */
    public boolean hasCopies(int dvdID){
        DVD dvd = dvdCont.getDVD(dvdID);
        if(dvd != null){
            return dvd.hasCopies();
        } else{
            throw new NullPointerException("DVD id dont exits");
        }
    }

    /**
     * endLoan - Ends the loan - All DVDs are handed in.
     * @param loanID The ID of the loan.
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
     * Extends a specific loan.
     * Can only be extended once
     * @param loanID The ID of the loan
     * @return boolean - true/false : The loan was/n't extended
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
     * @param personID The ID of the person.
     * @return String - The persons loans.
     */
    public String getLoansByID(int personID){
        Person p = addressBook.getPerson(personID);
        String nL = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        
        if(p != null){
            ArrayList<Loan> loans = loanCont.getLoans(p);
            if(!loans.isEmpty()){
                sb.append("### Name: " + p.getName() + " - ID: " + p.getID() + " ### " + nL);
                for(Loan l : loans){
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
                                sb.append("  - " + dvd.getTitle() + nL);
                            }
                        }
                    }
                    sb.append("Returned: " + l.getReturned() + nL + "Borrow Date: " + l.getBorrowDate() + nL + "Due Date: " + l.getDueDate() + nL + nL);
                }
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
     * @return String - Returns a string with all Loans.
     */
    public String listAllLoans(){
        HashMap<Person, ArrayList<Loan>> loans = loanCont.getAllLoans();
        String nLine = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append(nLine + "\f  *** All Loans *** " + nLine);
        
        if(!loans.isEmpty()){
            for(Person p : loans.keySet()) {
                sb.append(nLine + getLoansByID(p.getID()));
            }
        } else{
            throw new NullPointerException("Loans could not be found");
        }
        
        return sb.toString();
    }
    
    /**
     * getDVDTitleByID - Returns the title of DVD
     * @return String - DVD Title
     */
    public String getDVDTitleByID(int dvdID){
        DVDCtr dvdCtr = new DVDCtr();
        return dvdCtr.getTitleByID(dvdID);
    }
    
}
