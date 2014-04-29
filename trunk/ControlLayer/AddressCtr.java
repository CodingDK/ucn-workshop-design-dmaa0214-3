package ControlLayer;
import java.util.ArrayList;
import ModelLayer.*;

/**
 * Controller class for the address book
 * 
 * @author Group 3
 * @version 0.2
 * 
 * 
 * 
 * 
 * getNameByID
 */
public class AddressCtr
{
    private AddressBook addressBook;
        
    public AddressCtr(){
        addressBook = AddressBook.getInstance();
    }
    
    /**
     * getPersonInfo - Returns a string of information, by person id.
     * @param ID The id of the person.
     * @return String of person information.
     */
    public String getPersonInfo(int id){
        Person p = addressBook.getPerson(id);
        
        if (p != null){
            return "ID: " + p.getID() + ", Name: " + p.getName() + ", Address: " + p.getAddress() + 
        ", Postal: " + p.getPostalCode() + ", City: " + p.getCity() + ", Phone: " + p.getPhone();
        } else {
            throw new NullPointerException("Person was not found ");
        }
    }
    
    /**
     * createPerson - Creates a Person object and adds it to the AddressBook
     * @param name The name of the Person.
     * @param address The address of the person.
     * @param postalCode The postalCode of the person.
     * @param city The city of the person.
     * @param phone The phone number of the person.
     */
    public void createPerson(String name, String address, int postalCode, String city, String phone){   
        addressBook.createPerson(name, address, postalCode, city, phone);
    }
    
    /**
     * deletePerson - Delete a Person object, by person id.
     * @param id - The id of the person.
     */
    public void deletePerson(int id){
        Person p = addressBook.getPerson(id);
        if (p != null){
            addressBook.deletePerson(p);
        } else {
            throw new NullPointerException("Person was not found ");
        }
    }
    
    /**
     * changeLocation - Change the location of a person, by id.
     * @param id The id of the person to edit.
     * @param address The new address of the person.
     * @param postalCode The new postalCode of the person.
     * @param city The new city of the person.
     */
    public void changeLocation(int id, String address, int postalCode, String city){
        Person p = addressBook.getPerson(id);
        if (p != null){
            p.setAddress(address);
            p.setPostalCode(postalCode);
            p.setCity(city);
        } else {
            throw new NullPointerException("Person was not found ");
        }
    }
    
    /**
     * changeName - Change the name of a person, by id.
     * @param id The id of the person to edit.
     * @param name The new name of the person.
     */
    public void changeName(int id, String name){
        Person p = addressBook.getPerson(id);
        if (p != null){
            p.setName(name);
        } else {
            throw new NullPointerException("Person was not found ");
        }
    }
    
    /**
     * changePhone - Change the phoneNumber of a person, by id.
     * @param id The id of the person to edit.
     * @param phone The new phoneNumber of the person.
     */
    public void changePhone(int id, String phone){
        Person p = addressBook.getPerson(id);
        if (p != null){
            p.setPhone(phone);
        } else {
            throw new NullPointerException("Person was not found ");
        }
    }
    
    /**
     * listAllPersons - List all persons in the system.
     * @return String with list of all persons.
     */
    public String listAllPersons(){
        ArrayList<Person> persons = addressBook.getAllPersons();
        String nLine = System.getProperty("line.separator");
        String returnString = "### All Persons ###" + nLine;
        if (!persons.isEmpty()) {
            for(Person p : persons) {
                returnString += "#" + p.getID() + ", Name: " + p.getName() + ", Address: " + p.getAddress() + 
                ", Postal: " + p.getPostalCode() + ", City: " + p.getCity() + ", Phone: " + p.getPhone() + nLine;
            }
        } else {
            throw new NullPointerException("The addressbook is empty");
        }
        return returnString;
    }
    
    
    public String getNameByID(int id){
        Person p = addressBook.getPerson(id);
        if(p != null){
            return p.getName();
        } else {
            throw new NullPointerException("Person was not found");
        }
    }
}
