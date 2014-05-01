package TUILayer;
import java.util.*;


/**
 * SuperClass for the other menu classes
 * Containing the common methods used through all the UIs
 * 
 * @author Group 3 
 * @version 1
 */
public class MenuUI{

    /**
     * Constructor for objects of class MenuUI
     */
    public MenuUI(){

    }

    /**
     * pause - Waiting for user to press enter.
     */
    protected void pause(){
        Scanner keyboard = new Scanner(System.in);
        String pause = keyboard.nextLine();
    }
    
    /**
     * confirmStatement - Using the user confirmation.
     */
    protected boolean confirm(String confirmStatement){
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
