import static java.lang.System.out;
import java.util.*;
import java.util.Random;

public class Operators {
    public static void main(String[] args) {
        Random rand = new Random();
        
        int random_number_1 = rand.nextInt(10); // 0 thru 9
        int random_number_2 = rand.nextInt(10);
        
        int sum = random_number_1 + random_number_2;
        int product = random_number_1 * random_number_2;
        int difference = random_number_1 - random_number_2;
        int quotient = random_number_1 / random_number_2;
        
        boolean sum_even = false;
        boolean product_even = false;
        boolean difference_even = false;
        
        if (sum % 2 == 0) {
            sum_even = true;
        }
        if (product % 2 == 0) {
            product_even = true;
        }
        if (difference % 2 == 0) {
            difference_even = true;
        }
        
        System.out.println("\nFirst Random Number Selected: " + random_number_1);
        System.out.println("Second Random Number Selected: " + random_number_2);
        System.out.println("Sum of Integers: " + sum + "| Is the sum even: " + sum_even);
        System.out.println("Product of Integers: " + product + "| Is the product even: " + product_even);
        System.out.println("Difference of Integers: " + difference + "| Is the difference even: " + difference_even);
        System.out.println("Quotient of Integers: " + quotient);
        
        for (int i = 0; i <= sum; i++) {
            System.out.println(i);
        }
    }
}
