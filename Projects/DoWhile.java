// Author: Benjamin Hays

import static java.lang.System.out;
import java.util.*;
 

public class DoWhile {
    public static void main(String[] args) {
        // Self documenting code
        
        int number_1 = 0;
        boolean when_pigs_fly = false; // Never !!
        
        do {
            System.out.println("This ran despite the condition being false!");
        }
        while (when_pigs_fly == true);
        
        System.out.println("\nIteration:");
        
        do {
            number_1++;
            System.out.println("Counting up: " + number_1);
        }
        while (number_1 < 5);
    }
}
