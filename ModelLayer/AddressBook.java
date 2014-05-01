package ModelLayer;
import java.util.ArrayList;

/**
 * AddressBook containes a list of all persons in the AddressBook.
 * 
 * @author Group 3
 * @version 0.2
 */
public class AddressBook{
    private static AddressBook instance;
    private ArrayList<Person> persons;

    /**
     * Constructor for objects of class AddressBook
     */
    private AddressBook(){
        persons = new ArrayList<Person>();
    }

    /**
     * getInstance - Get only one instance of the AddressBook.
     * @return AddressBook - The instance of the AddressBook.
     */
    public static AddressBook getInstance(){
        if(instance == null){
            instance = new AddressBook();
        }
        
        return instance;
    }
    
    /**
     * deletePerson - Delete a person from the AddressBook.
     * @param person The person obejct to delete.
     */
    public void deletePerson(Person person){
        persons.remove(person);
    }
    
    /**
     * addPerson - Add a person obejct to the AddressBook.
     * @param person The person obejct to add.
     */
    public void addPerson(Person person){
        persons.add(person);
    }
    
    /**
     * getPerson - Get a person obejct from the id of the person.
     * @param id - The id of the person.
     * @return Person obejct of the person, or null if not found.
     */
    public Person getPerson(int id){
        Person returnPerson = null;
        
        for(Person p : persons){
            if(p.getID() == id){
                returnPerson = p;
            }
        }
        
        return returnPerson;
    }
    
    /**
     * getAllPersons - Get the ArrayList of Persons obejcts.
     * @return ArrayList<Person> with all the persons in the AddressBook.
     */
    public ArrayList<Person> getAllPersons(){
        return persons;
    }
    
}
