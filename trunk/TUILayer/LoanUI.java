package TUILayer;
import java.util.*;
import ControlLayer.*;

/**
 * Write a description of class LoanUI here.
 * 
 * @author Group 3
 * @version 0.1
 */
public class LoanUI{

    /**
     * Constructor for objects of class LoanUI
     */
    public LoanUI(){
        LoanMenu();
    }

        public void LoanMenu(){   
        boolean exit = false;
        while(!exit){
            int choice = writeLoanMenu();
            if (choice == 1){
                createLoan();
            }else if(choice == 2){
                returnDVD();
            }else if(choice == 3){
                extendLoan();
            }else if(choice == 4){
                addCopy();
            }else if(choice == 5){
                printLoans();
            }else if(choice == 6){
                printAllLoans();
            }else if(choice == 7){
                exit = true;
            }
        }
    }
    
    /**
     * writeLoanMenu - Write the Loan menu.
     */
    private int writeLoanMenu(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\f *** Loan Menu ***");
        System.out.println(" (1) Loan DVD");
        System.out.println(" (2) Return DVD");
        System.out.println(" (3) Extend Loan");
        System.out.println(" (4) Add Copy To Existing Loan");
        System.out.println(" (5) Print Loan");
        System.out.println(" (6) Print All Loans");
        System.out.println(" (7) Return");
        System.out.print("\n Make your choice: ");
        
        int choice = keyboard.nextInt();
        return choice;
    }
    
    private void createLoan(){
    
    }
    
    private void returnDVD(){
    
    }
    
    private void extendLoan(){
    
    }
    
    private void addCopy(){
    
    }
    
    private void printLoans(){
    
    }
    
    private void printAllLoans(){
    
    }

    /**
     * pause - Waiting for user to press enter.
     */
    private void pause(){
        Scanner keyboard = new Scanner(System.in);
        String pause = keyboard.nextLine();
    }
    
    /**
     * confirmStatement - Using the user confirmation.
     */
    private boolean confirm(String confirmStatement){
        boolean confirm = true;
        Scanner s = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            System.out.println();
            System.out.println(confirmStatement);
            System.out.println("Confirm - y/n");
            String conf = s.nextLine();
            if(conf.toLowerCase().equals("y")){
                confirm = true;
                exit = true;
            }else if(conf.toLowerCase().equals("n")){
                confirm = false;
                exit = true;
            }
        }
        return confirm;
    }
}
