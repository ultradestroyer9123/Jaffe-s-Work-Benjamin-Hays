// Author: Benjamin Hays

import static java.lang.System.out;
import java.util.*;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// lower bound = /2 and add 7 upper = sub 7 and mult by 2
public class PDAProject {
    
    public static void printWarning(String Str, int age) {
        System.out.println("\u001B[33m" + Str.replace("{age}",Integer.toString(age)) + "\u001B[0m");
    }
    
    public static void printError(String Str, String age) {
        System.out.println("\u001B[31m" + Str.replace("{age}",age) + "\u001B[0m");
    }
    
    public static void printGood(String Str, int age) {
        System.out.println("\u001B[32m" + Str.replace("{age}",Integer.toString(age)) + "\u001B[0m");
    }
    
    public static void main (String[] args) {
        int minimum_age = 18;
        int age;
        while (true) {
            System.out.println("\033[1mHow old are you >> \033[0m");
            Scanner scanner = new Scanner(System.in);
            try {
                age = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                printError("'{age}' is not a number. Try again!", scanner.next());
            }
        }
        if (age < minimum_age) {
            printWarning("{age} is too young! {age} is less than 18.", age);
        } else {
            int minimum = Math.round((age/2)+7);
            int maximum = Math.round((age-7)*2);
            System.out.println((age/2)+7);
            printGood(
                "As a(n) \033[1m{age}\033[0m\u001B[32m year old, your range is between \033[1m[min]\033[0m\u001B[32m and \033[1m[max]\033[0m"
                .replace("[min]",Integer.toString(minimum > minimum_age?minimum:minimum_age))
                .replace("[max]",Integer.toString(maximum)), age);
        }
    }
}
