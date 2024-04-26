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

        String[] new_grid = new String[grid.length];

        for (int row = 0; row < grid.length; row++) {
            int current_col = 0;
            String new_row = "";
            for (int column = 0; column < grid[row].length(); column++) {
                String new_nums = "123456789";
                for (int rowX = 0; rowX < grid.length; rowX++) {
                    new_nums = new_nums.replace(grid[rowX].charAt(current_col) + "", "");
                    System.out.println(current_col);
                }
                String rand = new_nums.charAt(new Random().nextInt(new_nums.length())) + "";
                new_row += rand;
                current_col += 1;
            }
            new_grid[row] = new_row;
        }

        for (int row = 0; row < new_grid.length; row++) {
            for (int column = 0; column < new_grid[row].length(); column++) {
                JButton b=new JButton(new_grid[row].charAt(column) + "");//creating instance of JButton
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