package TUILayer;
import java.util.*;
import java.io.*;
import ControlLayer.*;
/**
 * 
 * User interface - main menu
 * The entry-point for the application:
 * Create an instance of class MainMenuUI and the constructor starts the application
 * 
 * @author Group 3
 * @version 0.3
 */
public class MainMenuUI
{
   private AddressBookUI adrUI;
   private DvdUI dvdUI;
   private LoanUI loanUI;
   
   /**
    * Constructor for the MainMenuUI.
    */
   public MainMenuUI(){
       adrUI = null;
       dvdUI = null;
       loanUI = null;
   }
   
   /**
    * mainMenuStart - Make the main menu.
    */
   public void mainMenuStart(){
        boolean exit=false;
        while (!exit){
            int choice = writeMainMenu();
            if(choice == 1){
                startAddressBook();
            }else if(choice == 2){ 
                startDvd();
            }else if(choice == 3){
                startLoan();
            }else if(choice == 4){
                writeEnd();
                exit = true;
            }else if(choice == 5){
                test();
            }     
        }
   }
   
   /**
    * writeMainStart - Write the main menu.
    */
   private int writeMainMenu(){       
       int choice;
       try{     
           // creates a keyboard object to read input
           Scanner keyboard = new Scanner(System.in);
           System.out.println("\f *** MainMenu ***");
           System.out.println(" (1) AddressBook");
           System.out.println(" (2) DVDs");
           System.out.println(" (3) Loan");
           System.out.println(" (4) Close");
           System.out.println(" (5) Test");
           System.out.print("\n Make your choice: ");
        
           choice = keyboard.nextInt();
       }catch(InputMismatchException e){
            choice = 0;
       }
            
       return choice;
    }
    
    /**
     * startAddressBook - Start the AddressBookUI.
     */
    private void startAddressBook(){
        adrUI = new AddressBookUI();
    }

    /**
     * startDvd - Start the DvdUI.
     */
    private void startDvd(){
        dvdUI = new DvdUI();
    }
    
    /**
     * startLoan - Start the Loan UI
     */
    private void startLoan(){
        loanUI = new LoanUI();
    }
    
    /**
     * writeEnd - Write the shutdown confirm.
     */
    private void writeEnd(){
        System.out.println("The system is shuting down.");
    }
    
    /**
     * test - make some test persons in the system.
     */
    private void test(){
        AddressCtr addrCtr = new AddressCtr();
        addrCtr.createPerson("Lasse", "address", 8800, "Noget", "+4598642601");
        addrCtr.createPerson("Lau", "address", 8800, "Noget", "+4598642601");
        DVDCtr dvdCtr = new DVDCtr();
        dvdCtr.createDVD("Batman", "Børge fra lem", 2012);
        dvdCtr.createDVD("Batman 2", "Lasse", 2013);
        dvdCtr.addCopy(1, "03-02-2012", 50);
        dvdCtr.addCopy(1, "03-02-2013", 50);
        dvdCtr.addCopy(2, "03-02-2014", 150);
        dvdCtr.addCopy(2, "03-02-2013", 150);
        
        LoanCtr lCtr = new LoanCtr();
        ArrayList<Integer> loan = new ArrayList<Integer>();
        loan.add(1);
        loan.add(2);
        lCtr.createLoan(1, loan);
        
        ArrayList<Integer> loan2 = new ArrayList<Integer>();
        loan2.add(1);
        loan2.add(2);
        lCtr.createLoan(2, loan2);
    }
 }
