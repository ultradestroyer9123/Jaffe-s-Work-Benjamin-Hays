// Author: Benjamin Hays
import static java.lang.System.out;

public class ForLoops {
    public static void main(String[] args) {
        // for (statement 1; statement 2; increment/decrement) {
        // Similuar to lua and python:
        // Lua: for integer=0, min/max value, increment do print(integer) end
        // Python: for x in range(1,5,1):
        //              print(x)
        int max = 6;
        int wall_length = 10;
        
        String string_example_1 = "";
        String string_example_2 = "";
        for (int i = 0; i < max; i++) {
            int temporary = i;
            string_example_1 += i;
            if (i != max-1) {
                string_example_1 += ", ";
            }
        }
        System.out.println(string_example_1);
        // Nested loop: Loop inside a loop
        System.out.println("Lets build a square! (Technically)");
        for (int x_pos = 0; x_pos < wall_length; x_pos++) {
            for (int y_pos = 0; y_pos < wall_length; y_pos++) {
                if (y_pos == 0 || y_pos == wall_length-1 || x_pos == 0 || x_pos == wall_length-1) {
                    string_example_2 += "#";
                } else {
                    string_example_2 += " ";
                }
            }
            string_example_2 += "\n";
        }
        System.out.println(string_example_2);
        
    }
}
