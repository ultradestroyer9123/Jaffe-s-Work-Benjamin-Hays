// Author: Benjamin Hays

import static java.lang.System.out;
import java.util.*;

public class Scanners {
    public static void main(String[] args) {
        System.out.print("List the things you ate for breakfast seperated by a comma: ");
        Scanner myObj = new Scanner(System.in);
        String Breakfast = myObj.nextLine();  // Read user input
        System.out.println("\nYou ate:\n- " + Breakfast.replace(", ", "\n- "));
        
        System.out.println("How old do you want to be?");
        int Age = myObj.nextInt();
        int Distance;
        if (Age < 100) {
            Distance = 100-Age;
            System.out.println("You know " + Age + " is only " + Distance + " years from 100.. Right?");
        } else if (Age == 100){
            System.out.println("Right on the dot! Bullseye as they say... (100)");
        } else {
            Distance = Age-100;
            System.out.println("Jeez la weez! Thats an additional " + Distance + " years from 100! (" + Age + ")");
        }
    }
}
