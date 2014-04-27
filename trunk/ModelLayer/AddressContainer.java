package ModelLayer;
import java.util.ArrayList;


/**
 * Write a description of class DVDContainer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AddressContainer
{
    private AddressContainer instance;
    private ArrayList<Address> address;

    /**
     * Constructor for objects of class DVDContainer
     */
    private AddressContainer(){
        address = new ArrayList<Address>();
    }


    public AddressContainer getInstance(){
        if(instance == null){
            instance = new AddressContainer();
        }
        
        return instance;
    }
}
