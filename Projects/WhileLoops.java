// Author: Benjamin Hays

import static java.lang.System.out;
import java.util.*;
 

public class WhileLoops {
    public static void main(String[] args) {
        int max = 15;
        int min = 0;
        int example_a = 10;
        int example_b = 0;
        int example_c = 0;
        while (example_a != 4) {
          System.out.println("Starting from 10, ending on 5, subtracting by 1 : " + example_a);
          example_a--;
        }
        System.out.println("\n");
        do {
            example_c += 5;
            System.out.println("Do-While Loops (Starts at 0, increments by 5, ends at 15): " + example_c);
        }
        while (example_c < 15);
        
        //do { // Minimum amount of times each ones run.
        //    System.out.println("Do-While: Ran.");
        //}
        //while (4 == 5);
        //while (4 == 5) {
        //    System.out.println("While-Loop: Ran.");
        //}
    }
}
