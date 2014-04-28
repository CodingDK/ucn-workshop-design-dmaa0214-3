package TUILayer;//makes this class a part of the TUILayer package
import java.util.*;
import ControlLayer.*;//The TUILayer needs to know the ControlLayer

/**
 * User interface class to the AddressBook
 * 
 * @author Group 3 
 * @version (2005.03.31)
 * (FEN): 2006.03.21: Comments translated into English
 * (FEN): 2006.03.21: Some changes to the architecture in order to assure layering
 *                    and loose coupling
 */
public class AddressBookUI
{   

    private AddressCtr addrCtr;//reference to the ControlLayer

    //constructor which does nothing
    public AddressBookUI()
    {

    }

    public void start()
    {
        addressMenu();
    }

    private void addressMenu()
    {
        boolean exit = false;

        while(!exit)//that is: while exit is false
        {
            int choice = writeAddressBookMenu(); 
            if(choice == 1)
            {   //show person
                getPerson();
            }
            else if(choice == 2){
                //create person
            }  
            else if(choice == 3){
                //delete person
            }  
            else if(choice == 4){
                // update person
            }
            else if(choice == 5){
                // listAllPersons();
            }
            else if(choice == 6){
                exit = true;
            }

        }//end while
    }

    private int writeAddressBookMenu()
    {      // makes an object keyboard to read input from the screen
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\f *** AddressBook Menu ***");
        System.out.println(" (1) Show information about person");
        System.out.println(" (2) Add person");
        System.out.println(" (3) Delete person");
        System.out.println(" (4) Update person");
        System.out.println(" (5) List all persons");
        System.out.println(" (6) Return");
        System.out.print("\n Make your choice: ");

        int choice = keyboard.nextInt();
        return choice;
    }

    /**
     * Methods for deleting a person
     */
    private void deletePerson(){
        int deleteID;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's the ID of the person you will delete from the address book?");
        deleteID = keyboard.nextInt();
        try{
            addrCtr.deletePerson(deleteID);
        } catch(NullPointerException e){
            System.out.println(e);
        }
    }

    /**
     * Methods for printing a person
     */
    private void printPerson(){
        int printID;
        System.out.println("What's the ID of the person you want to print?");
        Scanner keyboard = new Scanner(System.in);
        printID = keyboard.nextInt();

        try {
            System.out.println(addrCtr.getPersonInfo(printID));
        }
        catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    /**
     * Methods for change location
     */

    private void changeLocation(){
        String addr;
        String city;
        int postalCode;
        int id;
        AddressCtr addrCtr = new AddressCtr();
        Scanner keyboard = new Scanner(System.in);
        
        try{
            System.out.println("What's the ID of the person?");
            id = keyboard.nextInt();
        } catch (InputMismatchException e){
            System.out.println(e);
        }
        
        try{
            System.out.println("What's the new address?");
            addr = keyboard.nextLine();
        } catch (InputMismatchException e){
            System.out.println(e);
        }

        try{
            System.out.println("What's the new city?");
            city = keyboard.nextLine();
        } catch (InputMismatchException e){
            System.out.println(e);
        }
        
        try{
        System.out.println("What's the new postal code?");
        postalCode = keyboard.nextInt();
        } catch (InputMismatchException e){
            System.out.println(e);
            return;
        }
        
        addrCtr.changeLocation(id, addr, postalCode, city); 
    }

    
    /**
     * Methods for change name
     */
    private void changeName(){
        String name;        
        int nameID;
        AddressCtr addrCtr = new AddressCtr();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's the new name?");
        name = keyboard.nextLine();
        System.out.println("What's the ID of the person?");
        nameID = keyboard.nextInt();
        addrCtr.changeName(nameID, name);
    }
    
    

    
    
    /**
     * Methods for change phone
     */

    /**
     * Methods for listing all persons 
     */
    public long inputPersonsID()
    {   
        boolean ok = false;
        long id = 0;
        while(!ok)
        {
            // makes an object keyboard to have input from the console
            Scanner keyboard = new Scanner(System.in);
            System.out.println(" Write Id:  ");
            try{
                id = keyboard.nextLong();
                ok = true;
            }
            catch (Exception e)
            {
                System.out.println("You must enter a number -  try again");
                String input = keyboard.nextLine();
            }
        }//end while
        return id;
    }

    public String inputName()
    {
        // makes an object keyboard to have input from the screen
        Scanner keyboard = new Scanner(System.in);  
        System.out.println(" Write Name:  ");
        String name = keyboard.nextLine();
        return name;
    }

    public String inputPostalCode()
    {
        // makes an object keyboard to have input from the screen
        Scanner keyboard = new Scanner(System.in);  
        System.out.println(" Write Postal Code:  ");
        String code = keyboard.nextLine();
        return code;
    }

    public String inputCity()
    {
        // makes an object keyboard to have input from the screen
        Scanner keyboard = new Scanner(System.in);  
        System.out.println(" Write City:  ");
        String city = keyboard.nextLine();
        return city;
    } 

    public String inputPhone()
    {
        // makes an object keyboard to have input from the screen
        Scanner keyboard = new Scanner(System.in);  
        System.out.println(" Write Phone Number:  ");
        String phone = keyboard.nextLine();
        return phone;
    } 

    public String  inputAddress()
    {
        // makes an object keyboard to read input from the console
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Write Address: ");
        String address = keyboard.nextLine();
        return address;
    }

    public void showId(long id)
    {
        System.out.println("ID of the person: " + id);
    }

    public void showName(String name)
    { 
        System.out.println("The name of the persone: " + name);
    }

    public void showAddress(String address)
    { 
        System.out.println("The address of the person: " + address);
    }

    private void getPerson()
    {//is to be changed when the address book controller is completed
        long id = inputPersonsID();

    }   
}

