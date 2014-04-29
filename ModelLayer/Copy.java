package ModelLayer;


/**
 * Aggregation of DVDContainer
 * 
 * @author Group 3
 * @version (a version number or a date)
 */
public class Copy
{
    private int serialNumber;
    private String purchaseDate;
    private double purchasePrice;

    /**
     * Constructor for objects of class Copy
     */
    public Copy()
    {
        serialNumber = 24;
        purchaseDate = "29/04/2014";
        purchasePrice = 9001;
    }
    
    /**
    * getSerialNumber() - Returns the SerialNumber
    * @return serialNumber
    */
    public int getSerialNumber(){
    	return serialNumber;
    }
    
    /**
    * setSerialNumber() - sets the SerialNumber
    * @param serialNumber - value as int
    */
    public void setSerialNumber(int serialNumber){
    	this.serialNumber = serialNumber;
    }
    
    /**
    * getPurchaseDate() - Returns the PurchaseDate
    * @return purchaseDate
    */
    public String getPurchaseDate(){
    	return purchaseDate;
    }
    
    /**
    * setPurchaseDate() - sets the PurchaseDate
    * @param purchaseDate - value as String
    */
    public void setPurchaseDate(String purchaseDate){
    	this.purchaseDate = purchaseDate;
    }
    
    /**
    * getPurchasePrice() - Returns the PurchasePrice
    * @return purchasePrice
    */
    public double getPurchasePrice(){
    	return purchasePrice;
    }
    
    /**
    * setPurchasePrice() - sets the PurchasePrice
    * @param purchasePrice - value as double
    */
    public void setPurchasePrice(double purchasePrice){
    	this.purchasePrice = purchasePrice;
    }

}