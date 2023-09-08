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

public class String_Manipulation {
    public static void main(String[] args) {
        
        String line_break = "\nThis is a \nBreak in the line '\\n'\n";
        String vacant = "This is a vacant string";
        String all_caps = "This string is in all caps!";
        String lowercase = "This STRING is in lowercase!";
        String location = "Uhhh? Where is the $ at in this sentence";
        
        int len_vacant = vacant.length();
        
        System.out.println(line_break);
        System.out.println(vacant + " | The length of the string is: " + len_vacant);
        System.out.println(all_caps + " | Changes to | " + all_caps.toUpperCase());
        System.out.println(lowercase + " | Changes to | " + lowercase.toLowerCase());
        System.out.println(location + " | At the position: " + location.indexOf("$"));
        
    }
}
