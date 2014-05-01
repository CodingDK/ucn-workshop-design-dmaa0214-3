package TUILayer;
import java.util.*;
import java.io.*;
import ControlLayer.*;

/**
 * User interface class to the AddressBook
 * 
 * @author Group 3 
 * @version 0.3
 */
public class AddressBookUI extends MenuUI{   
    
    public AddressBookUI(){
        addressMenu();
    }
    
    /**
     * addressMenu - Starts the menu selection
     */
    private void addressMenu(){
       boolean exit = false;
       
       while(!exit){
          int choice = writeAddressBookMenu(); 
          if(choice == 1){
              printPerson();
          }else if(choice == 2){
              createPerson();
          }else if(choice == 3){
              deletePerson();
          }else if(choice == 4){
              updatePersonMenu();
          }else if(choice == 5){
              listAllPersons();
          }else if(choice == 6){
              exit = true;
          }
       }
    }
    
    /**
     * writeAddressBookMenu - Menu for the addressbook.
     */
    private int writeAddressBookMenu(){
       int choice;
       try{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\f*** AddressBook Menu ***");
            System.out.println("(1) Show information about person");
            System.out.println("(2) Add person");
            System.out.println("(3) Delete person");
            System.out.println("(4) Update person");
            System.out.println("(5) List all persons");
            System.out.println("(6) Return");
            System.out.print("\nMake your choice: ");
            
            choice = keyboard.nextInt();
       }catch(InputMismatchException e){
            choice = 0;
       }
            
       return choice;
    }
    
    /**
     * writeUpdatePersonMenu - Menu for updating a person.
     */
    private int writeUpdatePersonMenu(){
           Scanner keyboard = new Scanner(System.in);
           System.out.println("*** Update person Menu ***");
           System.out.println("(1) Change location");
           System.out.println("(2) Change name");
           System.out.println("(3) Change phone");
           System.out.println("(4) Return");
           System.out.print("\nMake your choice: ");
            
           int c = keyboard.nextInt();
           return c;
    }
    
    /**
     * updatePersonMenu - Choose in the update person menu.
     */
    private void updatePersonMenu(){
        boolean exit = false;   
        while(!exit){ 
            int c = writeUpdatePersonMenu();
            if(c == 1){
                changeLocation();
            }else if(c == 2){
                changeName();
            }else if(c == 3){
                changePhone();
            }else if(c == 4){
                exit = true;
            }
        }
    }
    
    /**
     * Methodes for creating a person.
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
                System.out.println("Address can't be empty!");
                pause();
                return;
            }
            
            System.out.print("PostalCode: ");
            int postalCode = keyboard.nextInt();
            
            keyboard.nextLine(); // Consumes the new line when enter is pressed.
            
            System.out.print("City: ");
            String city = keyboard.nextLine();
            if(city.trim().isEmpty()){
                System.out.println("City can't be empty!");
                pause();
                return;
            }
            
            System.out.print("Phone Number: ");
            String phone = keyboard.nextLine();
            if(phone.trim().length() < 8){
                System.out.println("Phone number can't be less than 8");
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
     * deletePerson - deleting a person from the ID
     */
    private void deletePerson(){
        try{
            AddressCtr addrCtr = new AddressCtr();
            Scanner keyboard = new Scanner(System.in);
            
            System.out.print("What's the ID of the person you want to delete from the address book?" );
            int deleteID = keyboard.nextInt();
            String name = addrCtr.getNameByID(deleteID);
            
            if(confirm("Are you sure you wish to delete the person with the following id: " + deleteID + " " + name)){
                addrCtr.deletePerson(deleteID);
                System.out.println(name + " was deleted");
                pause();
            }
        }catch(InputMismatchException e1){
            System.out.println("Invalid values");
            pause();
            return;
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
            pause();
            return;
        }
    }
    
    /**
     * printPerson - Printing information about a person from the ID.
     */
    private void printPerson(){
        try {
            AddressCtr addrCtr = new AddressCtr();
            System.out.println("\f### Person Info ###");
            System.out.print("Person ID: ");
            Scanner keyboard = new Scanner(System.in);
            int printID = keyboard.nextInt();
            System.out.println(addrCtr.getPersonInfo(printID));
            pause();
        }catch(InputMismatchException e1){
            System.out.println("Invalid values");
            pause();
            return;
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
            pause();
            return;
        }
    }
    
    /**
     * changeLocation - Change the address, city and postalcode from the ID.
     */
    private void changeLocation(){
        try{
            AddressCtr addrCtr = new AddressCtr();
            Scanner keyboard = new Scanner(System.in);
            System.out.print("What's the ID of the person?: ");
            int id = keyboard.nextInt();
            keyboard.nextLine();
    
            System.out.print("What's the new address?: ");
            String addr = keyboard.nextLine();
            if(addr.trim().isEmpty()){
                System.out.println("Address can't be empty!");
                pause();
                return;
            }
    
            System.out.print("What's the new city?: ");
            String city = keyboard.nextLine();
            if(city.trim().isEmpty()){
                System.out.println("City can't be empty!");
                pause();
                return;
            }
            
            System.out.print("What's the new postal code? ");
            int postalCode = keyboard.nextInt();
            keyboard.nextLine();
            
            if(confirm("Are you sure you wish to change the location to: " + addr + ", " + postalCode + ", " + city)){
                addrCtr.changeLocation(id, addr, postalCode, city);
            }
        } catch (InputMismatchException e){
            System.out.println("Invalid values");
            pause();
            return;
        } catch (NullPointerException e1){
            System.out.println(e1.getMessage());
            pause();
            return;
        }
    }
    
    /**
     * changeName - Changing the name from the ID and old name.
     */
    private void changeName(){
        try{
            AddressCtr addrCtr = new AddressCtr();
            Scanner keyboard = new Scanner(System.in);
            System.out.print("What's the new name?: ");
            String name = keyboard.nextLine();
            System.out.print("What's the ID of the person?: ");
            int nameID = keyboard.nextInt();
            
            if(confirm("Do you wish to change to name to: " + name)){
                addrCtr.changeName(nameID, name);
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid values");
            pause();
            return;
        }catch(NullPointerException e1){
            System.out.println(e1.getMessage());
            pause();
            return;
        }
    }
     
    /**
     * changePhone - Changing the phone number from the ID.
     */
    private void changePhone(){
        try{
            AddressCtr addrCtr = new AddressCtr();
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Person ID: ");
            int id = keyboard.nextInt();
            keyboard.nextLine(); // Consumes the new line when enter is pressed.
            
            System.out.print("Phone Number: ");
            String phone = keyboard.nextLine();
            if(phone.trim().length() < 8){
                System.out.println("The phone number must be at least 8 chars long");
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
            System.out.println(e1.getMessage());
            pause();
            return;
        }
    }
    
    /**
     * listAllPersons - Listing all persons. 
     */
    private void listAllPersons(){
        try{
            AddressCtr addrCtr = new AddressCtr();
            System.out.println("\f" + addrCtr.listAllPersons());
            pause();
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
            pause();
        }
    }
}
            
        
