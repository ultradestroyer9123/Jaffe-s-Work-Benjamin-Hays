import java.util.Scanner; 
import java.util.Random;

public class Quiz {
  public static void main(String[] args) {
    Random rand = new Random();
    int int_random_1 = rand.nextInt(101); 
    int int_random_2 = rand.nextInt(101);
    int operater_selector = rand.nextInt(1);
    String operator;
    String feedback;
    
    if (operater_selector == 1) {
        operator = "+";
    } else {
        operator = "-";
    }
    int answer = 333;
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("What is " + int_random_1 + operator + int_random_2);

    String Question = myObj.nextLine();  // Read user input
    String convertAnswerToString = Integer.toString(answer);
    
    if (convertAnswerToString == Question) {
        feedback = "Correct!";
    } else {
        feedback = "Incorrect.";
    }
    System.out.println("That is " + feedback + " The answer is " + convertAnswerToString + ", not " + Question);  // Output user input
  }
}

