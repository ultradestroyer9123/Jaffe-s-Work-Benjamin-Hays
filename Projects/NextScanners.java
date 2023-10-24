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
            int add_total = 0;
            int total_sum = 0;
            while (file_scan.hasNextLine()) {
                String data = file_scan.nextLine();
                System.out.println(data);
                String[] items = data.split(",");
                int Num;
                for (int i=0; i < data.length(); i++) {
                    boolean number;
                    try {
                        Num = Integer.parseInt(items[i]);
                        number = true;
                    } catch (NumberFormatException err) {
                        number = false;
                    }
                    if (number) {
                        add_total++;
                        total_sum += Integer.parseInt(items[i]);
                        
                    }
                }
            }
            System.out.println(");
            file_scan.close();
        } catch (FileNotFoundException err) {
            System.out.println("File not found");
        }
    }
}
