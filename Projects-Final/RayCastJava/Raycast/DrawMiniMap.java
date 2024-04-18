import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.border.Border;
import java.util.Random;
import static java.lang.System.out;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.net.CookieHandler;
public class DrawMiniMap {
    int pixel_size = 5;
    JPanel[][] pixelList;
    public DrawMiniMap(int pixel_amount_x, int pixel_amount_y) {
        JFrame frame = new JFrame();
        
        Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 20); 
        frame.setLayout(null);//using no layout managers  
        frame.setTitle("Ray Maze - Active Game");
        frame.setVisible(false);//making the frame not visible to build pixels  
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(pixel_size*pixel_amount_x,pixel_size*pixel_amount_y);
        frame.setResizable(false);
        int count = 0;
        frame.setVisible(true);//making the frame visible
        pixelList = new JPanel[pixel_amount_x][pixel_amount_y];
        for (int x = 0; x < pixel_amount_x; x++) {
            for (int y = 0; y < pixel_amount_y; y++) {
                JPanel pixel = new JPanel();
                if (y == pixel_amount_y/2 || y == (pixel_amount_y/2)+0.5) {
                    count++;
                    pixel.setBackground(Color.WHITE);
                } else {
                    pixel.setBackground(Color.BLACK);
                }
                pixel.setBounds(x*pixel_size,y*pixel_size,pixel_size,pixel_size);
                pixelList[x][y] = pixel;
                frame.add(pixel);
            }
        }    
    }
    
    public void refresh(String grid) {
        String[] rows = grid.split("\n");
        for (int row = 0; row < rows.length; row++) {
            for (int chars = 0; chars < rows[row].length(); chars++) {
                if ((rows[row].charAt(chars) + "").equals("#") && !pixelList[chars][row].getBackground().equals(Color.WHITE)) {
                    pixelList[chars][row].setBackground(Color.WHITE);
                    pixelList[chars][row].repaint();
                } else if ((rows[row].charAt(chars) + "").equals("*")) {
                    pixelList[chars][row].setBackground(Color.RED);
                    pixelList[chars][row].repaint();
                } else if (!pixelList[chars][row].getBackground().equals(Color.BLACK)) {
                    pixelList[chars][row].setBackground(Color.BLACK);
                    pixelList[chars][row].repaint();
                }
            }
        }
    }
}
