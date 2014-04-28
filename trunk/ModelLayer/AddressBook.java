package ModelLayer;
import java.util.ArrayList;


/**
 * Write a description of class AddressBook here.
 * 
 * @author Group 3
 * @version 0.1
 */
public class AddressBook
{
    private AddressBook instance;
    private ArrayList<Person> persons;

    /**
     * Constructor for objects of class AddressBook
     */
    public AddressBook(){
        persons = new ArrayList<Person>();
    }


    public AddressBook getInstance(){
        if(instance == null){
            instance = new AddressBook();
        }
        
        return instance;
    }
    
    public void createPerson(String name, String address, int postalCode, String city, String phone){
        addPerson(new Person(name, address, postalCode, city, phone));
    }
    
    public void deletePerson(Person person){
        persons.remove(person);
    }
    
    private void addPerson(Person person){
        persons.add(person);
    }
    
    public Person getPerson(int id){
        Person returnPerson = null;
        
        for(Person p : persons){
            if(p.getID() == id){
                returnPerson = p;
            }
        }
        
        return returnPerson;
    }
    
    public ArrayList<Person> getAllPersons(){
        return persons;
    }
    
}
