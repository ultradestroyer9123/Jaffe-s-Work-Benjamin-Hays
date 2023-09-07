// Java program to demonstrate BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Test {
    public static void main(String[] args)
        throws IOException
    {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 
        // Reading data using readLine
        String name = reader.readLine();
 
        // Printing the read line
        System.out.println(name);
    }
}

// // Java program to demonstrate working of Scanner in Java
// import java.util.Scanner;

// class GetInputFromUser {
// 	public static void main(String args[])
// 	{
// 		// Using Scanner for Getting Input from User
// 		Scanner in = new Scanner(System.in);

// 		String s = in.nextLine();
// 		System.out.println("You entered string " + s);

// 		int a = in.nextInt();
// 		System.out.println("You entered integer " + a);

// 		float b = in.nextFloat();
// 		System.out.println("You entered float " + b);
// 	}
// }
