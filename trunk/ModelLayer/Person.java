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

    /**
    * getID() - Returns the ID
    * @return ID
    */
    public int getID(){
    	return id;
    }
    
    /**
    * setID() - sets the ID
    * @param ID - value as int
    */
    public void setID(int id){
    	this.id = id;
    }
    
    /**
    * getName() - Returns the Name
    * @return name
    */
    public String getName(){
    	return name;
    }
    
    /**
    * setName() - sets the Name
    * @param name - value as String
    */
    public void setName(String name){
    	this.name = name;
    }
    
    /**
    * getAddress() - Returns the Address
    * @return address
    */
    public String getAddress(){
    	return address;
    }
    
    /**
    * setAddress() - sets the Address
    * @param address - value as String
    */
    public void setAddress(String address){
    	this.address = address;
    }
    
    /**
    * getPostalCode() - Returns the PostalCode
    * @return postalCode
    */
    public int getPostalCode(){
    	return postalCode;
    }
    
    /**
    * setPostalCode() - sets the PostalCode
    * @param postalCode - value as int
    */
    public void setPostalCode(int postalCode){
    	this.postalCode = postalCode;
    }
    
    /**
    * getCity() - Returns the City
    * @return city
    */
    public String getCity(){
    	return city;
    }
    
    /**
    * setCity() - sets the City
    * @param city - value as String
    */
    public void setCity(String city){
    	this.city = city;
    }
    
    /**
    * getPhone() - Returns the Phone
    * @return phone
    */
    public String getPhone(){
    	return phone;
    }
    
    /**
    * setPhone() - sets the Phone
    * @param phone - value as String
    */
    public void setPhone(String phone){
    	this.phone = phone;
    }
}
