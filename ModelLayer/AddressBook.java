package ModelLayer;
import java.util.ArrayList;


/**
 * Write a description of class AddressBook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AddressBook
{
    private AddressBook instance;
    private ArrayList<Person> persons;

    /**
     * Constructor for objects of class AddressBook
     */
    private AddressBook(){
        persons = new ArrayList<Person>();
    }


    public AddressBook getInstance(){
        if(instance == null){
            instance = new AddressBook();
        }
        
        return instance;
    }
}
