// Author: Benjamin Hays

import static java.lang.System.out;
import java.util.*;

public class NextScanners {
    public static void main(String[] args) {
        System.out.println("We need to name 3 dogs. However we are very unsure what to name it.\nThat is why we are paying you to decide!");
        System.out.print("Enter full name: ");         
        Scanner scan = new Scanner(System.in);  
        //Read the first token  
        String firstName = scan.next();  
        //Read the second token  
        String lastName = scan.next();  
        //Print the token values read by Scanner object  
        System.out.println("First Name is: "+firstName);  
        System.out.println("Last Name is: "+lastName);    
        scan.close();  
    }
}
