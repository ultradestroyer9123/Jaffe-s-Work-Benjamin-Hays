import java.util.Scanner; 
import java.util.Random;

public class Quiz {
  public static void main(String[] args) {
    Random rand = new Random();
    int int_random_1 = rand.nextInt(101); 
    int int_random_2 = rand.nextInt(int_random_1);
    int operater_selector = rand.nextInt(2);
    int tries = 3;
    String operator;
    String feedback;
    String feedback2;
    String Question = null;
    int answer;
    if (operater_selector == 1) {
        operator = "+";
        answer = int_random_1 + int_random_2;
    } else {
        operator = "-";
        answer = int_random_1 - int_random_2;
    }
    // Create a Scanner object
    System.out.println("What is " + int_random_1 + operator + int_random_2);
    String convertAnswerToString = Integer.toString(answer);
    while (!convertAnswerToString.equals(Question)) {
        try {
            
            
            Scanner myObj = new Scanner(System.in);
            Question = myObj.nextLine();  // Read user input
            
            
            int Question_error_handle = Integer.parseInt(Question);
            if (convertAnswerToString.equals(Question)) {
                break;
            }
            else {
                tries -= 1;
                if (tries == 0) {
                    System.out.println("You have no more tries left! The answer was " + answer);
                    break;
                }
                System.out.println("That's not correct! You have " + tries + " left");
                System.out.println("What is " + int_random_1 + operator + int_random_2);
                
            }
        }
        catch(Exception e) {
            System.out.println("That is not an integer!");
            System.out.println("What is " + int_random_1 + operator + int_random_2);
        }
    }
        

    
    
    if (convertAnswerToString.equals(Question)) {
        System.out.println("That's correct! The answer is " + convertAnswerToString);
    }
    
  }
}

