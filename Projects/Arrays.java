// Author: Benjamin Hays

import static java.lang.System.out;
import java.util.*;

public class Arrays {
    public static void main(String[] args) {
        String[] arm_muscles = {"Bicepts", "Triceps","Forearms","Shoulders"};
        // Print First Data. Start at 0 to print the first one
        // arm_muscles[0] outputs : Bicepts
        arm_muscles[0] = "Biceps";
        int total_muscles = arm_muscles.length;
        System.out.println("Total Muscles: " + total_muscles + " | Iterating through each muscle\n");
        for (int iterate = 0; iterate < total_muscles; iterate++) {
            System.out.println(arm_muscles[iterate]);
        }
        
        String seperator = ", ";
        String line_of_muscles = String.join(seperator, arm_muscles);
        
        // Another way to iterate
        // for (String muscle : arm_muscles) {
        //     line_of_muscles += muscle + ", ";
        // }
        // line_of_muscles = line_of_muscles.substring(0, line_of_muscles.length()-2);
        
        System.out.println("\nUsing the join function on the array:");
        System.out.println(line_of_muscles + "\n");
    }
}
