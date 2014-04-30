package TUILayer;
import java.util.*;
import ControlLayer.DVDCtr;
/**
 * User interface to the DVD controller
 * @author Group 3
 * @version 0.2                 
 */

public class DvdUI{
    
    /**
     * DvdUI - Constructor for DvdUI.
     */
    public DvdUI(){
        dvdMenu();
    }
    
    /**
     * dvdMenu - Make the dvdMenu.
     */
    public void dvdMenu(){   
        boolean exit = false;
        while(!exit){
            int choice = writeDVDMenu();
            if (choice == 1){
                printDVD();
            }else if(choice == 2){
                createDVD();
            }else if(choice == 3){
                createCopy();
            }else if(choice == 4){
                deleteDVD();
            }else if(choice == 5){
                deleteCopy();
            }else if(choice == 6){
                updateDVD();
            }else if(choice == 7){
                updateCopy();
            }else if(choice == 8){
                listAllDVDs();
            }else if(choice == 9){
                exit = true;
            }
        }
    }
    
    /**
     * writeDVDMenu - Write the dvd menu.
     */
    private int writeDVDMenu(){
        int choice;
        try{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\f *** DVD Menu ***");
            System.out.println(" (1) Show DVD information");
            System.out.println(" (2) Create DVD");
            System.out.println(" (3) Create Copy");
            System.out.println(" (4) Delete DVD");
            System.out.println(" (5) Delete Copy");
            System.out.println(" (6) Update DVD");
            System.out.println(" (7) Update Copy");
            System.out.println(" (8) Show current DVD list");
            System.out.println(" (9) Return");
            System.out.print("\n Make your choice: ");
            
            choice = keyboard.nextInt();
        }catch(InputMismatchException e){
            choice = 0;
        }
        return choice;
    }
    
    /**
     * printDVD - print info about a dvd.
     */
    private void printDVD(){
        try{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\f ### DVD Information ###");
            System.out.print("DVD ID: ");
            int dvdID = keyboard.nextInt();
            
            DVDCtr dvdCtr = new DVDCtr();
            System.out.println(dvdCtr.getDVDInfo(dvdID));
            System.out.println("Copies Ids: " + dvdCtr.getCopies(dvdID));
            pause();        
        }catch(InputMismatchException e){
            System.out.println("Invalid values");
            pause();
            return;
        }catch(NullPointerException e1){
            System.out.println(e1);
            pause();
            return;
        }
    }
    
    /**
     * createDVD - Create a new dvd.
     */
    private void createDVD(){
        try{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("### Create DVD ###");
            
            System.out.print("Title: ");
            String title = keyboard.nextLine();
            if(title.trim().isEmpty()){
                System.out.println("Title cant be empty!");
            }
            
            System.out.print("Artist: ");
            String artist = keyboard.nextLine();
            if(artist.trim().isEmpty()){
                System.out.println("Artist cant be empty!");
            }
            
            System.out.print("Publication Year: ");
            int pubYear = keyboard.nextInt();

            keyboard.nextLine();
            
            if(String.valueOf(pubYear).length() != 4){
                System.out.println("The publication date must be 4 characters long");
            }
            
            if(confirm("Do you wish to create the DVD (Title: " + title + " / Artist: " + artist + " / Publication Year: " + pubYear + ")")){
                DVDCtr dvdCtr = new DVDCtr();
                dvdCtr.createDVD(title, artist, pubYear);
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid values");
            pause();
            return;
        }
    }
    
    /**
     * createCopy - Create a copy of a dvd.
     */
    private void createCopy(){
        try{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("### Create Copy ###");
            
            System.out.print("DVD ID: ");
            int dvdID = keyboard.nextInt();
            keyboard.nextLine();
            
            System.out.print("Purchase Date: ");
            String purDate = keyboard.nextLine();
            if(purDate.trim().isEmpty()){
                System.out.println("Purchase Date cant be empty!");
            }
            
            System.out.print("Purchase Price: ");
            double purPrice = keyboard.nextDouble();
            keyboard.nextLine();
            
            if(confirm("Do you wish to add Copy(Purchase Date: " + purDate + " / Publication Price: " + purPrice + ") to DVD(" + dvdID + ")")){
                DVDCtr dvdCtr = new DVDCtr();
                dvdCtr.addCopy(dvdID, purDate, purPrice);
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid values");
            pause();
            return;
        }catch(NullPointerException e1){
            System.out.println(e1);
            pause();
            return;
        }
    }
    
    /**
     * deleteDVD - Delete a dvd.
     */
    private void deleteDVD(){
        try{
            DVDCtr dvdCtr = new DVDCtr();
            Scanner keyboard = new Scanner(System.in);
            System.out.print("What's the ID of the dvd you want to delete?" );
            int deleteID = keyboard.nextInt();
            String title = dvdCtr.getTitleByID(deleteID);
            if(confirm("Are you sure you wish to delete the dvd with the following ID: " + deleteID + " " + title)){
                dvdCtr.deleteDVD(deleteID);
                System.out.println(title + " was deleted");
                pause();
            }
        }catch(InputMismatchException e1){
            System.out.println("Invalid values");
            pause();
            return;
        }catch(NullPointerException e){
            System.out.println(e);
            pause();
            return;
        }
    }
    
    /**
     * deleteCopy - Delete a copy of a dvd.
     */
    private void deleteCopy(){
        try{
            DVDCtr dvdCtr = new DVDCtr();
            Scanner keyboard = new Scanner(System.in);
            System.out.print("What's the ID of the dvd you want to delete a copy from?" );
            int dvdID = keyboard.nextInt();
            keyboard.nextLine();
            System.out.print(dvdCtr.getCopies(dvdID));
            System.out.print("");
            System.out.print("What's the serialnumber of the copy you want to delete?" );
            int copyID = keyboard.nextInt();
            if(confirm("Are you sure you wish to delete the copy with the following serialnumber: " + copyID)){
                dvdCtr.deleteCopy(dvdID, copyID);
                System.out.println(copyID + " was deleted");
                pause();
            }
        }catch(InputMismatchException e1){
            System.out.println("Invalid values");
            pause();
            return;
        }catch(NullPointerException e){
            System.out.println(e);
            pause();
            return;
        }
    }
    
    /**
     * updateDVD - update a dvd.
     */
    private void updateDVD(){
        try{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("### Update DVD ###");
            System.out.print("DVD ID: ");
            int dvdID = keyboard.nextInt();
            keyboard.nextLine();
            
            System.out.print("Title: ");
            String title = keyboard.nextLine();
            if(title.trim().isEmpty()){
                System.out.println("Title cant be empty!");
                pause();
                return;
            }
            System.out.print("Artist: ");
            String artist = keyboard.nextLine();
            if(artist.trim().isEmpty()){
                System.out.println("Artist cant be empty!");
                pause();
                return;
            }
            
            System.out.print("Publication Year: ");
            int pubYear = keyboard.nextInt();

            keyboard.nextLine();
            
            if(String.valueOf(pubYear).length() != 4){
                System.out.println("The publication date must be 4 characters long");
            }
            
            
            if(confirm("Update DVD(" + dvdID + ") to (Title: " + title + " / Artist" + artist + " / Publication Year: " + pubYear + ")")){
                DVDCtr dvdCtr = new DVDCtr();
                dvdCtr.updateDVD(dvdID, title, artist, pubYear);
            }
            
        }catch(InputMismatchException e){
            System.out.println("Invalid values");
            pause();
            return;
        }catch(NullPointerException e1){
            System.out.println(e1);
            pause();
            return;
        }
    }
    
    /**
     * updateCopy - update a copy of a dvd.
     */
    private void updateCopy(){
        try{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("### Update Copy ###");
            System.out.print("DVD ID: ");
            int dvdID = keyboard.nextInt();
            keyboard.nextLine();
            
            DVDCtr dvdCtr = new DVDCtr();
            
            System.out.println("Select Copy(" + dvdCtr.getCopies(dvdID) + ")");
            System.out.print("Serial Number: ");
            int serialNumber = keyboard.nextInt();
            keyboard.nextLine();

            System.out.print("Purchase Year: ");
            String purYear = keyboard.nextLine();
            if(purYear.trim().isEmpty()){
                System.out.println("Purchase Year cant be empty!");
                pause();
                return;
            }
            
            System.out.print("Purchase Price: ");
            double purPrice = keyboard.nextDouble();
            
            if(confirm("Update Copy(" + serialNumber + ") to (Purchase Year: " + purYear + " / Purchase Price:" + purPrice + ")")){
                dvdCtr.updateCopy(dvdID, serialNumber, purYear, purPrice);
            }
            
        }catch(InputMismatchException e){
            System.out.println("Invalid values");
            pause();
            return;
        }catch(NullPointerException e1){
            System.out.println(e1);
            pause();
            return;
        }
    }
    
    /**
     * listAllDVDs - Make a list of all dvds.
     */
    private void listAllDVDs(){
        try{
            DVDCtr dvdCtr = new DVDCtr();
            System.out.println(dvdCtr.listAllDVDs());
            pause();
        }catch(NullPointerException e){
            System.out.println(e);
            pause();
        }
    }
    
    /**
     * pause - Waiting for user to press enter.
     */
    private void pause(){
        Scanner keyboard = new Scanner(System.in);
        String pause = keyboard.nextLine();
    }
    
    /**
     * confirmStatement - Using the user confirmation.
     */
    private boolean confirm(String confirmStatement){
        boolean confirm = true;
        Scanner s = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            System.out.println();
            System.out.println(confirmStatement);
            System.out.println("Confirm - y/n");
            String conf = s.nextLine();
            if(conf.toLowerCase().equals("y")){
                confirm = true;
                exit = true;
            }else if(conf.toLowerCase().equals("n")){
                confirm = false;
                exit = true;
            }
        }
        return confirm;
    }
}