// Author: Benjamin Hays

import static java.lang.System.out;
import java.util.*;
import java.util.Random;

public class IfStatements {
    public static void main(String[] args) {
        int num_1 = 21;
        Random rand = new Random();
        int num_2;
        boolean is_factor_of;
        
        // If, Else If, Else
        String option = "";
        int random_int = rand.nextInt(3);
        if (random_int == 0) {
            option = "1";
            num_2 = 3;
        } else if (random_int == 1) {
            option = "2";
            num_2 = 7;
        } else {
            option = "3";
            num_2 = 8;
        }
        System.out.println("Selected option: " + option);
        
        // python : str_1 = "500" if add_100 == true else "400"
        
        // System.out.println(true ? "true!" : "false."); < - example online
        // System.out.println(false ? "true!" : "false.");
        
        // ? represents the condition and the : represents the 'else'
        String message = (num_1 % num_2 == 0)? "": "not ";
        
        System.out.println(num_2 + " is " + message + "a factor of " + num_1);
        
    }
}
