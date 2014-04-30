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

    private void LoanMenu(){   
        boolean exit = false;
        while(!exit){
            int choice = writeLoanMenu();
            if (choice == 1){
                createLoan();
            }else if(choice == 2){
                endLoan();
            }else if(choice == 3){
                extendLoan();
            }else if(choice == 4){
                printLoans();
            }else if(choice == 5){
                printAllLoans();
            }else if(choice == 6){
                exit = true;
            }
        }
    }
    
    /**
     * writeLoanMenu - Write the Loan menu.
     */
    private int writeLoanMenu(){
        int choice;
        try{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\f*** Loan Menu ***");
            System.out.println("(1) Create Loan");
            System.out.println("(2) End Loan");
            System.out.println("(3) Extend Loan");
            System.out.println("(4) Print Loan");
            System.out.println("(5) Print All Loans");
            System.out.println("(6) Return");
            System.out.print("\nMake your choice: ");
            
            choice = keyboard.nextInt();
        }catch(InputMismatchException e){
            choice = 0;
        } 
        return choice;
    }
    
    private void createLoan(){
        boolean exit = false;
        
        try{
            Scanner keyboard = new Scanner(System.in);
            ArrayList<Integer> dvdIDs = new ArrayList<Integer>();
            LoanCtr loanCtr = new LoanCtr();
            
            System.out.print("Person ID: ");
            int personID = keyboard.nextInt();
            keyboard.nextLine();
            if(!loanCtr.personExist(personID)){
                System.out.println("Person ID dont exist!");
                pause();
                return;
            }
            
            while(!exit){
                int choice;
                
                try{
                                       
                    System.out.println("\f*** Create Loan Menu ***");
                    System.out.println("(1) Loan DVD");
                    System.out.println("(2) End create loan");
                    System.out.println("(3) Cancel create loan");
                    System.out.print("\nMake your choice: ");
                    choice = keyboard.nextInt();
                    keyboard.nextLine();
                    
                }catch(InputMismatchException e){
                    choice = 0;
                } 
                if (choice == 1){
                    try{
                        System.out.print("DVDid: ");
                        int dvdID = keyboard.nextInt();
                        keyboard.nextLine();
            
                        if(dvdIDs.contains(dvdID)){
                            System.out.println("DVD already on the list");
                            pause();
                        }else if(loanCtr.hasCopies(dvdID)){
                            System.out.println("DVD added to loan");
                            dvdIDs.add(dvdID);
                            pause();
                        } else {
                            System.out.println("DVD dont have available copies.");
                            pause();
                        }
                    }catch(InputMismatchException e){
                        choice = 0;
                    }catch(NullPointerException e1){
                        System.out.println(e1);
                        pause();
                    }
                }else if(choice == 2){
                    loanCtr.createLoan(personID, dvdIDs);
                    System.out.println("Loan created.");
                    pause();
                    exit = true;
                }else if(choice == 3){
                    exit = true;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid values");
            pause();
            return;
        }catch(NullPointerException e1){
            System.out.println(e1);
            pause();
            return;
        }
    }
    
    private void endLoan(){
    
    }
    
    private void extendLoan(){
    
    }
    
    private void printLoans(){
    
    }
    
    private void printAllLoans(){
        LoanCtr loanCtr = new LoanCtr();
        System.out.println(loanCtr.listAllLoans());
        pause();
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
