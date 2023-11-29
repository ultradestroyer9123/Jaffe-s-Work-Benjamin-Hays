// Author: Benjamin Hays

import static java.lang.System.out;
import java.util.*;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// lower bound = /2 and add 7 upper = sub 7 and mult by 2
public class PDAProject {

    public static String removePointZero(String s) {
        return s.contains(".")?s.substring(0, s.indexOf(".")):s;
    }
    
    public static void printWarning(String Str, float age) {
        System.out.println("\u001B[33m" + Str.replace("{age}",removePointZero(Float.toString(age))) + "\u001B[0m");
    }
    
    public static void printError(String Str, String age) {
        System.out.println("\u001B[31m" + Str.replace("{age}",removePointZero(age)) + "\u001B[0m");
    }
    
    public static void printGood(String Str, float age) {
        System.out.println("\u001B[32m" + Str.replace("{age}",removePointZero(Float.toString(age))) + "\u001B[0m");
    }
    
    public static void main (String[] args) {
        System.out.println("Loading...");
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        printGood("Created by your coolest student, Benjamin Hays; Period 3.", 0);
        printError("Enter '0' to quit", "0");
        int minimum_age = 14;
        int maximum_age = 200;
        while (true) {
            float age;
            while (true) {
                System.out.println("\033[1mHow old are you >> \033[0m");
                Scanner scanner = new Scanner(System.in);
                try {
                    age = scanner.nextFloat();
                    break;
                } catch (InputMismatchException e) {
                    printError("'{age}' is not a number. Try again!", scanner.next());
                }
            }
            if (age == 0) {
                break;
            } else if (age < minimum_age) {
                printWarning("{age} is too young! {age} is less than {minimum}.".replace("{minimum}",
                        Integer.toString(minimum_age)), 
                        age);
            } else if (age > 200) {
                printWarning("{age} is too old! {age} is more than {maximum}.".replace("{maximum}",
                        Integer.toString(maximum_age)), 
                        age);
            } else {
                int minimum = Math.round((age/2)+7);
                int maximum = Math.round((age-7)*2);
                printGood(
                    "As a(n) \033[1m{age}\033[0m\u001B[32m year old, your range is between \033[1m[min]\033[0m\u001B[32m and \033[1m[max]\033[0m"
                    .replace("[min]",Integer.toString(minimum > minimum_age?minimum:minimum_age))
                    .replace("[max]",Integer.toString(maximum)), age);
            }
        }
    }
}
