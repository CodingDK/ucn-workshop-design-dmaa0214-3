package TUILayer;
import java.util.Scanner;
import ControlLayer.DVDCtr;
/**
 * User interface to the DVD controller
 * @author(kbh)
 * @version(2005.03.31)
 * (FEN): 2006.02.24: Comments translated into English
 * (FEN): 2006.03.21: Some changes to the architecture in order to assure layering
 *                    and loose coupling
 * (KBH): 2008.10.24: dvdmenu changed to If                   
 */

public class DvdUI{
    
    public DvdUI(){
        dvdMenu();
    }
    
    public void dvdMenu(){   
        boolean exit = false;
        while(!exit){
            int choice =   writeDVDMenu();
            if (choice == 1){
                //findDVD();
            }else if(choice == 2){
                createDVD();
            }else if(choice == 3){
                createCopy();
            }else if(choice == 4){
                deleteDVD();
            }else if(choice == 5){
                listAllDvds();
            }else if(choice == 6){
                exit = true;
            }
        }
    }
    private int writeDVDMenu(){
           // creates an object keyboard to read data from the keyboard
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\f *** DVD Menu ***");
            System.out.println(" (1) Show DVD information");
            System.out.println(" (2) Create DVD description");
            System.out.println(" (3) Create DVD specimen");
            System.out.println(" (4) Delete DVD");
            System.out.println(" (5) Show current DVD list");
            System.out.println(" (6) Return");
            System.out.print("\n Make your choice: ");
            
            int choice = keyboard.nextInt();
            return choice;
    }
    
    private void createDVD(){
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
        
        System.out.print("Publication Date: ");
        String pubDate = keyboard.nextLine();
        if(pubDate.trim().isEmpty()){
            System.out.println("The publication date cant be empty!");
        }
        
        if(confirm("Do you wish to create the DVD (Title: " + title + " / Artist: " + artist + " / Publication Date: " + pubDate + ")")){
            DVDCtr dvdCtr = new DVDCtr();
            dvdCtr.createDVD(title, artist, pubDate);
        }
    }
    
    private void createCopy(){
        DVDCtr dvdCtr = new DVDCtr();
    }
    
    private void deleteDVD(){
        DVDCtr dvdCtr = new DVDCtr();
    }
    
    private void listAllDvds(){
        DVDCtr dvdCtr = new DVDCtr();
    }
    
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