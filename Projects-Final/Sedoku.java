// 1 2 3 | 1 2 3 | 1 2 3
// 1 2 3 | 1 2 3 | 1 2 3
// 1 2 3 | 1 2 3 | 1 2 3
// ---------------------
// 1 2 3 | 1 2 3 | 1 2 3
// 1 2 3 | 1 2 3 | 1 2 3
// 1 2 3 | 1 2 3 | 1 2 3
// ---------------------
// 1 2 3 | 1 2 3 | 1 2 3
// 1 2 3 | 1 2 3 | 1 2 3
// 1 2 3 | 1 2 3 | 1 2 3
// Author: Benjamin Hays
import javax.swing.*;
import javax.swing.border.Border;
import java.util.Random;
import static java.lang.System.out;

import java.awt.Color;
import java.awt.Font;
import java.net.CookieHandler;
import java.util.*;
public class Sedoku {
    public static void main(String[] args) {
        String nums = "123456789";
        Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
        int frame_x_offset = 14;
        int frame_y_offset = 200;
        JFrame frame=new JFrame();//creating instance of JFrame  
        frame.setLayout(null);//using no layout managers  
        frame.setVisible(true);//making the frame visible  
        frame.getContentPane().setBackground(Color.BLACK);
        JLabel title=new JLabel("JSEDOKU!");//creating instance of JButton
        title.setForeground(Color.WHITE);
        title.setFont(f1);
        frame.add(title);
        String[] grid = {"#########",
                        "#########",
                        "#########",
                        "#########",
                        "#########",
                        "#########",
                        "#########",
                        "#########",
                        "#########",};


        for (int make_y = 0; make_y < grid.length; make_y++) {
            
            String current_row = "";
            for (int create_row = 0; create_row < 9; create_row++) {
                current_row = "";
                nums = "123456789";
                for (int columns_above = 0; columns_above < make_y; columns_above++) {

                    System.out.println(grid[columns_above+1]);
                    System.out.print(" ");
                    System.out.print(create_row);
                    nums = nums.replace(grid[columns_above+1]
                                        .charAt(create_row) + "","");
                    int rand_int1 = new Random().nextInt(nums.length()-1);
                    current_row += nums.charAt(rand_int1) + "";
                }
            }
            grid[make_y] = current_row;
        }
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length(); column++) {
                JButton b=new JButton(Integer.toString(row+1));//creating instance of JButton
                b.setBounds(0+(60*row),(frame_y_offset-37)+(60*column),60, 60);//x axis, y axis, width, height
                b.setBackground(Color.BLACK);
                b.setForeground(Color.WHITE);
                b.setFont(f1);
                frame.add(b);//adding button in JFrame   
            }
        }        
        frame.setSize(frame_x_offset+60*grid.length,frame_y_offset+60*grid[grid.length-1].length());//400 width and 500 height
        int frameSizeX = frame.getSize().width;
        int frameSizeY = frame.getSize().height;
        title.setBounds(frameSizeX/2-60,30,120, 60);//x axis, y axis, width, height   
    }
}