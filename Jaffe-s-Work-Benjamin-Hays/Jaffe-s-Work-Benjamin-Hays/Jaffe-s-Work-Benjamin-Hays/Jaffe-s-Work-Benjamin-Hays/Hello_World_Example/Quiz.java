import java.util.Scanner; 
import java.util.Random;

public class Quiz {
  public static void main(String[] args) {
    Random rand = new Random();
    int int_random_1 = rand.nextInt(101); 
    int int_random_2 = rand.nextInt(int_random_1);
    int operater_selector = rand.nextInt(1);
    String operator;
    String feedback;
    String feedback2;
    int answer;
    
    if (operater_selector == 1) {
        operator = "+";
        answer = int_random_1 + int_random_2;
    } else {
        operator = "-";
        answer = int_random_1 - int_random_2;
    }
    
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("What is " + int_random_1 + operator + int_random_2);
    
    String Question = myObj.nextLine();  // Read user input
    String convertAnswerToString = Integer.toString(answer);
    
    if (convertAnswerToString.equals(Question)) {
        feedback = "Correct!";
        feedback2 = "";
    } else {
        feedback = "Incorrect.";
        feedback2 = ", not " + Question;
        
    }
    System.out.println("That is " + feedback + " The answer is " + convertAnswerToString + feedback2);  // Output user input
  }
}

