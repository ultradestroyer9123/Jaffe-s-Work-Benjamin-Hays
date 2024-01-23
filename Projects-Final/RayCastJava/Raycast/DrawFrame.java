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
public class DrawFrame {
    int pixel_size = 10;
    int pixel_amount_x = 100;
    int pixel_amount_y = 80;
    public DrawFrame(String grid, String facing) {
        JFrame frame = new JFrame();
    
        frame.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_W) {
              System.out.println("Forward");
            }
            else if (keyCode == KeyEvent.VK_A) {
              System.out.println("Left");
            }
            else if (keyCode == KeyEvent.VK_D) {
            System.out.println("Right");
            }
          }
        });
        Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 20); 
        frame.setLayout(null);//using no layout managers  
        frame.setVisible(false);//making the frame not visible to build pixels  
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(pixel_size*pixel_amount_x,pixel_size*pixel_amount_y);
        for (int x = 0; x < pixel_amount_x; x++) {
            for (int y = 0; y < pixel_amount_y; y++) {
                JPanel pixel = new JPanel();
                pixel.setBounds(x*pixel_size,y*pixel_size,pixel_size,pixel_size);
                frame.add(pixel);
            }
        }
        frame.setVisible(true);//making the frame visible
    }
}
