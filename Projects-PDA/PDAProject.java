// Author: Benjamin Hays

import static java.lang.System.out;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// lower bound = /2 and add 7 upper = sub 7 and mult by 2
public class PDAProject {
    public boolean PermDatingAge(int age1,int age2) {
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
        if (age1 > lowerbound and age2) {
            // continue here
        }
    }
    
    public static void main (String[] args) {
        // This is where we ask for the users age to make sure they are capable of 'PDA'
        int age = 0;
        int minimum_age = 0;
        while (true) {
            System.out.println("How old are you?");
            Scanner scanner = new Scanner(System.in);
            try {
                age = scanner.nextInt();
                System.out.println("You are " + age + " year(s) old");
                break;
            } catch (InputMismatchException e) {
                System.out.println("'" + scanner.next() + "' is not a number! Try again.");
            }
        }
        if (age < minimum_age) {
            System.out.println(age + " is too young unfortunately.");            
        } else {
            
        }
    }
}
