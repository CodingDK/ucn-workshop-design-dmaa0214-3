package TUILayer;//makes this class a part of the TUILayer package
import java.util.*;
import java.io.*;
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
public class AddressBookUI{   
    
    public AddressBookUI()
    {
        AddressCtr addrCtr = new AddressCtr();
        addrCtr.createPerson("Lasse", "address", 8800, "Noget", "+4598642601");
        addrCtr.createPerson("Lau", "address", 8800, "Noget", "+4598642601");
        
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
              printPerson();
          }
          else if(choice == 2){
              createPerson();
          }  
          else if(choice == 3){
              deletePerson();
          }  
          else if(choice == 4){
              // update person
          }
          else if(choice == 5){
              listAllPersons();
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
     * Methodes for creating a person
     */
    
    private void createPerson(){
        try{
            AddressCtr addrCtr = new AddressCtr();
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Name: ");
            String name = keyboard.nextLine();
            if(name.trim().isEmpty()){
                System.out.println("Name can't be empty!");
                pause();
                return;
            }
            System.out.print("Address: ");
            String address = keyboard.nextLine();
            if(address.trim().isEmpty()){
                System.out.println("Address cant be empty!");
                pause();
                return;
            }
            System.out.print("PostalCode: ");
            int postalCode = keyboard.nextInt();
            
            keyboard.nextLine(); // Consumes the new line when enter is pressed.
            
            System.out.print("City: ");
            String city = keyboard.nextLine();
            if(city.trim().isEmpty()){
                System.out.println("City cant be empty!");
                pause();
                return;
            }
            System.out.print("Phone Number: ");
            String phone = keyboard.nextLine();
            if(phone.trim().length() < 11){
                System.out.println("Phone number cant be less than 11");
                pause();
                return;
            }
            if(confirm("Add Person(Name: " + name + ", Address: " + address + ", Postalcode: " + postalCode + ", City: " + 
            city + ", Phone Number: " + phone + ")")){
                addrCtr.createPerson(name, address, postalCode, city, phone);
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid values!");
            pause();
            return;
        }
    }
        
    /**
     * Methods for deleting a person
     */
    private void deletePerson(){
        try{
            AddressCtr addrCtr = new AddressCtr();
            Scanner keyboard = new Scanner(System.in);
            System.out.println("What's the ID of the person you want to delete from the address book?");
            int deleteID = keyboard.nextInt();
            if(confirm("Are you sure you wish to delete the person with the following id: " + deleteID)){
                addrCtr.deletePerson(deleteID);
            }
        }catch(InputMismatchException e1){
            System.out.println("Invalid values");
            pause();
            return;
        }catch(NullPointerException e){
            System.out.println(e);
            pause();
            return;
        }
    }
    
    /**
     * Methods for printing a person
     */
    private void printPerson(){
        try {
            AddressCtr addrCtr = new AddressCtr();
            int printID;
            System.out.println("What's the ID of the person you want to print?");
            Scanner keyboard = new Scanner(System.in);
            printID = keyboard.nextInt();
            System.out.println(addrCtr.getPersonInfo(printID));
            pause();
        }catch(InputMismatchException e1){
            System.out.println("Invalid values");
        }catch (NullPointerException e) {
            System.out.println(e);
        }
    }
    
    /**
     * Methods for change location
     */
    private void changeLocation(){
        try{
            String addr;
            String city;
            int postalCode;
            int id;
            AddressCtr addrCtr = new AddressCtr();
            Scanner keyboard = new Scanner(System.in);
            System.out.println("What's the ID of the person?");
            id = keyboard.nextInt();
    
            System.out.println("What's the new address?");
            addr = keyboard.nextLine();
    
            System.out.println("What's the new city?");
            city = keyboard.nextLine();
            
            System.out.println("What's the new postal code?");
            postalCode = keyboard.nextInt();
            if(confirm("Are you sure you wish to change the location to: " + addr + ", " + postalCode + ", " + city)){
                addrCtr.changeLocation(id, addr, postalCode, city);
            }
        } catch (InputMismatchException e){
            System.out.println(e);
            pause();
            return;
        }
    }
    
    /**
     * Methods for change name
     */
    private void changeName(){
        try{
            String name;        
            int nameID;
            AddressCtr addrCtr = new AddressCtr();
            Scanner keyboard = new Scanner(System.in);
            System.out.println("What's the new name?");
            name = keyboard.nextLine();
            System.out.println("What's the ID of the person?");
            nameID = keyboard.nextInt();
            if(confirm("Do you wish to change to name to: " + name)){
                addrCtr.changeName(nameID, name);
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid values");
        }catch(NullPointerException e1){
            System.out.println(e1);
        }
    }
     
    /**
     * Methods for change phone
     */
    private void changePhone(){
        try{
            AddressCtr addrCtr = new AddressCtr();
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Person ID: ");
            int id = keyboard.nextInt();
            System.out.print("Phone Number: ");
            String phone = keyboard.nextLine();
            if(phone.trim().length() < 11){
                System.out.println("The phone number must be atleast 11 chars long");
                pause();
                return;
            }
            
            if(confirm("Do you wish to change the phone number to: " + phone)){
                addrCtr.changePhone(id, phone);
            }
        }catch(InputMismatchException e){
            System.out.println("ID must be a number");
            pause();
            return;
        }catch(NullPointerException e1){
            System.out.println(e1);
            pause();
            return;
        }
    }
    
    /**
     * Methods for listing all persons 
     */
    private void listAllPersons(){
        try{
            AddressCtr addrCtr = new AddressCtr();
            System.out.println(addrCtr.listAllPersons());
            pause();
        }catch(NullPointerException e){
            System.out.println(e);
            pause();
        }
    }
    
    private void pause(){
        Scanner keyboard = new Scanner(System.in);
        String pause = keyboard.nextLine();
    }
    
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
            
        
