// Author: Benjamin Hays

import static java.lang.System.out;
import java.util.*;
import java.lang.Float;
public class Fizzbuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            String fizzbuzzOrNo = "";
            String float5_str = i/5f + "";
            String float3_str = i/3f + "";
            if (float5_str.contains(".0") && float3_str.contains(".0")) {
                fizzbuzzOrNo = "FizzBuzz";
            } else if (float5_str.contains(".0")) {
                fizzbuzzOrNo = "Buzz";
            } else if (float3_str.contains(".0")) {
                fizzbuzzOrNo = "Fizz";
            } else {
                fizzbuzzOrNo = "";
            }
            
            System.out.println((fizzbuzzOrNo=="")?i:fizzbuzzOrNo);
        }
    }
}
