// Author: Benjamin Hays

import static java.lang.System.out;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// lower bound = /2 and add 7 upper = sub 7 and mult by 2
public class PDAProject {
    public static boolean PermDatingAge(int age1,int age2) {
        float upperbound = 0f;
        float lowerbound = 0f;
        if (age1 > age2) {
            upperbound = (age1-7)/2;
            lowerbound = (age1/2)+7;
        } else if (age1 < age2) {
            upperbound = (age2-7)/2;
            lowerbound = (age2/2)+7;            
        } else {
            return true;
        }
        if (age1 > lowerbound && age1 < upperbound && age2 > lowerbound && age2 < upperbound) {
            System.out.println("Age1: " + age1 + "Age2: " + age2 + "Upper: " + upperbound + "Lower: " + lowerbound);
        }
        System.out.println("Age1: " + age1 + "Age2: " + age2 + "Upper: " + upperbound + "Lower: " + lowerbound);
        return true;
    }
    
    public static void main (String[] args) {
        // This is where we ask for the users age to make sure they are capable of 'PDA'
        int age1 = 0;
        int age2 = 0;
        int minimum_age = 0;
        while (true) {
            System.out.println("Write 2 ages seperated by a ', ':");
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter(", |\n");
            try {
                age1 = scanner.nextInt();
                age2 = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("'" + scanner.next() + "' is not a number! Try again.");
            }
        }
        if (age1 < minimum_age || age2 < minimum_age) {
            System.out.println(age1 + " is too young unfortunately.");            
        } else {
            PermDatingAge(age1,age2);
        }
    }
}
