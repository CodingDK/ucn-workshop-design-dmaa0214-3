package ModelLayer;

/**
 * Write a description of class Person here.
 * 
 * @author Group 3 
 * @version 0.1
 */
public class Person{
    private static int idIterator;
    private int id;
    private String name;
    private String address;
    private int postalCode;
    private String city;
    private String phone;

    public Person(String name, String address, int postalCode, String city, String phone){
        idIterator++;
        this.id = idIterator;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
    }

    // Get methods
    public int getID(){
    	return id;
    }
    
    public void setID(int id){
    	this.id = id;
    }
    
    public String getName(){
    	return name;
    }
    
    public void setName(String name){
    	this.name = name;
    }
    
    public String getAddress(){
    	return address;
    }
    
    public void setAddress(String address){
    	this.address = address;
    }
    
    public int getPostalCode(){
    	return postalCode;
    }
    
    public void setPostalCode(int postalCode){
    	this.postalCode = postalCode;
    }
    
    public String getCity(){
    	return city;
    }
    
    public void setCity(String city){
    	this.city = city;
    }
    
    public String getPhone(){
    	return phone;
    }
    
    public void setPhone(String phone){
    	this.phone = phone;
    }
    
}
