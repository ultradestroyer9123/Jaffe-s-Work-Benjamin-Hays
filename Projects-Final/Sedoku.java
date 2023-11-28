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
import static java.lang.System.out;
import java.util.*;

public class Sedoku {
    public static void main(String[] args) {
        int frame_x_offset = 0;
        int frame_y_offset = 200;
        JFrame frame=new JFrame();//creating instance of JFrame  
        frame.setLayout(null);//using no layout managers  
        frame.setVisible(true);//making the frame visible  
        JButton title=new JTextField(Integer.toString(row+1));//creating instance of JButton
        System.out.println(Integer.toString(row)+ ", " +Integer.toString(column));
        title.setBounds(0+(60*row),(frame_y_offset-37)+(60*column),60, 60);//x axis, y axis, width, height 
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

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length(); column++) {
                JButton b=new JButton(Integer.toString(row+1));//creating instance of JButton
                System.out.println(Integer.toString(row)+ ", " +Integer.toString(column));
                b.setBounds(0+(60*row),(frame_y_offset-37)+(60*column),60, 60);//x axis, y axis, width, height 
                frame.add(b);//adding button in JFrame   
            }
        }        
        frame.setSize(frame_x_offset+60*grid.length,frame_y_offset+60*grid[grid.length-1].length());//400 width and 500 height  
    }
}