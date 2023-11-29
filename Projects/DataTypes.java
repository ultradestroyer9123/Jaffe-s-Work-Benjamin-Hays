// use '//' for a comment
/*
Notes for java:
Begin everything with a public class:
public class Main {
    public static void main(String[] args) {
        **code here**
    }
}
*/


/* SUPER IMPORTANT: Compile a File: javac (file.java), 
 * Run a File: java (file.java)*/


import static java.lang.System.out;
import java.util.*;

public class DataTypes {
    public static void main(String[] args) {
        String stringy = "Apple Sauce";
        int integer = 15;
        float floater = 3.14f;
        char myLetter = 'B';
        boolean quiz = true;
        
        // .substring(10) removes the java.lang. from java.lang.String
        // getClass gets the type of the object. Ex: type() function in python
        String string_type = stringy.getClass().getName().substring(10);
        String char_type = ((Object)myLetter).getClass().getName().substring(10);
        String int_type = ((Object)integer).getClass().getName().substring(10); 
        String float_type = ((Object)floater).getClass().getName().substring(10); 
        String bool_type = ((Object)quiz).getClass().getName().substring(10); 

        
        
        System.out.println("I am a " + string_type + " and my value is " + stringy);
        System.out.println("I am a " + int_type + " and my value is " + integer);
        System.out.println("I am a " + float_type + " and my value is " + floater);
        System.out.println("I am a " + char_type + " and my value is " + myLetter);
        System.out.println("I am a " + bool_type + " and my value is " + quiz);
        
    }
}