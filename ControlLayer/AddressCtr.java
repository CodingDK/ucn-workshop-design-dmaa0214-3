package ControlLayer;
import java.util.ArrayList;
import ModelLayer.*;

/**
 * Controller class for the address book
 * 
 * @author group 3
 * @version 0.1
 */
public class AddressCtr
{
    private AddressBook addressBook;
        
    public AddressCtr(){
        addressBook = AddressBook.getInstance();
    }
    
    
    public String getPersonInfo(int id){
        Person p = addressBook.getPerson(id);
        
        if (p != null){
            return "ID: " + p.getID() + ", Name: " + p.getName() + ", Address: " + p.getAddress() + 
        ", Postal: " + p.getPostalCode() + ", City: " + p.getCity() + ", Phone: " + p.getPhone();
        } else {
            throw new NullPointerException("Person was not found ");
        }
    }
    
    public void createPerson(String name, String address, int postalCode, String city, String phone){   
        addressBook.createPerson(name, address, postalCode, city, phone);
    }
    
    public void deletePerson(int id){
        Person p = addressBook.getPerson(id);
        if (p != null){
            addressBook.deletePerson(p);
        } else {
            throw new NullPointerException("Person was not found ");
        }
    }
    
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
    
    public void changeName(int id, String name){
        Person p = addressBook.getPerson(id);
        if (p != null){
            p.setName(name);
        } else {
            throw new NullPointerException("Person was not found ");
        }
    }
    
    public void changePhone(int id, String phone){
        Person p = addressBook.getPerson(id);
        if (p != null){
            p.setPhone(phone);
        } else {
            throw new NullPointerException("Person was not found ");
        }
    }
    
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
}
