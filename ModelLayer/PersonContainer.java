package ModelLayer;
import java.util.ArrayList;


/**
 * Write a description of class DVDContainer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PersonContainer
{
    private PersonContainer instance;
    private ArrayList<Person> persons;

    /**
     * Constructor for objects of class DVDContainer
     */
    private PersonContainer(){
        persons = new ArrayList<Person>();
    }


    public PersonContainer getInstance(){
        if(instance == null){
            instance = new PersonContainer();
        }
        
        return instance;
    }
}
