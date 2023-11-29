// Author: Benjamin Hays

import static java.lang.System.out;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class NextScanners {
    public static void main(String[] args) {
        System.out.println("We need to name 3 dogs. However we are very unsure what to name it.\nThat is why we are paying you to decide!");
        System.out.print("Enter 3 names: ");         
        Scanner scan = new Scanner(System.in);  
        String first_dog = scan.next();   // The reason "Why won't my scanner get the last item in the list??!?!
        String second_dog = scan.next();  // Doesnt work is because some people don include
        String third_dog = scan.next();   // Another '.next()' method.
        System.out.println("\nThe first dog's name is: " + first_dog);  
        System.out.println("The second dog's name is: " + second_dog); 
        System.out.println("The third dog's name is: " + third_dog + "\n");  
        scan.close();  
        
        System.out.println("Text from file: 'Mystery.csv'");
        try {
            File mystery = new File("Mystery.csv");
            Scanner file_scan = new Scanner(mystery);
            
            while (file_scan.hasNextLine()) {
                String[] item = file_scan.nextLine().split(",");
                int avg = 0;
                int total_values = 0;
                boolean is_class_section = false;
                for (int i = 0; i < item.length; i++) {
                    try {
                        if (String.format(item[i]).equals("Class section")) {
                            System.out.println("Class section 1 thru 10 | -> 1,2,3,etc.. ->");
                            is_class_section = true;
                        } else if (i == 0) {
                            System.out.print(item[i] + " Average: ");
                        } else {
                            avg += Integer.parseInt(item[i]);
                            total_values += 1;
                        }
                    } catch (NumberFormatException err) {
                        System.out.println("Caught value isn't a number: " + item[i]);
                    }  
                }
                if (!is_class_section) {
                    System.out.println(avg/total_values);
                }
            }
            
            file_scan.close();
        } catch (FileNotFoundException err) {
            System.out.println("File not found");
        }
    }
}
