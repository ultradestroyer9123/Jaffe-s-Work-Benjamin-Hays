// Author: Benjamin Hays

import static java.lang.System.out;
import java.util.*;
 

public class WhileLoops {
    public static void main(String[] args) {
        int max = 15;
        int min = 0;
        int a = 0;
        int b = 0;
        while (max > 0) {
            max--;
            if (max+1 == 0) {
                System.out.println("BOOM!");
            } else {
                System.out.println(max+1 + "..");
            }
        }
        System.out.println("Lets reverse it!");
        while (min < 15) {
            min++;
            if (min+1 == 0) {
                System.out.println("BOOM!");
            } else {
                System.out.println(min+1 + "..");
            }
        }
        int start = 0;
        while (a < 10 || b <= 20) { // || represents "or", && represents "and"
            System.out.println("A Value: " + a + " B Value: " + b);
            if (a < 10) {
                a++;
            }
            if (b <= 10) {
                a++;
            }
        }
    }
}
